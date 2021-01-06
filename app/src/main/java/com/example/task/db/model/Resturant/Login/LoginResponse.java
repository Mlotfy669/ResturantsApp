package com.example.task.db.model.Resturant.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("sub_message")
    @Expose
    private String subMessage;
    @SerializedName("return")
    @Expose
    private Return _return;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public Return getReturn() {
        return _return;
    }

    public void setReturn(Return _return) {
        this._return = _return;
    }

    public String getMessage() {
        return message;
    }
}
