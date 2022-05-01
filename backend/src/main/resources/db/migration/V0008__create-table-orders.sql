CREATE TABLE orders (
	id SERIAL NOT NULL,
	subtotal NUMERIC(10,2) NOT NULL,
  	total_value NUMERIC(10,2) NOT NULL,

	address_cep VARCHAR(9) NOT NULL,
	address_place VARCHAR(100) NOT NULL,
	address_number VARCHAR(20) NOT NULL,
	address_complement VARCHAR(60),
	address_district VARCHAR(60) NOT NULL,

	CONSTRAINT pk_orders PRIMARY KEY(id)
);