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

-------------------------------------
SELECT bm.*, od.book_id, od.reg_id FROM book_mst bm LEFT OUTER JOIN order_delete od ON(bm.book_id = od.book_id) WHERE bm.book_id = od.book_id AND od.reg_id = #{regId}


SELECT
    bm.*,
    od.book_id,
    od.reg_id
FROM book_mst bm LEFT OUTER JOIN order_delete od ON(bm.book_id = od.book_id)
WHERE
    bm.book_id = od.book_id AND od.reg_id = #{regId}


