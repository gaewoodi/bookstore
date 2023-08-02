use bookstore;

create table register(
reg_id int not null auto_increment,
    reg_userid varchar(20),
    reg_passwd varchar(20) not null,
    reg_name varchar(10) not null,
    reg_birth date,
    reg_gender char(1),
    reg_email varchar(50) not null unique,
    reg_adr varchar(255),
    reg_tel1 int(3),
    reg_tel2 int(4),
    reg_tel3 int(4),
    reg_level int default 1,
    reg_grade varchar(50),
    reg_created datetime,
    reg_modified datetime,
    reg_image_name varchar(255),
    reg_image_size bigint,
    reg_trans_name varchar(255),
    primary key(book_reg_id)
);

INSERT INTO book_register VALUES(NULL, 'admin', '0824', '관리자', now(), 'M', 'admin@mail.com', NULL, '010', '1234', '4567', '9', null, now(), now(), '', 0, '');


