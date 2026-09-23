package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum dh implements com.google.android.libraries.navigation.internal.ael.bm {
    PREPARE(0),
    ACT(1),
    SUCCESS(2),
    NOTE(3);

    public final int e;

    dh(int i) {
        this.e = i;
    }

    public static dh b(int i) {
        if (i == 0) {
            return PREPARE;
        }
        if (i == 1) {
            return ACT;
        }
        if (i == 2) {
            return SUCCESS;
        }
        if (i != 3) {
            return null;
        }
        return NOTE;
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
