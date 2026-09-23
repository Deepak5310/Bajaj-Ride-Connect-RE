package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum as implements com.google.android.libraries.navigation.internal.ael.bm {
    GOOGLE(1),
    IMMERSIVE(2);

    private final int d;

    as(int i) {
        this.d = i;
    }

    public static as b(int i) {
        if (i == 1) {
            return GOOGLE;
        }
        if (i != 2) {
            return null;
        }
        return IMMERSIVE;
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
