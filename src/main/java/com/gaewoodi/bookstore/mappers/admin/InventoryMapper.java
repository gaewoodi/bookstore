package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AdminBookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InventoryMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_code DESC")
    List<AdminBookDto> getBookAll();

    @Select("SELECT COUNT(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT * FROM book_mst WHERE book_id= #{bookId}")
    AdminBookDto getBookOne(int bookId);

    @Update("UPDATE book_mst SET save_name=#{saveName}, origin_name=#{originName}, size=#{size} WHERE book_id=#{bookId}")
    AdminBookDto updateBookImage(int bookId);
}
