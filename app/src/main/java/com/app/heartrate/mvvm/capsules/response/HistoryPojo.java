package com.app.heartrate.mvvm.capsules.response;

import com.app.heartrate.mvvm.capsules.Super;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryPojo extends Super {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("resting_bp_s")
    @Expose
    private Integer restingBpS;
    @SerializedName("cholestrol")
    @Expose
    private Integer cholestrol;
    @SerializedName("fasting_blood_sugar")
    @Expose
    private Integer fastingBloodSugar;
    @SerializedName("old_peak")
    @Expose
    private Integer oldPeak;
    @SerializedName("chest_pain_type")
    @Expose
    private Integer chestPainType;
    @SerializedName("target")
    @Expose
    private Integer target;
    @SerializedName("st_slope")
    @Expose
    private Integer stSlope;
    @SerializedName("exercise_angina")
    @Expose
    private Integer exerciseAngina;
    @SerializedName("resting_ecg")
    @Expose
    private Integer restingEcg;
    @SerializedName("max_heart_rate")
    @Expose
    private Integer maxHeartRate;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("user")
    @Expose
    private Integer user;

    public HistoryPojo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRestingBpS() {
        return restingBpS;
    }

    public void setRestingBpS(Integer restingBpS) {
        this.restingBpS = restingBpS;
    }

    public Integer getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(Integer cholestrol) {
        this.cholestrol = cholestrol;
    }

    public Integer getFastingBloodSugar() {
        return fastingBloodSugar;
    }

    public void setFastingBloodSugar(Integer fastingBloodSugar) {
        this.fastingBloodSugar = fastingBloodSugar;
    }

    public Integer getOldPeak() {
        return oldPeak;
    }

    public void setOldPeak(Integer oldPeak) {
        this.oldPeak = oldPeak;
    }

    public Integer getChestPainType() {
        return chestPainType;
    }

    public void setChestPainType(Integer chestPainType) {
        this.chestPainType = chestPainType;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getStSlope() {
        return stSlope;
    }

    public void setStSlope(Integer stSlope) {
        this.stSlope = stSlope;
    }

    public Integer getExerciseAngina() {
        return exerciseAngina;
    }

    public void setExerciseAngina(Integer exerciseAngina) {
        this.exerciseAngina = exerciseAngina;
    }

    public Integer getRestingEcg() {
        return restingEcg;
    }

    public void setRestingEcg(Integer restingEcg) {
        this.restingEcg = restingEcg;
    }

    public Integer getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(Integer maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
