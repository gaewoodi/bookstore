package com.gaewoodi.bookstore.service.admin;


import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AdminBookDto;
import com.gaewoodi.bookstore.dto.admin.PagingDto;
import com.gaewoodi.bookstore.mappers.admin.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookPagingSrv {
    @Autowired
    private InventoryMapper inventoryMapper;

    public PagingDto pageCalc(int page) {
        int totalCount = inventoryMapper.getTotalCount();
        PagingDto pDto = new PagingDto();

        int totalPage = (int) Math.ceil(((double) totalCount / pDto.getPageCount()));
        int startPage = (((int) Math.ceil((double) page / pDto.getBlockCount())) - 1)  * pDto.getBlockCount() + 1;

        int endPage = startPage + pDto.getBlockCount() - 1;

        if( endPage > totalPage ) {
            endPage = totalPage;
        }

        pDto.setPage(page);
        pDto.setTotalPage(totalPage);
        pDto.setStartPage(startPage);
        pDto.setEndPage(endPage);

        return pDto;
    }

    public List<AdminBookDto> getPagingBook(int page) {
        Map<String, Object> map = new HashMap<>();
        PagingDto pagingDto = new PagingDto();

        int pageStartNum = (page - 1) * pagingDto.getPageCount();

        map.put("start", pageStartNum);
        map.put("limit", pagingDto.getPageCount());

        return inventoryMapper.getBookAll();
    }

}
