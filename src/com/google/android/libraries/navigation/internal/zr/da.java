package com.google.android.libraries.navigation.internal.zr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum da implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_SYNTHESIS_TYPE(0),
    LOCAL(1),
    NETWORK(2);

    public final int d;

    da(int i) {
        this.d = i;
    }

    public static da b(int i) {
        if (i == 0) {
            return UNKNOWN_SYNTHESIS_TYPE;
        }
        if (i == 1) {
            return LOCAL;
        }
        if (i != 2) {
            return null;
        }
        return NETWORK;
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
