use bookstore

create table Account_level(
      level int,
      level_name varchar(30),
      primary key(level)
  );

INSERT INTO Account_level VALUES(9, "관리자");
INSERT INTO Account_level VALUES(2, "사원");
INSERT INTO Account_level VALUES(1, "회원");


--조인
select R.level, Acct.level_name FROM register R
INNER JOIN Account_level Acct ON R.level = Acct.level;


select R.*,Acct.level_name FROM register R
INNER JOIN Account_level Acct ON R.level = Acct.level ORDER BY reg_id DESC;