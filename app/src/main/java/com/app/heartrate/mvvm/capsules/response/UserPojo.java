package com.app.heartrate.mvvm.capsules.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPojo {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;

    public UserPojo(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
