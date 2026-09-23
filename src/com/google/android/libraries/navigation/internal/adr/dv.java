package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum dv implements com.google.android.libraries.navigation.internal.ael.bm {
    STRAIGHT(0),
    SLIGHT(1),
    NORMAL(2),
    SHARP(3),
    U_TURN(4),
    MERGE(5);

    public final int g;

    dv(int i) {
        this.g = i;
    }

    public static dv b(int i) {
        if (i == 0) {
            return STRAIGHT;
        }
        if (i == 1) {
            return SLIGHT;
        }
        if (i == 2) {
            return NORMAL;
        }
        if (i == 3) {
            return SHARP;
        }
        if (i == 4) {
            return U_TURN;
        }
        if (i != 5) {
            return null;
        }
        return MERGE;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.g);
    }
}
