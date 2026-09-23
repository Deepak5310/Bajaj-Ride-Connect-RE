package com.google.android.libraries.navigation.internal.ael;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o extends p {
    final /* synthetic */ x a;
    private int b = 0;
    private final int c;

    public o(x xVar) {
        this.a = xVar;
        this.c = xVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.s
    public final byte a() {
        int i = this.b;
        if (i >= this.c) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        return this.a.b(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.c;
    }
}
