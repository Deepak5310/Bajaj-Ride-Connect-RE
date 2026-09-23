package com.google.android.libraries.navigation.internal.agj;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g extends h implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final am a;
    protected final int b;
    protected int c;

    public g(am amVar, int i, int i2) {
        this.a = amVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public final boolean addAll(int i, Collection collection) {
        C(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public ay b() {
        am amVar = this.a;
        if (amVar instanceof RandomAccess) {
            return new c(amVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new c(this) : new bc(w(), com.google.android.libraries.navigation.internal.agc.h.a(this));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final boolean e(short s) {
        int iU = u(s);
        if (iU == -1) {
            return false;
        }
        this.c--;
        this.a.m(this.b + iU);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final void i(short s) {
        this.a.o(this.c, s);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    /* JADX INFO: renamed from: j */
    public am subList(int i, int i2) {
        C(i);
        C(i2);
        if (i <= i2) {
            return new g(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    /* JADX INFO: renamed from: k */
    public ao listIterator(int i) {
        C(i);
        am amVar = this.a;
        return amVar instanceof RandomAccess ? new f(this, i) : new e(this, amVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public short l(int i) {
        D(i);
        return this.a.l(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final short m(int i) {
        D(i);
        this.c--;
        return this.a.m(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final short n(int i, short s) {
        D(i);
        return this.a.n(this.b + i, s);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void o(int i, short s) {
        C(i);
        this.a.o(this.b + i, s);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void p(int i, short[] sArr, int i2, int i3) {
        C(i);
        if (i + i3 <= size()) {
            this.a.p(this.b + i, sArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void q(int i, int i2) {
        C(i);
        C(i2);
        int i3 = this.b;
        this.a.q(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    public final boolean r(int i, u uVar) {
        C(i);
        C(i);
        aj it2 = uVar.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            o(i, it2.d());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void s(int i, short[] sArr, int i2) {
        C(i);
        this.a.s(this.b + i, sArr, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
