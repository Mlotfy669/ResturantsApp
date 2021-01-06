package com.example.task.db.model.Resturant.Order;

public class OrderDetails {

    private String prod_name;
    private int prod_quantity;
    private String prod_price;
    private String prod_image;

    public OrderDetails() {
    }

    public OrderDetails(String prod_name, int prod_quantity, String prod_price, String prod_image) {
        this.prod_name = prod_name;
        this.prod_quantity = prod_quantity;
        this.prod_price = prod_price;
        this.prod_image = prod_image;
    }

    public String getProd_name() {
        return prod_name;
    }

    public int getProd_quantity() {
        return prod_quantity;
    }

    public String getProd_price() {
        return prod_price;
    }

    public String getProd_image() {
        return prod_image;
    }
}
