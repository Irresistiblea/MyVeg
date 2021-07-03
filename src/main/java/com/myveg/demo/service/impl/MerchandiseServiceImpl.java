package com.myveg.demo.service.impl;

import com.myveg.demo.dao.MerchandiseDao;
import com.myveg.demo.domain.Classification;
import com.myveg.demo.domain.Merchandise;
import com.myveg.demo.domain.Product;
import com.myveg.demo.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MerchandiseServiceImpl implements MerchandiseService {
    @Autowired
    private MerchandiseDao merchandiseDao;
    @Override
    public List<Merchandise> findAll() {
        return merchandiseDao.findAll();
    }

    @Override
    public String findBandNameById(long id) {
        Merchandise mcc = merchandiseDao.findMerchandiseById(id);
        return mcc.getName();
    }
    /*通过品牌名称找商品*/
    @Override
    public List<Product> findProductsByBandId(long id) {
        if (id==0){
            //查找所有商品
            return merchandiseDao.findAllProduct();
        }else {
            return merchandiseDao.findProductByBandId(id);
        }
    }

    @Override
    public String findClassificationNameById(long cid) {
        return merchandiseDao.findClassificationById(cid).getName();
    }

    @Override
    public List<Classification> findAllClassification() {
        return merchandiseDao.findAllClassification();
    }

}
