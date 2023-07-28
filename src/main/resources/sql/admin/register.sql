use bookstore;

create table book_register(
book_reg_id int not null auto_increment,
book_reg_userid varchar(20),
book_reg_passwd varchar(20) not null,
book_reg_name varchar(10) not null,
book_reg_birth date,
book_reg_gender char(1),
book_reg_email varchar(50) not null unique,
book_reg_adr varchar(255),
book_reg_tel varchar(15),
book_reg_level int default 1,
book_reg_grade varchar(50),
book_reg_created datetime,
book_reg_modified datetime,
book_reg_image_name varchar(255),
book_reg_image_size bigint,
book_reg_trans_name varchar(255),
primary key(book_reg_id)
);

INSERT INTO book_register VALUES(NULL, 'admin', '0824', '관리자', now(), 'M', 'admin@mail.com', NULL, '010-1111-1111', '9', null, now(), now(), '', 0, '');
