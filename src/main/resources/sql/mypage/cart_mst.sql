use bookstore;

CREATE TABLE cart_mst (
    cart_id int not null auto_increment, -- 장바구니  id
    reg_id int, -- user id
    book_id int, -- 책 id
    create_date datetime,
    primary key(cart_id)
);

INSERT INTO cart_mst VALUES (NULL, '1', '1', now());

SELECT * FROM cart_mst;

drop table cart_mst;

DELETE FROM cart_mst WHERE reg_id = #{regId} AND book_id = #{bookId}
DELETE FROM cart_mst WHERE reg_id = '3' AND book_id = '2';

SELECT COUNT(book_id) as cartTotal FROM cart_mst WHERE reg_id = '2';
SELECT COUNT(book_id) as cartTotal FROM cart_mst WHERE reg_id = #{regId};
---------------------------------------

SELECT cm.book_id, cm.reg_id, cm.create_date, bm.* FROM book_mst bm LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id) WHERE bm.book_id = cm.book_id AND cm.reg_id = '2' ORDER BY cm.book_Id;
SELECT cm.book_id, cm.reg_id, cm.create_date, bm.* FROM book_mst bm LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id) WHERE bm.book_id = cm.book_id AND cm.reg_id = #{regId} ORDER BY cm.book_Id

SELECT
    cm.book_id,
    cm.reg_id,
    cm.create_date,
    bm.*
FROM
    book_mst bm
    LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id)
WHERE
    bm.book_id = cm.book_id AND cm.reg_id = #{regId}
ORDER BY cm.book_Id;
---------------------------------

