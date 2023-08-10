package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM register WHERE id = #{id} AND passwd = #{passwd}")
    RegisterDto getBookInfo(RegisterDto registerDto);

    @Select("SELECT * FROM register WHERE name = #{name} AND birth = #{birth}")
    RegisterDto getCheck(RegisterDto registerDto);

    @Select("SELECT * FROM register WHERE id = #{id}")
    RegisterDto getPwChk(RegisterDto registerDto);
}
