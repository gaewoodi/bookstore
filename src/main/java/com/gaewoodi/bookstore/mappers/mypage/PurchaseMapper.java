package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

import java.util.Map;

@Mapper
public interface PurchaseMapper {

    // purchase_mst 저장
    @Insert("INSERT INTO purchase_mst VALUES (NULL, #{bookId}, #{regId}, now(), now())")
    void savePurchase(PurchaseDto purchaseDto);

    @Select("SELECT bm.*, pm.book_id, pm.reg_id FROM book_mst bm LEFT OUTER JOIN purchase_mst pm ON(bm.book_id = pm.book_id) WHERE bm.book_id = pm.book_id AND pm.reg_id = #{regId}")
    List<BookDto> getPurchaseBook(int regId);

    @Delete("DELETE FROM purchase_mst WHERE reg_id = #{regId} AND book_id = ${deleteQuery}")
    void deletePurchase(int regId, String deleteQuery);

    //주문 취소 목록
    @Insert("INSERT INTO order_delete VALUES (NULL, #{bookId}, #{regId}, now(), now())")
    void saveOrderDelete(PurchaseDto purchaseDto);

    @Select("SELECT bm.*, od.book_id, od.reg_id FROM book_mst bm LEFT OUTER JOIN order_delete od ON(bm.book_id = od.book_id) WHERE bm.book_id = od.book_id AND od.reg_id = #{regId}")
    List<BookDto> getOrderDelete(int regId);

    @Delete("DELETE FROM order_delete WHERE reg_id = #{regId} AND book_id = #{bookId}")
    void deleteCart(int regId, int bookId);

}
