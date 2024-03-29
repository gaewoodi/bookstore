package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InventoryMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_id DESC")
    List<BookDto> getBookAll();

    @Select("SELECT COUNT(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT COUNT(*) FROM book_mst WHERE book_stock = 0")
    int getBookStockCount();

    @Select("SELECT * FROM book_mst WHERE book_id= #{bookId}")
    BookDto getBookOne(int bookId);

    @Update("UPDATE book_mst SET save_name=#{saveName}, origin_name=#{originName}, size=#{size} WHERE book_id=#{bookId}")
    void updateBookImage(BookDto bookDto);
}
