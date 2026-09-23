package com.airbnb.lottie.utils;

/* JADX INFO: loaded from: classes3.dex */
public class MeanCalculator {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f29n;
    private float sum;

    public void add(float f) {
        float f2 = this.sum + f;
        this.sum = f2;
        int i = this.f29n + 1;
        this.f29n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.f29n = i / 2;
        }
    }

    public float getMean() {
        int i = this.f29n;
        if (i == 0) {
            return 0.0f;
        }
        return this.sum / i;
    }
}
