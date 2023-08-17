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
    @Select("SELECT ui.*, r.id, r.passwd, r.name, r.birth, r.gender, r.email, r.postcode, r.address, r.address1, r.tel, r.level, r.grade FROM user_image ui LEFT OUTER JOIN register r ON(ui.reg_id = r.reg_id) WHERE ui.reg_id = #{regId}")
    RegisterDto getMypageId(int regId);


    @Update("UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now()")
    void setRegister(RegisterDto registerDto);

    @Update("UPDATE user_image SET save_name = #{saveName}, origin_name = #{originName}, image_size = #{imageSize} WHERE reg_id = #{regId}")
    void fileUpload(UserImageDto userImageDto);

    @Select("SELECT * FROM user_image WHERE reg_id = #{regId}")
    UserImageDto getRegIdCheck(UserImageDto userImageDto);

}

