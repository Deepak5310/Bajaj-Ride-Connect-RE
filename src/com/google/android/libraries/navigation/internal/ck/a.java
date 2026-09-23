package com.google.android.libraries.navigation.internal.ck;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public com.google.android.libraries.navigation.internal.ady.al a;
    public boolean b;
    public com.google.android.libraries.navigation.internal.oe.ad c;
    public List d;
    public List e;
    public short f;
    private boolean g;
    private boolean h;
    private List i;
    private List j;
    private List k;
    private int l;
    private float m;

    public final be a() {
        int i = ~this.f;
        if ((i & 9) == 0) {
            return new be(this.a, this.g, this.b, this.c, this.d, this.h, this.i, this.j, this.k, this.e, this.l, this.m, null, i & 8182);
        }
        throw new IllegalStateException();
    }

    public final void b(float f) {
        this.m = f;
        this.f = (short) (this.f | 2048);
    }

    public final void c(boolean z) {
        this.h = z;
        this.f = (short) (this.f | 32);
    }

    public final void d(boolean z) {
        this.g = z;
        this.f = (short) (this.f | 2);
    }

    public final void e(List list) {
        Objects.requireNonNull(list);
        this.k = list;
        this.f = (short) (this.f | 256);
    }

    public final void f(List list) {
        Objects.requireNonNull(list);
        this.j = list;
        this.f = (short) (this.f | 128);
    }

    public final void g(List list) {
        Objects.requireNonNull(list);
        this.i = list;
        this.f = (short) (this.f | 64);
    }

    public final void h(int i) {
        this.l = i;
        this.f = (short) (this.f | 1024);
    }
}
