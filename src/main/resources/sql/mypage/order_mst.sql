use bookstore;

CREATE table order_mst (
    order_id int not null auto_increment, -- 주문번호
    id varchar(20) not null, -- 유저아이디
    order_date datetime not null, -- 주문일자
    price int not null, -- 주문금액
    quantity int not null, -- 주문수량
    total_price int not null default 0, -- 주문 총 금액
    order_status varchar(45), -- 주문상태 : 구매/주문취소
    primary key(order_id)
);

-- 도서명, 수량, 금액, 총결제금액
-- book_mst, order_mst join해서 bookName 들고와서 같이 써야함.

SELECT * FROM order_mst INNER JOIN book_mst

-- 2단 조인 order_mst랑 register left outer join
SELECT om.*,r.name, r.email, r.address, r.address1, r.tel, r.postcode FROM order_mst om LEFT OUTER JOIN register r ON om.id = r.id

-- 3단 조인
SELECT om.*,r.name, r.email, r.address, r.address1, r.tel, r.postcode, bm.* FROM order_mst om LEFT OUTER JOIN register r ON om.id = r.id LEFT OUTER JOIN book_mst bm ON om.price = bm.price;

SELECT
    om.*,
    r.name,
    r.email,
    r.address,
    r.address1,
    r.tel,
    r.postcode,
    bm.*

FROM
    order_mst om

LEFT OUTER JOIN
    register r

ON
    om.id = r.id

LEFT OUTER JOIN
    book_mst bm

ON
    om.price = bm.price;

INSERT INTO order_mst VALUES(NULL, 'smile52',now(), '35000', '1', '35000', "주문");
INSERT INTO order_mst VALUES(NULL, 'tree98 ',now(), '19000', '1', '19000', "주문");