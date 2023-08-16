use bookstore;

CREATE TABLE cart_mst (
    cart_id int not null auto_increment, -- 장바구니  id
    reg_id int, -- user id
    book_id int, -- 책 id
    book_code varchar(45),
    book_name varchar(45),
    book_stock int default 0,
    author varchar(45),
    publisher varchar(45),
    publication_date year,
    category varchar(45),
    price int,
    visit int default 0,
    quantity int default 1, -- 수량
    primary key(cart_id)
);

CREATE TABLE cart_mst (
    cart_id int not null auto_increment, -- 장바구니  id
    book_id int, -- 책 id
    book_code varchar(45),
    book_name varchar(45),
    book_stock int default 0,
    author varchar(45),
    publisher varchar(45),
    publication_date year,
    category varchar(45),
    price int,
    visit int default 0,
    quantity int default 1, -- 수량
    primary key(cart_id)
);

SELECT * FROM cart_mst;

drop table cart_mst;

---------------------------------------


