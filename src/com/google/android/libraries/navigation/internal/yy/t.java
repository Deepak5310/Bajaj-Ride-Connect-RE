package com.google.android.libraries.navigation.internal.yy;

import java.util.AbstractQueue;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t extends AbstractQueue {
    final bj a = new r();

    @Override // java.util.Queue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final bj peek() {
        bj bjVar = this.a;
        bj bjVar2 = ((r) bjVar).a;
        if (bjVar2 == bjVar) {
            return null;
        }
        return bjVar2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        bj bjVar = ((r) this.a).a;
        while (true) {
            bj bjVar2 = this.a;
            if (bjVar == bjVar2) {
                r rVar = (r) bjVar2;
                rVar.a = bjVar2;
                rVar.b = bjVar2;
                return;
            } else {
                bj bjVarF = bjVar.f();
                bi.f(bjVar);
                bjVar = bjVarF;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return ((bj) obj).f() != an.INSTANCE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        bj bjVar = this.a;
        return ((r) bjVar).a == bjVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new s(this, peek());
    }

    @Override // java.util.Queue
    public final /* bridge */ /* synthetic */ boolean offer(Object obj) {
        bj bjVar = (bj) obj;
        bi.d(bjVar.h(), bjVar.f());
        bi.d(((r) this.a).b, bjVar);
        bi.d(bjVar, this.a);
        return true;
    }

    @Override // java.util.Queue
    public final /* bridge */ /* synthetic */ Object poll() {
        bj bjVar = this.a;
        bj bjVar2 = ((r) bjVar).a;
        if (bjVar2 == bjVar) {
            return null;
        }
        remove(bjVar2);
        return bjVar2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        bj bjVar = (bj) obj;
        bj bjVarH = bjVar.h();
        bj bjVarF = bjVar.f();
        bi.d(bjVarH, bjVarF);
        bi.f(bjVar);
        return bjVarF != an.INSTANCE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i = 0;
        for (bj bjVarF = ((r) this.a).a; bjVarF != this.a; bjVarF = bjVarF.f()) {
            i++;
        }
        return i;
    }
}
