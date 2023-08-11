use bookstore;

create table user_image (
    user_image_id int not null auto_increment,
    reg_id int,
    save_name varchar(255), -- 변형해서 저장시킨 이름
    origin_name varchar(255), -- 원본이름
    image_size bigint,
    primary key(user_image_id)
);

SELECT
    ui.*,
    r.reg_id
FROM
    user_image ui
LEFT OUTER JOIN
    register r
ON
    ui.user_image_id = r.reg_id
-------------------------------------------------------------

SELECT ui.*, r.reg_id FROM user_image ui LEFT OUTER JOIN register r ON ui.user_image_id = r.reg_id WHERE r.reg_id = 1
