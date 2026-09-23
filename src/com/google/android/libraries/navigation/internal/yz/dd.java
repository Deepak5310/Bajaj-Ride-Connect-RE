package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dd extends de {
    final /* synthetic */ Iterable[] a;

    public dd(Iterable[] iterableArr) {
        this.a = iterableArr;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterable[] iterableArr = this.a;
        return new gx(new dc(iterableArr.length, iterableArr));
    }
}
