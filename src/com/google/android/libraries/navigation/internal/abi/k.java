package com.google.android.libraries.navigation.internal.abi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends c {
    public k(i iVar) {
        super(iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final void c(j jVar) {
        d dVar = (d) this.a;
        dVar.a.a();
        dVar.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean d(j jVar) {
        d dVar = (d) this.a;
        boolean zD = dVar.a.d();
        if (zD) {
            dVar.a.b();
        }
        return zD;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean h(j jVar) {
        return ((d) this.a).a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final int i(long j, LinkedList linkedList, List list) {
        g gVar;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).f()) {
                return 1;
            }
        }
        if (linkedList.size() < 3) {
            return 2;
        }
        Iterator it3 = linkedList.iterator();
        do {
            if (!it3.hasNext()) {
                gVar = null;
                break;
            }
            gVar = (g) it3.next();
        } while (gVar.e() <= 1);
        g gVar2 = (g) linkedList.getLast();
        if (gVar == null || gVar2.e() <= 1) {
            return 1;
        }
        float f = true != list.isEmpty() ? 0.17453292f : 0.08726646f;
        float fAbs = Math.abs(a(gVar.i(), gVar2.i()));
        if (fAbs < f) {
            return 1;
        }
        float fB = (gVar2.b() + gVar2.d()) * 0.5f;
        float fJ = gVar2.j() / fB;
        if (fJ < 0.75f) {
            return 1;
        }
        float fAbs2 = Math.abs(fJ - (gVar.j() / fB));
        if (fAbs2 != 0.0f) {
            float f2 = fAbs / fAbs2;
            if (f2 < 0.5f) {
                return 1;
            }
            if (f2 < 0.9f) {
                return 2;
            }
        }
        return 3;
    }
}
