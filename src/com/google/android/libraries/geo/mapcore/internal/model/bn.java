package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bn implements Iterator {
    final /* synthetic */ bp a;
    private final Deque b;
    private final com.google.android.libraries.navigation.internal.oe.ai c;
    private final int d;
    private int e;

    public bn(bp bpVar, com.google.android.libraries.navigation.internal.oe.ai aiVar, int i) {
        this.a = bpVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.b = arrayDeque;
        this.c = aiVar;
        this.d = i;
        arrayDeque.add(0);
        this.e = -1;
        if (bpVar.h(i)) {
            b();
        }
    }

    private final void b() {
        if (!this.b.isEmpty()) {
            Integer num = (Integer) this.b.pollFirst();
            com.google.android.libraries.navigation.internal.yx.ar.q(num);
            this.e = num.intValue();
            while (true) {
                if (this.a.h(this.e)) {
                    bp bpVar = this.a;
                    int i = this.e;
                    bm bmVar = bpVar.a[i];
                    com.google.android.libraries.navigation.internal.oe.ai aiVar = this.c;
                    int i2 = bmVar.a;
                    com.google.android.libraries.navigation.internal.oe.x xVar = aiVar.b;
                    if (i2 <= xVar.a && bmVar.b <= xVar.b) {
                        com.google.android.libraries.navigation.internal.oe.x xVar2 = aiVar.a;
                        if (bmVar.c >= xVar2.a && bmVar.d >= xVar2.b) {
                            int i3 = bpVar.b;
                            int i4 = i3 - 1;
                            if (i >= bp.d(i4)) {
                                return;
                            }
                            int iE = bp.e(i);
                            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(Integer.highestOneBit(iE + 1));
                            if (bp.d(i4) + ((iE - bp.d(iNumberOfTrailingZeros)) << ((i3 - iNumberOfTrailingZeros) - 1)) <= this.d) {
                                this.e = iE;
                            } else {
                                this.b.offerFirst(Integer.valueOf(iE));
                                this.e = bp.c(this.e);
                            }
                        }
                    }
                }
                if (!this.b.isEmpty()) {
                    Integer num2 = (Integer) this.b.pollFirst();
                    com.google.android.libraries.navigation.internal.yx.ar.q(num2);
                    this.e = num2.intValue();
                }
            }
        }
        this.e = -1;
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
