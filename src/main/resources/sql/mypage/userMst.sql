use bookstore;

CREATE TABLE user_mst (
    user_id int not null auto_increment,
    user_name varchar(10) not null,
    user_password varchar(20) not null,
    user_phone int not null,
    user_email varchar(50) not null unique,
    user_gender char(1),
    user_address varchar(100) not null,
    create_date datetime,
    update_date datetime,
    user_level int default 1,
    primary key(user_id)
);

SELECT * FROM user_mst;

desc book_mst;