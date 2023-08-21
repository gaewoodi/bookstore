package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO cart_mst VALUES (NULL, #{regId}, #{bookId}, now())")
    void saveCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst")
    BookDto getBook();

    @Select("SELECT cm.book_id, cm.reg_id, cm.create_date, bm.* FROM book_mst bm LEFT OUTER JOIN cart_mst cm ON(bm.book_id = cm.book_id) WHERE bm.book_id = cm.book_id AND cm.reg_id = #{regId} ORDER BY cm.book_Id")
    List<BookDto> getCartBookList(int regId);

    @Delete("DELETE FROM cart_mst WHERE reg_id = #{regId}")
    void deleteCart(int regId);

}
