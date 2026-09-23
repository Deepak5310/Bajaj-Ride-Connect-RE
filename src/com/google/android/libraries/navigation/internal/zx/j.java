package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.dj;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends dj {
    private final ListIterator a;

    public j(ListIterator listIterator) {
        this.a = listIterator;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dj, com.google.android.libraries.navigation.internal.yz.dh
    protected final /* synthetic */ Iterator a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dj, java.util.ListIterator
    public final void add(Object obj) {
        ar.r(obj, "this list cannot contain null");
        this.a.add(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dj
    protected final ListIterator b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dj, java.util.ListIterator
    public final void set(Object obj) {
        ar.r(obj, "this list cannot contain null");
        this.a.set(obj);
    }
}
