package com.google.android.libraries.navigation.internal.db;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public static com.google.android.libraries.navigation.internal.aes.g a(double d, double d2, float f) {
        com.google.android.libraries.navigation.internal.aes.g gVar = (com.google.android.libraries.navigation.internal.aes.g) com.google.android.libraries.navigation.internal.aes.h.a.q();
        com.google.android.libraries.navigation.internal.aes.c cVar = (com.google.android.libraries.navigation.internal.aes.c) com.google.android.libraries.navigation.internal.aes.d.a.q();
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aes.d dVar = (com.google.android.libraries.navigation.internal.aes.d) cVar.b;
        dVar.b |= 1;
        dVar.c = (int) (d * 1.0E7d);
        double d3 = d2 * 1.0E7d;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aes.d dVar2 = (com.google.android.libraries.navigation.internal.aes.d) cVar.b;
        dVar2.b |= 2;
        dVar2.d = (int) d3;
        com.google.android.libraries.navigation.internal.aes.d dVar3 = (com.google.android.libraries.navigation.internal.aes.d) cVar.t();
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) gVar.b;
        dVar3.getClass();
        hVar.f = dVar3;
        hVar.b |= 16;
        if (f > 0.0f) {
            float f2 = f * 1000.0f;
            if (!gVar.b.H()) {
                gVar.v();
            }
            com.google.android.libraries.navigation.internal.aes.h hVar2 = (com.google.android.libraries.navigation.internal.aes.h) gVar.b;
            hVar2.b |= 128;
            hVar2.g = f2;
        }
        return gVar;
    }
}
