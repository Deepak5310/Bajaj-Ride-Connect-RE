package com.google.android.libraries.navigation.internal.xe;

import android.location.Location;
import android.os.Bundle;
import com.google.android.libraries.navigation.RoadSnappedLocationProvider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fw {
    final RoadSnappedLocationProvider.LocationListener a;

    public fw(RoadSnappedLocationProvider.LocationListener locationListener) {
        this.a = locationListener;
    }

    public final void a(boolean z) {
        RoadSnappedLocationProvider.LocationListener locationListener = this.a;
        if (locationListener instanceof RoadSnappedLocationProvider.GpsAvailabilityEnhancedLocationListener) {
            ((RoadSnappedLocationProvider.GpsAvailabilityEnhancedLocationListener) locationListener).onGpsAvailabilityUpdate(z);
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.db.r rVar) {
        Location locationA = com.google.android.libraries.navigation.internal.db.t.a(rVar);
        Bundle bundle = locationA.getExtras() != null ? (Bundle) locationA.getExtras().clone() : new Bundle();
        bundle.putBoolean(RoadSnappedLocationProvider.LocationListener.IS_ROAD_SNAPPED_KEY, rVar.B());
        locationA.setExtras(bundle);
        this.a.onLocationChanged(locationA);
    }

    public final void c(Location location) {
        this.a.onRawLocationUpdate(location);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fw)) {
            return false;
        }
        RoadSnappedLocationProvider.LocationListener locationListener = this.a;
        if (locationListener == null) {
            return ((fw) obj).a == null;
        }
        return locationListener.equals(((fw) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
