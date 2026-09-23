package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n extends o implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final es a;
    protected final int b;
    protected int c;

    public n(es esVar, int i, int i2) {
        this.a = esVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final boolean addAll(int i, Collection collection) {
        F(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public fh spliterator() {
        es esVar = this.a;
        if (esVar instanceof RandomAccess) {
            return new j(esVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new j(this) : new fo(z(), com.google.android.libraries.navigation.internal.agc.h.a(this), 16720);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final boolean c(int i) {
        this.a.r(this.c, i);
        this.c++;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean h(int i) {
        int iX = x(i);
        if (iX == -1) {
            return false;
        }
        this.c--;
        this.a.o(this.b + iX);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: m */
    public es subList(int i, int i2) {
        F(i);
        F(i2);
        if (i <= i2) {
            return new n(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    public int n(int i) {
        G(i);
        return this.a.n(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int o(int i) {
        G(i);
        this.c--;
        return this.a.o(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int p(int i, int i2) {
        G(i);
        return this.a.p(this.b + i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: q */
    public eu listIterator(int i) {
        F(i);
        es esVar = this.a;
        return esVar instanceof RandomAccess ? new m(this, i) : new l(this, esVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void r(int i, int i2) {
        F(i);
        this.a.r(this.b + i, i2);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void s(int i, int[] iArr, int i2, int i3) {
        F(i);
        if (i + i3 <= size()) {
            this.a.s(this.b + i, iArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void t(int i, int i2) {
        F(i);
        F(i2);
        int i3 = this.b;
        this.a.t(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    public final boolean u(int i, Cdo cdo) {
        F(i);
        F(i);
        ei eiVarN = cdo.n();
        boolean zHasNext = eiVarN.hasNext();
        while (eiVarN.hasNext()) {
            r(i, eiVarN.nextInt());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void v(int i, int[] iArr, int i2) {
        F(i);
        this.a.v(this.b + i, iArr, i2);
    }
}
