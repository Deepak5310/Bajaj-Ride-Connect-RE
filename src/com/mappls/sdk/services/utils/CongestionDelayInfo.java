package com.mappls.sdk.services.utils;

import com.mappls.sdk.geojson.Point;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CongestionDelayInfo {
    private int delayDuration;
    private Point point;
    private List<Point> points;

    public CongestionDelayInfo(List<Point> list, int i) {
        this.points = list;
        this.delayDuration = i;
        this.point = list.get(list.size() / 2);
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> list) {
        this.points = list;
    }

    public int getDelayDuration() {
        return this.delayDuration;
    }

    public void setDelayDuration(int i) {
        this.delayDuration = i;
    }

    public String toString() {
        return "CongestionSegment{point=" + this.point + ", delayDuration=" + this.delayDuration + '}';
    }
}
