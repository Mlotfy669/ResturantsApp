package com.example.task.db.model.Resturant.Order;

import java.util.ArrayList;

public class Order {

    private String order_id;
    private String order_user;
    private String order_price;
    private String user_location;
    private String resturant_name;
    private ArrayList<OrderDetails> order_details;

    public Order() {
    }

    public Order(String order_id, String order_user, String order_price, String user_location, String resturant_name, ArrayList<OrderDetails> details) {
        this.order_id = order_id;
        this.order_user = order_user;
        this.order_price = order_price;
        this.user_location = user_location;
        this.resturant_name = resturant_name;
        this.order_details = details;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_user() {
        return order_user;
    }

    public String getOrder_price() {
        return order_price;
    }

    public String getUser_location() {
        return user_location;
    }

    public String getResturant_name() {
        return resturant_name;
    }

    public ArrayList<OrderDetails> getDetails() {
        return order_details;
    }
}
