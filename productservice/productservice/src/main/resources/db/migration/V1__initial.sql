-- Create the category table
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Create the price table (assuming it exists based on foreign key)
CREATE TABLE price (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2),
    currency VARCHAR(10)
);

-- Create the product table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    image VARCHAR(255),
    category INT,
    price_id INT,
    inventory_count INT NOT NULL,

    CONSTRAINT fk_product_category FOREIGN KEY (category) REFERENCES category(id),
    CONSTRAINT fk_product_price FOREIGN KEY (price_id) REFERENCES price(id)
);
