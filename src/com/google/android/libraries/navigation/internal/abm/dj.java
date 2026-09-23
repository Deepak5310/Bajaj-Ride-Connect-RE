package com.google.android.libraries.navigation.internal.abm;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dj {
    static final Comparator a = new Comparator() { // from class: com.google.android.libraries.navigation.internal.abm.di
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            dj djVar = (dj) obj;
            dj djVar2 = (dj) obj2;
            float f = djVar.c;
            float f2 = djVar2.c;
            if (f != f2) {
                return Float.compare(f2, f);
            }
            int i = djVar.d;
            int i2 = djVar2.d;
            return i != i2 ? i2 - i : djVar2.e - djVar.e;
        }
    };
    public final String b;
    public final float c;
    public final int d;
    public final int e;

    public dj(String str, float f, int i, int i2) {
        this.b = str;
        this.c = f;
        this.d = i;
        this.e = i2;
    }
}
