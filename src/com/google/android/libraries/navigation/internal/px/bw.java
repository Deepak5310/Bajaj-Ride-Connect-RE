package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bw {
    public static boolean a(com.google.android.libraries.navigation.internal.pd.d dVar, com.google.android.libraries.navigation.internal.pd.d dVar2, int i, float f) {
        if (dVar2 == null || dVar == null) {
            return true;
        }
        if (dVar.equals(dVar2)) {
            return false;
        }
        float f2 = dVar.k;
        float f3 = dVar2.k;
        if (((int) (f2 + f2)) == ((int) (f3 + f3)) && Math.abs(f2 - f3) < 0.1f && Math.abs(com.google.android.libraries.navigation.internal.nq.a.e(dVar.m - dVar2.m)) < 3.0f && Math.abs(dVar.l - dVar2.l) < 1.0f) {
            float f4 = com.google.android.libraries.navigation.internal.pb.j.f(f2, i, f);
            if (dVar.j.i(dVar2.j) / (f4 * f4) < 0.010000001f) {
                com.google.android.libraries.navigation.internal.pd.e eVar = dVar.f515n;
                com.google.android.libraries.navigation.internal.pd.e eVar2 = dVar2.f515n;
                float f5 = eVar.b - eVar2.b;
                float f6 = eVar.c - eVar2.c;
                return (f5 * f5) + (f6 * f6) >= 0.010000001f;
            }
        }
        return true;
    }
}
