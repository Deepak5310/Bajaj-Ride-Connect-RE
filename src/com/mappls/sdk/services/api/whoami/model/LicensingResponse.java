package com.mappls.sdk.services.api.whoami.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class LicensingResponse {

    @SerializedName("licenseType")
    @Expose
    private String licenseType;

    @SerializedName("headers")
    @Expose
    private LicensingHeader licensingHeader;

    @SerializedName("outputParameters")
    @Expose
    private LicensingOutputParams licensingOutputParams;

    @SerializedName("parameters")
    @Expose
    private LicensingParams licensingParams;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("userLoginRequired")
    @Expose
    private Boolean userLoginRequired;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLicenseType() {
        return this.licenseType;
    }

    public void setLicenseType(String str) {
        this.licenseType = str;
    }

    public Boolean isUserLoginRequired() {
        return this.userLoginRequired;
    }

    public void setUserLoginRequired(Boolean bool) {
        this.userLoginRequired = bool;
    }

    public LicensingParams getLicensingParams() {
        return this.licensingParams;
    }

    public void setLicensingParams(LicensingParams licensingParams) {
        this.licensingParams = licensingParams;
    }

    public LicensingHeader getLicensingHeader() {
        return this.licensingHeader;
    }

    public void setLicensingHeader(LicensingHeader licensingHeader) {
        this.licensingHeader = licensingHeader;
    }

    public LicensingOutputParams getLicensingOutputParams() {
        return this.licensingOutputParams;
    }

    public void setLicensingOutputParams(LicensingOutputParams licensingOutputParams) {
        this.licensingOutputParams = licensingOutputParams;
    }
}
