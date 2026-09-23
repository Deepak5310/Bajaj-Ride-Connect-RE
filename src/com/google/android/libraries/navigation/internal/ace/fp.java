package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fp implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_MAP_FACTS_TYPE(0),
    POSTAL_CODE(1),
    ADMINISTRATIVE_AREA1(2),
    ADMINISTRATIVE_AREA2(3),
    COUNTRY(4),
    LOCALITY(5),
    DEPRECATED_NEIGHBORHOOD(6),
    DEPRECATED_SCHOOL_DISTRICT(7),
    ROAD(8),
    INTERSECTION(9),
    DEPRECATED_CLICKABLE_MAPS_ROAD(10),
    DEPRECATED_ADMINISTRATIVE_AREA3(11),
    DEPRECATED_ADMINISTRATIVE_AREA4(12),
    DEPRECATED_SUBLOCALITY_LEVEL_1(13),
    POSTAL_CODE_PREFIX(14),
    ROAD_PILOT(15),
    BUILDING(16),
    SCHOOL_DISTRICT_V2(17),
    NEIGHBORHOOD_PILOT(18),
    LOGGING_ONLY_DATASET(19);

    public final int u;

    fp(int i) {
        this.u = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.u;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.u);
    }
}
