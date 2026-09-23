package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum hv implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    DIRECTIONS(1),
    PLACE_DETAILS(2),
    START_PAGE(3),
    SEARCH(4),
    DEPRECATED_TILE(5),
    MAPS_ACTIVITIES_TIMELINE(6),
    RIDDLER(7),
    LOCAL_STREAM(8);

    public final int j;

    hv(int i) {
        this.j = i;
    }

    public static hv b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return DIRECTIONS;
            case 2:
                return PLACE_DETAILS;
            case 3:
                return START_PAGE;
            case 4:
                return SEARCH;
            case 5:
                return DEPRECATED_TILE;
            case 6:
                return MAPS_ACTIVITIES_TIMELINE;
            case 7:
                return RIDDLER;
            case 8:
                return LOCAL_STREAM;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.j;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.j);
    }
}
