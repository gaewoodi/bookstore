package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book_mst LIMIT #{start}, #{limit}")
    List<BookDto> getBook(Map<String, Object> map);

    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();

    @Select("SELECT * FROM book_mst WHERE book_id = #{bookId}")
    List<BookDto> viewBook(int bookId);

    // 조회수
    @Update("UPDATE book_mst SET visit = visit + 1 WHERE book_id = #{bookId}")
    void updateVisit(int bookId);

    @Select("SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, ui.image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.reg_id WHERE r.reg_id = #{regId}")
    RegisterDto getBookByBookId(int bookId);

}
