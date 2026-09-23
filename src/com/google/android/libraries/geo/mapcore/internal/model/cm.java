package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cm {
    private static final String[] a = {"data:", "http:", "https:"};

    public static String a(String str, boolean z, int i, com.google.android.libraries.navigation.internal.adh.b bVar) {
        if (!z || bVar == null) {
            return str;
        }
        String[] strArr = a;
        for (int i2 = 0; i2 < 3; i2++) {
            if (str.startsWith(strArr[i2])) {
                return str;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (bVar.b.e(0)) {
            if (bVar.f206n == null) {
                if (bVar.b.e(0)) {
                    bVar.f206n = new String(bVar.t, bVar.b.b(0), bVar.b.a(0), com.google.android.libraries.navigation.internal.adh.b.r);
                } else {
                    bVar.f206n = "";
                }
            }
            sb.append(bVar.f206n);
        }
        com.google.android.libraries.navigation.internal.adh.f fVar = bVar.l;
        if (i < fVar.b) {
            synchronized (fVar) {
                if (bVar.m == null) {
                    bVar.m = new com.google.android.libraries.navigation.internal.adh.j(bVar.t, bVar.l);
                }
            }
            com.google.android.libraries.navigation.internal.adh.j jVar = bVar.m;
            String[] strArr2 = jVar.a;
            if (strArr2[i] == null) {
                strArr2[i] = new String(jVar.b, jVar.c.b(i), jVar.c.a(i), com.google.android.libraries.navigation.internal.adh.k.r);
            }
            sb.append(jVar.a[i]);
        }
        sb.append(str);
        if (bVar.b.e(1)) {
            if (bVar.o == null) {
                if (bVar.b.e(1)) {
                    bVar.o = new String(bVar.t, bVar.b.b(1), bVar.b.a(1), com.google.android.libraries.navigation.internal.adh.b.r);
                } else {
                    bVar.o = "";
                }
            }
            sb.append(bVar.o);
        }
        return sb.toString();
    }
}
