use bookstore;

create table user_image (
    user_image_id int not null auto_increment,
    reg_id int,
    save_name varchar(255), -- 변형해서 저장시킨 이름
    origin_name varchar(255), -- 원본이름
    image_size bigint,
    primary key(user_image_id)
);

---------------------
--** MypageMapper => mypage.html에 이미지랑 유저 정보 들고오는 join 쿼리
SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.user_image_id WHERE r.reg_id = 3

SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.user_image_id AND ui.user_image_id = #{regId} WHERE r.reg_id = #{regId}

ui = user_image
r = register r

SELECT
    ui.user_image_id,
    ui.save_name,
    ui.origin_name,
    image_size,
    r.*
FROM
    register r
LEFT OUTER JOIN
    user_image ui
ON
    r.reg_id = ui.user_image_id AND ui.user_image_id = #{regId}
WHERE
    r.reg_id = #{regId}
-------------------------------------------------------------

--** MypageMapper => user_edit에 이미지랑 유저 정보 들고오는 join 쿼리

