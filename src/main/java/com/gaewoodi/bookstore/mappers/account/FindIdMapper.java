package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FindIdMapper {
    @Select("SELECT COUNT(*) FROM register WHERE name = #{name} AND birth = #{birth}")
    int getFindInfo(RegisterDto registerDto);
}
