package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eb extends u {
    final /* synthetic */ ef a;

    public eb(ef efVar) {
        this.a = efVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new dz(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new ea(this, 0, this.a.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.e(obj) != -1;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            consumer.accept(this.a.a[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new dz(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iE = this.a.e(obj);
        if (iE == -1) {
            return false;
        }
        ef efVar = this.a;
        int i = (efVar.c - iE) - 1;
        int i2 = iE + 1;
        Object[] objArr = efVar.a;
        System.arraycopy(objArr, i2, objArr, iE, i);
        Object[] objArr2 = this.a.b;
        System.arraycopy(objArr2, i2, objArr2, iE, i);
        ef efVar2 = this.a;
        int i3 = efVar2.c - 1;
        efVar2.c = i3;
        efVar2.a[i3] = null;
        efVar2.b[i3] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
