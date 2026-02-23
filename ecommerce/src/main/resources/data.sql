-- Sample data for E-Commerce Application

USE ecommerce_db;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE order_items;
TRUNCATE TABLE orders;
TRUNCATE TABLE cart_items;
TRUNCATE TABLE products;
TRUNCATE TABLE users;
TRUNCATE TABLE categories;
SET FOREIGN_KEY_CHECKS = 1;

-- =========================
-- Categories
-- =========================
INSERT INTO categories (name, description) VALUES
('Electronics', 'Gadgets, devices, and accessories'),
('Fashion', 'Clothing, footwear, and apparel'),
('Home & Kitchen', 'Appliances and home decor'),
('Books', 'Educational and entertainment literature');

-- =========================
-- Users (Password: 123456)
-- =========================
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@example.com', '123456', 'ADMIN'),
('Test User', 'user@example.com', '123456', 'USER');

-- =========================
-- Products
-- =========================
INSERT INTO products (name, description, price, image_path, category_id) VALUES
('Smartphone Pro 15', 'Latest flagship smartphone with advanced camera.', 89900.00, 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=500&auto=format', 1),
('Wireless Headphones', 'Noise canceling over-ear headphones.', 15000.00, 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&auto=format', 1),
('Cotton T-Shirt', 'Premium quality cotton t-shirt.', 999.00, 'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=500&auto=format', 2),
('Denim Jeans', 'Classic blue denim jeans.', 2499.00, 'https://images.unsplash.com/photo-1542272604-787c3835535d?w=500&auto=format', 2),
('Coffee Maker', 'Automatic espresso and coffee machine.', 5500.00, 'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=500&auto=format', 3),
('Cookware Set', 'Non-stick 10-piece cookware set.', 12000.00, 'https://images.unsplash.com/photo-1592419044706-39796d40f98c?w=500&auto=format', 3),
('Java Programming Book', 'Complete guide to Java development.', 2500.00, 'https://images.unsplash.com/photo-1589998059171-988d887df646?w=500&auto=format', 4),
('Spring Boot in Action', 'Learn Spring Boot framework.', 1800.00, 'https://images.unsplash.com/photo-1532012197267-da84d127e765?w=500&auto=format', 4),
('Gaming Laptop', 'High performance gaming laptop with RTX graphics.', 125000.00, 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=500&auto=format', 1),
('Smart Watch X', 'Fitness tracking smart watch with AMOLED display.', 19999.00, 'https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b?w=500&auto=format', 1),
('Bluetooth Speaker', 'Portable wireless speaker with deep bass.', 3499.00, 'https://images.unsplash.com/photo-1507874457470-272b3c8d8ee2?w=500&auto=format', 1),
('Leather Jacket', 'Stylish black leather jacket.', 5999.00, 'https://images.unsplash.com/photo-1520975916090-3105956dac38?w=500&auto=format', 2),
('Running Shoes', 'Comfortable sports running shoes.', 2999.00, 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=500&auto=format', 2),
('Casual Hoodie', 'Warm and cozy cotton hoodie.', 1899.00, 'https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=500&auto=format', 2),
('Air Fryer', 'Healthy oil-free air fryer.', 8500.00, 'https://images.unsplash.com/photo-1585238342028-4c1c1a4c4b2b?w=500&auto=format', 3),
('Mixer Grinder', 'Multi-purpose kitchen mixer grinder.', 4200.00, 'https://images.unsplash.com/photo-1626806787461-102c1bfaaea1?w=500&auto=format', 3),
('Dining Set', 'Wooden 4-seater dining table set.', 15000.00, 'https://images.unsplash.com/photo-1505691938895-1758d7feb511?w=500&auto=format', 3),
('Data Structures in Java', 'Comprehensive DSA guide using Java.', 2200.00, 'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=500&auto=format', 4),
('Clean Code', 'Handbook of Agile Software Craftsmanship.', 3200.00, 'https://images.unsplash.com/photo-1516979187457-637abb4f9353?w=500&auto=format', 4),
('Database System Concepts', 'Fundamentals of database systems.', 2800.00, 'https://images.unsplash.com/photo-1481627834876-b7833e8f5570?w=500&auto=format', 4);