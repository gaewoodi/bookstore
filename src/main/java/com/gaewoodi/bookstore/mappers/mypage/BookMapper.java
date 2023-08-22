package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    @Select("SELECT " +
            "bm.book_id as bookId, " +
            "bm.book_code as bookCode, " +
            "bm.book_name as bookName, " +
            "bm.book_stock as bookStock, " +
            "bm.author, bm.publisher, " +
            "bm.publication_date as publicationDate, " +
            "bm.category, " +
            "bm.price, " +
            "bm.visit, " +
            "bl.like_id as likeId, " +
            "lc.like_count as like_count\n" +
            "FROM book_mst bm " +
            "LEFT OUTER JOIN book_like bl ON bl.book_id = bm.book_id AND bl.user_id = #{userId} " +
            "LEFT OUTER JOIN (SELECT book_id, count(book_id) as like_count FROM book_like GROUP BY book_id) lc ON(lc.book_id = bm.book_id)\n" +
            "WHERE 1 = 1 LIMIT #{start}, #{limit}")
    List<BookDto> getBook(Map<String, Object> map);

    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    List<BookDto> viewBook(int bookId);

    // 조회수
    @Update("UPDATE book_mst SET visit = visit + 1 WHERE book_id = #{bookId}")
    void updateVisit(int bookId);

    // 카테고리
    @Select("SELECT * FROM book_mst WHERE category = #{category}")
    List<BookDto> getCategory(String category);

    //재고수
    @Select("SELECT book_stock FROM book_mst WHERE book_id = #{bookId}")
    int getBookStock(int bookId);

}
