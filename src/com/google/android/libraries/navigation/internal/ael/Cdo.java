package com.google.android.libraries.navigation.internal.ael;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.ael.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class Cdo implements Iterator {
    private final ArrayDeque a;
    private u b;

    public Cdo(x xVar) {
        if (!(xVar instanceof dq)) {
            this.a = null;
            this.b = (u) xVar;
            return;
        }
        dq dqVar = (dq) xVar;
        ArrayDeque arrayDeque = new ArrayDeque(dqVar.g);
        this.a = arrayDeque;
        arrayDeque.push(dqVar);
        this.b = b(dqVar.e);
    }

    private final u b(x xVar) {
        while (xVar instanceof dq) {
            dq dqVar = (dq) xVar;
            this.a.push(dqVar);
            int i = dq.h;
            xVar = dqVar.e;
        }
        return (u) xVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final u next() {
        u uVarB;
        u uVar = this.b;
        if (uVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.a;
            uVarB = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            dq dqVar = (dq) this.a.pop();
            int i = dq.h;
            uVarB = b(dqVar.f);
        } while (uVarB.A());
        this.b = uVarB;
        return uVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
