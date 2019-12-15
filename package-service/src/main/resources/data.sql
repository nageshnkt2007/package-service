DROP ALL OBJECTS;

DROP TABLE IF EXISTS package;
CREATE TABLE package
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    product_id VARCHAR(250) NOT NULL,
    name      VARCHAR(250) NOT NULL,
    base_price INT NOT NULL,
    package_id INT NOT NULL,
    FOREIGN KEY (package_id) REFERENCES package (id)
);
DELETE
FROM PACKAGE;
INSERT INTO PACKAGE (id, name, description)
VALUES (4, 'Premium Package', 'This Package Containes Our Premium Products'),
       (5, 'Express Package', 'Excel with Our Express Products package'),
       (6, 'Durable Package', 'Budget is a concern? We have the right product for you');


DELETE FROM product;
INSERT INTO product (id, base_price, name, PRODUCT_ID,package_id)
VALUES
       (4, 1149, 'Shield', 'VqKb4tyj9V6i',4),
       (5, 999, 'Helmet', 'DXSQpv6XVeJm',4),
       (6, 899, 'Sword', '7dgX6XzU3Wds',4),
       (7, 799, 'Axe', 'PKM5pGAh9yGm',4),
       (8, 349, 'Knife', '7Hv0hA2nmci7',5),
       (9, 249, 'Gold Coin', '500R5EHvNlNB',5),
       (10, 399, 'Platinum Coin', 'IP3cv7TcZhQn',6),
       (11, 649, 'Bow', 'IJOHGYkY2CYq',6),
       (12, 50, 'Silver Coin', '8anPsR2jbfNW',6);
