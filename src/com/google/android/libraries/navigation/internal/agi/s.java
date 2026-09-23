package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class s extends t implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final gu a;
    protected final int b;
    protected int c;

    public s(gu guVar, int i, int i2) {
        this.a = guVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t
    /* JADX INFO: renamed from: a */
    public gu subList(int i, int i2) {
        k(i);
        k(i2);
        if (i <= i2) {
            return new s(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final void add(int i, Object obj) {
        k(i);
        this.a.add(this.b + i, obj);
        this.c++;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final boolean addAll(int i, Collection collection) {
        k(i);
        this.c += collection.size();
        return this.a.addAll(this.b + i, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public hj spliterator() {
        gu guVar = this.a;
        if (guVar instanceof RandomAccess) {
            return new o(guVar, this.b, this.c);
        }
        return this instanceof RandomAccess ? new o(this) : new hq(i(), com.google.android.libraries.navigation.internal.agc.h.a(this), 16464);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.gu
    /* JADX INFO: renamed from: d */
    public gw listIterator(int i) {
        k(i);
        gu guVar = this.a;
        return guVar instanceof RandomAccess ? new r(this, i) : new q(this, guVar.listIterator(i + this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.gu
    public final void e(int i, Object[] objArr, int i2, int i3) {
        k(i);
        if (i + i3 <= size()) {
            this.a.e(this.b + i, objArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("End index (" + i + i3 + ") is greater than list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.gu
    public final void f(int i, int i2) {
        k(i);
        k(i2);
        int i3 = this.b;
        this.a.f(i3 + i, i3 + i2);
        this.c -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.gu
    public final void g(int i, Object[] objArr, int i2) {
        k(i);
        this.a.g(this.b + i, objArr, i2);
    }

    public Object get(int i) {
        l(i);
        return this.a.get(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final Object remove(int i) {
        l(i);
        this.c--;
        return this.a.remove(this.b + i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final Object set(int i, Object obj) {
        l(i);
        return this.a.set(this.b + i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        this.a.add(this.c, obj);
        this.c++;
        return true;
    }
}
