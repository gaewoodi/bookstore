package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AccountDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("INSERT INTO book_register VALUES(NULL, " +
            "#{bookRegUserid}, " +
            "#{bookRegPasswd}, " +
            "#{bookRegName}, " +
            "now(), " +
            "'M', " +
            "#{bookRegEmail}, " +
            "NULL, " +
            "#{bookRegTel}, '1', null, now(), now(), '', 0, '')")
    void getRegister(RegisterDto registerDto);

    @Select("SELECT * FROM book_register ORDER BY book_reg_id DESC")
    List<RegisterDto> getMemberAll();

    @Select("SELECT * FROM book_register WHERE book_reg_id = #{bookRegId}")
    RegisterDto getMemberOne(int id);

    @Update("UPDATE book_register SET " +
            "book_reg_userid = #{bookRegUserid}, " +
            "book_reg_passwd = #{bookRegPasswd}, " +
            "book_reg_name = #{bookRegName}, " +
            "book_reg_email = #{bookRegEmail}, " +
            "book_reg_adr = #{bookRegAdr}, " +
            "book_reg_tel=#{bookRegTel}, " +
            "book_reg_level=#{bookRegLevel}, " +
            "book_reg_grade=#{Grade}, " +
            "book_reg_modified= NOW() " +
            "WHERE book_reg_id = #{bookRegId}")
    void setAccountUpdate(RegisterDto registerDto);


}
