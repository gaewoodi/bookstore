package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM Account_level ORDER BY level_name ASC")
    List<RegisterDto> getLevel();

    @Select("select Acct.level_name,R.*,ui.* FROM register R " +
            "INNER JOIN Account_level Acct ON R.level = Acct.level " +
            "INNER JOIN user_image ui ON R.reg_id = ui.reg_id " +
            "ORDER BY R.reg_id DESC")
    List<RegisterDto> getMemberAll();


    @Update("UPDATE user_image SET save_name = NULL, origin_name = NULL, image_size= NULL WHERE reg_id = #{regId}")
    RegisterDto getImageName(int regId);


    @Select("SELECT * FROM register R INNER JOIN Account_level Acct ON R.level = Acct.level WHERE R.reg_id = #{regId}")
    RegisterDto getMemberOne(int regId);

    @Select("SELECT COUNT(*) FROM register")
    int getTotalCount();

    @Delete("DELETE register, user_image FROM register INNER JOIN user_image ON register.reg_id = user_image.reg_id WHERE register.reg_id=#{regId}")
    void deleteAccount(int regId);

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
