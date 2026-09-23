package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends p {
    public boolean a;
    public q b;
    public ev c;
    public short d;
    private com.google.android.libraries.navigation.internal.oe.r e;
    private u f;
    private long g;
    private final an h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final an f492n;

    public a() {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.h = aVar;
        this.f492n = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final r a() {
        if (this.d != 511 || this.e == null || this.f == null || this.b == null || this.c == null) {
            throw new IllegalStateException();
        }
        return new e(this.e, this.f, this.g, this.h, this.i, this.a, this.b, this.j, this.k, this.c, this.l, this.m, this.f492n);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void b(long j) {
        this.g = j;
        this.d = (short) (this.d | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void c(int i) {
        this.j = i;
        this.d = (short) (this.d | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void d(int i) {
        this.l = i;
        this.d = (short) (this.d | 128);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void e(int i) {
        this.m = i;
        this.d = (short) (this.d | 256);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void f(int i) {
        this.k = i;
        this.d = (short) (this.d | 16);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void g(int i) {
        this.i = i;
        this.d = (short) (this.d | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void h(u uVar) {
        Objects.requireNonNull(uVar);
        this.f = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.p
    public final void i(com.google.android.libraries.navigation.internal.oe.r rVar) {
        Objects.requireNonNull(rVar);
        this.e = rVar;
    }
}
