
package com.webace.secondwork.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webace.secondwork.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
