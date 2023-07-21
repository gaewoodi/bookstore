package com.gaewoodi.bookstore.service.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.purchase.PagingDto;
import com.gaewoodi.bookstore.mappers.purchase.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PagingService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    public PagingDto purchaseListCalculator(int page) {
        int totalCount = purchaseMapper.getTotalCount();

        PagingDto pagingDto = new PagingDto();

        int totalPage = (int) Math.ceil((double)totalCount / pagingDto.getPageCount());

        int startPage = (((int)Math.ceil((double) page / pagingDto.getBlockCount())) - 1) * pagingDto.getBlockCount() + 1 ;

        int endPage = startPage + pagingDto.getBlockCount() - 1;

        if(endPage > totalPage) {
            endPage = totalPage;
        }

        pagingDto.setPage(page);
        pagingDto.setTotalPage(page);
        pagingDto.setStartPage(page);
        pagingDto.setEndPage(page);

        return pagingDto;

    }

    public List<BookDto> getPagingPurchaseList(int page) {
        Map<String, Object> map = new HashMap<>();

        PagingDto pagingDto = new PagingDto();

        int pageStartNumber = (page - 1) * pagingDto.getPageCount();
        map.put("start", pageStartNumber);
        map.put("limit", pagingDto.getPageCount());

        return purchaseMapper.getBookList(map);
    }
}
