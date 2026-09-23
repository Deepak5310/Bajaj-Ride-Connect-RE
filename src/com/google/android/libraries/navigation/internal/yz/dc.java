package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc extends h {
    final /* synthetic */ Iterable[] a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(int i, Iterable[] iterableArr) {
        super(i, 0);
        this.a = iterableArr;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.h
    public final /* bridge */ /* synthetic */ Object a(int i) {
        return this.a[i].iterator();
    }
}
