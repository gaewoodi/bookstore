use bookstore;

CREATE table order_delete (
    purchase_id int not null auto_increment, -- 주문번호
    book_id int,
    reg_id int, -- register id
    purchase_date datetime, -- 주문일자
    payment_end_date datetime,
    primary key(purchase_id)
);

drop table order_delete;

SELECT * FROM order_delete;
