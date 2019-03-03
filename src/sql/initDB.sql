CREATE TABLE clients (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(25),
  lastName VARCHAR(25),
  age      INT,
  email    VARCHAR(50),
  phone    VARCHAR(25)
);
INSERT INTO clients (name, lastName, age, email, phone) VALUES ('Igor', 'Ivanov', 35, 'iivanov@gmail.com', '0952223333');
INSERT INTO clients (name, lastName, age, email, phone) VALUES ('Pavel', 'Ivanov', 36, 'pivanov@gmail.com', '0952223334');
INSERT INTO clients (name, lastName, age, email, phone) VALUES ('Ivan', 'Ivanov', 37, 'ivivanov@gmail.com', '0952223335');
INSERT INTO clients (name, lastName, age, email, phone) VALUES ('Sasha', 'Ivanov', 38, 'sivanov@gmail.com', '0952223336');

  CREATE TABLE products (
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(25),
    price INT
  );


CREATE TABLE orders (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  clientId  int,
  products_ids VARCHAR(900)
);

