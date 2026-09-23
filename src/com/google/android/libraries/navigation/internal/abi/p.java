package com.google.android.libraries.navigation.internal.abi;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p extends c {
    protected final float c;
    protected final float d;
    protected float e;
    protected float f;

    public p(i iVar) {
        super(iVar);
        this.c = 0.7853982f;
        this.d = 0.25f;
        this.e = 0.125f;
        this.f = 1.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    public final int i(long j, LinkedList linkedList, List list) {
        if (linkedList.size() < 3) {
            return 2;
        }
        g gVar = (g) linkedList.getLast();
        if (gVar.e() != 2) {
            return 1;
        }
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        g gVar2 = null;
        g gVar3 = gVar;
        float fAbs = 0.0f;
        float fAbs2 = 0.0f;
        float fAbs3 = 0.0f;
        float fAbs4 = 0.0f;
        while (listIterator.hasPrevious()) {
            g gVar4 = (g) listIterator.previous();
            if (gVar4.e() != gVar.e()) {
                break;
            }
            if (j(gVar4.i()) >= 0.7853982f || gVar4.j() / gVar4.b() < 0.25f) {
                return 1;
            }
            if (gVar2 != null) {
                fAbs += Math.abs(k(gVar4, 0) - k(gVar2, 0));
                fAbs3 += Math.abs(l(gVar4, 0) - l(gVar2, 0));
                fAbs2 += Math.abs(k(gVar4, gVar4.e() - 1) - k(gVar2, gVar2.e() - 1));
                fAbs4 += Math.abs(l(gVar4, gVar4.e() - 1) - l(gVar2, gVar2.e() - 1));
            }
            gVar2 = gVar4;
            gVar3 = gVar2;
        }
        if (fAbs + fAbs2 > (fAbs3 + fAbs4) * this.f) {
            return 1;
        }
        float fL = l(gVar, 0) - l(gVar3, 0);
        float fL2 = l(gVar, gVar.e() - 1) - l(gVar3, gVar3.e() - 1);
        if (fL * fL2 < 0.0f) {
            return 1;
        }
        return Math.min(Math.abs(fL) / gVar.d(), Math.abs(fL2) / gVar.d()) < this.e ? 2 : 3;
    }

    protected abstract float j(float f);

    protected abstract float k(g gVar, int i);

    protected abstract float l(g gVar, int i);
}
