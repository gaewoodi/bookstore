package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_id ASC")
    List<BookDto> getBook();
}
