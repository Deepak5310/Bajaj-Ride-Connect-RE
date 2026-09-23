package com.mappls.sdk.navigation;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class p {
    private Thread a;
    private NavigationLocationProvider b;

    public p(Context context, NavigationLocationProvider navigationLocationProvider) {
        this.b = navigationLocationProvider;
    }

    public static NavLocation a(NavLocation navLocation, NavLocation navLocation2, float f) {
        double latitude = (navLocation.getLatitude() * 3.141592653589793d) / 180.0d;
        double longitude = (navLocation.getLongitude() * 3.141592653589793d) / 180.0d;
        float fBearingTo = (float) ((((double) navLocation.bearingTo(navLocation2)) * 3.141592653589793d) / 180.0d);
        double d = ((double) (f / 1000.0f)) / 6371.0d;
        double d2 = fBearingTo;
        double dAsin = Math.asin((Math.cos(d2) * Math.sin(d) * Math.cos(latitude)) + (Math.cos(d) * Math.sin(latitude)));
        double dAtan2 = Math.atan2(Math.cos(latitude) * Math.sin(d) * Math.sin(d2), Math.cos(d) - (Math.sin(dAsin) * Math.sin(latitude))) + longitude;
        NavLocation navLocation3 = new NavLocation(navLocation);
        navLocation3.setLatitude((dAsin * 180.0d) / 3.141592653589793d);
        navLocation3.setLongitude((dAtan2 * 180.0d) / 3.141592653589793d);
        navLocation3.setBearing(fBearingTo);
        return navLocation3;
    }

    public final boolean a() {
        return this.a != null;
    }

    public final void b() {
        if (a()) {
            this.a = null;
            return;
        }
        List<NavLocation> listD = NavigationContext.getNavigationContext().l.d();
        if (listD.isEmpty()) {
            return;
        }
        o oVar = new o(this, new ArrayList(listD));
        this.a = oVar;
        oVar.start();
    }

    public final void c() {
        if (!a()) {
            this.a = null;
        }
        List<NavLocation> listD = NavigationContext.getNavigationContext().l.d();
        if (listD.isEmpty()) {
            return;
        }
        o oVar = new o(this, new ArrayList(listD));
        this.a = oVar;
        oVar.start();
    }

    public final void d() {
        this.a = null;
    }
}
