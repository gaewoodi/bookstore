use bookstore;

create table book_image (
    image_id int not null auto_increment,
    book_code varchar(45),
    save_name varchar(255) not null,
    origin_name varchar(255) not null,
    size bigint,
    primary key(image_id)
);

SELECT
    om.*,
    r.name,
    r.email,
    r.address,
    r.address1,
    r.tel,
    r.postcode,
    bm.*

FROM
    order_mst om

LEFT OUTER JOIN
    register r

ON
    om.id = r.id

LEFT OUTER JOIN
    book_mst bm

ON
    om.price = bm.price;