
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.KrsDAO;
import com.belajar.spring.entity.Dosen;
import com.belajar.spring.entity.Krs;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class KrsDAOImpl implements KrsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Krs save(Krs param) {
        String sql = "INSERT INTO " + Table.TABLE_KRS + " (idKrs, nameJurusan, nameFakultas) VALUES (?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getIdKrs());
            ps.setString(2, param.getNameJurusan());
            ps.setString(3, param.getNameFakultas());
            return ps;
        }, keyHolder);

        param.setIdKrs (param.getIdKrs());
        return param;
    }

    @Override
    public Krs update(Krs param) {
        String sql = "UPDATE " + Table.TABLE_KRS + " SET " +
                "nameJurusan = ?, " +
                "nameFakultas = ? " +
                "WHERE idkrs =  ? ";

        jdbcTemplate.update(sql,
                param.getNameJurusan(),
                param.getNameFakultas(),
                param.getIdKrs());

        return param;
    }

    @Override
    public int delete(Krs param) {
        String sql = "DELETE FROM " + Table.TABLE_KRS + " WHERE idKrs = ? ";

        return jdbcTemplate.update(sql, param.getIdKrs());
    }

    @Override
    public List<Krs> find() {
        String sql = "SELECT * FROM " + Table.TABLE_KRS;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public Krs findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " WHERE idKrs = ? ";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Krs.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }



    @Override
    public List<Krs> findByName(Krs param){
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " where nameJurusan like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNameJurusan() + "%"}, new BeanPropertyRowMapper<>(Krs.class));
    }


}