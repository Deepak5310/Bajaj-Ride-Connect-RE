package com.google.android.libraries.navigation.internal.de;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e {
    final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    public final void a(com.google.android.libraries.navigation.internal.cy.d dVar) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        f fVar = this.a;
        fVar.i = dVar.e();
        fVar.e = dVar.d();
        fVar.f = dVar.c();
        int i = fVar.g;
        fVar.g = com.google.android.libraries.navigation.internal.cw.o.a((int) Math.ceil(fVar.f));
        if (fVar.f <= 25.0f) {
            fVar.g = 4;
        }
        fVar.f(true);
        if (i != fVar.g) {
            int i2 = fVar.g;
            if (fVar.h) {
                synchronized (fVar.c) {
                    Iterator it2 = fVar.d.keySet().iterator();
                    while (it2.hasNext()) {
                        ((h) it2.next()).a(i2);
                    }
                }
            }
        }
        float f = fVar.e;
        if (fVar.h) {
            synchronized (fVar.c) {
                Iterator it3 = fVar.d.keySet().iterator();
                while (it3.hasNext()) {
                    ((h) it3.next()).b(f, -1000.0f, null, null, 0, 0, -1.0f, Float.MAX_VALUE);
                }
            }
        }
        fVar.g();
    }
}
