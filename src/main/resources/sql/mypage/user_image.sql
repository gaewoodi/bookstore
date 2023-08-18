use bookstore;

create table user_image (
    user_image_id int not null auto_increment,
    reg_id int UNIQUE,
    save_name varchar(255), -- 변형해서 저장시킨 이름
    origin_name varchar(255), -- 원본이름
    image_size bigint,
    primary key(user_image_id)
);


DROP TABLE user_image;

SELECT * FROM user_image;

---------------------
-- 관리자 insert
INSERT INTO user_image VALUES (NULL, '1', NULL, NULL, NULL);

--** MypageMapper => mypage.html에 이미지랑 유저 정보 들고오는 join 쿼리
SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, ui.image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.reg_id WHERE r.reg_id = '3';

SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, ui.image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.reg_id WHERE r.reg_id = #{regId}


SELECT
	r.*,
	ui.user_image_id,
	ui.save_name,
	ui.origin_name,
	ui.image_size
FROM
	register r
	LEFT OUTER JOIN user_image ui ON r.reg_id = ui.reg_id
WHERE
	r.reg_id = #{regId}


-------------------------------------------------------------

