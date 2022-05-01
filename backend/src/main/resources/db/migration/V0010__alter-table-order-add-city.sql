ALTER TABLE orders
    ADD COLUMN address_city_id BIGINT;
ALTER TABLE orders
    ADD CONSTRAINT FK_orders_address_city
    FOREIGN KEY (address_city_id) REFERENCES cities;
