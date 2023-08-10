package com.gaewoodi.bookstore.mappers.admin;


import com.gaewoodi.bookstore.dto.admin.LevelDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LevelMapper {

    @Select("SELECT * FROM Account_level ORDER BY level_name ASC")
    List<LevelDto> getLevel();
}
