package com.google.android.libraries.navigation.internal.abw;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.ac;
import com.google.android.libraries.navigation.internal.abf.ah;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final double a = Math.log(2.0d);
    private static final int b = o(360.0d);

    public static double a(double d) {
        return Math.min(1.0d, Math.max(0.0d, d));
    }

    public static double b(int i) {
        return c(i % b);
    }

    public static double c(int i) {
        return ((double) i) * 1.0E-6d;
    }

    public static double d(int i, int i2, double d) {
        return t(false, i, i2, 90.0d);
    }

    public static double e(double d) {
        return d * 57.295780181884766d;
    }

    public static double f(double d) {
        return d * 0.01745329238474369d;
    }

    public static float g(float f, float f2) {
        float fL = l(f - f2);
        return fL < 180.0f ? fL : fL - 360.0f;
    }

    public static float h(float f) {
        return i(f, 0.0f, 1.0f);
    }

    public static float i(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f2, f));
    }

    public static float j(float f) {
        if (Float.isNaN(f)) {
            throw new ArithmeticException("Tilt value is NaN.");
        }
        return i(f, -90.0f, 90.0f);
    }

    public static float k(float f) {
        return (float) (Math.log(f) / a);
    }

    public static float l(float f) {
        return f - (((float) Math.floor(f / 360.0f)) * 360.0f);
    }

    public static float m(float f) {
        return f * 0.017453292f;
    }

    public static int n(float f) {
        return ((int) Math.floor((f + 22.5f) / 45.0f)) & 7;
    }

    public static int o(double d) {
        return (int) Math.round(d * 1000000.0d);
    }

    public static ThreadLocal p() {
        ExecutorService executorService = ah.a;
        return new ac(16);
    }

    public static ThreadLocal q() {
        ExecutorService executorService = ah.a;
        return new ac(4);
    }

    public static boolean r(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return (streetViewPanoramaCamera == null || Float.isNaN(streetViewPanoramaCamera.zoom) || Float.isNaN(streetViewPanoramaCamera.tilt) || Float.isNaN(streetViewPanoramaCamera.bearing)) ? false : true;
    }

    public static double s(int i, int i2) {
        return t(true, i, i2, 90.0d);
    }

    private static double t(boolean z, int i, int i2, double d) {
        if (z == (i >= i2)) {
            return 90.0d;
        }
        double d2 = i2;
        double d3 = i;
        double dAtan = Math.atan((z ? d3 / d2 : d2 / d3) * Math.tan(0.7853981573134661d)) * 57.295780181884766d;
        return dAtan + dAtan;
    }
}
