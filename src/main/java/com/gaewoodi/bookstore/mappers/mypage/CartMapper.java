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

    @Insert("INSERT INTO cart_mst VALUES (NULL, #{regId}, #{bookId}, #{bookCode}, #{bookName}, #{bookStock}, #{author}, #{publisher}, #{publicationDate}, #{category}, #{price}, #{visit}, #{quantity})")
    void saveCart(CartDto cartDto);

    @Select("SELECT * FROM book_mst")
    BookDto getBook();

    @Select("SELECT cm.cart_id as cartId, cm.reg_id as cmRegId, cm.book_id as bookId, cm.book_code as bookCode, cm.book_name as bookName, cm.book_stock as bookStock, cm.author as author, cm.publisher as publisher, cm.publication_date as publicationDate, cm.category as category, cm.price as price, cm.visit as visit, cm.quantity as quantity, r.reg_id as rRegId, bm.book_id as bookId FROM cart_mst cm LEFT OUTER JOIN register r ON(cm.reg_id = r.reg_id) LEFT OUTER JOIN book_mst bm ON(cm.book_id = bm.book_id) WHERE cm.reg_id = #{regId}")
    List<BookDto> getCartBookList(int bookId);






}
