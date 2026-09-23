package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum im implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_STYLE(0),
    SLOWER_TRAFFIC(1),
    TRAFFIC_JAM(2);

    private final int e;

    im(int i) {
        this.e = i;
    }

    public static im b(int i) {
        if (i == 0) {
            return UNKNOWN_STYLE;
        }
        if (i == 1) {
            return SLOWER_TRAFFIC;
        }
        if (i != 2) {
            return null;
        }
        return TRAFFIC_JAM;
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
