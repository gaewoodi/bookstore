package com.gaewoodi.bookstore.dto.account;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RegisterDto {
    private int bookRegId;
    private String bookRegUserid;
    private String bookRegPasswd;
    private String bookRegName;
    private Date bookRegBirth;
    private String bookRegGender;
    private String bookRegEmail;
    private String bookRegAdr;
    private String bookRegTel;
    private int bookRegLevel;
    private String bookRegGrade;
    private LocalDateTime bookRegCreated;
    private LocalDateTime bookRegModified;
    private Long bookRegImageSize;
    private String bookRegTransName;
}
