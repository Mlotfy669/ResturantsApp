package com.example.task.db.model.Resturant;

import java.util.ArrayList;

public class Restaurants {

    private String rest_id;
    private String rest_name;
    private String rest_img;
    private String rest_locstion;
    private String rest_type;
    private ArrayList<Products> products;

    public Restaurants() {
    }

    public Restaurants(String rest_id, String rest_name, String rest_img, String rest_locstion, String rest_type, ArrayList<Products> products) {
        this.rest_id = rest_id;
        this.rest_name = rest_name;
        this.rest_img = rest_img;
        this.rest_locstion = rest_locstion;
        this.rest_type = rest_type;
        this.products = products;
    }

    public String getRest_id() {
        return rest_id;
    }

    public String getRest_name() {
        return rest_name;
    }

    public String getRest_img() {
        return rest_img;
    }

    public String getRest_locstion() {
        return rest_locstion;
    }

    public String getRest_type() {
        return rest_type;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }
}
