package com.myveg.demo.dao.impl;

import com.myveg.demo.dao.MerchandiseDao;
import com.myveg.demo.domain.Classification;
import com.myveg.demo.domain.Merchandise;
import com.myveg.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MerchandiseDaoImpl implements MerchandiseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Merchandise> findAll() {
        String sql="select * from \"Merchandise\".\"band\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Merchandise.class));
    }
    @Override
    public Merchandise findMerchandiseById(long id) {
        String sql="select * from \"Merchandise\".\"band\" where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Merchandise.class),id);
    }

    @Override
    public Classification findClassificationById(long cid) {
        String sql="select * from \"Merchandise\".\"classification\" where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Classification.class),cid);
    }

    @Override
    public List<Classification> findAllClassification() {
        String sql="select * from \"Merchandise\".\"classification\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Classification.class));
    }


    @Override
    public List<Product> findProductByBandId(long id) {
        String sql="select * from \"Merchandise\".\"products\" where band_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class),id);
    }

    @Override
    public List<Product> findAllProduct() {
        String sql="select * from \"Merchandise\".\"products\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class));
    }


}
