package com.gaewoodi.bookstore.mappers.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PurchaseMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_id ASC LIMIT #{start}, #{limit}")
    List<BookDto> getBookList(Map<String, Object> map);

    //paging
    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();
}