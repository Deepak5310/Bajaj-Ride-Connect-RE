package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fp implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    CONTINUE(1),
    TOLL(2),
    PARTIAL_TOLL(3),
    SEASONAL_CLOSURE(4),
    TEMPORARY_ROAD_CLOSURE(15),
    ROUNDABOUTS(5),
    COUNTRY_BORDER(6),
    CRISIS(29),
    COUNTRY_CROSSING(16),
    PRIVATE_ROAD(17),
    FERRY_BOAT(18),
    FERRY_TRAIN(19),
    PROVINCE_BORDER(7),
    SIDE_OF_ROAD(8),
    TOLL_ZONE_CROSSING(9),
    EVENT(25),
    INCIDENT(10),
    BETA(11),
    TRAFFIC_ONE_LINER(12),
    TRAFFIC_PROBLEM(13),
    TRAFFIC_PROMPT(14),
    TRAFFIC_TREND(24),
    TRANSIT_ALERT(20),
    TIME_BASED_RESTRICTION(21),
    TIME_BASED_HOV(22),
    TRANSIT_SYSTEM_SUMMARY(23),
    TIME_ZONE(26),
    VEHICLE_LICENSE_RESTRICTION(27),
    HIGHWAY(28),
    ON_ROUTE_PROBLEM(30),
    BUSYNESS(31),
    RESTRICTED_ZONE(32),
    ROUTE_FIXTURE(33),
    ENERGY_CONSUMPTION(34),
    IMPRECISE_LODGING(35),
    WIDESPREAD_TRANSIT_DISRUPTION(36);

    public final int L;

    fp(int i) {
        this.L = i;
    }

    public static fp b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return CONTINUE;
            case 2:
                return TOLL;
            case 3:
                return PARTIAL_TOLL;
            case 4:
                return SEASONAL_CLOSURE;
            case 5:
                return ROUNDABOUTS;
            case 6:
                return COUNTRY_BORDER;
            case 7:
                return PROVINCE_BORDER;
            case 8:
                return SIDE_OF_ROAD;
            case 9:
                return TOLL_ZONE_CROSSING;
            case 10:
                return INCIDENT;
            case 11:
                return BETA;
            case 12:
                return TRAFFIC_ONE_LINER;
            case 13:
                return TRAFFIC_PROBLEM;
            case 14:
                return TRAFFIC_PROMPT;
            case 15:
                return TEMPORARY_ROAD_CLOSURE;
            case 16:
                return COUNTRY_CROSSING;
            case 17:
                return PRIVATE_ROAD;
            case 18:
                return FERRY_BOAT;
            case 19:
                return FERRY_TRAIN;
            case 20:
                return TRANSIT_ALERT;
            case 21:
                return TIME_BASED_RESTRICTION;
            case 22:
                return TIME_BASED_HOV;
            case 23:
                return TRANSIT_SYSTEM_SUMMARY;
            case 24:
                return TRAFFIC_TREND;
            case 25:
                return EVENT;
            case 26:
                return TIME_ZONE;
            case 27:
                return VEHICLE_LICENSE_RESTRICTION;
            case 28:
                return HIGHWAY;
            case 29:
                return CRISIS;
            case 30:
                return ON_ROUTE_PROBLEM;
            case 31:
                return BUSYNESS;
            case 32:
                return RESTRICTED_ZONE;
            case 33:
                return ROUTE_FIXTURE;
            case 34:
                return ENERGY_CONSUMPTION;
            case 35:
                return IMPRECISE_LODGING;
            case 36:
                return WIDESPREAD_TRANSIT_DISRUPTION;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.L;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.L);
    }
}
