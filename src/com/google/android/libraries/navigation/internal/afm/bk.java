package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bk implements com.google.android.libraries.navigation.internal.ael.bm {
    SPHERICAL(3),
    CUBIC(4);

    public final int c;

    bk(int i) {
        this.c = i;
    }

    public static bk b(int i) {
        if (i == 3) {
            return SPHERICAL;
        }
        if (i != 4) {
            return null;
        }
        return CUBIC;
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
