package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw {
    public static double a(LatLng latLng, double d) {
        return Math.toDegrees(d / (Math.cos(Math.toRadians(latLng.latitude)) * 6371009.0d));
    }

    public static double b(double d, double d2) {
        double dAbs = Math.abs(d - d2);
        return Math.min(dAbs, 360.0d - dAbs);
    }

    public static float c(LatLng latLng, LatLng latLng2) {
        double d = latLng.latitude;
        float degrees = (float) Math.toDegrees(Math.atan2((latLng2.longitude - latLng.longitude) * Math.cos(Math.toRadians(d)), latLng2.latitude - d));
        return degrees - (((float) Math.floor(degrees / 360.0f)) * 360.0f);
    }

    static LatLng d(LatLng latLng, LatLng latLng2) {
        if (h(latLng, latLng2)) {
            return new LatLng(0.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
        }
        gg ggVarB = gg.b(latLng);
        gg ggVarB2 = gg.b(latLng2);
        double d = ggVarB.a;
        double d2 = ggVarB2.a;
        return new gg((d + d2) / 2.0d, (ggVarB.b + ggVarB2.b) / 2.0d, (ggVarB.c + ggVarB2.c) / 2.0d).a();
    }

    public static LatLng e(LatLng latLng, LatLng latLng2, double d) {
        if (h(latLng, latLng2)) {
            LatLng latLngD = d(latLng, latLng2);
            if (d <= 0.5d) {
                return e(latLng, latLngD, d + d);
            }
            double d2 = d - 0.5d;
            return e(latLngD, latLng2, d2 + d2);
        }
        gg ggVarB = gg.b(latLng);
        gg ggVarB2 = gg.b(latLng2);
        double dAcos = Math.acos(Math.min(1.0d, Math.max(-1.0d, (ggVarB.a * ggVarB2.a) + (ggVarB.b * ggVarB2.b) + (ggVarB.c * ggVarB2.c))));
        double dSin = Math.sin(dAcos);
        if (dSin < 1.0E-6d) {
            return new LatLng(latLng.latitude, latLng.longitude);
        }
        double dSin2 = Math.sin((1.0d - d) * dAcos) / dSin;
        double dSin3 = Math.sin(dAcos * d) / dSin;
        gg ggVarC = ggVarB.c(dSin2);
        gg ggVarC2 = ggVarB2.c(dSin3);
        return new gg(ggVarC.a + ggVarC2.a, ggVarC.b + ggVarC2.b, ggVarC.c + ggVarC2.c).a();
    }

    public static LatLngBounds f(LatLng latLng, double d, double d2, double d3, double d4) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "Null anchor");
        com.google.android.libraries.navigation.internal.abf.s.b(d3 >= 0.0d, "Negative latSpan: %s", Double.valueOf(d3));
        com.google.android.libraries.navigation.internal.abf.s.b(d4 >= 0.0d, "Negative lngSpan: %s", Double.valueOf(d4));
        double dMin = Math.min(359.999999d, d4);
        double d5 = latLng.latitude;
        double d6 = (d3 * d2) + d5;
        double d7 = d5 - (d3 * (1.0d - d2));
        double d8 = latLng.longitude;
        return new LatLngBounds(new LatLng(d7, d8 - (dMin * d)), new LatLng(d6, d8 + (dMin * (1.0d - d))));
    }

    public static void g(List list, List list2, List list3) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null inputPoints");
        com.google.android.libraries.navigation.internal.abf.s.k(list2, "Null outputPoints");
        list2.clear();
        list3.clear();
        if (list.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet(list);
        LinkedList linkedList = new LinkedList(list);
        LatLng latLng = (LatLng) linkedList.removeFirst();
        while (!linkedList.isEmpty()) {
            LatLng latLng2 = (LatLng) linkedList.getFirst();
            if (Math.max(Math.abs(latLng.latitude - latLng2.latitude), b(latLng.longitude, latLng2.longitude)) < 4.0d) {
                list2.add(latLng);
                if (hashSet.contains(latLng)) {
                    list3.add(Integer.valueOf(list2.size() - 1));
                }
                latLng = (LatLng) linkedList.removeFirst();
            } else {
                linkedList.addFirst(d(latLng, latLng2));
            }
        }
        list2.add(latLng);
        list3.add(Integer.valueOf(list2.size() - 1));
    }

    public static boolean h(LatLng latLng, LatLng latLng2) {
        return latLng.latitude == (-latLng2.latitude) && Math.abs(latLng.longitude - latLng2.longitude) == 180.0d;
    }

    public static double i(double d) {
        return Math.toDegrees(d / 6371009.0d);
    }
}
