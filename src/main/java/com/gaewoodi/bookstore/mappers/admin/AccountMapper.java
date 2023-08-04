package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AccountDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM register ORDER BY reg_id DESC")
    List<RegisterDto> getMemberAll();

    @Delete("DELETE FROM register WHERE reg_id={regId}")
    void deleteAccount(int regId);

    @Select("SELECT * FROM register WHERE reg_id = #{regId}")
    RegisterDto getMemberOne(int regId);

    @Update("UPDATE register SET level=#{level} ")

    @Update("UPDATE register SET id = {id}, " +
            "passwd={passwd}, " +
            "name={name}, " +
            "birth={birth}, " +
            "gender={gender}, " +
            "email={email}, " +
            "postcode={postcode}, " +
            "address={address}, " +
            "address1={address1}, " +
            "tel={tel}, grade={grade}, modified=now() WHERE reg_id=#{regId}")
    void setAccountUpdate(AccountDto accountDto);

}
