package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MypageMapper {

    @Select("SELECT * FROM register")
    List<RegisterDto> getMemberAll();

    @Select("SELECT * FROM register WHERE reg_id = #{regId}")
    RegisterDto getMypageId(int regId);

    @Update("UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()")
    void setRegister(RegisterDto registerDto);

    @Update("UPDATE user_image SET origin_name = #{originName}, image_size = #{imageSize} WHERE user_image_id = #{userImageId}")
    void fileUpload(UserImageDto userImageDto);
}

