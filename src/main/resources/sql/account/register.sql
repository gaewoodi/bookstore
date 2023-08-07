use bookstore;


CREATE TABLE `register` (
  `reg_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(20) DEFAULT NULL,
  `passwd` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `birth` varchar(12) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `postcode` int NOT NULL,
  `address` varchar(255) NOT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `level` int DEFAULT 1,
  `grade` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `image_size` bigint DEFAULT NULL,
  `trans_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reg_id`),
  UNIQUE KEY `email` (`email`)
);


INSERT INTO `register` VALUES (1,'admin','0824','관리자','2023-08-03','M','admin@mail.com',47296,'부산 부산진구 중앙대로 668','(부전동) 4층','010-1234-4567',9,NULL,'2023-08-04 10:05:43','2023-08-04 10:05:43','',0,''),(2,NULL,'1111','홍길동','1990-11-11',NULL,'koreait@naver.com',6267,'서울 강남구 강남대로 238-4',' (도곡동)','01011112222',0,NULL,'2023-08-04 10:07:57','2023-08-04 10:07:57','',0,''),(3,NULL,'2222','김민지','1995-01-20',NULL,'busan@naver.com',47243,'부산 부산진구 동천로132번길 34',' (전포동)','01045678901',0,NULL,'2023-08-04 10:10:46','2023-08-04 10:10:46','',0,''),(4,NULL,'3333','박성훈','1970-07-28',NULL,'abcdf@gmail.com',6035,'서울 강남구 가로수길 5',' (신사동)','01089456125',0,NULL,'2023-08-04 10:12:34','2023-08-04 10:12:34','',0,''),(5,NULL,'4444','이유리','1964-02-10',NULL,'korea@naver.com',16824,'경기 용인시 수지구 고기로 189',' (동천동)','01065428965',0,NULL,'2023-08-04 10:14:54','2023-08-04 10:14:54','',0,''),(6,NULL,'5555','강재준','1997-08-25',NULL,'zxcvb@daum.net',47546,'부산 연제구 거제대로 140-5',' (거제동)','01023549654',0,NULL,'2023-08-04 10:16:51','2023-08-04 10:16:51','',0,''),(7,NULL,'6666','문동은','1994-12-25',NULL,'spring@daum.net',13479,'경기 성남시 분당구 서판교로 32',' (판교동)','01078952368',0,NULL,'2023-08-04 10:19:23','2023-08-04 10:19:23','',0,''),(8,NULL,'7777','이도현','1980-05-11',NULL,'summer@naver.com',63534,'제주특별자치도 서귀포시 가가로 14',' (상예동)','010456983265',0,NULL,'2023-08-04 10:20:58','2023-08-04 10:20:58','',0,''),(9,NULL,'8888','임지현','1988-04-12',NULL,'autumn@nate.com',48035,'부산 해운대구 반여로 133',' (반여동, 센텀롯데캐슬아파트)','01026956412',0,NULL,'2023-08-04 10:24:42','2023-08-04 10:24:42','',0,''),(10,NULL,'9999','강동원','1966-09-19',NULL,'winter@naver.com',21927,'인천 연수구 먼우금로 218',' (연수동, 연수푸르지오3단지)','01078963452',0,NULL,'2023-08-04 10:26:34','2023-08-04 10:26:34','',0,''),(11,NULL,'abc11','임윤아','1990-05-30',NULL,'star@naver.com',4362,'서울 용산구 원효로31길 12-3',' (원효로3가, 아카이브시티)','01089561234',0,NULL,'2023-08-04 10:29:21','2023-08-04 10:29:21','',0,'');


