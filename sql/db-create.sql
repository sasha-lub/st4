CONNECT 'jdbc:derby://localhost:1527/st4db;create=true;user=test;password=test;derby.ui.codeset=UTF-8';

DROP TABLE orders;
DROP TABLE users;
DROP TABLE tours;
DROP TABLE roles;
DROP TABLE sales;

CREATE TABLE roles (
	id INTEGER NOT NULL PRIMARY KEY,
	name VARCHAR(15) NOT NULL
);

INSERT INTO roles VALUES(0, 'admin');
INSERT INTO roles VALUES(1, 'manager');
INSERT INTO roles VALUES(2, 'user');

CREATE TABLE users (
	id_user INTEGER NOT NULL generated always AS identity  PRIMARY KEY,
	login VARCHAR(10) NOT NULL,
	password VARCHAR(15) NOT NULL,
	full_name VARCHAR(30) NOT NULL,
	role_id INTEGER NOT NULL REFERENCES roles(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	banned BOOLEAN NOT NULL 
);

INSERT INTO users VALUES(DEFAULT,'user','user','Spider Man',2,false);
INSERT INTO users VALUES(DEFAULT,'manager','manager','Iron Man',1,false);
INSERT INTO users VALUES(DEFAULT,'admin','admin','Wonder Woman',0,false);

SELECT * from users;

CREATE TABLE tours(
	id_tour INTEGER NOT NULL generated always AS identity PRIMARY KEY,
	country VARCHAR(20) NOT NULL,
	city VARCHAR(20) NOT NULL,
	hotel VARCHAR(20) NOT NULL,
	type_trip VARCHAR(20) NOT NULL,
	type_hotel VARCHAR(10) NOT NULL,
	from_date DATE NOT NULL,	
	to_date DATE NOT NULL,
	cost INTEGER NOT NULL,
	people_number INTEGER NOT NULL,	
	hot BOOLEAN NOT NULL
);

CREATE TABLE orders(
	id_user INTEGER NOT NULL REFERENCES users(id_user)
		ON DELETE CASCADE 
		ON UPDATE RESTRICT, 
	id_trip INTEGER NOT NULL REFERENCES tours(id_tour)
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	status VARCHAR(20) NOT NULL
);



CREATE TABLE sales (
	id INTEGER unique,
	hot_sale INTEGER not null DEFAULT 0,
	step_sale INTEGER not null DEFAULT 0,
	max_step_sale INTEGER not null DEFAULT 0
);
	
	INSERT INTO sales VALUES(0, 0, 0, 0);
