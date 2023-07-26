package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book_mst LIMIT #{start}, #{limit}")
    List<BookDto> getBook(Map<String, Object> map);

    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();

}
