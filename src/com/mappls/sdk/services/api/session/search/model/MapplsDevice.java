package com.mappls.sdk.services.api.session.search.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsDevice {

    @SerializedName("activatedOn")
    @Expose
    private String activatedOn;

    @SerializedName("deviceId")
    @Expose
    private String deviceId;

    @SerializedName("entityId")
    @Expose
    private String entityId;

    @SerializedName("entityName")
    @Expose
    private String entityName;

    @SerializedName("expiresAfter")
    @Expose
    private String expiresAfter;

    @SerializedName("expiryRenewed")
    @Expose
    private Boolean expiryRenewed;

    @SerializedName("registeredOn")
    @Expose
    private String registeredOn;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private String status;

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(String str) {
        this.registeredOn = str;
    }

    public String getActivatedOn() {
        return this.activatedOn;
    }

    public void setActivatedOn(String str) {
        this.activatedOn = str;
    }

    public String getExpiresAfter() {
        return this.expiresAfter;
    }

    public void setExpiresAfter(String str) {
        this.expiresAfter = str;
    }

    public Boolean getExpiryRenewed() {
        return this.expiryRenewed;
    }

    public void setExpiryRenewed(Boolean bool) {
        this.expiryRenewed = bool;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
