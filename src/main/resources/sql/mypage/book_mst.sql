use bookstore;

CREATE table book_mst (
       book_id int not null auto_increment,
       book_code varchar(45) not null unique,
       book_name varchar(45) not null,
       book_stock int default 0,
       author varchar(45),
       publisher varchar(45),
       publication_date year,
       category varchar(45) not null,
       price varchar(45) not null,
       visit int default 0,
       primary key(book_id)
);

UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()
UPDATE register SET id = #{id}