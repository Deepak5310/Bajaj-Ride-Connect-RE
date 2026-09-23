package com.google.android.libraries.navigation.internal.agd;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f extends h implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final ao a;
    protected final int b;
    protected int c;

    public f(ao aoVar, int i, int i2) {
        this.a = aoVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public final boolean addAll(int i, Collection collection) {
        D(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public be b() {
        ao aoVar = this.a;
        if (aoVar instanceof RandomAccess) {
            return new g(aoVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new g(this) : new bi(x(), com.google.android.libraries.navigation.internal.agc.h.a(this));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean c(byte b) {
        this.a.p(this.c, b);
        this.c++;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean g(byte b) {
        int iV = v(b);
        if (iV == -1) {
            return false;
        }
        this.c--;
        this.a.m(this.b + iV);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h
    /* JADX INFO: renamed from: k */
    public ao subList(int i, int i2) {
        D(i);
        D(i2);
        if (i <= i2) {
            return new f(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public byte l(int i) {
        E(i);
        return this.a.l(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final byte m(int i) {
        E(i);
        this.c--;
        return this.a.m(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final byte n(int i, byte b) {
        E(i);
        return this.a.n(this.b + i, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    /* JADX INFO: renamed from: o */
    public aq listIterator(int i) {
        D(i);
        ao aoVar = this.a;
        return aoVar instanceof RandomAccess ? new e(this, i) : new d(this, aoVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void p(int i, byte b) {
        D(i);
        this.a.p(this.b + i, b);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void q(int i, byte[] bArr, int i2, int i3) {
        D(i);
        if (i + i3 <= size()) {
            this.a.q(this.b + i, bArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void r(int i, int i2) {
        D(i);
        D(i2);
        int i3 = this.b;
        this.a.r(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h
    public final boolean s(int i, w wVar) {
        D(i);
        D(i);
        al it2 = wVar.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            p(i, it2.c());
            i++;
        }
        return zHasNext;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void t(int i, byte[] bArr, int i2) {
        D(i);
        this.a.t(this.b + i, bArr, i2);
    }
}
