use bookstore

create table Account_level(
      level int,
      level_name varchar(30),
      primary key(level),
      FOREIGN KEY(level) REFERENCES register(level)
  );

INSERT INTO Account_level VALUES(9, "관리자");
INSERT INTO Account_level VALUES(2, "사원");
INSERT INTO Account_level VALUES(1, "회원");


--조인
select R.level, Acc.level as 구분 FROM register r INNER JOIN Account_level acc ON R.level = Acc.level WHERE R.level = 1;

