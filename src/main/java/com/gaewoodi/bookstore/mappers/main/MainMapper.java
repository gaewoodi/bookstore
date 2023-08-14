package com.gaewoodi.bookstore.mappers.main;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    @Select("select * from book_mst where book_code = 'AL0000000504'")
    BookDto getMainDto(BookDto bookDto);

//    @Select("select book_id, book_name, visit, publication_date from book_mst where publication_date >= '2022' order by visit desc limit 6;")
//    List<book_>
}
