package com.gaewoodi.bookstore.mappers.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MypageMapper {

    @Insert("INSERT INTO user_image VALUES(NULL, #{regId}, #{saveName}, #{originName}, #{imageSize})")
    void getUserImage(UserImageDto userImageDto);

    // mypage 정보불러오기
    @Select("SELECT r.*, ui.user_image_id, ui.save_name, ui.origin_name, image_size FROM register r LEFT OUTER JOIN user_image ui ON r.reg_id = ui.reg_id WHERE r.reg_id = #{regId}")
    RegisterDto getMypageId(int regId);


    @Update("UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()")
    void setRegister(RegisterDto registerDto);

    @Update("UPDATE user_image SET save_name = #{saveName}, origin_name = #{originName}, image_size = #{imageSize} WHERE reg_id = #{regId}")
    void fileUpload(UserImageDto userImageDto);

    @Select("SELECT * FROM user_image WHERE reg_id = #{regId}")
    UserImageDto getRegIdCheck(UserImageDto userImageDto);

}

