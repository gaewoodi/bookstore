use bookstore;

CREATE TABLE cart (
    cart_id int not null auto_increment,
    book_code varchar(45) not null unique,
    book_name varchar(45) not null,
    book_count int,
    author varchar(45),
    publisher varchar(45),
    publication_date year,
    category varchar(10) not null,
    price varchar(45) not null,
    primary key(cart_id)
);

SELECT * FROM cart;

drop table cart;
