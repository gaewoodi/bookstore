use bookstore;

create table book_image (
    image_id int not null auto_increment,
    image_book_code varchar(45) not null,
    image_save_name varchar(255) not null,
    image_origin_name varchar(255) not null,
    image_size bigint,
    primary key(image_id)
);