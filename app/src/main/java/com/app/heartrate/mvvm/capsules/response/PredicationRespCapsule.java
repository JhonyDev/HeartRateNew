package com.app.heartrate.mvvm.capsules.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredicationRespCapsule {
    @SerializedName("Target")
    @Expose
    private Integer target;


    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
