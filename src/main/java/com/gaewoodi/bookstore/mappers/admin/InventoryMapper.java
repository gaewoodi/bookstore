package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AdminBookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InventoryMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_code DESC")
    List<AdminBookDto> getBookAll();

    @Select("SELECT COUNT(*) FROM book_mst")
    int getTotalCount();

}
