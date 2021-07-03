package com.myveg.demo.dao;

import com.myveg.demo.domain.Location;
import com.myveg.demo.domain.SpokesPerson;
import com.myveg.demo.domain.SpokesPersonActivity;

import java.util.List;

public interface SpokesPersonDao {
    public List<SpokesPerson> findAll();
    public SpokesPerson findSPById(long id);

    public List<SpokesPersonActivity> findAllSPActivity();
    public SpokesPersonActivity findSPAById(long id);
    public List<SpokesPersonActivity> findSPAByLocId(long locId);

    public List<Location> findAllLoc();
    public Location findLocById(long id);

}
