use bookstore;

CREATE table purchase_mst (
    purchase_id int not null auto_increment, -- 주문번호
    book_id int,
    reg_id int, -- register id
    purchase_date datetime, -- 주문일자
    price int, -- 주문금액
    quantity int default 1, -- 주문수량
    total_price int default 0, -- 주문 총 금액
    purchase_status varchar(45), -- 주문상태 : 구매/주문취소
    payment_end_date datetime,
    primary key(purchase_id)
);

drop table purchase_mst;

SELECT * FROM purchase_mst;

INSERT INTO purchase_mst VALUES(NULL, '1', '1', now(), '35000', '1', '35000', '구매', now());
----------------------------------------
SELECT * FROM book_mst bm LEFT OUTER JOIN purchase_mst ON(bm.book_id = pm.book_id) pm WHERE pm.book_id = '1';
SELECT * FROM book_mst bm LEFT OUTER JOIN purchase_mst ON(bm.book_id = pm.book_id) pm WHERE pm.book_id = #{bookId}

SELECT bm.*, pm.book_id, pm.reg_id FROM book_mst bm LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE bm.book_id = pm.book_id AND pm.reg_id = '4';
SELECT bm.*, pm.book_id, pm.reg_id FROM book_mst bm LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE bm.book_id = pm.book_id AND pm.reg_id = #{regId}

SELECT
    bm.*,
    pm.book_id,
    pm.reg_id
FROM
    book_mst bm
    LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id)
WHERE
    bm.book_id = pm.book_id AND pm.reg_id = #{regId}

----------------------------------------
select book_stock from book_mst WHERE book_id = '29';

SELECT
    bm.book_name AS bmBookName,
    pm.*
FROM
    book_mst bm
    LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id)
WHERE
    pm.reg_id = #{regId}

SELECT bm.book_name AS bmBookName, pm.* FROM book_mst bm INNER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE pm.reg_id = '1';
SELECT bm.book_name AS bmBookName, pm.* FROM book_mst bm INNER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE pm.reg_id = #{regId}

SELECT
    bm.book_name AS bmBookName,
    pm.*
FROM
    purchase_mst pm
    LEFT OUTER JOIN book_mst bm ON(bm.book_id = pm.book_id)
WHERE
    pm.reg_id = #{regId}

SELECT bm.book_name AS bmBookName, pm.* FROM purchase_mst pm LEFT OUTER JOIN book_mst bm ON(bm.book_id = pm.book_id) WHERE pm.reg_id = '1';
SELECT bm.book_name AS bmBookName, pm.* FROM purchase_mst pm LEFT OUTER JOIN book_mst bm ON(bm.book_id = pm.book_id) WHERE pm.reg_id = #{regId}











-- 도서명, 수량, 금액, 총결제금액
-- book_mst, purchase_mst join해서 bookName 들고와서 같이 써야함.

SELECT * FROM purchase_mst INNER JOIN book_mst

-- 2단 조인 purchase_mst랑 register left outer join
SELECT om.*,r.name, r.email, r.address, r.address1, r.tel, r.postcode FROM purchase_mst om LEFT OUTER JOIN register r ON om.id = r.id

-- 3단 조인
SELECT om.*,r.name, r.email, r.address, r.address1, r.tel, r.postcode, bm.* FROM purchase_mst om LEFT OUTER JOIN register r ON om.id = r.id LEFT OUTER JOIN book_mst bm ON om.price = bm.price;

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
    purchase_mst om

LEFT OUTER JOIN
    register r

ON
    om.id = r.id

LEFT OUTER JOIN
    book_mst bm

ON
    om.price = bm.price;


-- book_mst랑 purchase_mst left outer join

SELECT om.*, r.id FROM purchase_mst om LEFT OUTER JOIN register r ON om.id = r.id;

INSERT INTO purchase_mst VALUES(NULL, 'smile52',now(), '35000', '1', '35000', "주문");
INSERT INTO purchase_mst VALUES(NULL, 'tree98 ',now(), '19000', '1', '19000', "주문");
