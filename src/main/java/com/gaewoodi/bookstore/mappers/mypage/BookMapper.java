package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book_mst LIMIT #{start}, #{limit}")
    List<BookDto> getBook(Map<String, Object> map);

    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    List<BookDto> viewBook(int bookId);

    // 조회수
    @Update("UPDATE book_mst SET visit = visit + 1 WHERE book_id = #{bookId}")
    void updateVisit(int bookId);

    // 카테고리
    @Select("SELECT * FROM book_mst WHERE category = #{category}")
    List<BookDto> getCategory(String category);

    //재고수
    @Select("SELECT book_stock FROM book_mst WHERE book_id = #{bookId}")
    int getBookStock(int bookId);

}
