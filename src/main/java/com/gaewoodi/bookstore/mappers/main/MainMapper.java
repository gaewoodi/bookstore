package com.gaewoodi.bookstore.mappers.main;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.BestsellerDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface MainMapper {

////    조인
//    @Select("select * from book_bestseller B inner join book_mst M on B.book_id = M.book_id where book_id = #{bookId}")
//    BookDto getAll(int bookId);


//    스콘

    @Select("select * from book_mst where book_id = '463'")
    BookDto getMst();

    @Select("select M.book_id, M.book_code, B.book_name, B.book_subname, B.book_img from book_bestseller B inner join book_mst M on B.book_id = M.book_id where B.book_id = '463'")
    BestsellerDto getMainDto();

//    슬라이드

    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, M.visit\n" +
            "from book_bestseller B\n" +
            "inner join book_mst M\n" +
            "on B.book_id = M.book_id\n" +
            "where M.publication_date >= '2022' order by visit desc limit 6;")
    List<BestsellerDto> getImage();

    //    개우디추천
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, M.visit from book_bestseller B inner join book_mst M on B.book_id = M.book_id order by visit desc limit 1;")
    BestsellerDto getGawoody();

    //    mz추천
    @Select("select * from book_bestseller order by book_mz desc limit 1")
    BestsellerDto getMz();

    //    trend 추천
    @Select("select * from book_bestseller order by book_trend desc limit 1;")
    BestsellerDto getTrend();

    //    출판사추천
    @Select("select B.book_id, B.book_name, B.book_subname, B.book_img from book_mst M inner join book_bestseller B on M.book_id = B.book_id order by book_stock desc limit 1")
    BestsellerDto getPublisher();

    //    미디어 추천
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit from book_bestseller B inner join book_mst M on B.book_id = M.book_id order by book_media desc limit 1")
    BestsellerDto getMedia();

    //    이책어때
    @Select("select B.book_id, B.book_name, B.book_subname, B.book_img from book_mst M inner join book_bestseller B on M.book_id = B.book_id where category = '에세이' order by visit desc limit 1")
    BestsellerDto getThisBook();

    //베스트셀러(청소년/문학(에세이, 소설/시/희곡)) : : literature
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '에세이' or category = '소설/시/희곡' order by book_media desc limit 6")
    List<BestsellerDto> getLiterature();

    //베스트셀러(유아/어린이(유아/어린이, 기타)) : child
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '유아/어린이' or category = '기타' order by book_media desc limit 6")
    List<BestsellerDto> getChild();

    //베스트셀러(생활/육아(가정/생활)) : living
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '가정/생활' order by book_media desc limit 6")
    List<BestsellerDto> getLiving();

    //베스트셀러(정치/경제(정치/경제)) : politic
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '정치/경제' order by book_media desc limit 6")
    List<BestsellerDto> getPolitic();

    //베스트셀러(인문/사회(인문/사회)) : humanity
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '인문/사회' or category = '역사/문화' order by book_media desc limit 6")
    List<BestsellerDto> getHumanity();

    //베스트셀러(과학(과학, it)) : it
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = 'IT/과학' order by book_media desc limit 6")
    List<BestsellerDto> getIt();

    //베스트셀러(자기계발(자기계발)) : self
    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit, B.price from book_bestseller B inner join book_mst M on B.book_id = M.book_id where category = '자기계발' order by book_media desc limit 6")
    List<BestsellerDto> getSelf();

//    @Update("update book_heart set book_heart = book_heart + 1 where board_id = #{boardId}")
//    void getHeart(int bookId);

}


