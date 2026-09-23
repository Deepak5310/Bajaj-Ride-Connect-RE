package com.mappls.sdk.navigation.events;

import android.content.Context;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.data.a;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;

/* JADX INFO: loaded from: classes4.dex */
public class NavEvent implements LocationPoint {
    private double distanceLeft;
    private Long index;
    private double latitude;
    private double longitude;
    private String name;
    private ReportDetails reportDetails;
    private boolean shouldSpeak;
    private boolean visibility;

    public NavEvent() {
    }

    public NavEvent(String str, double d, double d2, boolean z, boolean z2) {
        this.name = str;
        this.latitude = d;
        this.longitude = d2;
        this.shouldSpeak = z;
        this.visibility = z2;
    }

    public NavEvent(String str, double d, double d2, boolean z, boolean z2, Long l) {
        this.name = str;
        this.latitude = d;
        this.longitude = d2;
        this.shouldSpeak = z;
        this.visibility = z2;
        this.index = l;
    }

    public NavEvent(String str, double d, double d2, boolean z, boolean z2, Long l, ReportDetails reportDetails) {
        this.name = str;
        this.latitude = d;
        this.longitude = d2;
        this.shouldSpeak = z;
        this.visibility = z2;
        this.index = l;
        this.reportDetails = reportDetails;
    }

    public double getDistanceLeft() {
        return this.distanceLeft;
    }

    public Long getIndex() {
        return this.index;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLatitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public a getPointDescription(Context context) {
        return new a("events", this.name);
    }

    public ReportDetails getReportDetails() {
        return this.reportDetails;
    }

    public boolean isShouldSpeak() {
        return this.shouldSpeak;
    }

    public boolean isVisible() {
        return this.visibility;
    }

    public void setDistanceLeft(double d) {
        this.distanceLeft = d;
    }

    public void setIndex(Long l) {
        this.index = l;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public void setShouldSpeak(boolean z) {
        this.shouldSpeak = z;
    }

    public void setVisibility(boolean z) {
        this.visibility = z;
    }
}
