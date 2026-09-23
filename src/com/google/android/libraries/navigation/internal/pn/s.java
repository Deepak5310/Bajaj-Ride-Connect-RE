package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends b {
    private static final float e = (float) Math.toRadians(10.0d);

    public s(j jVar, float f, float f2) {
        super(jVar, f, f2);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final void c(n nVar) {
        this.a.l(nVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean d(n nVar) {
        return this.a.t(nVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean h(n nVar) {
        return this.a.s(nVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final int i(long j, Deque deque, List list) {
        if (deque.size() < 3) {
            return 2;
        }
        h hVar = (h) deque.getLast();
        float f = hVar.a;
        Iterator itDescendingIterator = deque.descendingIterator();
        h hVar2 = hVar;
        while (itDescendingIterator.hasNext()) {
            h hVar3 = (h) itDescendingIterator.next();
            if (hVar3.d != hVar.d) {
                break;
            }
            if (Math.abs(a(f, hVar3.a)) > e) {
                return 1;
            }
            hVar2 = hVar3;
        }
        if (e < 0.0f) {
            return 1;
        }
        return Math.abs(hVar2.b - hVar.b) / ((this.c + this.d) * 0.5f) < (true != list.isEmpty() ? 0.2f : 0.1f) ? 2 : 3;
    }
}
