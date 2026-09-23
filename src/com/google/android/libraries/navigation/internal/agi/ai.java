package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ai extends aj implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final la a;
    protected final int b;
    protected int c;

    public ai(la laVar, int i, int i2) {
        this.a = laVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final void add(int i, Object obj) {
        j(i);
        this.a.add(this.b + i, obj);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final boolean addAll(int i, Collection collection) {
        j(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public hj spliterator() {
        la laVar = this.a;
        if (laVar instanceof RandomAccess) {
            return new ae(laVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new ae(this) : new hq(h(), com.google.android.libraries.navigation.internal.agc.h.a(this), 16464);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj
    /* JADX INFO: renamed from: c */
    public la subList(int i, int i2) {
        j(i);
        j(i2);
        if (i <= i2) {
            return new ai(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    /* JADX INFO: renamed from: d */
    public gw listIterator(int i) {
        j(i);
        la laVar = this.a;
        return laVar instanceof RandomAccess ? new ah(this, i) : new ag(this, laVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void e(int i, Object[] objArr, int i2, int i3) {
        j(i);
        if (i + i3 <= size()) {
            this.a.e(this.b + i, objArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void f(int i, int i2) {
        j(i);
        j(i2);
        int i3 = this.b;
        this.a.f(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void g(int i, Object[] objArr, int i2) {
        j(i);
        this.a.g(this.b + i, objArr, i2);
    }

    @Override // java.util.List
    public Object get(int i) {
        k(i);
        return this.a.get(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final Object remove(int i) {
        k(i);
        this.c--;
        return this.a.remove(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final Object set(int i, Object obj) {
        k(i);
        return this.a.set(this.b + i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        this.a.add(this.c, obj);
        this.c++;
        return true;
    }
}
