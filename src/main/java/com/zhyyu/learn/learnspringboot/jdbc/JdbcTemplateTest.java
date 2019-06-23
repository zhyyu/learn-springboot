package com.zhyyu.learn.learnspringboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplateTest
 * <pre>
 *     1. 仅需配置properties, url username pwd, 即可使用 jdbcTemplate
 *     2. starter 构建好datasource 等bean, 无需手动构建
 * </pre>
 */
@Component
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void testQueryAll() {
        queryAll();
    }

    public void queryAll() {
        List<User> userList = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setUserName(rs.getString("userName"));
                user.setRoleId(rs.getInt("roleId"));
                user.setCreateDate(rs.getDate("create_date"));
                return user;
            }
        });

        System.out.println(userList);
    }

}
