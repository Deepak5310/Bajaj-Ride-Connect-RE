package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.di;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends di {
    final List a;

    public i(List list) {
        ar.q(list);
        this.a = list;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Collection aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final void add(int i, Object obj) {
        ar.r(obj, "this list cannot contain null");
        this.a.add(i, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final boolean addAll(int i, Collection collection) {
        return this.a.addAll(i, m.a(collection));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di
    protected final List b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final ListIterator listIterator() {
        return new j(this.a.listIterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final Object set(int i, Object obj) {
        ar.r(obj, "this list cannot contain null");
        return this.a.set(i, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final List subList(int i, int i2) {
        return new i(this.a.subList(i, i2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.di, java.util.List
    public final ListIterator listIterator(int i) {
        return new j(this.a.listIterator(i));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        ar.r(obj, "this list cannot contain null");
        return this.a.add(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection
    public final boolean addAll(Collection collection) {
        return this.a.addAll(m.a(collection));
    }
}
