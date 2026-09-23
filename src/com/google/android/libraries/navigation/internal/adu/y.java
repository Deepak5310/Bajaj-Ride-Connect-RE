package com.google.android.libraries.navigation.internal.adu;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum y implements bm {
    UNKNOWN_INCIDENT_TYPE(0),
    INCIDENT_ROAD_CLOSED(1),
    INCIDENT_CRASH(2),
    INCIDENT_CONSTRUCTION(3),
    INCIDENT_FIXED_CAMERA(4),
    INCIDENT_MOBILE_CAMERA(5),
    INCIDENT_SUSPECTED_JAM(6),
    INCIDENT_SPEED_LIMIT(7),
    INCIDENT_SUSPECTED_CLOSURE(8),
    INCIDENT_LANE_CLOSURE(9),
    INCIDENT_STALLED_VEHICLE(10),
    INCIDENT_OBJECT_ON_ROAD(11),
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
    INCIDENT_SLIPPERY_ROAD(26);

    public final int x;

    y(int i) {
        this.x = i;
    }

    public static y b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_INCIDENT_TYPE;
            case 1:
                return INCIDENT_ROAD_CLOSED;
            case 2:
                return INCIDENT_CRASH;
            case 3:
                return INCIDENT_CONSTRUCTION;
            case 4:
                return INCIDENT_FIXED_CAMERA;
            case 5:
                return INCIDENT_MOBILE_CAMERA;
            case 6:
                return INCIDENT_SUSPECTED_JAM;
            case 7:
                return INCIDENT_SPEED_LIMIT;
            case 8:
                return INCIDENT_SUSPECTED_CLOSURE;
            case 9:
                return INCIDENT_LANE_CLOSURE;
            case 10:
                return INCIDENT_STALLED_VEHICLE;
            case 11:
                return INCIDENT_OBJECT_ON_ROAD;
            case 12:
            case 18:
            case 19:
            case 20:
            default:
                return null;
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
                return INCIDENT_SLIPPERY_ROAD;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.x;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.x);
    }
}
