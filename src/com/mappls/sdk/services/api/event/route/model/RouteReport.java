package com.mappls.sdk.services.api.event.route.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RouteReport implements Parcelable {
    public static final Parcelable.Creator<RouteReport> CREATOR = new Parcelable.Creator<RouteReport>() { // from class: com.mappls.sdk.services.api.event.route.model.RouteReport.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteReport createFromParcel(Parcel parcel) {
            return new RouteReport(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteReport[] newArray(int i) {
            return new RouteReport[i];
        }
    };

    @SerializedName(alternate = {FirebaseAnalytics.Param.INDEX}, value = "routeIdx")
    @Expose
    private Long index;

    @SerializedName("reports")
    @Expose
    private List<ReportDetails> reportDetails;

    @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)
    @Expose
    private String routeId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Long getIndex() {
        return this.index;
    }

    public void setIndex(Long l) {
        this.index = l;
    }

    public List<ReportDetails> getReports() {
        return this.reportDetails;
    }

    public void setReports(List<ReportDetails> list) {
        this.reportDetails = list;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public void setRouteId(String str) {
        this.routeId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.index);
        parcel.writeTypedList(this.reportDetails);
        parcel.writeString(this.routeId);
    }

    public void readFromParcel(Parcel parcel) {
        this.index = (Long) parcel.readValue(Long.class.getClassLoader());
        this.reportDetails = parcel.createTypedArrayList(ReportDetails.CREATOR);
        this.routeId = parcel.readString();
    }

    public RouteReport() {
        this.reportDetails = null;
    }

    protected RouteReport(Parcel parcel) {
        this.reportDetails = null;
        this.index = (Long) parcel.readValue(Long.class.getClassLoader());
        this.reportDetails = parcel.createTypedArrayList(ReportDetails.CREATOR);
        this.routeId = parcel.readString();
    }
}
