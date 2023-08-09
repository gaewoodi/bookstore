package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

@Data
public class LikeDto {
    // 좋아요 번호
    private int likeId;
    //도서 ID
    private int bookId;
    //사용자 ID
    private int userId;

}
