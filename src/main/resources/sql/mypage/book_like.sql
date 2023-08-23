use bookstore;

CREATE TABLE book_like (
    like_id int NOT NULL AUTO_INCREMENT,
    book_id int NOT NULL,
    user_id varchar(45) NOT NULL,
    PRIMARY KEY (like_id)
);

-------------------------
SELECT
    count(*)
FROM
    book_like
WHERE
    book_id = #{bookId}
