
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.KRSDAO;
import com.belajar.spring.entity.Dosen;
import com.belajar.spring.entity.KRS;
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
public class KRSDAOImpl implements KRSDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public KRS save(KRS param) {
        String sql = "INSERT INTO " + Table.TABLE_KRS + " (krs_id, name_jurusan, name_fakultas) VALUES (?, ?, ?)";

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
    public KRS update(KRS param) {
        String sql = "UPDATE " + Table.TABLE_KRS + " SET " +
                "name_jurusan = ?, " +
                "name_fakultas = ? " +
                "WHERE krs_id =  ? ";

        jdbcTemplate.update(sql,
                param.getNameJurusan(),
                param.getNameFakultas(),
                param.getIdKrs());

        return param;
    }

    @Override
    public int delete(KRS param) {
        String sql = "DELETE FROM " + Table.TABLE_KRS + " WHERE krs_id = ? ";

        return jdbcTemplate.update(sql, param.getIdKrs());
    }

    @Override
    public List<KRS> find() {
        String sql = "SELECT * FROM " + Table.TABLE_KRS;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(KRS.class));
    }

    @Override
    public KRS findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " WHERE krs_id = ? ";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(KRS.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }



    @Override
    public List<KRS> findByName(KRS param){
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " where name_jurusan like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNameJurusan() + "%"}, new BeanPropertyRowMapper<>(KRS.class));
    }


}