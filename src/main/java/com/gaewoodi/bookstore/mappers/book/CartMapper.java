package com.gaewoodi.bookstore.mappers.book;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.purchase.CartDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface CartMapper {

//    @Insert("INSERT INTO cart VALUES (NULL, {bookCode}, {bookName}, #{bookCount}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price})")
//    void getCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    List<BookDto> getCartBook();

//    @Select("SELECT * FROM book_mst")
//    List<BookDto> getBookData();
}
