package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

//    @Select("SELECT bm.book_name AS bmBookName, pm.* FROM purchase_mst pm LEFT OUTER JOIN book_mst bm ON(bm.book_id = pm.book_id) WHERE pm.reg_id = #{regId}")
    @Select("select\n" +
            "    pm.*,\n" +
            "    bm.book_id,\n" +
            "    bm.book_code,\n" +
            "    bm.book_name,\n" +
            "    bm.book_stock,\n" +
            "    bm.author,\n" +
            "    bm.publisher,\n" +
            "    bm.publication_date,\n" +
            "    bm.category,\n" +
            "    bm.price,\n" +
            "    bm.visit,\n" +
            "    bm.book_like\n" +
            "from\n" +
            "    purchase_mst pm inner join book_mst bm ON(pm.book_id = bm.book_id)\n" +
            "WHERE\n" +
            "    pm.book_id = #{bookId}")
    List<PurchaseDto> getPurchase();
}
