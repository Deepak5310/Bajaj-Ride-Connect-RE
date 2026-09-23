package com.google.android.libraries.navigation.internal.tc;

import android.location.Location;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.eg;
import com.google.android.libraries.navigation.internal.yz.ku;
import com.google.android.libraries.navigation.internal.yz.li;
import com.google.android.libraries.navigation.internal.zr.cn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final ku a = eg.n();
    final com.google.android.libraries.navigation.internal.kd.g b = new com.google.android.libraries.navigation.internal.kd.g();
    final com.google.android.libraries.navigation.internal.kd.g c = new com.google.android.libraries.navigation.internal.kd.g();
    final com.google.android.libraries.navigation.internal.kd.g d = new com.google.android.libraries.navigation.internal.kd.g();
    double e;
    public Location f;
    public com.google.android.libraries.navigation.internal.db.r g;

    final synchronized void a(Location location) {
        if (location != null) {
            String provider = location.getProvider();
            if (!aq.c(provider)) {
                this.a.add(provider);
                if ("gps".equals(provider) || "fused".equals(provider)) {
                    Location location2 = this.f;
                    if (location2 != null && location2.hasSpeed() && location2.hasBearing()) {
                        float fMax = Math.max(0.0f, (location.getTime() - location2.getTime()) / 1000.0f);
                        double bearing = ((double) location2.getBearing()) * 0.017453292519943295d;
                        double speed = location2.getSpeed() * fMax;
                        double dCos = Math.cos(bearing) * speed;
                        double dCos2 = Math.cos(location2.getLatitude() * 0.017453292519943295d) * 2.001511821194711E7d;
                        double dSin = speed * Math.sin(bearing);
                        Location location3 = new Location("");
                        location3.setLatitude(location2.getLatitude() + ((dCos * 180.0d) / 2.001511821194711E7d));
                        location3.setLongitude(location2.getLongitude() + ((dSin * 180.0d) / dCos2));
                        this.d.b(location.distanceTo(location3));
                    }
                    if (location.hasAccuracy()) {
                        this.c.b(location.getAccuracy());
                    }
                    this.f = location;
                }
            }
        }
    }

    public final synchronized int b() {
        if (!this.a.isEmpty()) {
            String str = (String) new li(new c(this)).f(this.a.l().iterator());
            if ("network".equals(str)) {
                return cn.b;
            }
            if ("gps".equals(str)) {
                return cn.a;
            }
            if ("fused".equals(str)) {
                return cn.c;
            }
        }
        return 0;
    }
}
