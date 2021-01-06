package com.example.task.db.model.Resturant.Order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RetJsonOrder {

    private int status;
    private String sub_message;
    @SerializedName("return")
    @Expose
    private ArrayList<Order> $return = new ArrayList<>();
    private String message;

    public RetJsonOrder() {
    }

    public RetJsonOrder(int status, String sub_message, ArrayList<Order> $return, String message) {
        this.status = status;
        this.sub_message = sub_message;
        this.$return = $return;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getSub_message() {
        return sub_message;
    }

    public ArrayList<Order> getReturn() {
        return $return;
    }

    public String getMessage() {
        return message;
    }
}
