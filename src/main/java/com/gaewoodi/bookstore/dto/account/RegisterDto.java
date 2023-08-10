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
    private String imageName;
    private Long imageSize;
    private String transName;
}
