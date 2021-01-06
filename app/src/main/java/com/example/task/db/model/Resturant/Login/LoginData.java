package com.example.task.db.model.Resturant.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("access_key")
    @Expose
    private String accessKey="Gdka52DASWE3DSasWE742Wq";
    @SerializedName("access_password")
    @Expose
    private String accessPassword="yH52dDDF85sddEWqPNV7D12sW5e";

    public LoginData(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }


}
