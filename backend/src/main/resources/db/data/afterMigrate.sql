SET session_replication_role = 'replica';

DELETE FROM cities;
DELETE FROM states;
DELETE FROM categories;
DELETE FROM products;
DELETE FROM users;
DELETE FROM orders;
DELETE FROM order_item;

SET session_replication_role = 'origin';

ALTER SEQUENCE cities_id_seq RESTART WITH 1;
ALTER SEQUENCE states_id_seq RESTART WITH 1;
ALTER SEQUENCE categories_id_seq RESTART WITH 1;
ALTER SEQUENCE products_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE orders_id_seq RESTART WITH 1;
ALTER SEQUENCE order_item_id_seq RESTART WITH 1;

INSERT INTO states (id, name) VALUES (1, 'Minas Gerais');
INSERT INTO states (id, name) VALUES (2, 'São Paulo');
INSERT INTO states (id, name) VALUES (3, 'Ceará');

SELECT nextval ('states_id_seq');
SELECT nextval ('states_id_seq');
SELECT nextval ('states_id_seq');

INSERT INTO cities (id, name, state_id) VALUES (1, 'Uberlândia', 1);
INSERT INTO cities (id, name, state_id) VALUES (2, 'Belo Horizonte', 1);
INSERT INTO cities (id, name, state_id) VALUES (3, 'São Paulo', 2);
INSERT INTO cities (id, name, state_id) VALUES (4, 'Campinas', 2);
INSERT INTO cities (id, name, state_id) VALUES (5, 'Fortaleza', 3);

SELECT nextval ('cities_id_seq');
SELECT nextval ('cities_id_seq');
SELECT nextval ('cities_id_seq');
SELECT nextval ('cities_id_seq');
SELECT nextval ('cities_id_seq');

INSERT INTO categories (id, name, parent_category_id) VALUES (1, 'Prato Principal', null);
INSERT INTO categories (id, name, parent_category_id) VALUES (2, 'Bebidas', null);

SELECT nextval ('categories_id_seq');
SELECT nextval ('categories_id_seq');

INSERT INTO products (id, name, description, price, active, category_id) VALUES
(1, 'Coxinha', 'coxinha de frango', 50.0, true, 1),
(2, 'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, false, 1),
(3, 'Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 2),
(4, 'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 1),
(5, 'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 1),
(6, 'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 1),
(7, 'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 1),
(8, 'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 1),
(9, 'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 1),
(10, 'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 1);

SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');
SELECT nextval ('products_id_seq');

INSERT INTO users (id, name, email, password, creation_date) VALUES
(1, 'João da Silva', 'joao.ger@gmail.com', '123', now()),
(2, 'Maria Joaquina', 'maria.vnd@email.com', '123', now()),
(3, 'José Souza', 'jose.aux@outlook.com', '123', now()),
(4, 'Sebastião Martins', 'sebastiao.cad@test.com', '123', now()),
(5, 'Manoel Lima', 'manoel.loja@gmail.com', '123', now());

SELECT nextval ('users_id_seq');
SELECT nextval ('users_id_seq');
SELECT nextval ('users_id_seq');
SELECT nextval ('users_id_seq');
SELECT nextval ('users_id_seq');

INSERT INTO orders (
id, code, total_value, user_client_id, address_city_id,
address_cep, address_place, address_number, address_complement, address_district)
--status, creation_date)
VALUES
(1, '66909e67-fdbf-49ab-86c5-221b998127c6', 308.90, 1, 2, '38400-000', 'Rua Floriano Peixoto', '500', 'Apto 801', 'Brasil'),
(2, '4a6977b6-9bc3-4a36-b8b0-e599e0f72507', 79, 4, 1, '38400-111', 'Rua Acre', '300', 'Casa 2', 'Centro'),
(3, '8d774bcf-b238-42f3-aef1-5fb388754d63', 97.2, 2, 3, '38400-200', 'Rua 10', '930', 'Casa 20', 'Martins'),
(4, '5c621c9a-ba61-4454-8631-8aabefe58dc2', 179.4, 1, 1, '38400-800', 'Rua Fortaleza', '900', 'Apto 504', 'Centro'),
(5, 'b5741512-8fbc-47fa-9ac1-b530354fc0ff', 120, 1, 1, '38400-222', 'Rua Natal', '200', 'Apto 317', 'Brasil');

SELECT nextval ('orders_id_seq');
SELECT nextval ('orders_id_seq');
SELECT nextval ('orders_id_seq');
SELECT nextval ('orders_id_seq');
SELECT nextval ('orders_id_seq');

INSERT INTO order_item (id, order_id, product_id, quantity, unit_price, total_price, observation) VALUES
(1, 1, 1, 1, 78.9, 78.9, null),
(2, 1, 2, 2, 110, 220, 'Menos picante, por favor'),
(3, 2, 6, 1, 79, 79, 'Ao ponto');

SELECT nextval ('order_item_id_seq');
SELECT nextval ('order_item_id_seq');
SELECT nextval ('order_item_id_seq');

INSERT INTO order_status (order_status_id, status, moment) VALUES
(1, 'CREATED', '2021-11-01 22:20:01.362'),
(1, 'CONFIRMED', '2021-11-01 22:20:01.362'),
(1, 'DELIVERED', '2021-11-01 22:20:01.362'),
(2, 'CREATED', '2021-11-02 22:20:01.362'),
(2, 'CONFIRMED', '2021-11-02 22:20:01.362'),
(2, 'DELIVERED', '2021-11-02 22:20:01.362'),
(3, 'CREATED', '2021-11-03 22:20:01.362'),
(3, 'CONFIRMED', '2021-11-03 22:20:01.362'),
(3, 'DELIVERED', '2021-11-03 22:20:01.362'),
(4, 'CREATED', '2021-12-03 22:20:01.362'),
(4, 'CONFIRMED', '2021-12-03 22:20:01.362'),
(4, 'DELIVERED', '2021-12-03 22:20:01.362'),
(5, 'CREATED', now());