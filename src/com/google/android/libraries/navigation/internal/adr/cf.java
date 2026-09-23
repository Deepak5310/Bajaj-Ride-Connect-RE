package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum cf implements com.google.android.libraries.navigation.internal.ael.bm {
    POSITION_UNKNOWN(0),
    POSITION_START(1),
    POSITION_END(2);

    private final int e;

    cf(int i) {
        this.e = i;
    }

    public static cf b(int i) {
        if (i == 0) {
            return POSITION_UNKNOWN;
        }
        if (i == 1) {
            return POSITION_START;
        }
        if (i != 2) {
            return null;
        }
        return POSITION_END;
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
