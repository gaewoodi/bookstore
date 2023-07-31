package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.book.BestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface BestMapper {

@Select("select * from book_mst")
List<BestDto> getBestDtoList();

}
