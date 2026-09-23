package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum nz implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_USER_INCIDENT_TYPE(0),
    INCIDENT_CRASH(1),
    INCIDENT_FIXED_CAMERA(2),
    INCIDENT_MOBILE_CAMERA(3),
    INCIDENT_JAM(4),
    INCIDENT_CONSTRUCTION(5),
    INCIDENT_LANE_CLOSURE(6),
    INCIDENT_DISABLED_VEHICLE(7),
    INCIDENT_OBJECT_ON_ROAD(8),
    INCIDENT_SPEED_LIMIT(9),
    INCIDENT_SUSPECTED_CLOSURE(10),
    INCIDENT_POLICE_PRESENCE(11),
    INCIDENT_MOBILE_SPEED_CAMERA(12);

    private final int o;

    nz(int i) {
        this.o = i;
    }

    public static nz b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_USER_INCIDENT_TYPE;
            case 1:
                return INCIDENT_CRASH;
            case 2:
                return INCIDENT_FIXED_CAMERA;
            case 3:
                return INCIDENT_MOBILE_CAMERA;
            case 4:
                return INCIDENT_JAM;
            case 5:
                return INCIDENT_CONSTRUCTION;
            case 6:
                return INCIDENT_LANE_CLOSURE;
            case 7:
                return INCIDENT_DISABLED_VEHICLE;
            case 8:
                return INCIDENT_OBJECT_ON_ROAD;
            case 9:
                return INCIDENT_SPEED_LIMIT;
            case 10:
                return INCIDENT_SUSPECTED_CLOSURE;
            case 11:
                return INCIDENT_POLICE_PRESENCE;
            case 12:
                return INCIDENT_MOBILE_SPEED_CAMERA;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.o;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.o);
    }
}
