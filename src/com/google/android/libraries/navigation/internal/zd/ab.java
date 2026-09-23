package com.google.android.libraries.navigation.internal.zd;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab implements Iterator {
    final /* synthetic */ ac a;
    private final com.google.android.libraries.navigation.internal.zb.ac b;
    private int c;
    private int d;

    public ab(ac acVar, com.google.android.libraries.navigation.internal.zb.ac acVar2, int i) {
        this.a = acVar;
        this.b = acVar2;
        int i2 = i & 31;
        this.c = i2;
        this.d = i >>> (i2 + 5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i;
        Object objC = this.b.c(this.a.f(this.c));
        int i2 = this.d;
        if (i2 != 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i2) + 1;
            this.d = i2 >>> iNumberOfTrailingZeros;
            i = this.c + iNumberOfTrailingZeros;
        } else {
            i = -1;
        }
        this.c = i;
        return objC;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
