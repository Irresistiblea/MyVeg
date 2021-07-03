package com.myveg.demo.domain;

public class SpokesPersonActivity {
    long id;
    /*代言人姓名*/
    long sp_name_id;
    String activity_content;
    String begin_time;
    String end_time;
    long location_id;
    String status;

    String sp_name;
    String loc_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSp_name_id() {
        return sp_name_id;
    }

    public void setSp_name_id(long sp_name_id) {
        this.sp_name_id = sp_name_id;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    @Override
    public String toString() {
        return "SpokesPersonActivity{" +
                "id=" + id +
                ", sp_name_id=" + sp_name_id +
                ", activity_content='" + activity_content + '\'' +
                ", begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", location_id=" + location_id +
                ", status='" + status + '\'' +
                ", sp_name='" + sp_name + '\'' +
                ", loc_name='" + loc_name + '\'' +
                '}';
    }
}
