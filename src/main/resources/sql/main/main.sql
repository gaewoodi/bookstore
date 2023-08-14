

use bookstore;
create table bestseller (
    board_id int not null auto_increment,
    book_bestseller int,
    book_newbook int,
    book_partbest int,
    book_gawoody int,
    book_mz int,
    book_trend int,
    book_publisher int,
    book_media int,
    book_writer int,
    primary key(board_id)
);

insert into bestseller values()