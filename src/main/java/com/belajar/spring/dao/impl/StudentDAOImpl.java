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
        String sql = "INSERT INTO " + Table.TABLE_STUDENT + " (nameStudent , addressStudent, idDosen , idKrs) VALUES (?,?,?,?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNameStudent());
            ps.setString(2, param.getAddressStudent());
            ps.setInt( 3, param.getIdDosen());
            ps.setInt(4, param.getIdKrs());
            return ps;
        }, keyHolder);

        param.setIdStudent(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }


    @Override
    public Student update(Student param) {
        String sql = "update " + Table.TABLE_STUDENT + " set nameStudent=?,addressStudent=? ,idDosen=? , idKrs =? where idStudent=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNameStudent());
            ps.setString(2, param.getAddressStudent());
            ps.setInt(3, param.getIdDosen());
            ps.setInt(4, param.getIdKrs());
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

    //SELECT nameStudent ,addressStudent ,nameDosen ,nameJurusan ,nameFakultas FROM (table_student JOIN  table_dosen ON table_student.idDosen =
    //                 table_dosen.idDosen ) JOIN table_krs ON table_student.idKrs = table_krs.idKrs
    @Override
    public List<Student> find() {
        String sql = "SELECT s.nameStudent ,s.addressStudent ,d.nameDosen ,k.nameJurusan ,k.nameFakultas "
                + "FROM (" + Table.TABLE_STUDENT +" s JOIN "+ Table.TABLE_DOSEN+" d ON s.idDosen ="
                + "d.idDosen ) JOIN "+ Table.TABLE_KRS +" k ON s.idKrs = k.idKrs";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT s.nameStudent ,s.addressStudent ,d.nameDosen ,k.nameJurusan ,k.nameFakultas "
                + "from (" + Table.TABLE_STUDENT +" s JOIN "+ Table.TABLE_DOSEN+" d ON s.idDosen = "
                + "d.idDosen ) JOIN "+ Table.TABLE_KRS +" k ON s.idKrs = k.idKrs"
                + "WHERE s.idStudent =?";
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