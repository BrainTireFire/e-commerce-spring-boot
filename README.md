# E-commerce Project  

## 📖 Overview  
This project is an **E-commerce platform** designed with a **microservices architecture**. It leverages a range of modern technologies to ensure scalability, reliability, and performance. The project demonstrates a modular approach to building large-scale applications while integrating essential services such as authentication, messaging, monitoring, and service discovery. 

This project is inspired by a course created by **Bouali Ali**. You can find more information and resources about the course on his YouTube channel [Bouali Ali](https://www.youtube.com/@BoualiAli), where he dives deep into the development and architecture of such systems.

---

## 🛠️ Tech Stack  

### Backend  
- **Kafka**: For event-driven messaging and asynchronous communication between microservices.  
- **Keycloak**: Provides secure authentication and authorization management.  
- **Spring Boot 3**: A framework for creating standalone, production-ready microservices.  
- **Spring Data JPA**: Simplifies database interactions and ORM.  
- **Spring Validation**: Handles data validation effectively.  
- **Docker**: For containerizing and deploying microservices.  
- **Eureka**: Service discovery for dynamic microservices communication.  
- **Spring Cloud**: Enables distributed system patterns such as configuration, routing, and load balancing.  
- **Zipkin**: Distributed tracing to debug and monitor microservice requests.  
- **Prometheus and Grafana**: Tools for monitoring system performance and visualizing metrics.  

---

## ✨ Features  
- **Microservices Architecture**: Modular and scalable design for independent service development.  
- **Authentication and Authorization**: Managed by Keycloak.  
- **Event-Driven Architecture**: Kafka for real-time communication between services.  
- **Service Discovery**: Dynamic microservice registration with Eureka.  
- **Observability**: Distributed tracing with Zipkin and monitoring with Prometheus and Grafana.  
- **Containerized Deployment**: Simplified deployments using Docker.  

---

## 🏗️ Microservices  

### Core Services  
- **Config Server**: Centralized configuration management for all microservices.  
- **Customer Service**: Manages customer profiles, order history, and customer-related operations.  
- **Discovery Service**: Provides service discovery using Eureka to allow microservices to find and communicate with each other dynamically.  
- **Gateway Service**: A single entry point for client requests, routing them to the appropriate services.  
- **Notification Service**: Handles sending notifications to customers about orders, promotions, and updates.  
- **Order Service**: Manages customer orders, including creation, updates, and status tracking.  
- **Payment Service**: Responsible for processing payments, integrating with external payment gateways.  
- **Product Service**: Manages the product catalog, including product listings, details, and inventory.  

---

## 🗄️ Databases  
- **PostgreSQL**: Relational database used for managing structured data, such as customer profiles, orders, and product details.  
- **MongoDB**: NoSQL database used for managing unstructured data, like logs, events, and application analytics.
