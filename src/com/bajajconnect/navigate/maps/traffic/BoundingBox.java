package com.bajajconnect.navigate.maps.traffic;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public class BoundingBox {
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;

    public BoundingBox(double d, double d2, double d3, double d4) {
        this.mMinX = d2;
        this.mMinY = d;
        this.mMaxX = d4;
        this.mMaxY = d3;
    }

    protected BoundingBox(Parcel parcel) {
        this.mMinX = parcel.readDouble();
        this.mMinY = parcel.readDouble();
        this.mMaxX = parcel.readDouble();
        this.mMaxY = parcel.readDouble();
    }

    public double getMinX() {
        return this.mMinX;
    }

    public void setMinX(double d) {
        this.mMinX = d;
    }

    public double getMinY() {
        return this.mMinY;
    }

    public void setMinY(double d) {
        this.mMinY = d;
    }

    public double getMaxX() {
        return this.mMaxX;
    }

    public void setMaxX(double d) {
        this.mMaxX = d;
    }

    public double getMaxY() {
        return this.mMaxY;
    }

    public void setMaxY(double d) {
        this.mMaxY = d;
    }

    public String toString() {
        return this.mMinY + "," + this.mMinX + "|" + this.mMaxY + "," + this.mMaxX;
    }
}
