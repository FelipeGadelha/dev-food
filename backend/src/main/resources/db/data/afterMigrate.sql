SET session_replication_role = 'replica';

DELETE FROM categories;
DELETE FROM products;

SET session_replication_role = 'origin';

ALTER SEQUENCE categories_id_seq RESTART WITH 1;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

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