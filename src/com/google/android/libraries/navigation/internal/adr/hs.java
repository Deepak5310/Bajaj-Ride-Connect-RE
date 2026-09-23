package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum hs implements com.google.android.libraries.navigation.internal.ael.bm {
    SIDE_LEFT(1),
    SIDE_RIGHT(2),
    SIDE_UNSPECIFIED(3);

    public final int d;

    hs(int i) {
        this.d = i;
    }

    public static hs b(int i) {
        if (i == 1) {
            return SIDE_LEFT;
        }
        if (i == 2) {
            return SIDE_RIGHT;
        }
        if (i != 3) {
            return null;
        }
        return SIDE_UNSPECIFIED;
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
