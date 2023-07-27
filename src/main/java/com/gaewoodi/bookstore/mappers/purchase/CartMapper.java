package com.gaewoodi.bookstore.mappers.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

//    @Insert("INSERT INTO cart VALUES (NULL, {bookCode}, {bookName}, #{bookCount}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price})")
//    void getCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    BookDto getCartBook(int bookId);

    @Select("SELECT * FROM book_mst")
    BookDto getBookData(int bookId);
}
