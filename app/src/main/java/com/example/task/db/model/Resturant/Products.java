package com.example.task.db.model.Resturant;

public class Products {

    private String prod_name;
    private int prod_id;
    private String prod_price;
    private String prod_image;

    public Products() {

    }

    public Products(String prod_name, int prod_id, String prod_price, String prod_image) {
        this.prod_name = prod_name;
        this.prod_id = prod_id;
        this.prod_price = prod_price;
        this.prod_image = prod_image;
    }

    public String getProd_name() {
        return prod_name;
    }

    public int getProd_id() {
        return prod_id;
    }

    public String getProd_price() {
        return prod_price;
    }

    public String getProd_image() {
        return prod_image;
    }
}
