package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.adr.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum Cdo implements com.google.android.libraries.navigation.internal.ael.bm {
    INCIDENT_ROAD_CLOSED(1),
    INCIDENT_CRASH(2),
    INCIDENT_CONSTRUCTION(3),
    INCIDENT_JAM(4),
    INCIDENT_SPEED_TRAP(5),
    INCIDENT_SPEED_CAMERA(6),
    INCIDENT_SUSPECTED_JAM(7),
    INCIDENT_SPEED_LIMIT(8),
    INCIDENT_SUSPECTED_CLOSURE(9),
    INCIDENT_LANE_CLOSURE(10),
    INCIDENT_STALLED_VEHICLE(11),
    INCIDENT_OBJECT_ON_ROAD(12),
    INCIDENT_POLICE_PRESENCE(13),
    INCIDENT_MOBILE_SPEED_CAMERA(14),
    INCIDENT_HAZARD(15),
    INCIDENT_BROKEN_TRAFFIC_LIGHT(16),
    INCIDENT_POTHOLE(17),
    INCIDENT_WEATHER(21),
    INCIDENT_ICE(22),
    INCIDENT_SNOW(23),
    INCIDENT_FOG(24),
    INCIDENT_FLOOD(25),
    INCIDENT_SLIPPERY_ROAD(30),
    INCIDENT_CHECKPOINT(26),
    INCIDENT_RAILROAD_CROSSING(27),
    INCIDENT_TRAFFIC_LIGHT(28),
    INCIDENT_STOP_SIGN(29),
    INCIDENT_OTHER(127);

    public final int C;

    Cdo(int i) {
        this.C = i;
    }

    public static Cdo b(int i) {
        if (i == 127) {
            return INCIDENT_OTHER;
        }
        switch (i) {
            case 1:
                return INCIDENT_ROAD_CLOSED;
            case 2:
                return INCIDENT_CRASH;
            case 3:
                return INCIDENT_CONSTRUCTION;
            case 4:
                return INCIDENT_JAM;
            case 5:
                return INCIDENT_SPEED_TRAP;
            case 6:
                return INCIDENT_SPEED_CAMERA;
            case 7:
                return INCIDENT_SUSPECTED_JAM;
            case 8:
                return INCIDENT_SPEED_LIMIT;
            case 9:
                return INCIDENT_SUSPECTED_CLOSURE;
            case 10:
                return INCIDENT_LANE_CLOSURE;
            case 11:
                return INCIDENT_STALLED_VEHICLE;
            case 12:
                return INCIDENT_OBJECT_ON_ROAD;
            case 13:
                return INCIDENT_POLICE_PRESENCE;
            case 14:
                return INCIDENT_MOBILE_SPEED_CAMERA;
            case 15:
                return INCIDENT_HAZARD;
            case 16:
                return INCIDENT_BROKEN_TRAFFIC_LIGHT;
            case 17:
                return INCIDENT_POTHOLE;
            default:
                switch (i) {
                    case 21:
                        return INCIDENT_WEATHER;
                    case 22:
                        return INCIDENT_ICE;
                    case 23:
                        return INCIDENT_SNOW;
                    case 24:
                        return INCIDENT_FOG;
                    case 25:
                        return INCIDENT_FLOOD;
                    case 26:
                        return INCIDENT_CHECKPOINT;
                    case 27:
                        return INCIDENT_RAILROAD_CROSSING;
                    case 28:
                        return INCIDENT_TRAFFIC_LIGHT;
                    case 29:
                        return INCIDENT_STOP_SIGN;
                    case 30:
                        return INCIDENT_SLIPPERY_ROAD;
                    default:
                        return null;
                }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.C;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.C);
    }
}
