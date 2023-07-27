package com.gaewoodi.bookstore.service.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.purchase.PagingDto;
import com.gaewoodi.bookstore.mappers.purchase.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PagingService {

    @Autowired
    private BookMapper bookMapper;

    public PagingDto bookCalculator(int page) {
        int totalCount = bookMapper.getTotalCount();
        PagingDto pagingDto = new PagingDto();

        int totalPage = (int) Math.ceil((double)totalCount / pagingDto.getPageCount());

        int startPage = (((int) Math.ceil((double) page / pagingDto.getBlockCount())) - 1) * pagingDto.getBlockCount() + 1;

        int endPage = startPage + pagingDto.getBlockCount() - 1;

        if(endPage > totalPage) {
            endPage = totalPage;
        }

        pagingDto.setPage(page);
        pagingDto.setTotalPage(totalPage);
        pagingDto.setStartPage(startPage);
        pagingDto.setEndPage(endPage);

        return pagingDto;
    }

    public List<BookDto> getBookPaging(int page) {
        Map<String, Object> map = new HashMap<>();

        PagingDto pagingDto = new PagingDto();

        int pageStartNumber = (page - 1) * pagingDto.getPageCount();

        map.put("start", pageStartNumber);
        map.put("limit", pagingDto.getPageCount());


        return bookMapper.getBook(map);
    }


}
