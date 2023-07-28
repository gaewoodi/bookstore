use bookstore;

create table book_register(
    book_reg_id int not null auto_increment, --아이디
    book_reg_userid varchar(20) , --사용자아이디
    book_reg_passwd varchar(20) not null, --비밀번호
    book_reg_name varchar(10) not null, --이름
    book_reg_birth date, --생일
    book_reg_gender char(1), -- 성별 남 여 M, W
    book_reg_email varchar(50) not null unique, --이메일
    book_reg_adr varchar(255), --주소
    book_reg_tel varchar(15), --전화번호
    kor_reg_level int default 1, --레벨 (1번 관리자, 2번 유저)
    kor_reg_grade varchar(50), --등급(bronze(10만원미만), silver(10만원이상20만원미만), gold(20만원이상30만원미만), platinum(30만원이상~)
    kor_reg_created datetime, --회원가입일
    kor_reg_modified datetime, --수정일
    kor_reg_image_name varchar(255), --이미지
    kor_reg_image_size bigint,
    kor_reg_trans_name varchar(255),
    primary key(book_reg_id)
);


INSERT INTO book_register VALUES(NULL, 'admin', '0824', '관리자', now(), 'M', 'admin@mail.com', NULL, '010-1111-1111', '1', null, now(), now(), '', 0, '');