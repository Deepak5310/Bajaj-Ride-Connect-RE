package com.mappls.sdk.navigation.common;

import com.mappls.sdk.navigation.h;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    protected double a;
    protected double b;
    protected transient double c;
    protected transient double d;

    public a() {
    }

    public a(double d, double d2) {
        a(d, d2);
    }

    public final void a(double d, double d2) {
        double d3;
        double d4 = d <= 90.0d ? d : 90.0d;
        if (d4 < -90.0d) {
            d4 = -90.0d;
        }
        this.a = d4;
        if (d2 < -180.0d || d2 > 180.0d) {
            double d5 = (d2 + 180.0d) % 360.0d;
            d3 = d5 < 0.0d ? d5 + 180.0d : d5 - 180.0d;
        } else {
            d3 = d2;
        }
        this.b = d3;
        this.c = Math.toRadians(d);
        this.d = Math.toRadians(d2);
    }

    public final boolean equals(Object obj) {
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Math.abs(this.a - aVar.a) <= 1.0E-5d && Math.abs(this.b - aVar.b) <= 1.0E-5d;
    }

    public final String toString() {
        StringBuilder sbA = h.a("Lat=");
        sbA.append(this.a);
        sbA.append(", Lon=");
        sbA.append(this.b);
        return sbA.toString();
    }
}
