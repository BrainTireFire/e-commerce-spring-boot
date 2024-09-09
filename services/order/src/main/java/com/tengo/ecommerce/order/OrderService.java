package com.tengo.ecommerce.order;

import com.tengo.ecommerce.customer.CustomerClient;
import com.tengo.ecommerce.exception.BusinessException;
import com.tengo.ecommerce.kafka.OrderConfirmation;
import com.tengo.ecommerce.kafka.OrderProducer;
import com.tengo.ecommerce.orderline.OrderLineRequest;
import com.tengo.ecommerce.orderline.OrderLineService;
import com.tengo.ecommerce.payment.PaymentClient;
import com.tengo.ecommerce.payment.PaymentRequest;
import com.tengo.ecommerce.product.ProductClient;
import com.tengo.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest orderRequest) {

        // Find customer
        var customer = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order for non-existing customer " + orderRequest.customerId()));

        // Purchase products
        var purchasedProducts = this.productClient.purchaseProducts(orderRequest.products());

        // Save order
        var order = orderRepository.save(orderMapper.toOrder(orderRequest));

        // Save order lines
        for (PurchaseRequest purchaseRequest : orderRequest.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // Request payment
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);


        // Send order confirmation
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("Order with id " + orderId + " not found"));
    }
}
