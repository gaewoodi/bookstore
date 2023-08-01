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
    reg_tel varchar(13),
    reg_level int default 1, -- 1 회원 , 9 관리자 2 사원
    reg_grade varchar(50),
    reg_created datetime,
    reg_modified datetime,
    reg_image_name varchar(255),
    reg_image_size bigint,
    reg_trans_name varchar(255),
    primary key(reg_id)
);

INSERT INTO register VALUES(NULL, 'admin', '0824', '관리자', now(), 'M', 'admin@mail.com', NULL, '010-1111-1111' , '9', null, now(), now(), '', 0, '');


