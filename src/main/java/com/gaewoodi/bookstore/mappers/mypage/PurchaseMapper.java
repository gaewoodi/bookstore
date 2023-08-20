package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import java.util.Map;

@Mapper
public interface PurchaseMapper {

    @Insert("INSERT INTO purchase_mst VALUES (NULL, #{bookId}, #{regId}, now(), #{price}, #{quantity}, #{totalPrice}, #{purchaseStatus}, now())")
    void savePurchase(PurchaseDto purchaseDto);

    @Select("SELECT * FROM book_mst bm LEFT OUTER JOIN purchase_mst ON(bm.book_id = pm.book_id) pm WHERE pm.book_id = #{bookId}")
    List<BookDto> getPurchaseBook(int regId);
}
