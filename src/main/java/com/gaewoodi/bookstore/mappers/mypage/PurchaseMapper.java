package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurchaseMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_id ASC")
    List<BookDto> getBookList();

    //paging
    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    List<BookDto> getPurchaseBook(int bookId);
}
