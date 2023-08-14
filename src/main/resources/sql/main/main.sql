

use bookstore;
create table book_bestseller (
    book_id int auto_increment,
    book_name varchar(50) ,
    book_subname varchar(100),
    book_mz int,
    book_trend int,
    book_media int,
    book_img varchar(50),
    primary key(book_id)
);

--mz추천
insert into book_bestseller values('382', "꿈은 없고요", "그냥 성공하고 싶습니다", '150', '0', '0', null);
insert into book_bestseller values('163', "지구인만큼 지구를 사랑할 순 없어", "정세랑 에세이", '147', '0', '0', null);
insert into book_bestseller values('230', "꽃잎 한 장처럼", "오늘을 살아가는 당신을 위한 이해인 수녀의 시 편지", '138', '0', '0', null);
insert into book_bestseller values('371', "젊은 꼰대가 온다", "MZ세대와 회식 없이 친해지는 법", '126', '0', '0', null);
insert into book_bestseller values('319', "밀레니얼 실험실", "요즘 애들의 생각과 사는 방식", '120', '0', '0', null);
insert into book_bestseller values('480', "흔한 MBTI", "믿거나 말거나 나에게 어울리는 직업", '111', '0', '0', null);

-- trend
insert into book_bestseller values('270', "카카오 네이버, 지금사도 될까요?", null, '10', '154', '0', null);
insert into book_bestseller values('155', "해외구매대행으로 평생 돈 벌기", "n잡러시대 부캐로 방구석에서 투잡하기", '10', '138', '0', null);
insert into book_bestseller values('274', "웰씽킹=Wealthinking", "부를 창조하는 생각의 뿌리", '10', '120', '0', null);
insert into book_bestseller values('233', "세븐 테크", "3년 후 당신의 미래를 바꿀 7가지 기술", '10', '110', '0', null);
insert into book_bestseller values('429', "부의 인문학", "슈퍼리치의 서재에서 찾아낸 부자의 길", '10', '103', '0', null);
insert into book_bestseller values('314', "앞으로 10년 빅테크 수업", "미래를 바꿀 4가지 메가테크", '10', '97', '0', null);

-- media
insert into book_bestseller values('284', "권력의 심리학", "누가 권력을 쥐고, 권력은 우리를 어떻게 바꾸는가", '10', '10', '177', null);
insert into book_bestseller values('18', "책이 사는 세계", "책, 책이 잠든 공간들에 대하여", '10', '10', '161', null);
insert into book_bestseller values('69', "나의 상상은 현실이 된다", "꿈꾸는 대로 이루어지는 마음 주문", '10', '10', '142', null);
insert into book_bestseller values('238', "대통령의 염장이", "대한민국 장례명장이 어루만진 삶의 끝과 시작", '10', '10', '136', null);
insert into book_bestseller values('45', "혼자여서 좋은 직업", "두 언어로 살아가는 번역가의 삶", '10', '10', '127', null);
insert into book_bestseller values('426', "사이언스 픽션", "과학은 어떻게 추락하는가", '10', '10', '110', null);


