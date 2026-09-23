package com.mappls.sdk.navigation.model;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationSummary {
    private float averageSpeed;
    private float totalDistance;
    private float totalTimeTaken;

    public NavigationSummary(float f, float f2, float f3) {
        this.averageSpeed = f;
        this.totalDistance = f2;
        this.totalTimeTaken = f3;
    }

    public float getAverageSpeed() {
        return this.averageSpeed;
    }

    public float getTotalDistance() {
        return this.totalDistance;
    }

    public float getTotalTimeTaken() {
        return this.totalTimeTaken;
    }

    public void setAverageSpeed(float f) {
        this.averageSpeed = f;
    }

    public void setTotalDistance(float f) {
        this.totalDistance = f;
    }

    public void setTotalTimeTaken(float f) {
        this.totalTimeTaken = f;
    }
}
