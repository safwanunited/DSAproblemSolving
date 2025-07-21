-- Add inventory_check column to product table
ALTER TABLE product
ADD COLUMN inventory_check INT DEFAULT 0;