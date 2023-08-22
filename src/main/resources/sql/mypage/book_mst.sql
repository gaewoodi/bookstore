use bookstore;

CREATE table book_mst (
       book_id int not null auto_increment,
       book_code varchar(45) not null unique,
       book_name varchar(45) not null,
       book_stock int default 0,
       author varchar(45),
       publisher varchar(45),
       publication_date year,
       category varchar(45) not null,
       price int not null,
       visit int default 0,
       save_name varchar(255),
       origin_name varchar(255),
       size bigint,
       book_like int default 0,
       primary key(book_id)
);


---------------------------------------------------------
-- ** book 정보 불러오기 book_mst, book_like join + paging처리

SELECT bm.book_id as bookId, bm.book_code as bookCode, bm.book_name as bookName, bm.book_stock as bookStock, bm.author, bm.publisher, bm.publication_date as publicationDate, bm.category, bm.price, bm.visit, bl.like_id as likeId, lc.like_count as like_count FROM book_mst bm LEFT OUTER JOIN book_like bl ON bl.book_id = bm.book_id AND bl.user_id = #{userId} LEFT OUTER JOIN (SELECT book_id, count(book_id) as like_count FROM book_like GROUP BY book_id) lc ON(lc.book_id = bm.book_id) WHERE 1 = 1 LIMIT #{start}, #{limit}

SELECT
    bm.book_id as bookId,
    bm.book_code as bookCode,
    bm.book_name as bookName,
    bm.book_stock as bookStock,
    bm.author, bm.publisher,
    bm.publication_date as publicationDate,
    bm.category,
    bm.price,
    bm.visit,
    bl.like_id as likeId,
    lc.like_count as like_count
FROM book_mst bm
LEFT OUTER JOIN book_like bl ON bl.book_id = bm.book_id AND bl.user_id = #{userId}
LEFT OUTER JOIN (SELECT
                    book_id,
                    count(book_id) as like_count
                    FROM book_like
                    GROUP BY book_id) lc
ON(lc.book_id = bm.book_id)
WHERE 1 = 1 LIMIT #{start}, #{limit}


---------------------------------------------------------
-- ** user_edit 정보수정

UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()


