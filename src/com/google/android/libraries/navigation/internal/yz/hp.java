package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hp extends AbstractList implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;
    final Object a;
    final Object[] b;

    public hp(Object obj, Object[] objArr) {
        this.a = obj;
        this.b = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, size());
        return i == 0 ? this.a : this.b[i - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int length = this.b.length;
        return com.google.android.libraries.navigation.internal.zw.e.b(3, 1);
    }
}
