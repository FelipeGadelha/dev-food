ALTER TABLE products
    ADD COLUMN category_id BIGINT;
ALTER TABLE products
    ADD FOREIGN KEY (category_id)
    REFERENCES categories (id);