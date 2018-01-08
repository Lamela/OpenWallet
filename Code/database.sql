DROP DATABASE IF EXISTS openwallet;
CREATE DATABASE openwallet DEFAULT CHARACTER SET utf8;
USE openwallet;

CREATE TABLE user (
	id_user int(11) NOT NULL AUTO_INCREMENT,
	firstname_user varchar(255) DEFAULT NULL,
	lastname_user varchar(255) DEFAULT NULL,
	birthday datetime DEFAULT NULL,
	type_user varchar(255) DEFAULT NULL,
	premium boolean DEFAULT false,
	email varchar(255) DEFAULT NULL,
	password varchar(255) DEFAULT NULL,
	mobile_user varchar(255) DEFAULT NULL,
	number_id_card varchar(255) DEFAULT NULL,
	PRIMARY KEY (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE category (
	id_category int(11) NOT NULL AUTO_INCREMENT,
	name_category varchar(255) DEFAULT NULL,
	PRIMARY KEY (id_category)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE address (
	id_address int(11) NOT NULL AUTO_INCREMENT,
	id_user int(11) DEFAULT NULL,
	firstname_receiver varchar(255) DEFAULT NULL,
	lastname_receiver varchar(255) DEFAULT NULL,
	mobile_receiver varchar(255) DEFAULT NULL,
	street varchar(255) DEFAULT NULL,
	city varchar(255) DEFAULT NULL,
	country varchar(255) DEFAULT NULL,
	post_address varchar(255) DEFAULT NULL,
	PRIMARY KEY (id_address),
	CONSTRAINT fk_address_user FOREIGN KEY (id_user) REFERENCES user (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE product (
	id_product int(11) NOT NULL AUTO_INCREMENT,
	id_category int(11) DEFAULT NULL,
	id_user int(11) DEFAULT NULL,
	name_product varchar(255) DEFAULT NULL,
	description varchar(4000) DEFAULT NULL,
	price double(11,2) DEFAULT NULL,
	stock int(11) DEFAULT NULL,
	create_date_product datetime DEFAULT NULL,
	origin varchar(255) DEFAULT NULL,
	sold int(11) DEFAULT NULL,
	brand varchar(255) DEFAULT NULL,
	color varchar(255) DEFAULT NULL,
	material varchar(255) DEFAULT NULL,
	note double(11,1) DEFAULT NULL,
	PRIMARY KEY (id_product),
	CONSTRAINT fk_product_category FOREIGN KEY (id_category) REFERENCES category (id_category),
	CONSTRAINT fk_product_user FOREIGN KEY (id_user) REFERENCES user (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE comment (
	id_comment int(11) NOT NULL AUTO_INCREMENT,
	id_user int(11) DEFAULT NULL,
	id_product int(11) DEFAULT NULL,
	date_comment datetime DEFAULT NULL,
	note double(11,1) DEFAULT NULL,
	PRIMARY KEY (id_comment),
	CONSTRAINT fk_comment_product FOREIGN KEY (id_product) REFERENCES product (id_product),
	CONSTRAINT fk_comment_user FOREIGN KEY (id_user) REFERENCES user (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE orders (
	id_order int(11) NOT NULL AUTO_INCREMENT,
	id_user int(11) DEFAULT NULL,
	code_order varchar(255) DEFAULT NULL,
	total_price double(11,2) DEFAULT NULL,
	delivery_address varchar(255) DEFAULT NULL,
	invoice_address varchar(255) DEFAULT NULL,
	user_message varchar(500) DEFAULT NULL,
	create_date_order datetime DEFAULT NULL,
	pay_date datetime DEFAULT NULL,
	delivery_date datetime DEFAULT NULL,
	confirm_date datetime DEFAULT NULL,
	status varchar(255) DEFAULT NULL,
	PRIMARY KEY (id_order),
	CONSTRAINT fk_order_user FOREIGN KEY (id_user) REFERENCES user (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE item_cart (
	id_item_cart int(11) NOT NULL AUTO_INCREMENT,
	id_user int(11) DEFAULT NULL,
	id_product int(11) DEFAULT NULL,
	number_item_cart int(11) DEFAULT NULL,
	PRIMARY KEY (id_item_cart),
	CONSTRAINT fk_item_cart_user FOREIGN KEY (id_user) REFERENCES user (id_user),
	CONSTRAINT fk_item_cart_product FOREIGN KEY (id_product) REFERENCES product (id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE item_order (
	id_item_order int(11) NOT NULL AUTO_INCREMENT,
	id_order int(11) DEFAULT NULL,
	id_product int(11) DEFAULT NULL,
	number_item_order int(11) DEFAULT NULL,
	PRIMARY KEY (id_item_order),
	CONSTRAINT fk_item_order_user FOREIGN KEY (id_order) REFERENCES orders (id_order),
	CONSTRAINT fk_item_order_product FOREIGN KEY (id_product) REFERENCES product (id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
