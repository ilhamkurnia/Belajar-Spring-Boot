package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.Krs;
import com.belajar.spring.entity.Student;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;



@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student save(Student param) {
        String sql = "INSERT INTO " + Table.TABLE_STUDENT + " (nameStudent , addressStudent, namaJurusan, fakultas) VALUES (?,?,?,?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNameStudent());
            ps.setString(2, param.getAddressStudent());
            ps.setString(3, param.getNamaJurusan());
            ps.setString(4, param.getFakultas());
            return ps;
        }, keyHolder);

        param.setIdStudent(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }


    @Override
    public Student update(Student param) {
        String sql = "update " + Table.TABLE_STUDENT + " set nameStudent=?,addressStudent=?,namaJurusan=?, fakultas=? where idStudent=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNameStudent());
            ps.setString(2, param.getAddressStudent());
            ps.setString(3, param.getNamaJurusan());
            ps.setString(4, param.getFakultas());
            ps.setInt(5, param.getIdStudent());
            return ps;
        });
        param.setIdStudent(rtn);
        return param;
    }

    @Override
    public int delete(Student param) {
        String sql = "DELETE from " + Table.TABLE_STUDENT + " where idStudent = ?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getIdStudent());
            return ps;
        });
        return rtn;
    }

    @Override
    public List<Student> find() {
        String sql = "SELECT * FROM " + Table.TABLE_STUDENT;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM "+ Table.TABLE_STUDENT + " where idStudent = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

    @Override
    public List<Student> findByName(Student param){
        String sql = "SELECT * FROM " + Table.TABLE_STUDENT + " where nameStudent like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNameStudent() + "%"}, new BeanPropertyRowMapper<>(Student.class));
    }
}