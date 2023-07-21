use bookstore ;

create table inventory (
    도서번호	(책 코드) book_code varchar(45) not null,
    도서명	(책 이름) book_name varchar(45) not null,
    창고재고	(책 수량) book_count int not null,
    주문대기(주문과 연계)
    총 재고량
    재고수정
    판매상황	(sell/ sell out)
);