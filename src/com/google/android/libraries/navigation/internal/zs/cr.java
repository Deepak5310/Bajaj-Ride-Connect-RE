package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum cr implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    RAW(1),
    RAW_ONLY(2),
    CLIENT_SNAPPED(3),
    CLIENT_SNAPPED_ONLY(6);

    public final int f;

    cr(int i) {
        this.f = i;
    }

    public static cr b(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return RAW;
        }
        if (i == 2) {
            return RAW_ONLY;
        }
        if (i == 3) {
            return CLIENT_SNAPPED;
        }
        if (i != 6) {
            return null;
        }
        return CLIENT_SNAPPED_ONLY;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f);
    }
}
