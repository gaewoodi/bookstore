    use bookstore;

    create table book_mst (
           book_id int not null auto_increment,
           book_code varchar(45) not null unique,
           book_name varchar(45) not null,
           book_count int default 0,
           author varchar(45),
           publisher varchar(45),
           publication_date year,
           category varchar(45) not null,
           price varchar(45) not null,
           visit int default 0,
           primary key(book_id)
    );