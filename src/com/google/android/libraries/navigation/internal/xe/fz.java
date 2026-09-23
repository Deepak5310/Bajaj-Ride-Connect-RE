package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.NavigationTrafficData;
import com.google.android.libraries.navigation.RouteSegment;
import com.google.android.libraries.navigation.Waypoint;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fz implements RouteSegment {
    private final Waypoint a;
    private final List b;
    private final NavigationTrafficData c;

    public fz(com.google.android.libraries.navigation.internal.vv.b bVar) {
        try {
            this.a = z.c(bVar.a);
            this.b = z.d(bVar.b);
            this.c = new NavigationTrafficData();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RouteSegment
    public final LatLng getDestinationLatLng() {
        try {
            List list = this.b;
            return (LatLng) list.get(list.size() - 1);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RouteSegment
    public final Waypoint getDestinationWaypoint() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RouteSegment
    public final List<LatLng> getLatLngs() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RouteSegment
    public final NavigationTrafficData getTrafficData() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public fz(com.google.android.libraries.navigation.internal.vv.b bVar, NavigationTrafficData navigationTrafficData) {
        try {
            this.a = z.c(bVar.a);
            this.b = z.d(bVar.b);
            this.c = navigationTrafficData;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
