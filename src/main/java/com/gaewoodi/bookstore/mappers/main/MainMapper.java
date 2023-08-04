package com.gaewoodi.bookstore.mappers.main;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    @Select("select * from book_mst order by book_id desc limit 1")
    BookDto getBookList();

    @Select("select * from book_mst where book_code = #{bookCode}")
    BookDto getMainDto(BookDto bookDto);
}
