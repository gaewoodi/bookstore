use bookstore;

CREATE TABLE cart (
    cart_id int not null auto_increment,
    count int
    primary key(cart_id)
);

SELECT * FROM cart;

drop table cart;
