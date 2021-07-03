package com.myveg.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myveg.demo.domain.Location;
import com.myveg.demo.domain.SpokesPersonActivity;
import com.myveg.demo.service.SpokesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/spokesPerson")
public class SpokesPersonController {
    @Autowired
    private SpokesPersonService spokesPersonService;

    /**
     * 查找所有高校代言人信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAllSP(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("allSPs",spokesPersonService.findAll());
        modelAndView.setViewName("pages/spokes_person_management");
        return modelAndView;
    }
    /**
     * 查看高校代言人活动详情
     */
    @RequestMapping("/findActivityById")
    public ModelAndView findActivityByIdd(@RequestParam("id")long aid){
        ModelAndView modelAndView=new ModelAndView();
        SpokesPersonActivity spaById = spokesPersonService.findSPAById(aid);
        //设置姓名和地点名
        spaById.setSp_name(spokesPersonService.getSPNameById(spaById.getSp_name_id()));
        spaById.setLoc_name(spokesPersonService.getLocNameById(spaById.getLocation_id()));

        modelAndView.addObject("activityDetail",spaById);
        modelAndView.setViewName("pages/detail/activity_detail");
        return modelAndView;
    }
    /**
     * 查找所有高校代言人的活动
     * @return
     */
    @RequestMapping("/findAllSPActivities")
    public ModelAndView findAllSPActivitiess(){
        ModelAndView modelAndView=new ModelAndView();
        List<SpokesPersonActivity> allSPActivity = spokesPersonService.findAllSPActivity();
        for (SpokesPersonActivity spokesPersonActivity : allSPActivity) {
            spokesPersonActivity.setSp_name(spokesPersonService.getSPNameById(spokesPersonActivity.getSp_name_id()));
            spokesPersonActivity.setLoc_name(spokesPersonService.getLocNameById(spokesPersonActivity.getLocation_id()));
        }
        //初始默认展示所有活动的所有地点
        modelAndView.addObject("locId",0);
        modelAndView.addObject("allActivities",allSPActivity);
        //跳转到地图页面
        modelAndView.addObject("moveTo","start");
        modelAndView.setViewName("pages/spokes_person_activities");
        return modelAndView;
    }

    /**
     * 通过活动来查地址，返回json字符串
     * 这里的id表示活动的id
     */
    @RequestMapping("/findActivityPlaceByLocId")
    @ResponseBody
    public List<Location> findActivityPlacee(@RequestParam(value = "id",defaultValue = "0")long id){
        return spokesPersonService.findLocationsById(id);
    }

    /**
     * 通过地址查找所有活动
     * 这里的id表示地址id
     */
    @RequestMapping("/findAllActivityByLoc")
    public ModelAndView findAllActivityByLocc(@RequestParam(value = "id",defaultValue = "0")long id){
        ModelAndView modelAndView=new ModelAndView();
        List<SpokesPersonActivity> allSPActivity = spokesPersonService.findSPActivityByLoc(id);
        for (SpokesPersonActivity spokesPersonActivity : allSPActivity) {
            spokesPersonActivity.setSp_name(spokesPersonService.getSPNameById(spokesPersonActivity.getSp_name_id()));
            spokesPersonActivity.setLoc_name(spokesPersonService.getLocNameById(spokesPersonActivity.getLocation_id()));
        }
        modelAndView.addObject("locId",id);
        modelAndView.addObject("allActivities",allSPActivity);
        //跳转到活动列表页面
        modelAndView.addObject("moveTo","dataList");
        modelAndView.setViewName("pages/spokes_person_activities");
        return modelAndView;
    }
}
