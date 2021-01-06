package com.example.task.db.model.Resturant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RetJSON {

    private int status;
    private String sub_message;
    @SerializedName("return")
    @Expose
    private ArrayList<Restaurants> $return = new ArrayList<>();
    private String message;

    public RetJSON() {
    }

    public RetJSON(int status, String sub_message, ArrayList<Restaurants> $return, String message) {
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

    public ArrayList<Restaurants> getReturn() {
        return $return;
    }

    public String getMessage() {
        return message;
    }
}
