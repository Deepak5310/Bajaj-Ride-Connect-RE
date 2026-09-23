package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cq extends u {
    final /* synthetic */ cu a;

    public cq(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new co(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new cp(this, 0, this.a.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.p(obj) != -1;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.d;
        for (int i2 = 0; i2 < i; i2++) {
            consumer.accept(this.a.b[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new co(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iP = this.a.p(obj);
        if (iP == -1) {
            return false;
        }
        cu cuVar = this.a;
        int i = (cuVar.d - iP) - 1;
        int i2 = iP + 1;
        Object[] objArr = cuVar.b;
        System.arraycopy(objArr, i2, objArr, iP, i);
        long[] jArr = this.a.c;
        System.arraycopy(jArr, i2, jArr, iP, i);
        cu cuVar2 = this.a;
        int i3 = cuVar2.d - 1;
        cuVar2.d = i3;
        cuVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
