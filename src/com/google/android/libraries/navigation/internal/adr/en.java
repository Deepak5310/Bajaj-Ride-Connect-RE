package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum en implements com.google.android.libraries.navigation.internal.ael.bm {
    NONE(0),
    LEFT(1),
    RIGHT(2);

    private final int e;

    en(int i) {
        this.e = i;
    }

    public static en b(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return LEFT;
        }
        if (i != 2) {
            return null;
        }
        return RIGHT;
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
