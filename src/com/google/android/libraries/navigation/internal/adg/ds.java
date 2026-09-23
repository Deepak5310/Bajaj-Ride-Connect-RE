package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ds implements com.google.android.libraries.navigation.internal.ael.bm {
    CENTER_JUSTIFY(1),
    LEFT_JUSTIFY(2),
    RIGHT_JUSTIFY(3);

    public final int d;

    ds(int i) {
        this.d = i;
    }

    public static ds b(int i) {
        if (i == 1) {
            return CENTER_JUSTIFY;
        }
        if (i == 2) {
            return LEFT_JUSTIFY;
        }
        if (i != 3) {
            return null;
        }
        return RIGHT_JUSTIFY;
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
