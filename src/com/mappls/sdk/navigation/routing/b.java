package com.mappls.sdk.navigation.routing;

import android.app.Application;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public NavLocation a;
    public String b;
    public List<LatLng> c;
    public Application d;
    public com.mappls.sdk.navigation.d e;
    public c.a f;
    public boolean g;
    public com.mappls.sdk.navigation.router.a h;

    public final String toString() {
        try {
            return "RouteOptionsParams{start=" + this.a.toString() + ", end=" + this.b + ", intermediates=" + this.c.toString() + '}';
        } catch (Exception e) {
            NavigationLogger.d(e);
            return "";
        }
    }
}
