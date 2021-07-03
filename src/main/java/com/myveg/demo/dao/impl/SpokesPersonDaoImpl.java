package com.myveg.demo.dao.impl;

import com.myveg.demo.dao.SpokesPersonDao;
import com.myveg.demo.domain.Location;
import com.myveg.demo.domain.SpokesPerson;
import com.myveg.demo.domain.SpokesPersonActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpokesPersonDaoImpl implements SpokesPersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SpokesPerson> findAll() {
        String sql="select * from \"SpokesPerson\".\"info\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(SpokesPerson.class));
    }

    @Override
    public SpokesPerson findSPById(long id) {
        String sql="select * from \"SpokesPerson\".\"info\" where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(SpokesPerson.class),id);
    }

    @Override
    public List<SpokesPersonActivity> findAllSPActivity() {
        String sql="select * from \"SpokesPerson\".\"activities\" order by id";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(SpokesPersonActivity.class));
    }

    @Override
    public SpokesPersonActivity findSPAById(long id) {
        String sql="select * from \"SpokesPerson\".\"activities\" where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(SpokesPersonActivity.class),id);
    }

    @Override
    public List<SpokesPersonActivity> findSPAByLocId(long locId) {
        String sql="select * from \"SpokesPerson\".\"activities\" where location_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(SpokesPersonActivity.class),locId);
    }

    @Override
    public List<Location> findAllLoc() {
        String sql="select * from \"SpokesPerson\".\"location_latlon\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Location.class));
    }

    @Override
    public Location findLocById(long id) {
        String sql="select * from \"SpokesPerson\".\"location_latlon\" where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Location.class),id);
    }


}
