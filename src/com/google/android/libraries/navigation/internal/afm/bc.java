package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bc implements com.google.android.libraries.navigation.internal.ael.bm {
    OUTDOOR(0),
    INDOOR(1);

    private final int d;

    bc(int i) {
        this.d = i;
    }

    public static bc b(int i) {
        if (i == 0) {
            return OUTDOOR;
        }
        if (i != 1) {
            return null;
        }
        return INDOOR;
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
