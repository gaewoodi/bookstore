package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
=======
>>>>>>> mypage
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

//    @Insert("INSERT INTO cart VALUES (NULL, {bookCode}, {bookName}, #{bookCount}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price})")
//    void getCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
<<<<<<< HEAD
    BookDto getCartBook(int bookId);

    @Select("SELECT * FROM book_mst")
    BookDto getBookData(int bookId);
=======
    List<BookDto> getCartBook(int bookId);

>>>>>>> mypage
}
