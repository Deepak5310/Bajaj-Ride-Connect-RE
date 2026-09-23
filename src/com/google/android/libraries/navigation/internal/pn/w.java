package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends b {
    private final float e;

    public w(j jVar, float f, float f2, float f3) {
        super(jVar, f, f2);
        this.e = f3 * f3;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final void c(n nVar) {
        this.a.l(nVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean d(n nVar) {
        return this.a.t(nVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean h(n nVar) {
        return this.a.s(nVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final int i(long j, Deque deque, List list) {
        h hVar;
        h hVar2;
        Iterator it2 = deque.iterator();
        do {
            hVar = null;
            if (!it2.hasNext()) {
                hVar2 = null;
                break;
            }
            hVar2 = (h) it2.next();
        } while (hVar2.d != 2);
        Iterator itDescendingIterator = deque.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            h hVar3 = (h) itDescendingIterator.next();
            if (hVar3.d == 2) {
                hVar = hVar3;
                break;
            }
        }
        if (hVar2 == null || hVar == null || hVar.c - j > 300) {
            return 1;
        }
        float fB = hVar.b(0) - hVar2.b(0);
        float fC = hVar.c(0) - hVar2.c(0);
        float fB2 = hVar.b(1) - hVar2.b(1);
        float fC2 = hVar.c(1) - hVar2.c(1);
        return Math.max((fB * fB) + (fC * fC), (fB2 * fB2) + (fC2 * fC2)) > this.e ? 1 : 3;
    }
}
