package com.gaewoodi.bookstore.mappers.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {

    @Insert("INSERT INTO book_register VALUES(NULL, #{bookRegUserid}, #{bookRegPasswd}, #{bookRegName}, now(), 'M', #{bookRegEmail}, NULL, #{bookRegTel}, '1', null, now(), now(), '', 0, '')")
    void getRegister(RegisterDto registerDto);

    @Select("SELECT COUNT(*) FROM book_register WHERE book_reg_passwd = #{bookRegPasswd}")
    int chkPwd(String passwd);



}
