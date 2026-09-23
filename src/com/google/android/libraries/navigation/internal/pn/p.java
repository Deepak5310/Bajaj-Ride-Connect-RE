package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class p extends b {
    protected final float e;
    protected final float f;
    protected float g;
    protected float h;
    private final int i;

    public p(int i, j jVar, float f, float f2) {
        super(jVar, f, f2);
        this.e = (float) Math.toRadians(45.0d);
        this.f = 0.25f;
        this.g = 0.125f;
        this.h = 1.0f;
        this.i = i;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public int i(long j, Deque deque, List list) {
        if (deque.size() < 3) {
            return 2;
        }
        h hVar = (h) deque.getLast();
        if (hVar.d != this.i) {
            return 1;
        }
        Iterator itDescendingIterator = deque.descendingIterator();
        h hVar2 = null;
        h hVar3 = hVar;
        float fAbs = 0.0f;
        float fAbs2 = 0.0f;
        float fAbs3 = 0.0f;
        float fAbs4 = 0.0f;
        while (itDescendingIterator.hasNext()) {
            h hVar4 = (h) itDescendingIterator.next();
            if (hVar4.d != hVar.d) {
                break;
            }
            if (j(hVar4.a) >= this.e || (hVar4.b * (this.i - 1)) / this.c < 0.25f) {
                return 1;
            }
            if (hVar2 != null) {
                fAbs += Math.abs(k(hVar4, 0) - k(hVar2, 0));
                fAbs3 += Math.abs(l(hVar4, 0) - l(hVar2, 0));
                fAbs2 += Math.abs(k(hVar4, hVar4.d - 1) - k(hVar2, hVar2.d - 1));
                fAbs4 += Math.abs(l(hVar4, hVar4.d - 1) - l(hVar2, hVar2.d - 1));
            }
            hVar2 = hVar4;
            hVar3 = hVar2;
        }
        if (fAbs + fAbs2 > (fAbs3 + fAbs4) * this.h) {
            return 1;
        }
        float fL = l(hVar, 0) - l(hVar3, 0);
        float fL2 = l(hVar, hVar.d - 1) - l(hVar3, hVar3.d - 1);
        if (fL * fL2 < 0.0f) {
            return 1;
        }
        float fAbs5 = Math.abs(fL);
        float f = this.d;
        return Math.min(fAbs5 / f, Math.abs(fL2) / f) < this.g ? 2 : 3;
    }

    protected abstract float j(float f);

    protected abstract float k(h hVar, int i);

    protected abstract float l(h hVar, int i);
}
