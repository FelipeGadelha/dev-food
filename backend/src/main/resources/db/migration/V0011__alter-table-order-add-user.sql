ALTER TABLE orders
    ADD COLUMN user_client_id BIGINT;
ALTER TABLE orders
    ADD CONSTRAINT FK_orders_user_client
    FOREIGN KEY (user_client_id) REFERENCES users;
