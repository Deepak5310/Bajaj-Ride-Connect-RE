package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum m implements com.google.android.libraries.navigation.internal.ael.bm {
    PNG(0),
    GIF(1),
    JPEG(2),
    CJPEG(3);

    public final int e;

    m(int i) {
        this.e = i;
    }

    public static m b(int i) {
        if (i == 0) {
            return PNG;
        }
        if (i == 1) {
            return GIF;
        }
        if (i == 2) {
            return JPEG;
        }
        if (i != 3) {
            return null;
        }
        return CJPEG;
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
