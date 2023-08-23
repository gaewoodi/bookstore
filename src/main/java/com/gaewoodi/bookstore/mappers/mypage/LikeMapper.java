package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.LikeDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {

    @Insert("INSERT INTO book_like VALUES(0, #{bookId}, #{userId}")
    void addLike(LikeDto likeDto);

    @Delete("DELETE FROM book_like WHERE book_id = #{bookId} AND user_id = #{userId}")
    void deleteLike(LikeDto likeDto);

    @Select("SELECT count(*) FROM book_like WHERE book_id = #{bookId} AND user_id = #{userId}")
    int getLikeStatus(LikeDto likeDto);

    @Select("SELECT COUNT(*) FROM book_like WHERE book_id = #{bookId}")
    int getLikeCount(int bookId);

    @Update("UPDATE book_mst SET book_like = #{bookLike} WHERE book_id = #{bookId}")
    void setBookLikeCount(BookDto bookDto);



}
