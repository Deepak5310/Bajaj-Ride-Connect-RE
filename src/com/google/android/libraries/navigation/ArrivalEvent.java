package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ArrivalEvent {
    private final Waypoint a;
    private final boolean b;

    public ArrivalEvent(Waypoint waypoint, boolean z) {
        try {
            this.a = waypoint;
            this.b = z;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Waypoint getWaypoint() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean isFinalDestination() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
