package com.mappls.sdk.services.api.geolocation;

/* JADX INFO: loaded from: classes4.dex */
class GeolocationRequest {
    private final Integer cellId;
    private final Integer locationAreaCode;
    private final Integer mobileCountryCode;
    private final Integer mobileNetworkCode;
    private final Integer newRadioCellId;

    GeolocationRequest(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.cellId = num;
        this.locationAreaCode = num2;
        this.mobileCountryCode = num3;
        this.mobileNetworkCode = num4;
        this.newRadioCellId = num5;
    }

    public Integer getCellId() {
        return this.cellId;
    }

    public Integer getLocationAreaCode() {
        return this.locationAreaCode;
    }

    public Integer getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    public Integer getMobileNetworkCode() {
        return this.mobileNetworkCode;
    }

    public Integer getNewRadioCellId() {
        return this.newRadioCellId;
    }
}
