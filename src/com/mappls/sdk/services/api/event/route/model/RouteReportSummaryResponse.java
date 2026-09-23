package com.mappls.sdk.services.api.event.route.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RouteReportSummaryResponse implements Parcelable {
    public static final Parcelable.Creator<RouteReportSummaryResponse> CREATOR = new Parcelable.Creator<RouteReportSummaryResponse>() { // from class: com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteReportSummaryResponse createFromParcel(Parcel parcel) {
            return new RouteReportSummaryResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteReportSummaryResponse[] newArray(int i) {
            return new RouteReportSummaryResponse[i];
        }
    };

    @SerializedName("routes")
    @Expose
    private List<RouteReport> routes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RouteReport> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<RouteReport> list) {
        this.routes = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.routes);
    }

    public void readFromParcel(Parcel parcel) {
        this.routes = parcel.createTypedArrayList(RouteReport.CREATOR);
    }

    public RouteReportSummaryResponse() {
        this.routes = null;
    }

    protected RouteReportSummaryResponse(Parcel parcel) {
        this.routes = null;
        this.routes = parcel.createTypedArrayList(RouteReport.CREATOR);
    }
}
