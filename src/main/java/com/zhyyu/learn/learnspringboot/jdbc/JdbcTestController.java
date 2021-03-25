package com.zhyyu.learn.learnspringboot.jdbc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("jdbcTest")
@Slf4j
public class JdbcTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("queryAll")
    public List<Student> queryAll() {
        List<Student> studentList = jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                return student;
            }
        });

        return studentList;
    }

    @Data
    static class Student {
        private Integer id;
        private String name;
    }

}
