package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.Student;
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

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student save(Student param) {
        String sql = "INSERT INTO " + Table.TABLE_STUDENT + " (name, address, kodeMataKuliah) VALUES (?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            ps.setString(3, param.getKodeMataKuliah());
            return ps;
        }, keyHolder);

        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Student update(Student param) {
        String sql = "UPDATE " + Table.TABLE_STUDENT + " SET " +
                "name = ?, " +
                "address = ? " +
                "kodeMataKuliah = ? " +
                "WHERE id =  ? ";

        jdbcTemplate.update(sql,
                param.getName(),
                param.getAddress(),
                param.getKodeMataKuliah(),
                param.getId());

        return param;
    }

    @Override
    public int delete(Student param) {
        String sql = "DELETE FROM " + Table.TABLE_STUDENT + " WHERE id = ? ";

        return jdbcTemplate.update(sql, param.getId());
    }

    @Override
    public List<Student> find() {
        String sql = "SELECT * FROM " + Table.TABLE_STUDENT;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        //String sql = "SELECT * FROM " + Table.TABLE_STUDENT + " WHERE id = ? ";
        /*SELECT id,NAME,address,kodeMataKuliah,namaMataKuliah
FROM table_student INNER JOIN table_krs
ON table_student.kodeMataKuliah=table_krs.id_krs*/
        String sql = "SELECT id, name, address,kodeMataKuliah id_dosen,namaMataKuliah,idDosen name_dosen " +
                " FROM " + Table.TABLE_STUDENT +" JOIN " +Table.TABLE_KRS +
                " ON " +".kodeMataKuliah=" + ".id_krs="+ " JOIN " +Table.TABLE_DOSEN +" ON "+".idDosen"+".id="
                +" WHERE " +Table.TABLE_STUDENT +".id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

}
