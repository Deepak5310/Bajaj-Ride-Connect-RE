package com.mappls.sdk.services.api.session.search.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.spotify.sdk.android.auth.LoginActivity;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceSearchResponse {

    @SerializedName(LoginActivity.RESPONSE_KEY)
    @Expose
    private List<MapplsDevice> devices;

    @SerializedName("pagination")
    @Expose
    private DeviceSearchPageInfo pageInfo;

    public List<MapplsDevice> getResponse() {
        return this.devices;
    }

    public void setResponse(List<MapplsDevice> list) {
        this.devices = list;
    }

    public DeviceSearchPageInfo getPagination() {
        return this.pageInfo;
    }

    public void setPagination(DeviceSearchPageInfo deviceSearchPageInfo) {
        this.pageInfo = deviceSearchPageInfo;
    }
}
