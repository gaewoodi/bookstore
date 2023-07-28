package com.gaewoodi.bookstore.mappers.admin;

import com.gaewoodi.bookstore.dto.admin.AccountDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    @Insert("INSERT INTO bookstore VALUES (NULL, #{bookRegUserid}, #{bookRegPasswd}, #{bookRegName},)")
    void setAccountView(AccountDto accountDto);

}
