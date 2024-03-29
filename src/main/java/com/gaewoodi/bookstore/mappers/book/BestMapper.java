package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.book.BestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BestMapper {

@Select("select * from book_mst order by visit desc limit 30")
List<BestDto> getBestDtoList();

}
