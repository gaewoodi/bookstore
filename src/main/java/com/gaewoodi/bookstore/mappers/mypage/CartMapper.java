package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

//    @Insert("INSERT INTO cart VALUES (NULL, {bookCode}, {bookName}, #{bookCount}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price})")
//    void getCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    BookDto getBook();

    @Select("SELECT * FROM book_mst WHERE book_id = ${checkResult} ${orCheckResult}")
    List<BookDto> getCartBookList(Map<String, Object> map);
//
//     @Select("SELECT * FROM book_mst WHERE ${checkResult}")
//    List<BookDto> getCartBookList(int bookId);




}
