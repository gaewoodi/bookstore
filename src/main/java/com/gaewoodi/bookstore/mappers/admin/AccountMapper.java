package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("select Acct.level_name,R.*,ui.origin_name FROM register R " +
            "INNER JOIN Account_level Acct ON R.level = Acct.level " +
            "INNER JOIN user_image ui ON R.reg_id = ui.reg_id " +
            "ORDER BY R.reg_id DESC")
    List<RegisterDto> getMemberAll();

    @Delete("DELETE FROM register WHERE reg_id=#{regId}")
    void deleteAccount(int regId);

    @Select("SELECT * FROM register R INNER JOIN Account_level Acct ON R.level = Acct.level WHERE R.reg_id = #{regId}")
    RegisterDto getMemberOne(int regId);

    @Select("SELECT COUNT(*) FROM register")
    int getTotalCount();

    @Update("UPDATE register SET id = {id}, " +
            "passwd={passwd}, " +
            "name={name}, " +
            "birth={birth}, " +
            "gender={gender}, " +
            "email={email}, " +
            "postcode={postcode}, " +
            "address={address}, " +
            "address1={address1}, " +
            "tel={tel}, '', grade={grade}, modified=now() WHERE reg_id=#{regId}")
    void setAccountUpdate(RegisterDto registerDto);

}
