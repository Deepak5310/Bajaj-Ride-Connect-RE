package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum cu implements com.google.android.libraries.navigation.internal.ael.bm {
    OKAY(0),
    NO_ENDPOINTS_FOUND(1),
    NO_PATH_FOUND(2);

    public final int d;

    cu(int i) {
        this.d = i;
    }

    public static cu b(int i) {
        if (i == 0) {
            return OKAY;
        }
        if (i == 1) {
            return NO_ENDPOINTS_FOUND;
        }
        if (i != 2) {
            return null;
        }
        return NO_PATH_FOUND;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}
