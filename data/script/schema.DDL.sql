--CREATE DATABASE sql_injection;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id bigint GENERATED ALWAYS AS IDENTITY,
	user_name varchar NOT NULL,
	email varchar NOT NULL,
	user_password varchar NOT NULL,
	admin_role boolean NOT NULL DEFAULT FALSE,
	CONSTRAINT user_pkey PRIMARY KEY (id),
	CONSTRAINT user_ukey UNIQUE (user_name,email)
);

CREATE TABLE products (
	id bigint GENERATED ALWAYS AS IDENTITY,
	product_name varchar NOT NULL,
	description text NOT NULL,
	price NUMERIC(5, 2) NOT NULL,
	CONSTRAINT products_pkey PRIMARY KEY  (id),
	CONSTRAINT products_ukey UNIQUE (product_name)
);