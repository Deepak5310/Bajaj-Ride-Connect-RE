package com.google.android.libraries.navigation.internal.yy;

import java.util.AbstractQueue;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bg extends AbstractQueue {
    final bj a = new be();

    @Override // java.util.Queue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final bj peek() {
        bj bjVar = this.a;
        bj bjVar2 = ((be) bjVar).a;
        if (bjVar2 == bjVar) {
            return null;
        }
        return bjVar2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        bj bjVar = ((be) this.a).a;
        while (true) {
            bj bjVar2 = this.a;
            if (bjVar == bjVar2) {
                be beVar = (be) bjVar2;
                beVar.a = bjVar2;
                beVar.b = bjVar2;
                return;
            } else {
                bj bjVarG = bjVar.g();
                bi.g(bjVar);
                bjVar = bjVarG;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return ((bj) obj).g() != an.INSTANCE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        bj bjVar = this.a;
        return ((be) bjVar).a == bjVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new bf(this, peek());
    }

    @Override // java.util.Queue
    public final /* bridge */ /* synthetic */ boolean offer(Object obj) {
        bj bjVar = (bj) obj;
        bi.e(bjVar.i(), bjVar.g());
        bi.e(((be) this.a).b, bjVar);
        bi.e(bjVar, this.a);
        return true;
    }

    @Override // java.util.Queue
    public final /* bridge */ /* synthetic */ Object poll() {
        bj bjVar = this.a;
        bj bjVar2 = ((be) bjVar).a;
        if (bjVar2 == bjVar) {
            return null;
        }
        remove(bjVar2);
        return bjVar2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        bj bjVar = (bj) obj;
        bj bjVarI = bjVar.i();
        bj bjVarG = bjVar.g();
        bi.e(bjVarI, bjVarG);
        bi.g(bjVar);
        return bjVarG != an.INSTANCE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i = 0;
        for (bj bjVarG = ((be) this.a).a; bjVarG != this.a; bjVarG = bjVarG.g()) {
            i++;
        }
        return i;
    }
}
