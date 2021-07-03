package com.myveg.demo.controller;

import com.myveg.demo.domain.Merchandise;
import com.myveg.demo.domain.Product;
import com.myveg.demo.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mcc")
public class MerchandiseController {
    @Autowired
    private MerchandiseService merchandiseService;
    //查找所有品牌
    @RequestMapping("/findAll")
    public ModelAndView findAllMerchandises(){
        ModelAndView modelAndView=new ModelAndView();
        List<Merchandise> merchandises = merchandiseService.findAll();
        for (Merchandise merchandise : merchandises) {
            merchandise.setProduct_classification(merchandiseService.findClassificationNameById(merchandise.getProduct_classification_id()));
        }
        modelAndView.addObject("merchandisesList",merchandises);
        modelAndView.setViewName("pages/brand_management");
        return modelAndView;
    }

    /**
     * 查找商品
     * @return
     */
    //根据商家id查找特定商品
    @RequestMapping("/findProduct")
    public ModelAndView findProductt(@RequestParam(value = "bandId",defaultValue = "0")long id){
        ModelAndView modelAndView=new ModelAndView();
        List<Product> productsByBandId = merchandiseService.findProductsByBandId(id);
        for (Product product : productsByBandId) {
            //设置品牌名
            product.setBand_name(merchandiseService.findBandNameById(product.getBand_id()));
            //设置图片路径
            String sb = "../img/product/" +
                    product.getPic();//图片名，需要加上路径
            product.setPic(sb);
        }
        modelAndView.addObject("productsByBandId",productsByBandId);
        modelAndView.setViewName("pages/products_management");
        return modelAndView;
    }

    //查找所有分类
    @RequestMapping("/findAllClassifications")
    public ModelAndView findAllClassificationss(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("allClassfications",merchandiseService.findAllClassification());
        modelAndView.setViewName("pages/classification_management");
        return modelAndView;
    }
}
