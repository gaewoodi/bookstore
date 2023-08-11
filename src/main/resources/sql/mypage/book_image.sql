use bookstore;

create table book_image (
    book_image_id int not null auto_increment,
    book_code varchar(45) not null,
    save_name varchar(255) not null, -- 변형이름
    origin_name varchar(255) not null, -- 원본이름
    image_size bigint,
    primary key(book_image_id)
);

