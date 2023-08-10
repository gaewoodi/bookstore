use bookstore;

create table user_image (
    user_image_id int not null auto_increment,
    reg_id int,
    save_name varchar(255) not null,
    origin_name varchar(255) not null,
    size bigint,
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

SELECT ui.*, r.reg_id FROM user_image ui LEFT OUTER JOIN register r ON ui.user_image_id = r.reg_id
