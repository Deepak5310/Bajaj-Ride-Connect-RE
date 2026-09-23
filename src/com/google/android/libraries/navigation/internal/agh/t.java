package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class t extends u implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final gy a;
    protected final int b;
    protected int c;

    public t(gy gyVar, int i, int i2) {
        this.a = gyVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public final boolean addAll(int i, Collection collection) {
        E(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public hl spliterator() {
        gy gyVar = this.a;
        if (gyVar instanceof RandomAccess) {
            return new p(gyVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new p(this) : new hr(y(), com.google.android.libraries.navigation.internal.agc.h.a(this), 16720);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean c(long j) {
        this.a.q(this.c, j);
        this.c++;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean g(long j) {
        int iW = w(j);
        if (iW == -1) {
            return false;
        }
        this.c--;
        this.a.n(this.b + iW);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    /* JADX INFO: renamed from: l */
    public gy subList(int i, int i2) {
        E(i);
        E(i2);
        if (i <= i2) {
            return new t(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    public long m(int i) {
        F(i);
        return this.a.m(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final long n(int i) {
        F(i);
        this.c--;
        return this.a.n(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final long o(int i, long j) {
        F(i);
        return this.a.o(this.b + i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    /* JADX INFO: renamed from: p */
    public ha listIterator(int i) {
        E(i);
        gy gyVar = this.a;
        return gyVar instanceof RandomAccess ? new s(this, i) : new r(this, gyVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void q(int i, long j) {
        E(i);
        this.a.q(this.b + i, j);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void r(int i, long[] jArr, int i2, int i3) {
        E(i);
        if (i + i3 <= size()) {
            this.a.r(this.b + i, jArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void s(int i, int i2) {
        E(i);
        E(i2);
        int i3 = this.b;
        this.a.s(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    public final boolean t(int i, gf gfVar) {
        E(i);
        E(i);
        gs gsVarM = gfVar.m();
        boolean zHasNext = gsVarM.hasNext();
        while (gsVarM.hasNext()) {
            q(i, gsVarM.nextLong());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void u(int i, long[] jArr, int i2) {
        E(i);
        this.a.u(this.b + i, jArr, i2);
    }
}
