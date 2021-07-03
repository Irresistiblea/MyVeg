package com.myveg.demo.domain;

public class Product {
    long id;
    long band_id;
    String name;
    double commodity_price;
    String description;
    String pic;

    String band_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBand_id() {
        return band_id;
    }

    public void setBand_id(long band_id) {
        this.band_id = band_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(double commodity_price) {
        this.commodity_price = commodity_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", band_id=" + band_id +
                ", name='" + name + '\'' +
                ", commodity_price=" + commodity_price +
                ", description='" + description + '\'' +
                ", pic='" + pic + '\'' +
                ", band_name='" + band_name + '\'' +
                '}';
    }
}
