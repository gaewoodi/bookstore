package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FindPwMapper {
    @Select("SELECT COUNT(*) FROM register WHERE id = #{id}")
    int getPwInfo(RegisterDto registerDto);

    @Select("SELECT passwd FROM register WHERE id = #{id}")
    RegisterDto getUserPw(RegisterDto registerDto);
}
