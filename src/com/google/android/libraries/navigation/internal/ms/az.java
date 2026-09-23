package com.google.android.libraries.navigation.internal.ms;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az {
    by b;
    int e;
    int h;
    int i;
    com.google.android.libraries.navigation.internal.mx.g k;
    final ba a = new ba();
    final ba c = new ba();
    final List d = new ArrayList();
    com.google.android.libraries.navigation.internal.mx.w f = null;
    Integer g = null;
    com.google.android.libraries.navigation.internal.mx.y j = null;

    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    private final void d(com.google.android.libraries.navigation.internal.mx.w wVar, boolean z) {
        ba baVar;
        ba baVar2 = this.a;
        cw cwVarA = wVar.a();
        if (baVar2.c(cwVarA)) {
            if (z) {
                baVar = this.c;
            } else {
                baVar = this.a;
            }
        } else if (z) {
            this.c.c(cwVarA);
            baVar = this.c;
        } else {
            baVar = this.a;
        }
        baVar.b.put(wVar.a(), Integer.valueOf(baVar.a.size()));
        if (wVar.c()) {
            baVar.d++;
        } else {
            baVar.e++;
        }
        baVar.a.add(wVar);
    }

    public final cc a() {
        return this.k.d();
    }

    final void b(com.google.android.libraries.navigation.internal.mx.m[] mVarArr, boolean z) {
        for (com.google.android.libraries.navigation.internal.mx.m mVar : mVarArr) {
            if (mVar != null && mVar != com.google.android.libraries.navigation.internal.mx.m.e) {
                if (mVar instanceof com.google.android.libraries.navigation.internal.mx.i) {
                    if (z) {
                        throw new com.google.android.libraries.navigation.internal.yx.cb("Can't handle view node in child layout: ".concat(mVar.toString()));
                    }
                    this.d.add((com.google.android.libraries.navigation.internal.mx.i) mVar);
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.o) {
                    this.i = ((com.google.android.libraries.navigation.internal.mx.o) mVar).a;
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.n) {
                    this.h = 0;
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.z) {
                    this.g = 0;
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.aa) {
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.y) {
                    com.google.android.libraries.navigation.internal.mx.y yVar = (com.google.android.libraries.navigation.internal.mx.y) mVar;
                    this.j = yVar;
                    d(yVar.c, z);
                } else if (mVar instanceof com.google.android.libraries.navigation.internal.mx.w) {
                    com.google.android.libraries.navigation.internal.mx.w wVar = (com.google.android.libraries.navigation.internal.mx.w) mVar;
                    if (wVar.a() == e.ID) {
                        this.f = wVar;
                        d(wVar, z);
                    } else {
                        d(wVar, z);
                    }
                } else {
                    if (!(mVar instanceof com.google.android.libraries.navigation.internal.mx.k)) {
                        throw new com.google.android.libraries.navigation.internal.yx.cb("Can't handle node: ".concat(mVar.toString()));
                    }
                    b(((com.google.android.libraries.navigation.internal.mx.k) mVar).a, z);
                }
            }
        }
    }

    final boolean c() {
        return this.b != null;
    }
}
