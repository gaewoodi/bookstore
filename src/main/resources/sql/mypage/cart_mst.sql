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


SELECT * FROM cart_mst;

drop table cart_mst;

---------------------------------------
INSERT INTO cart_mst VALUES (NULL, '1', '2', 'AL0000002543', '국가로 듣는 세계사 : 영국인 저널리스트의 배꼽 잡는 국가 여행기', '2', '알렉스 마셜 지음 ; 박미준 옮김', '틈새책방', '2021', '역사/문화', '19000', '98', '3');

-- ** cart_mst랑 register랑 조인
SELECT cm.cart_id as cartId, cm.reg_id as cmRegId, cm.book_id as bookId, cm.book_code as bookCode, cm.book_name as bookName, cm.book_stock as bookStock, cm.author as author, cm.publisher as publisher, cm.publication_date as publicationDate, cm.category as category, cm.price as price, cm.visit as visit, cm.quantity as quantity, r.reg_id as rRegId FROM cart_mst cm LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id) WHERE r.reg_id = '1';

SELECT cm.cart_id as cartId, cm.reg_id as cmRegId, cm.book_id as bookId, cm.book_code as bookCode, cm.book_name as bookName, cm.book_stock as bookStock, cm.author as author, cm.publisher as publisher, cm.publication_date as publicationDate, cm.category as category, cm.price as price, cm.visit as visit, cm.quantity as quantity, r.reg_id as rRegId FROM cart_mst cm LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id) WHERE r.reg_id = #{regId}

SELECT
    cm.cart_id as cartId,
    cm.reg_id as cmRegId,
    cm.book_id as bookId,
    cm.book_code as bookCode,
    cm.book_name as bookName,
    cm.book_stock as bookStock,
    cm.author as author,
    cm.publisher as publisher,
    cm.publication_date as publicationDate,
    cm.category as category,
    cm.price as price,
    cm.visit as visit,
    cm.quantity as quantity,
    r.reg_id as rRegId
FROM
    cart_mst cm
    LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id)
WHERE
    r.reg_id = '1';

-- ** cart_mst && register && book_mst 조인
SELECT
    cm.cart_id as cartId,
    cm.reg_id as cmRegId,
    cm.book_id as bookId,
    cm.book_code as bookCode,
    cm.book_name as bookName,
    cm.book_stock as bookStock,
    cm.author as author,
    cm.publisher as publisher,
    cm.publication_date as publicationDate,
    cm.category as category,
    cm.price as price,
    cm.visit as visit,
    cm.quantity as quantity,
    r.reg_id as rRegId,
    bm.book_id as bookId
FROM
    cart_mst cm
    LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id)
    LEFT OUTER JOIN book_mst bm ON(cm.book_id = bm.book_id)
WHERE
    cm.reg_id = #{regId}

SELECT cm.cart_id as cartId, cm.reg_id as cmRegId, cm.book_id as bookId, cm.book_code as bookCode, cm.book_name as bookName, cm.book_stock as bookStock, cm.author as author, cm.publisher as publisher, cm.publication_date as publicationDate, cm.category as category, cm.price as price, cm.visit as visit, cm.quantity as quantity, r.reg_id as rRegId, bm.book_id as bookId FROM cart_mst cm LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id) LEFT OUTER JOIN book_mst bm ON(cm.book_id = bm.book_id) WHERE cm.reg_id = '3';

SELECT cm.cart_id as cartId, cm.reg_id as cmRegId, cm.book_id as bookId, cm.book_code as bookCode, cm.book_name as bookName, cm.book_stock as bookStock, cm.author as author, cm.publisher as publisher, cm.publication_date as publicationDate, cm.category as category, cm.price as price, cm.visit as visit, cm.quantity as quantity, r.reg_id as rRegId, bm.book_id as bookId FROM cart_mst cm LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id) LEFT OUTER JOIN book_mst bm ON(cm.book_id = bm.book_id) WHERE cm.reg_id = #{regId}



---------------------------------
SELECT cm.book_id AS cmBookId, cm.reg_id AS cmRegId, bm.* FROM book_mst bm LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id) WHERE bm.book_id = cm.book_id ORDER BY cm.book_Id;
SELECT cm.book_id AS cmBookId, cm.reg_id AS cmRegId, bm.* FROM book_mst bm LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id) WHERE bm.book_id = cm.book_id ORDER BY cm.book_Id

SELECT
    cm.book_id AS cmBookId,
    cm.reg_id AS cmRegId,
    bm.*
FROM
    book_mst bm
    LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id)
WHERE
    bm.book_id = cm.book_id
ORDER BY cm.book_Id;
---------------------------------

