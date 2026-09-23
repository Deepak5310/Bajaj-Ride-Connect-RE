package com.google.android.libraries.navigation;

import android.location.Location;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class LocationEvent {
    private final Location a;

    public LocationEvent(Location location) {
        try {
            this.a = location;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Location getLocation() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
