package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.bp.bg;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static com.google.android.libraries.navigation.internal.ade.c a(double d, bg bgVar) {
        List listN = bgVar.N();
        if (listN.size() < 2) {
            com.google.android.libraries.navigation.internal.ade.b bVar = (com.google.android.libraries.navigation.internal.ade.b) com.google.android.libraries.navigation.internal.ade.c.a.q();
            if (!bVar.b.H()) {
                bVar.v();
            }
            ((com.google.android.libraries.navigation.internal.ade.c) bVar.b).b = 0;
            if (!bVar.b.H()) {
                bVar.v();
            }
            ((com.google.android.libraries.navigation.internal.ade.c) bVar.b).c = 0.0f;
            return (com.google.android.libraries.navigation.internal.ade.c) bVar.t();
        }
        int iMin = Math.min(bgVar.h(d), listN.size() - 2);
        double dA = bgVar.a(iMin);
        double dA2 = bgVar.a(iMin + 1) - dA;
        double d2 = dA2 != 0.0d ? (d - dA) / dA2 : 0.0d;
        com.google.android.libraries.navigation.internal.ade.b bVar2 = (com.google.android.libraries.navigation.internal.ade.b) com.google.android.libraries.navigation.internal.ade.c.a.q();
        if (!bVar2.b.H()) {
            bVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).b = iMin;
        float f = (float) d2;
        if (!bVar2.b.H()) {
            bVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).c = f;
        return (com.google.android.libraries.navigation.internal.ade.c) bVar2.t();
    }

    public static com.google.android.libraries.navigation.internal.ade.c b(double d, bg bgVar) {
        List listN = bgVar.N();
        if (listN.size() < 2) {
            com.google.android.libraries.navigation.internal.ade.b bVar = (com.google.android.libraries.navigation.internal.ade.b) com.google.android.libraries.navigation.internal.ade.c.a.q();
            if (!bVar.b.H()) {
                bVar.v();
            }
            ((com.google.android.libraries.navigation.internal.ade.c) bVar.b).b = 0;
            if (!bVar.b.H()) {
                bVar.v();
            }
            ((com.google.android.libraries.navigation.internal.ade.c) bVar.b).c = 0.0f;
            return (com.google.android.libraries.navigation.internal.ade.c) bVar.t();
        }
        int iBinarySearch = Arrays.binarySearch(bgVar.F, d);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 2);
        }
        int iMin = Math.min(Math.max(0, iBinarySearch), listN.size() - 2);
        double d2 = bgVar.d(iMin);
        double d3 = bgVar.d(iMin + 1) - d2;
        double d4 = d3 != 0.0d ? (d - d2) / d3 : 0.0d;
        com.google.android.libraries.navigation.internal.ade.b bVar2 = (com.google.android.libraries.navigation.internal.ade.b) com.google.android.libraries.navigation.internal.ade.c.a.q();
        if (!bVar2.b.H()) {
            bVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).b = iMin;
        float f = (float) d4;
        if (!bVar2.b.H()) {
            bVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).c = f;
        return (com.google.android.libraries.navigation.internal.ade.c) bVar2.t();
    }
}
