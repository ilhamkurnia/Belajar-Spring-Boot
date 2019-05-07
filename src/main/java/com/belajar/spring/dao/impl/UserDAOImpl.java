package com.belajar.spring.dao.impl;

import com.belajar.spring.dao.UserDAO;
import com.belajar.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.belajar.spring.common.Table.TABLE_USER;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User param) {
        String sql = "INSERT INTO " + TABLE_USER + " ( username, password, email, profile_name) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getUsername());
            ps.setString(2, param.getPassword());
            ps.setString(3, param.getEmail());
            ps.setString(4, param.getProfileName());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public User update(User param) {
        String sql = "UPDATE " + TABLE_USER + " set username=?,password=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getUsername());
            ps.setString(2, param.getPassword());
            ps.setInt(3, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(User param) {
        String sql = "DELETE FROM " + TABLE_USER + " where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM " + TABLE_USER + " where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> find() {
        String sql = "SELECT * FROM " + TABLE_USER;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findByUsername(User param) {
        String sql = "SELECT * FROM " + TABLE_USER + " where username like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getUsername() + "%"}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE username = ? AND password = ? ";
        return jdbcTemplate.queryForObject(sql, new String[]{username, password}, new BeanPropertyRowMapper<>(User.class));
    }


}
