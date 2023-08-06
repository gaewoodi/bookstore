package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.book.BestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BestMapper {

    @Select("SELECT * FROM book_mst ORDER BY visit DESC LIMIT 4")
    List<BestDto> getBestDtoList();

    @Select("SELECT COUNT(*) FROM book_mst")
    int totalBookCount();
}

