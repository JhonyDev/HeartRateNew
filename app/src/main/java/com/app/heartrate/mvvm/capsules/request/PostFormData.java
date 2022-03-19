package com.app.heartrate.mvvm.capsules.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostFormData {
    @SerializedName("age")
    @Expose
    int age;
    @SerializedName("gender")
    @Expose
    int sex;
    @SerializedName("chest_pain_type")
    @Expose
    int chestPainType;
    @SerializedName("resting_bp_s")
    @Expose
    int restingBPS;
    @SerializedName("cholestrol")
    @Expose
    int cholesterol;
    @SerializedName("resting_ecg")
    @Expose
    int restingECG;
    @SerializedName("max_heart_rate")
    @Expose
    int MaxHeartRate;
    @SerializedName("exercise_angina")
    @Expose
    int exerciseAngina;
    @SerializedName("old_peak")
    @Expose
    int oldPeak;
    @SerializedName("st_slope")
    @Expose
    int STSlope;
    @SerializedName("fasting_blood_sugar")
    @Expose
    int fastingBloodSugar;

    public PostFormData(int age, int sex, int chestPainType, int restingBPS, int cholesterol, int fastingBloodSugar, int restingECG, int maxHeartRate, int exerciseAngina, int oldPeak, int STSlope) {
        this.age = age;
        this.sex = sex;
        this.chestPainType = chestPainType;
        this.restingBPS = restingBPS;
        this.cholesterol = cholesterol;
        this.fastingBloodSugar = fastingBloodSugar;
        this.restingECG = restingECG;
        this.MaxHeartRate = maxHeartRate;
        this.exerciseAngina = exerciseAngina;
        this.oldPeak = oldPeak;
        this.STSlope = STSlope;
    }


}
