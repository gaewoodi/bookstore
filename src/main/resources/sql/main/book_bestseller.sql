

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

--slide
insert into book_bestseller values('191','난데없이 메타버스','줄리엣에게 웃음을 돌려줘','0','0','0','0','0');
insert into book_bestseller values('364','문샷','불가능을 가능으로 만든 화이자의 대담한 전략','0','0','0','0');
insert into book_bestseller values('264','빅테크 트렌드 CES 2022','한 권으로 끝내는 미래 혁신 기술 대전망','0','0','0','0');
insert into book_bestseller values('244','놓아주는 엄마 주도하는 아이,자기주도성은 성공 경험으로 만들어진다','0','0','0','0');
insert into book_bestseller values('229','서영동 이야기','조남주 연작소설','0','0','0','0');
insert into book_bestseller values('321','이토록 치밀하고 친밀한 적에 대하여','나를 잃어버리게 하는 가스라이팅의 모든 것','0','0','0','0');


--gawoody
insert into book_bestseller values('364','문샷','불가능을 가능으로 만든 화이자의 대담한 전략','0','0','0','0');
insert into book_bestseller values('191','난데없이 메타버스','줄리엣에게 웃음을 돌려줘','0','0','0','0');
insert into book_bestseller values('47','스노볼','박소영 장편소설','0','0','0','0');
insert into book_bestseller values('5','코믹 헤븐에 어서 오세요','박서련 짧은 소설','0','0','0','0');
insert into book_bestseller values('50','킵 샤프','늙지 않는 뇌','0','0','0','0');
insert into book_bestseller values('15','에그박사. 4',null,'0','0','0','0');

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


-- 출판사
insert into book_bestseller values('29', "우리는 페퍼로니에서 왔어", "김금희 소설집", '10', '97', '0', null);
insert into book_bestseller values('72', "흔한남매. 9", "김금희 소설집", '10', '97', '0', null);
insert into book_bestseller values('73', "(채사장의)지대넓얕", "지적 대화를 위한 넓고 얕은 지식. 2, 자본이라는 신", '10', '97', '0', null);
insert into book_bestseller values('110', "네이버 vs 카카오", "대한민국 양대 빅테크 기업의 성장 동력과 미래 전략", '10', '97', '0', null);
insert into book_bestseller values('278', "그림들", "모마 미술관 도슨트북", '10', '97', '0', null);
insert into book_bestseller values('35', "다이어트보다 근력 운동", "여성의 몸에 맞는 운동은 따로 있다!", '10', '97', '0', null);

-- media
insert into book_bestseller values('284', "권력의 심리학", "누가 권력을 쥐고, 권력은 우리를 어떻게 바꾸는가", '10', '10', '177', null);
insert into book_bestseller values('18', "책이 사는 세계", "책, 책이 잠든 공간들에 대하여", '10', '10', '161', null);
insert into book_bestseller values('69', "나의 상상은 현실이 된다", "꿈꾸는 대로 이루어지는 마음 주문", '10', '10', '142', null);
insert into book_bestseller values('238', "대통령의 염장이", "대한민국 장례명장이 어루만진 삶의 끝과 시작", '10', '10', '136', null);
insert into book_bestseller values('45', "혼자여서 좋은 직업", "두 언어로 살아가는 번역가의 삶", '10', '10', '127', null);
insert into book_bestseller values('426', "사이언스 픽션", "과학은 어떻게 추락하는가", '10', '10', '110', null);


-- thisbook
insert into book_bestseller values('140', "그러라 그래", "양희은 에세이", '10', '10', '177', null);
insert into book_bestseller values('401', "나에게 맞는 삶을 가꿉니다", null, '10', '10', '161', null);
insert into book_bestseller values('45', "혼자여서 좋은 직업", "두 언어로 살아가는 번역가의 삶", '10', '10', '142', null);
insert into book_bestseller values('399', "미래를 구하러 온 초보인간", "낯선 세계를 건너는 초보자 응원 에세이", '10', '10', '136', null);
insert into book_bestseller values('243', "강아지 외개인", "사람이 좋아서 지구에 왔습니다", '10', '10', '127', null);
insert into book_bestseller values('164', "인생은 실전이다", "아주 작은 날갯짓의 시작", '10', '10', '110', null);


--bestseller
insert into book_bestseller values('170', '달러구트 꿈 백화점', '주문하신 꿈은 매진입니다', '0', '0', '0', '0');
insert into book_bestseller values('393', '나나', '이희영 장편소설', '0', '0', '0', '0');
insert into book_bestseller values('64', '우리 땅 더 넓고 더 깊게 여행하는 법', null, '0', '0', '0', '0');
insert into book_bestseller values('380', '오늘부터, 처음 텃밭 가꾸기', '베란다 텃밭부터 노지 텃밭까지 완전 정복', '0', '0', '0', '0');
insert into book_bestseller values('390', '나도 한다! 셀프 인테리어', '아야빠의 새집 만들기 프로젝트', '0', '0', '0', '0');
insert into book_bestseller values('454', '제나나잼', '달콤한 자연', '0', '0', '0', '0');
insert into book_bestseller values('199', '열한 살 감정툰', null, '0', '0', '0', '0');
insert into book_bestseller values('188', '순한 맛, 매운 맛 매생이 클럽 아이들', '어린이를 위한 글쓰기 교육 동화', '0', '0', '0', '0');
insert into book_bestseller values('390', '제나나잼', '달콤한 자연', '0', '0', '0', '0');
insert into book_bestseller values('432', '(비전공자도 이해할 수 있는)AI 지식', null, '0', '0', '0', '0');
insert into book_bestseller values('484', '코스모스', null, '0', '0', '0', '0');
insert into book_bestseller values('392', 'SNS로 돈 벌기=Make money with SNS', '뭐 해먹고 살지?', '0', '0', '0', '0');
insert into book_bestseller values('334', '생각은 어떻게 행동이 되는가', '목표를 세우고 성취하는 인지조절의 뇌과학', '0', '0', '0', '0');
insert into book_bestseller values('22', '고래가 가는 곳', '바닷속 우리의 동족 고래가 품은 지구의 비밀', '0', '0', '0', '0');
insert into book_bestseller values('412', '나를 알고 싶을 때 뇌과학을 공부합니다', null, '0', '0', '0', '0');
insert into book_bestseller values('145', '어른이라는 진지한 농담', '격식에 얽매이지 않고 품위를 지키는 27가지 방법', '0', '0', '0', '0');
insert into book_bestseller values('322', '당신이 살았던 날들', '죽음 뒤에도 반드시 살아남는 것들에 관하여', '0', '0', '0', '0');
insert into book_bestseller values('323', '3분 차이', null, '0', '0', '0', '0');



insert into book_bestseller values('118', '여기가 끝이 아니다', '진짜 끌어당김의 법칙', '0', '0', '0', '0');
insert into book_bestseller values('161', '내 곁에서 내 삶을 받쳐 주는 것들', '고전에서 찾은 나만의 행복 정원', '0', '0', '0', '0');
insert into book_bestseller values('304', '인생의 답은 내 안에 있다', '길 잃은 사람들을 위한 인생 인문학', '0', '0', '0', '0');insert into book_bestseller values('432', '(비전공자도 이해할 수 있는)AI 지식', null, '0', '0', '0', '0');
insert into book_bestseller values('177', '아주 보통의 행복', '평범해서 더욱 소중한', '0', '0', '0', '0');
insert into book_bestseller values('51', '리더의 말그릇', '비울수록 사람을 더 성장시키는', '0', '0', '0', '0');
insert into book_bestseller values('236', '럭키=Lucky', '내 안에 잠든 운을 깨우는 7가지 법칙', '0', '0', '0', '0');



