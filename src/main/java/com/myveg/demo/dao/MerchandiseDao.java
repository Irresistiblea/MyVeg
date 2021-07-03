package com.myveg.demo.dao;

import com.myveg.demo.domain.Classification;
import com.myveg.demo.domain.Merchandise;
import com.myveg.demo.domain.Product;

import java.util.List;

public interface MerchandiseDao {
    public List<Merchandise> findAll();
    public List<Product> findProductByBandId(long id);
    public List<Product> findAllProduct();
    public Merchandise findMerchandiseById(long id);
    public Classification findClassificationById(long cid);
    public List<Classification> findAllClassification();
}
