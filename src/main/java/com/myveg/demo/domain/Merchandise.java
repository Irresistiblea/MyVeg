package com.myveg.demo.domain;

public class Merchandise {
    long id;
    String name;
    String main_product;
    long product_classification_id;
    String place_of_origin;

    String product_classification;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain_product() {
        return main_product;
    }

    public void setMain_product(String main_product) {
        this.main_product = main_product;
    }

    public long getProduct_classification_id() {
        return product_classification_id;
    }

    public void setProduct_classification_id(long product_classification_id) {
        this.product_classification_id = product_classification_id;
    }

    public String getPlace_of_origin() {
        return place_of_origin;
    }

    public void setPlace_of_origin(String place_of_origin) {
        this.place_of_origin = place_of_origin;
    }

    public String getProduct_classification() {
        return product_classification;
    }

    public void setProduct_classification(String product_classification) {
        this.product_classification = product_classification;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", main_product='" + main_product + '\'' +
                ", product_classification_id=" + product_classification_id +
                ", place_of_origin='" + place_of_origin + '\'' +
                ", product_classification='" + product_classification + '\'' +
                '}';
    }
}
