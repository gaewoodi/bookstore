package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {

    @Insert("INSERT INTO register VALUES(NULL, #{id}, #{passwd}, #{name}, now(), 'M', #{email}, #{postcode}, #{address}, #{address1}, #{tel}, '9', null, '', '')")
    void getRegister(RegisterDto registerDto);

    @Insert("INSERT INTO register VALUES(NULL, #{id}, #{passwd}, #{name}, #{birth}, #{gender}, #{email}, #{postcode}, #{address}, #{address1}, #{tel}, #{level}, #{grade}, now(), now())")
    void saveRegister(RegisterDto registerDto);

    @Select("SELECT COUNT(*) FROM register WHERE id = #{id}")
    int idCheck(String id);

}
