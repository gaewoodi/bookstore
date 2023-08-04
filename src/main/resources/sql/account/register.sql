use bookstore;

create table register(
reg_id int not null auto_increment,
id varchar(20),
passwd varchar(20) not null,
name varchar(10) not null,
birth date,
gender char(1),
email varchar(50) not null unique,
postcode int not null,
address varchar(255) not null,
address1 varchar(255),
tel varchar(15),
level int default 1, -- 1 : 회원, 2 : 사원, 9 : 관리자
grade varchar(50),
created datetime,
modified datetime,
image_name varchar(255),
image_size bigint,
trans_name varchar(255),
primary key(reg_id)
);

INSERT INTO register VALUES(NULL, 'admin', '0824', '관리자', now(), 'M', 'admin@mail.com', '47296', '부산 부산진구 중앙대로 668', '(부전동) 4층', '010-1234-4567', '9', null, now(), now(), '', 0, '');