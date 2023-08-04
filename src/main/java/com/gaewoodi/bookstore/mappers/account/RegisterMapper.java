package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

    @Insert("INSERT INTO book_register VALUES(NULL, #{bookRegUserid}, #{bookRegPasswd}, #{bookRegName}, now(), 'M', #{bookRegEmail}, NULL, #{bookRegTel}, '1', null, now(), now(), '', 0, '')")
    void getRegister(RegisterDto registerDto);

}
