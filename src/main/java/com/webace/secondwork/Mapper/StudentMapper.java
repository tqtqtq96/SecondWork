package com.webace.secondwork.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webace.secondwork.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Student> selectByNameLike(@Param("name") String name);
}
