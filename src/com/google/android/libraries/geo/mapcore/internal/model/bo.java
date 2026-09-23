package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bo implements Iterator {
    final /* synthetic */ bp a;
    private final bn b;
    private final int c;
    private final int d;
    private int e;
    private int f;

    public bo(bp bpVar, com.google.android.libraries.navigation.internal.oe.ai aiVar, int i, int i2) {
        this.a = bpVar;
        com.google.android.libraries.navigation.internal.yx.ar.a(i2 >= 0);
        this.b = new bn(bpVar, aiVar, bpVar.a(0));
        this.c = 0;
        this.d = i2;
        this.e = -1;
        this.f = -1;
        b();
    }

    private final void b() {
        int i = this.e;
        int i2 = this.d;
        if (i < i2 && i < this.f) {
            this.e = i + 1;
            return;
        }
        if (i < i2) {
            bn bnVar = this.b;
            if (bnVar.hasNext()) {
                int iB = this.a.b(bnVar.next().intValue());
                this.e = Math.max(iB, 0);
                this.f = Math.min(iB + 8, this.a.c.e() - 1);
                return;
            }
        }
        this.e = -1;
        this.f = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.e >= 0;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        int i = this.e;
        b();
        return Integer.valueOf(i);
    }
}
