package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> mypage

@Mapper
public interface PurchaseMapper {

    @Select("SELECT * FROM book_mst ORDER BY book_id ASC")
    List<BookDto> getBookList();

    //paging
    @Select("SELECT count(*) FROM book_mst")
    int getTotalCount();
}
