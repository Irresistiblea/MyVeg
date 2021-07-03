package com.myveg.demo.service;

import com.myveg.demo.domain.Location;
import com.myveg.demo.domain.SpokesPerson;
import com.myveg.demo.domain.SpokesPersonActivity;

import java.util.List;

public interface SpokesPersonService {
    public List<SpokesPerson> findAll();
    public String getSPNameById(long id);
    public List<SpokesPersonActivity> findAllSPActivity();
    public String getLocNameById(long id);
    public SpokesPersonActivity findSPAById(long id);
    public List<Location> findLocationsById(long id);
    public List<SpokesPersonActivity> findSPActivityByLoc(long id);
}
