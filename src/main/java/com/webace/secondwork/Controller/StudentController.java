package com.webace.secondwork.Controller;

import com.webace.secondwork.Mapper.StudentMapper;
import com.webace.secondwork.common.Result;
import com.webace.secondwork.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 通过 ID 查询学生信息
     */
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Long id) {
        Student student = studentMapper.selectById(id);
        if (student == null) {
            return Result.error("未找到 ID 为 " + id + " 的学生");
        }
        return Result.success(student);
    }

    /**
     * 新增学生
     */
    @PostMapping
    public Result<String> addStudent(@RequestBody Student student) {
        log.info("新增学生信息：{}", student);
        int rows = studentMapper.insert(student);
        if (rows > 0) {
            return Result.success("新增成功");
        }
        return Result.error("新增失败");
    }

    /**
     * 更新学生信息
     */
    @PutMapping
    public Result<String> updateStudent(@RequestBody Student student) {
        int rows = studentMapper.updateById(student);
        if (rows > 0) {
            return Result.success("更新成功");
        }
        return Result.error("更新失败，可能是 ID 不存在");
    }

    /**
     * 删除学生
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteStudent(@PathVariable Long id) {
        int rows = studentMapper.deleteById(id);
        if (rows > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败，ID " + id + " 不存在");
    }

    /**
     * 通过姓名模糊搜索学生
     */
    @GetMapping("/search")
    public Result<List<Student>> searchByName(@RequestParam String name) {
        List<Student> students = studentMapper.selectByNameLike("%" + name + "%");
        if (students.isEmpty()) {
            return Result.error("未找到姓名包含 '" + name + "' 的学生");
        }
        return Result.success(students);
    }
}
