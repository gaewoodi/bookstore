use bookstore;

CREATE table purchase_list (
    purchase_id int not null auto_increment, -- 주문번호
    book_id int,
    reg_id int, -- register id
    purchase_date datetime, -- 주문일자
    payment_end_date datetime,
    primary key(purchase_id)
);

drop table purchase_list;

SELECT * FROM purchase_list;
