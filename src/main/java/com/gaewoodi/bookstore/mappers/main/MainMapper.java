package com.gaewoodi.bookstore.mappers.main;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.BestsellerDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    @Select("select * from book_mst where book_id = '463'")
    BookDto getMst();

    @Select("select M.book_id, M.book_code, B.book_name, B.book_subname, B.book_img from book_bestseller B inner join book_mst M on B.book_id = M.book_id where B.book_id = '463'")
    BestsellerDto getMainDto();

    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, M.visit\n" +
            "from book_bestseller B\n" +
            "inner join book_mst M\n" +
            "on B.book_id = M.book_id\n" +
            "where M.publication_date >= '2022' order by visit desc limit 6;")
    List<BestsellerDto> getImage();

    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, M.visit from book_bestseller B inner join book_mst M on B.book_id = M.book_id order by visit desc limit 1;")
    BestsellerDto getGawoody();

    @Select("select * from book_bestseller order by book_mz desc limit 1")
    BestsellerDto getMz();

    @Select("select * from book_bestseller order by book_trend desc limit 1;")
    BestsellerDto getTrend();

    @Select("select B.book_id, B.book_name, B.book_subname, B.book_img from book_mst M inner join book_bestseller B on M.book_id = B.book_id order by book_stock desc limit 1")
    BestsellerDto getPublisher();

    @Select("select B.book_id, M.book_code, B.book_name, B.book_subname, B.book_img, B.book_media, M.visit from book_bestseller B inner join book_mst M on B.book_id = M.book_id order by book_media desc limit 1")
    BestsellerDto getMedia();
    @Select("select B.book_id, B.book_name, B.book_subname, B.book_img from book_mst M inner join book_bestseller B on M.book_id = B.book_id where category = '에세이' order by visit desc limit 1")
    BestsellerDto getThisBook();
}


