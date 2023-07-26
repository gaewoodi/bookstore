package com.gaewoodi.bookstore.dto.admin;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AccountDto {
    private int bookRegId;
    private String bookRegUserid;
    private String bookRegPasswd;
    private String bookRegName;
    private Date bookRegBirth;
    private char bookRegGender;
    private String bookRegEmail;
    private String bookRegAdr;
    private String bookRegTel;
    private int korRegLevel;
    private String korRegGrade;
    private LocalDateTime korRegCreated;
    private LocalDateTime korRegModified;
    private String korRegImageName;
    private Long korRegImageSize;
    private String korRegTransName;
}
