package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

import java.util.Map;

@Mapper
public interface PurchaseMapper {

    @Insert("INSERT INTO purchase_mst VALUES (NULL, #{bookId}, #{regId}, now(), #{price}, #{quantity}, #{totalPrice}, #{purchaseStatus}, now())")
    void savePurchase(PurchaseDto purchaseDto);

    @Select("SELECT bm.*, pm.book_id, pm.reg_id FROM book_mst bm LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE bm.book_id = pm.book_id AND pm.reg_id = #{regId}")
    List<BookDto> getPurchaseBook(int regId);

    @Update("UPDATE purchase_mst SET price = #{price}")
    void updatePurchase(PurchaseDto purchaseDto);

    @Delete("DELETE FROM purchase_mst WHERE reg_id = #{regId} AND book_id = #{bookId}")
    void deletePurchase(int regId, int bookId);
}
