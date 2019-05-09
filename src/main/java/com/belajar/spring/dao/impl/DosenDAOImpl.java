/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.DosenDAO;
import com.belajar.spring.entity.Dosen;
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
public class DosenDAOImpl implements DosenDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Dosen save(Dosen param) {
        String sql = "INSERT INTO " + Table.TABLE_DOSEN + " (dosen_id,dosen_name, dosen_address) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getIdDosen());
            ps.setString(1, param.getNameDosen());
            ps.setString(2, param.getAddressDosen());
            return ps;
        }, keyHolder);

        param.setIdDosen(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Dosen update(Dosen param) {
        String sql = "UPDATE " + Table.TABLE_DOSEN + " SET " +
                "dosen_name = ?, " +
                "dosen_address = ? " +
                "WHERE dosen_id =  ? ";

        jdbcTemplate.update(sql,
                param.getNameDosen(),
                param.getAddressDosen(),
                param.getIdDosen());

        return param;
    }

    @Override
    public int delete(Dosen param) {
        String sql = "DELETE FROM " + Table.TABLE_DOSEN + " where dosen_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getIdDosen());
            return ps;
        });
        return rtn;
    }

    @Override
    public List<Dosen> find() {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dosen.class));
    }

    @Override
    public Dosen findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN + " WHERE dosen_id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dosen.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

    @Override
    public List<Dosen> findByName(Dosen param){
        String sql = "select * from " + Table.TABLE_DOSEN + " where dosen_name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getNameDosen() + "%"}, new BeanPropertyRowMapper<>(Dosen.class));
    }



}
