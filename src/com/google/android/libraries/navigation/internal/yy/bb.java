package com.google.android.libraries.navigation.internal.yy;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class bb extends WeakReference implements bj {
    final int g;
    final bj h;
    volatile ax i;

    public bb(ReferenceQueue referenceQueue, Object obj, int i, bj bjVar) {
        super(obj, referenceQueue);
        this.i = bi.b;
        this.g = i;
        this.h = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bj
    public final int a() {
        return this.g;
    }

    public long b() {
        throw new UnsupportedOperationException();
    }

    public long c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bj
    public final ax d() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bj
    public final bj e() {
        return this.h;
    }

    public bj f() {
        throw new UnsupportedOperationException();
    }

    public bj g() {
        throw new UnsupportedOperationException();
    }

    public bj h() {
        throw new UnsupportedOperationException();
    }

    public bj i() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bj
    public final Object j() {
        return get();
    }

    public void k(long j) {
        throw new UnsupportedOperationException();
    }

    public void l(bj bjVar) {
        throw new UnsupportedOperationException();
    }

    public void m(bj bjVar) {
        throw new UnsupportedOperationException();
    }

    public void n(bj bjVar) {
        throw new UnsupportedOperationException();
    }

    public void o(bj bjVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bj
    public final void p(ax axVar) {
        this.i = axVar;
    }

    public void q(long j) {
        throw new UnsupportedOperationException();
    }
}
