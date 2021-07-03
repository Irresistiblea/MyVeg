package com.myveg.demo.service;

import com.myveg.demo.domain.Classification;
import com.myveg.demo.domain.Merchandise;
import com.myveg.demo.domain.Product;

import java.util.List;

public interface MerchandiseService {
    public List<Merchandise> findAll();
    public String findBandNameById(long id);
    public List<Product> findProductsByBandId(long id);
    public String findClassificationNameById(long cid);
    public List<Classification> findAllClassification();
}
