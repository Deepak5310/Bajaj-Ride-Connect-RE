package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bg implements com.google.android.libraries.navigation.internal.ael.bm {
    TYPE_TO_ROAD_NAME(0),
    TYPE_TOWARD_NAME(1),
    TYPE_TOWARD_ROAD_NAME(2),
    TYPE_EXIT_NUMBER(3),
    TYPE_FOLLOW_ROAD_NAME(4),
    TYPE_FROM_ROAD_NAME(5),
    TYPE_TITLE(6),
    TYPE_ADDRESS(7),
    TYPE_AT_ROAD_NAME(8),
    TYPE_INTERSECTION(9),
    TYPE_TRANSIT_SIGNPOST(10),
    TYPE_EXIT_NAME(11),
    TYPE_TRANSIT_ENTRANCE_NAME(12),
    TYPE_TRANSIT_EXIT_NAME(13);

    public final int o;

    bg(int i) {
        this.o = i;
    }

    public static bg b(int i) {
        switch (i) {
            case 0:
                return TYPE_TO_ROAD_NAME;
            case 1:
                return TYPE_TOWARD_NAME;
            case 2:
                return TYPE_TOWARD_ROAD_NAME;
            case 3:
                return TYPE_EXIT_NUMBER;
            case 4:
                return TYPE_FOLLOW_ROAD_NAME;
            case 5:
                return TYPE_FROM_ROAD_NAME;
            case 6:
                return TYPE_TITLE;
            case 7:
                return TYPE_ADDRESS;
            case 8:
                return TYPE_AT_ROAD_NAME;
            case 9:
                return TYPE_INTERSECTION;
            case 10:
                return TYPE_TRANSIT_SIGNPOST;
            case 11:
                return TYPE_EXIT_NAME;
            case 12:
                return TYPE_TRANSIT_ENTRANCE_NAME;
            case 13:
                return TYPE_TRANSIT_EXIT_NAME;
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
