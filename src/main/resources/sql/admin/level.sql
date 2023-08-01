use bookstore

create table Account_level(
    reg_level int,
    reg_level_name varchar(30)
);

INSERT INTO Account_level VALUES(9, "관리자");
INSERT INTO Account_level VALUES(2, "사원");
INSERT INTO Account_level VALUES(1, "회원");

create table Account_grade(
    -- 구매 정보값
    grade_name varchar(20) -- 회원 등급 이름
);

INSERT INTO Account_grade VALUES (, "플래티넘");
INSERT INTO Account_grade VALUES (, "골드");
INSERT INTO Account_grade VALUES (, "실버");
INSERT INTO Account_grade VALUES (, "일반");