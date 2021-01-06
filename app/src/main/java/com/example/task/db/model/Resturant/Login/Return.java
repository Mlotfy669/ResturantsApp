package com.example.task.db.model.Resturant.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Return {

    @SerializedName("id")
    @Expose
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
