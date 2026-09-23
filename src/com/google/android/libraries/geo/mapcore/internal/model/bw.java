package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.ig;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.agh.cv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bw {
    final int a;
    com.google.android.libraries.navigation.internal.agh.ce b = null;
    int c;

    public bw(int i, int i2) {
        this.a = i;
        this.c = i2;
    }

    public final synchronized void a(com.google.android.libraries.navigation.internal.adh.a aVar) {
        int i = this.c;
        if (i >= 0) {
            try {
                com.google.android.libraries.navigation.internal.agh.cg cgVar = null;
                ig igVar = (ig) ((dg) ig.a.aH(7, null)).j(aVar.t, aVar.c.b(i), aVar.c.a(i), aVar.a);
                if (igVar.b.size() == igVar.c.size()) {
                    cv cvVar = new cv(igVar.b.size());
                    cvVar.a = -1L;
                    long jD = 0;
                    long jD2 = 0;
                    for (int i2 = 0; i2 < igVar.b.size(); i2++) {
                        jD += (long) igVar.b.d(i2);
                        jD2 += (long) igVar.c.d(i2);
                        if (!cvVar.e(jD)) {
                            cvVar.b(jD, jD2);
                        }
                    }
                    com.google.android.libraries.navigation.internal.agh.cf cfVar = com.google.android.libraries.navigation.internal.agh.ch.a;
                    cgVar = new com.google.android.libraries.navigation.internal.agh.cg(cvVar);
                }
                this.b = cgVar;
            } catch (com.google.android.libraries.navigation.internal.ael.cc unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1091)).p("InternalStyle transform failed parsing");
            }
            this.c = -1;
        }
    }
}
