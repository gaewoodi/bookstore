package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

@Data
public class PagingDto {
    //한 페이지에 표시될 게시물 수
    private int pageCount = 3;
    //표시할 페이지 번호의 갯수
    private int blockCount = 10;
    //페이지 표시
    private int page;
    //전체 게시물 수 => 계산할 때 필요
    private int totalPage;
    //첫 페이지에 있을 때 어떻게 할건지 / 1페이지에 있으면 이전 페이지 작동 안해야해서 만들어 줘야함
    private int startPage;
    //끝 페이지에 있을 때 어떻게 할건지
    private int endPage;
}
