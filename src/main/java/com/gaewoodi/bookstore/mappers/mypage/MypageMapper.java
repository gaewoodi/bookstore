package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MypageMapper {

    @Insert("INSERT INTO user_image VALUES(NULL, #{regId}, #{saveName}, #{originName}, #{imageSize})")
    void getUserIamge(UserImageDto userImageDto);

    // mypage 정보불러오기
    @Select("SELECT r.*, ui.* FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.user_image_id WHERE r.reg_id = #{regId}")
    RegisterDto getMypageId(int regId);


    @Update("UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()")
    void setRegister(RegisterDto registerDto);

    @Update("UPDATE user_image SET origin_name = #{originName}, image_size = #{imageSize} WHERE user_image_id = #{userImageId}")
    void fileUpload(UserImageDto userImageDto);
}

