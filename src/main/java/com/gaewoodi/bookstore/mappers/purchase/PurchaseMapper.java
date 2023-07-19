package com.gaewoodi.bookstore.mappers.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurchaseMapper {

    @Select("SELECT * FROM book_mst ORDER BY bookId AES")
    List<BookDto> getBook(BookDto bookDto);
}
