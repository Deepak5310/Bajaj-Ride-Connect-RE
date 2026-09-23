package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ff implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_VIEW_MODE(0),
    FAR_VIEW_MODE(1),
    NORMAL(2),
    APPROACH(3),
    INSPECT_STEP(4),
    INSPECT_ROUTE(5),
    ARRIVING(11),
    LIMITED_CONTROLLED_ACCESS_MANEUVER(12),
    LIMITED_CONTROLLED_ACCESS_APPROACH(13);

    public final int j;

    ff(int i) {
        this.j = i;
    }

    public static ff b(int i) {
        if (i == 0) {
            return UNKNOWN_VIEW_MODE;
        }
        if (i == 1) {
            return FAR_VIEW_MODE;
        }
        if (i == 2) {
            return NORMAL;
        }
        if (i == 3) {
            return APPROACH;
        }
        if (i == 4) {
            return INSPECT_STEP;
        }
        if (i == 5) {
            return INSPECT_ROUTE;
        }
        switch (i) {
            case 11:
                return ARRIVING;
            case 12:
                return LIMITED_CONTROLLED_ACCESS_MANEUVER;
            case 13:
                return LIMITED_CONTROLLED_ACCESS_APPROACH;
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
