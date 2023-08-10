use bookstore;

CREATE TABLE cart (
    cart_id int not null auto_increment, --
    book_code varchar(45) not null,
    quantity int not null, -- 수량
    primary key(cart_id)
);

SELECT * FROM cart;

drop table cart;
