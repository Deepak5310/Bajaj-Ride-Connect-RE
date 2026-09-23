package com.mappls.sdk.navigation.model;

import android.content.Context;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.data.a;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CongestionInfo implements LocationPoint {
    private List<Point> congestionLocationPoints;
    private double congestionRemainingDelay;
    private double congestionRemainingDistance;
    private double congestionStartDistance = 0.0d;
    private double delayInfo;
    private Integer endNodeIndex;
    private Point endPoint;
    private Integer startNodeIndex;
    private Point startPoint;

    public List<Point> getCongestionLocationPoints() {
        return this.congestionLocationPoints;
    }

    public double getCongestionRemainingDelay() {
        return this.congestionRemainingDelay;
    }

    public double getCongestionRemainingDistance() {
        return this.congestionRemainingDistance;
    }

    public double getCongestionStartDistance() {
        return this.congestionStartDistance;
    }

    public double getDelayInfo() {
        return this.delayInfo;
    }

    public Integer getEndNodeIndex() {
        return this.endNodeIndex;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLatitude() {
        return this.startPoint.latitude();
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLongitude() {
        return this.startPoint.longitude();
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public a getPointDescription(Context context) {
        return new a(this.startPoint.latitude(), this.startPoint.longitude());
    }

    public Integer getStartNodeIndex() {
        return this.startNodeIndex;
    }

    public Point getStartPoint() {
        return this.startPoint;
    }

    public void setCongestionLocationPoints(List<Point> list) {
        this.congestionLocationPoints = list;
    }

    public void setCongestionRemainingDelay(double d) {
        this.congestionRemainingDelay = d;
    }

    public void setCongestionRemainingDistance(double d) {
        this.congestionRemainingDistance = d;
    }

    public void setCongestionStartDistance(double d) {
        this.congestionStartDistance = d;
    }

    public void setDelayInfo(double d) {
        this.delayInfo = d;
    }

    public void setEndNodeIndex(Integer num) {
        this.endNodeIndex = num;
    }

    public void setEndPoint(Point point) {
        this.endPoint = point;
    }

    public void setStartNodeIndex(Integer num) {
        this.startNodeIndex = num;
    }

    public void setStartPoint(Point point) {
        this.startPoint = point;
    }
}
