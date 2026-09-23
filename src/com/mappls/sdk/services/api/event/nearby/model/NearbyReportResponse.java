package com.mappls.sdk.services.api.event.nearby.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NearbyReportResponse {

    @SerializedName("reports")
    @Expose
    private List<NearbyReport> nearbyReports = null;

    @SerializedName("pagination")
    @Expose
    private NearbyReportPagination pagination;

    public List<NearbyReport> getReports() {
        return this.nearbyReports;
    }

    public void setReports(List<NearbyReport> list) {
        this.nearbyReports = list;
    }

    public NearbyReportPagination getPagination() {
        return this.pagination;
    }

    public void setPagination(NearbyReportPagination nearbyReportPagination) {
        this.pagination = nearbyReportPagination;
    }
}
