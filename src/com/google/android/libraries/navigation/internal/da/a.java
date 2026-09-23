package com.google.android.libraries.navigation.internal.da;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements LocationListener {
    final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        synchronized (this.a.c) {
            if (this.a.f) {
                Bundle extras = location.getExtras();
                if (extras == null) {
                    return;
                }
                if (extras.containsKey("networkLocationType") && "wifi".equals(extras.getString("networkLocationType"))) {
                    d dVar = this.a;
                    dVar.b.a(new h(dVar.a.a(), location.getLatitude(), location.getLongitude(), location.getAccuracy()));
                }
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
