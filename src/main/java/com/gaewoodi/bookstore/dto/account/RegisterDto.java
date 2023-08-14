package com.gaewoodi.bookstore.dto.account;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RegisterDto {
    private int regId;
    private String id;
    private String passwd;
    private String name;
    private String birth;
    private String gender;
    private String email;
    private int postcode;
    private String adr2;
    private String address;
    private String address1;
    private String tel;
    private int level;
    private String levelName;
    private String grade;
    private LocalDateTime created;
    private LocalDateTime modified;

    // image id
    private int userImageId;
    // 저장할이름
    private String saveName;
    // 원본이름
    private String originName;
    // 이미지용량
    private Long imageSize;

}
