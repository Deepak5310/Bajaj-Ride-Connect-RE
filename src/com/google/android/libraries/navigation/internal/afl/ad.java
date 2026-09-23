package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ad implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_LOCATION_SHARING_STATE(0),
    NOT_SHARING(1),
    SHARING_BUT_NOT_REPORTING(2),
    SHARING_AND_REPORTING(3);

    public final int e;

    ad(int i) {
        this.e = i;
    }

    public static ad b(int i) {
        if (i == 0) {
            return UNKNOWN_LOCATION_SHARING_STATE;
        }
        if (i == 1) {
            return NOT_SHARING;
        }
        if (i == 2) {
            return SHARING_BUT_NOT_REPORTING;
        }
        if (i != 3) {
            return null;
        }
        return SHARING_AND_REPORTING;
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
