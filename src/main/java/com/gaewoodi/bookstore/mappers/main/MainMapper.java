package com.gaewoodi.bookstore.mappers.main;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.BestsellerDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    @Select("select * from book_mst order by book_id desc")
    BookDto getBookList();

    @Select("select * from book_mst where book_code = 'AL0000000504'")
    BookDto getMainDto(BookDto bookDto);

    @Select("select B.book_id, B.book_name, B.book_subname, M.visit\n" +
            "from book_bestseller B\n" +
            "inner join book_mst M\n" +
            "on B.book_id = M.book_id\n" +
            "where M.publication_date >= '2022' order by visit desc limit 6;")
    List<BestsellerDto> getSlider();

}
