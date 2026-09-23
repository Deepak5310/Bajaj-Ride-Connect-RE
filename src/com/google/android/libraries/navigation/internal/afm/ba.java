package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ba implements com.google.android.libraries.navigation.internal.ael.bm {
    SPHERICAL(3),
    CUBIC(4);

    private final int d;

    ba(int i) {
        this.d = i;
    }

    public static ba b(int i) {
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
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}
