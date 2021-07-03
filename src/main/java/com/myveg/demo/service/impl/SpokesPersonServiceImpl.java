package com.myveg.demo.service.impl;

import com.myveg.demo.dao.SpokesPersonDao;
import com.myveg.demo.domain.Location;
import com.myveg.demo.domain.SpokesPerson;
import com.myveg.demo.domain.SpokesPersonActivity;
import com.myveg.demo.service.SpokesPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpokesPersonServiceImpl implements SpokesPersonService {
    @Autowired
    private SpokesPersonDao spokesPersonDao;

    @Override
    public List<SpokesPerson> findAll() {
        return spokesPersonDao.findAll();
    }

    @Override
    public String getSPNameById(long id) {
        return spokesPersonDao.findSPById(id).getName();
    }

    @Override
    public List<SpokesPersonActivity> findAllSPActivity() {
        return spokesPersonDao.findAllSPActivity();
    }

    @Override
    public String getLocNameById(long id) {
        return spokesPersonDao.findLocById(id).getLocation_name();
    }

    @Override
    public SpokesPersonActivity findSPAById(long id) {
        return spokesPersonDao.findSPAById(id);
    }

    /**
     * 这里的id应该是活动的id
     * @param id
     * @return 该活动所在地点的所有
     */
    @Override
    public List<Location> findLocationsById(long id) {
        List<Location> list=new ArrayList<>();
        if (id==0){
            //查询所有高校代言人活动的所有位置
            //所有的活动
            List<SpokesPersonActivity> allSPActivity = spokesPersonDao.findAllSPActivity();
            for (SpokesPersonActivity spa : allSPActivity) {
                list.add(spokesPersonDao.findLocById(spa.getLocation_id()));
            }
            return list;
        }else {
            //查询某个活动对应的位置
            SpokesPersonActivity spaById = spokesPersonDao.findSPAById(id);
            list.add(spokesPersonDao.findLocById(spaById.getId()));
            return list;
        }
    }

    @Override
    public List<SpokesPersonActivity> findSPActivityByLoc(long id) {
        //先找地点
        Location locById = spokesPersonDao.findLocById(id);
        return spokesPersonDao.findSPAByLocId(locById.getId());
    }
}
