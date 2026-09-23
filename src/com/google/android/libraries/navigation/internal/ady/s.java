package com.google.android.libraries.navigation.internal.ady;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum s implements bm {
    PNG(0),
    SVG(1),
    JPG(2);

    public final int d;

    s(int i) {
        this.d = i;
    }

    public static s b(int i) {
        if (i == 0) {
            return PNG;
        }
        if (i == 1) {
            return SVG;
        }
        if (i != 2) {
            return null;
        }
        return JPG;
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
