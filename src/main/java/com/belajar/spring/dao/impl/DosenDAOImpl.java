
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.DosenDao;
import com.belajar.spring.entity.Dosen;
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
 *
 * @author ACER i3
 */
@Repository
public class DosenDAOImpl implements DosenDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Dosen save(Dosen param){
        String sql = " INSERT INTO " +Table.TABLE_DOSEN + " (name_Dosen, address) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNameDosen());
            ps.setString(2, param.getAddressDosen());
            return ps;
        }, keyHolder);

        param.setIdDosen(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }
    
    @Override
    public Dosen update (Dosen param){
        String sql = "UPDATE " + Table.TABLE_DOSEN + " SET " +
                "name = ?, " +
                "address = ? " +
                "WHERE id_dosen =  ? ";

        jdbcTemplate.update(sql,
                param.getNameDosen(),
                param.getAddressDosen(),
                param.getIdDosen());

        return param;
    }
    @Override
    public int delete(Dosen param) {
        String sql = "DELETE FROM " + Table.TABLE_DOSEN + " WHERE id_dosen = ? ";

        return jdbcTemplate.update(sql, param.getIdDosen());
    }

    @Override
    public List<Dosen> find() {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dosen.class));
    }

    @Override
    public Dosen findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN + " WHERE id_dosen = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dosen.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
}
