package com.gaewoodi.bookstore.mappers.admin;


import com.gaewoodi.bookstore.dto.admin.LevelDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LevelMapper {

    @Select("select R.level, Acct.level_name FROM register R " +
            "INNER JOIN Account_level Acct ON R.level = Acct.level WHERE Acct.level_name=#{levelName}")
    List<LevelDto> getLevel();
}
