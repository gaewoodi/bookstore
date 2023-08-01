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

    @Insert("INSERT INTO register VALUES(NULL, " +
            "#{regUserid}, " +
            "#{regPasswd}, " +
            "#{regName}, " +
            "now(), " +
            "'M', " +
            "#{regEmail}, " +
            "NULL, " +
            "#{regTel}, '1', null, now(), now(), '', 0, '')")
    void getRegister(RegisterDto registerDto);

    @Select("SELECT * FROM register ORDER BY reg_id DESC")
    List<RegisterDto> getMemberAll();

    @Select("SELECT * FROM register WHERE reg_id = #{regId}")
    RegisterDto getMemberOne(int id);

    @Update("UPDATE register SET " +
            "reg_userid = #{regUserid}, " +
            "reg_passwd = #{regPasswd}, " +
            "reg_name = #{regName}, " +
            "reg_email = #{regEmail}, " +
            "reg_adr = #{regAdr}, " +
            "reg_tel=#{regTel}, " +
            "reg_level=#{regLevel}, " +
            "reg_grade=#{regGrade}, " +
            "reg_modified= NOW() " +
            "reg_id = #{regId}")
    void setAccountUpdate(RegisterDto registerDto);


}
