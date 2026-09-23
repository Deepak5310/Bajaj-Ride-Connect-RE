package com.google.android.libraries.navigation.internal.agh;

import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc extends v {
    final /* synthetic */ dg a;

    public dc(dg dgVar) {
        this.a = dgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public final gs m() {
        return new da(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new db(this, 0, this.a.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.h(j) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new da(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v
    public final boolean l(long j) {
        int iH = this.a.h(j);
        if (iH == -1) {
            return false;
        }
        dg dgVar = this.a;
        int i = (dgVar.c - iH) - 1;
        int i2 = iH + 1;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i2, jArr, iH, i);
        Object[] objArr = this.a.b;
        System.arraycopy(objArr, i2, objArr, iH, i);
        dg dgVar2 = this.a;
        int i3 = dgVar2.c - 1;
        dgVar2.c = i3;
        dgVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
