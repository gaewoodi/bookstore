package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

//    @Insert("INSERT INTO cart_mst VALUES (NULL, #{regId}, #{bookId}, #{bookCode}, #{bookName}, #{bookStock}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price}, #{visit}, #{quantity})")
    @Insert("INSERT INTO cart_mst VALUES (NULL, #{bookId}, #{bookCode}, #{bookName}, #{bookStock}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price}, #{visit}, #{quantity})")
    void saveCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst")
    BookDto getBook();


    @Select("SELECT * FROM book_mst WHERE book_id = #{bid}")
    List<BookDto> getCartBookList(int bid);

//     @Select("SELECT * FROM book_mst WHERE ${checkResult}")
//    List<BookDto> getCartBookList(int bookId);




}
