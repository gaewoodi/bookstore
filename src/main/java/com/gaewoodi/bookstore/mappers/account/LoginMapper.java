package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM book_register WHERE book_reg_userid = #{bookRegUserid} AND book_reg_passwd = #{bookRegPasswd}")
    RegisterDto getBookInfo(RegisterDto registerDto);
}
