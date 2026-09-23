package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionManeuver {

    @SerializedName("begin_shape_index")
    @Expose
    private Integer beginShapeIndex;

    @SerializedName("begin_street_names")
    @Expose
    private List<String> beginStreetNames;

    @SerializedName("cost")
    @Expose
    private Double cost;

    @SerializedName("end_shape_index")
    @Expose
    private Integer endShapeIndex;

    @SerializedName("instruction")
    @Expose
    private String instruction;

    @SerializedName("length")
    @Expose
    private Double length;

    @SerializedName("roundabout_exit_count")
    @Expose
    private Integer roundaboutExitCount;

    @SerializedName("sign")
    @Expose
    private PredictiveDirectionSign sign;

    @SerializedName("street_names")
    @Expose
    private List<String> streetNames;

    @SerializedName("time")
    @Expose
    private Double time;

    @SerializedName(DirectionsCriteria.EXCLUDE_TOLL)
    @Expose
    private Boolean toll;

    @SerializedName("travel_mode")
    @Expose
    private String travelMode;

    @SerializedName("travel_type")
    @Expose
    private String travelType;

    @SerializedName("type")
    @Expose
    private Integer type;

    @SerializedName("verbal_multi_cue")
    @Expose
    private Boolean verbalMultiCue;

    @SerializedName("verbal_post_transition_instruction")
    @Expose
    private String verbalPostTransitionInstruction;

    @SerializedName("verbal_pre_transition_instruction")
    @Expose
    private String verbalPreTransitionInstruction;

    @SerializedName("verbal_transition_alert_instruction")
    @Expose
    private String verbalTransitionAlertInstruction;

    public Boolean getVerbalMultiCue() {
        return this.verbalMultiCue;
    }

    public void setVerbalMultiCue(Boolean bool) {
        this.verbalMultiCue = bool;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double d) {
        this.cost = d;
    }

    public Integer getBeginShapeIndex() {
        return this.beginShapeIndex;
    }

    public void setBeginShapeIndex(Integer num) {
        this.beginShapeIndex = num;
    }

    public String getTravelMode() {
        return this.travelMode;
    }

    public void setTravelMode(String str) {
        this.travelMode = str;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String str) {
        this.instruction = str;
    }

    public Double getLength() {
        return this.length;
    }

    public void setLength(Double d) {
        this.length = d;
    }

    public Integer getEndShapeIndex() {
        return this.endShapeIndex;
    }

    public void setEndShapeIndex(Integer num) {
        this.endShapeIndex = num;
    }

    public String getVerbalPostTransitionInstruction() {
        return this.verbalPostTransitionInstruction;
    }

    public void setVerbalPostTransitionInstruction(String str) {
        this.verbalPostTransitionInstruction = str;
    }

    public Double getTime() {
        return this.time;
    }

    public void setTime(Double d) {
        this.time = d;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public String getVerbalPreTransitionInstruction() {
        return this.verbalPreTransitionInstruction;
    }

    public void setVerbalPreTransitionInstruction(String str) {
        this.verbalPreTransitionInstruction = str;
    }

    public String getTravelType() {
        return this.travelType;
    }

    public void setTravelType(String str) {
        this.travelType = str;
    }

    public List<String> getStreetNames() {
        return this.streetNames;
    }

    public void setStreetNames(List<String> list) {
        this.streetNames = list;
    }

    public String getVerbalTransitionAlertInstruction() {
        return this.verbalTransitionAlertInstruction;
    }

    public void setVerbalTransitionAlertInstruction(String str) {
        this.verbalTransitionAlertInstruction = str;
    }

    public List<String> getBeginStreetNames() {
        return this.beginStreetNames;
    }

    public void setBeginStreetNames(List<String> list) {
        this.beginStreetNames = list;
    }

    public Boolean getToll() {
        return this.toll;
    }

    public void setToll(Boolean bool) {
        this.toll = bool;
    }

    public Integer getRoundaboutExitCount() {
        return this.roundaboutExitCount;
    }

    public void setRoundaboutExitCount(Integer num) {
        this.roundaboutExitCount = num;
    }

    public PredictiveDirectionSign getSign() {
        return this.sign;
    }

    public void setSign(PredictiveDirectionSign predictiveDirectionSign) {
        this.sign = predictiveDirectionSign;
    }
}
