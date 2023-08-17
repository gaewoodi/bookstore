package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserImageDto {
    // image id
    private int userImageId;
    // register id
    private int regId;
    // 저장할이름
    private String saveName;
    // 원본이름
    private String originName;
    // 이미지용량
    private Long imageSize;

}
