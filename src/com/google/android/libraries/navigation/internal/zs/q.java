package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum q implements com.google.android.libraries.navigation.internal.ael.bm {
    IN_VEHICLE(0),
    ON_BICYCLE(1),
    ON_FOOT(2),
    STILL(3),
    UNKNOWN(4),
    TILTING(5),
    EXITING_VEHICLE(6),
    WALKING(7),
    RUNNING(8),
    OFF_BODY(9),
    TRUSTED_GAIT(10),
    FLOOR_CHANGE(11),
    ON_STAIRS(12),
    ON_ESCALATOR(13),
    IN_ELEVATOR(14),
    SLEEPING(15),
    IN_ROAD_VEHICLE(16),
    IN_RAIL_VEHICLE(17),
    IN_TWO_WHEELER_VEHICLE(18),
    IN_FOUR_WHEELER_VEHICLE(19),
    IN_CAR(20),
    IN_BUS(21);

    public final int w;

    q(int i) {
        this.w = i;
    }

    public static q b(int i) {
        switch (i) {
            case 0:
                return IN_VEHICLE;
            case 1:
                return ON_BICYCLE;
            case 2:
                return ON_FOOT;
            case 3:
                return STILL;
            case 4:
                return UNKNOWN;
            case 5:
                return TILTING;
            case 6:
                return EXITING_VEHICLE;
            case 7:
                return WALKING;
            case 8:
                return RUNNING;
            case 9:
                return OFF_BODY;
            case 10:
                return TRUSTED_GAIT;
            case 11:
                return FLOOR_CHANGE;
            case 12:
                return ON_STAIRS;
            case 13:
                return ON_ESCALATOR;
            case 14:
                return IN_ELEVATOR;
            case 15:
                return SLEEPING;
            case 16:
                return IN_ROAD_VEHICLE;
            case 17:
                return IN_RAIL_VEHICLE;
            case 18:
                return IN_TWO_WHEELER_VEHICLE;
            case 19:
                return IN_FOUR_WHEELER_VEHICLE;
            case 20:
                return IN_CAR;
            case 21:
                return IN_BUS;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.w;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.w);
    }
}
