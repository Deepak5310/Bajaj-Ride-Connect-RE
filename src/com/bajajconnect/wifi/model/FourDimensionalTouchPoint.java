package com.bajajconnect.wifi.model;

/* JADX INFO: loaded from: classes3.dex */
public class FourDimensionalTouchPoint {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public FourDimensionalTouchPoint(int i, int i2, int i3, int i4) {
        this.x1 = i;
        this.x2 = i2;
        this.y1 = i3;
        this.y2 = i4;
    }

    public int getX1() {
        return this.x1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY1() {
        return this.y1;
    }

    public int getY2() {
        return this.y2;
    }

    public void setX1(int i) {
        this.x1 = i;
    }

    public void setX2(int i) {
        this.x2 = i;
    }

    public void setY1(int i) {
        this.y1 = i;
    }

    public void setY2(int i) {
        this.y2 = i;
    }
}
