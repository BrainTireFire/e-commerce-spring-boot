-- Insert sample data into category table
INSERT INTO category (id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Devices, gadgets, and accessories'),
    (nextval('category_seq'), 'Books', 'Literature, academic, and fiction books'),
    (nextval('category_seq'), 'Clothing', 'Apparel for men, women, and children'),
    (nextval('category_seq'), 'Sports', 'Sports equipment and accessories');

-- Insert sample data into product table
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone', 'Latest model smartphone with 128GB storage', 100, 799.99, (SELECT id FROM category WHERE name = 'Electronics')),  -- Electronics
    (nextval('product_seq'), 'Laptop', '15-inch display, 16GB RAM, 512GB SSD', 50, 1199.99, (SELECT id FROM category WHERE name = 'Electronics')),            -- Electronics
    (nextval('product_seq'), 'Novel', 'Best-selling fiction novel', 200, 19.99, (SELECT id FROM category WHERE name = 'Books')),                        -- Books
    (nextval('product_seq'), 'Textbook', 'University-level calculus textbook', 75, 89.99, (SELECT id FROM category WHERE name = 'Books')),              -- Books
    (nextval('product_seq'), 'T-shirt', 'Cotton t-shirt with various sizes', 300, 14.99,(SELECT id FROM category WHERE name = 'Clothing')),               -- Clothing
    (nextval('product_seq'), 'Sneakers', 'Running shoes for men', 120, 79.99, (SELECT id FROM category WHERE name = 'Clothing')),                          -- Clothing
    (nextval('product_seq'), 'Football', 'Official size football', 150, 29.99, (SELECT id FROM category WHERE name = 'Sports')),                         -- Sports
    (nextval('product_seq'), 'Tennis Racket', 'Professional-grade tennis racket', 80, 149.99, (SELECT id FROM category WHERE name = 'Sports'));          -- Sports
