package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bm implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_SEARCH_FILTER(0),
    OUTDOOR(1);

    public final int c;

    bm(int i) {
        this.c = i;
    }

    public static bm b(int i) {
        if (i == 0) {
            return UNKNOWN_SEARCH_FILTER;
        }
        if (i != 1) {
            return null;
        }
        return OUTDOOR;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.c);
    }
}
