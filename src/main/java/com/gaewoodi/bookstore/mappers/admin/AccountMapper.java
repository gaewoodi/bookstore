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

    @Select("SELECT * FROM register ORDER BY reg_id DESC")
    List<RegisterDto> getMemberAll();

    @Select("SELECT * FROM register WHERE reg_id = #{regId}")
    RegisterDto getMemberOne(int id);

}
