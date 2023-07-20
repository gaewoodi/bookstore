use bookstore;

create table book_image (
    image_id int not null auto_increment,
    book_code varchar(45) not null,
    save_name varchar(255) not null,
    origin_name varchar(255) not null,
    size bigint,
    primary key(image_id)
);