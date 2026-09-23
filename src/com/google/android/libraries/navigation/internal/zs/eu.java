package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum eu implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_CLIENT_SIDE_DEVICE_TIER(0),
    LOW(1),
    MID(2),
    HIGH(3);

    public final int e;

    eu(int i) {
        this.e = i;
    }

    public static eu b(int i) {
        if (i == 0) {
            return UNKNOWN_CLIENT_SIDE_DEVICE_TIER;
        }
        if (i == 1) {
            return LOW;
        }
        if (i == 2) {
            return MID;
        }
        if (i != 3) {
            return null;
        }
        return HIGH;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.e);
    }
}
