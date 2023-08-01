package com.gaewoodi.bookstore.dto.admin;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AccountDto {
    private int regId;
    private String regUserid;
    private String regPasswd;
    private String regName;
    private Date regBirth;
    private char regGender;
    private String regEmail;
    private String regAdr;
    private String regTel;
    private int regLevel;
    private String regGrade;
    private LocalDateTime regCreated;
    private LocalDateTime regModified;
    private String regImageName;
    private Long regImageSize;
    private String regTransName;
}
