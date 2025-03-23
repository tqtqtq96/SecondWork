package com.webace.secondwork.Controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.webace.secondwork.Mapper.UserMapper;

import com.webace.secondwork.common.Result;
import com.webace.secondwork.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper usersMapper;
    @GetMapping("/users")
    public List<User> GetUsers(){
        return usersMapper.selectList(null);
    }
    @PostMapping("/users")
    public Result<String> addUsers(@RequestBody User user){
       Integer row = usersMapper.insert(user);
       if(row > 0){
           return Result.success("添加成功");
       }
       else{
           return Result.error("添加失败");
       }
    }

    @PutMapping("/users/{id}")
    public String updateUsers(@PathVariable Integer id,@RequestBody User user){
        user.setId(id);
        int rows = usersMapper.updateById(user);
        return rows > 0 ? "更新成功" : "用户不存在";

    }
    @PutMapping("/disable/{id}")
    public String disableUsers(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setStatus("DISABLED");
        int rows = usersMapper.updateById(user);
        return rows > 0 ? "禁用成功" : "禁用失败";
    }
}
