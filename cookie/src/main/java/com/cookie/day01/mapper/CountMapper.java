package com.cookie.day01.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Roger
 */
public interface CountMapper {

    @Select("select count from count")
    int count();

    @Update("update count set count = #{count}")
    void updateCount(int count);
}
