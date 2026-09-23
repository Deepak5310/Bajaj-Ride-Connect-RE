package com.mappls.sdk.services.api.tripplan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.autosuggest.model.PartnerFlag;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SmartTripPlanStop {

    @SerializedName("durationOfCharge")
    private Integer durationOfCharge;

    @SerializedName("expectedSOC")
    private Integer expectedSOC;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    @SerializedName("mapplsPin")
    private String mapplsPin;

    @SerializedName("name")
    private String name;

    @SerializedName("idx")
    private Integer orderIndex;

    @SerializedName("partnersFlag")
    @Expose
    public List<PartnerFlag> partnersFlag;

    @SerializedName("type")
    private String type;

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Integer getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(Integer num) {
        this.orderIndex = num;
    }

    public Integer getDurationOfCharge() {
        return this.durationOfCharge;
    }

    public void setDurationOfCharge(Integer num) {
        this.durationOfCharge = num;
    }

    public Integer getExpectedSOC() {
        return this.expectedSOC;
    }

    public void setExpectedSOC(Integer num) {
        this.expectedSOC = num;
    }

    public List<PartnerFlag> getPartnersFlag() {
        return this.partnersFlag;
    }

    public void setPartnersFlag(List<PartnerFlag> list) {
        this.partnersFlag = list;
    }
}
