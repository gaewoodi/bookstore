use bookstore;

CREATE table order_mst (
    order_id int not null auto_increment, -- 주문번호
    user_id int not null, -- user아이디
    order_date datetime not null, -- 주문일자
    price int not null, -- 주문금액
    quantity int not null, -- 주문수량
    total_price int not null default 0, -- 주문 총 금액
    order_status varchar(45), -- 주문상태 : 구매/주문취소
    payment_price int null, -- 결제 금액
    payment_end_date datetime, -- 결제 완료일
    primary key(order_id)
);
