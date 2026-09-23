package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends b {
    private static final float f;
    private static final float g;
    public boolean e;

    static {
        float radians = (float) Math.toRadians(5.0d);
        f = radians;
        g = radians + radians;
    }

    public r(j jVar, float f2, float f3) {
        super(jVar, f2, f3);
        this.e = true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final void c(n nVar) {
        this.a.k(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean d(n nVar) {
        return this.a.r(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean h(n nVar) {
        return this.a.q(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final int i(long j, Deque deque, List list) {
        h hVar;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((b) list.get(i)).f()) {
                return 1;
            }
        }
        if (deque.size() < 3) {
            return 2;
        }
        Iterator it2 = deque.iterator();
        do {
            if (!it2.hasNext()) {
                hVar = null;
                break;
            }
            hVar = (h) it2.next();
        } while (hVar.d <= 1);
        h hVar2 = (h) deque.getLast();
        if (hVar == null || hVar2.d <= 1) {
            return 1;
        }
        if (!this.e) {
            return 3;
        }
        float f2 = list.isEmpty() ? f : g;
        float fAbs = Math.abs(a(hVar.a, hVar2.a));
        if (fAbs < f2) {
            return 1;
        }
        float f3 = (this.c + this.d) * 0.5f;
        float f4 = hVar2.b / f3;
        if (f4 < 0.75f) {
            return 1;
        }
        float fAbs2 = Math.abs(f4 - (hVar.b / f3));
        if (fAbs2 != 0.0f) {
            float f5 = fAbs / fAbs2;
            if (f5 < 0.5f) {
                return 1;
            }
            if (f5 < 0.9f) {
                return 2;
            }
        }
        return 3;
    }
}
