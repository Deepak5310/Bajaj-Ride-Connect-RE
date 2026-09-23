package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum at implements com.google.android.libraries.navigation.internal.ael.bm {
    SUCCESS(0),
    BAD_WAYPOINT_COUNT(1),
    WAYPOINT_REFINEMENT(2),
    WAYPOINT_FAILURE(3),
    NO_ROUTES_FOUND(4),
    NO_TRIPS_ON_GIVEN_DATE(6),
    NAVIGATION_NOT_ALLOWED(7),
    NOT_ENOUGH_CHARGING_STATIONS_FOUND(8);

    public final int i;

    at(int i) {
        this.i = i;
    }

    public static at b(int i) {
        switch (i) {
            case 0:
                return SUCCESS;
            case 1:
                return BAD_WAYPOINT_COUNT;
            case 2:
                return WAYPOINT_REFINEMENT;
            case 3:
                return WAYPOINT_FAILURE;
            case 4:
                return NO_ROUTES_FOUND;
            case 5:
            default:
                return null;
            case 6:
                return NO_TRIPS_ON_GIVEN_DATE;
            case 7:
                return NAVIGATION_NOT_ALLOWED;
            case 8:
                return NOT_ENOUGH_CHARGING_STATIONS_FOUND;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.i);
    }
}
