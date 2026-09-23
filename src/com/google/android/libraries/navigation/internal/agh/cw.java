package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cw implements com.google.android.libraries.navigation.internal.agi.gi {
    int a = -1;
    int b = 0;
    final /* synthetic */ cz c;

    public cw(cz czVar) {
        this.c = czVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.c.a.c;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            dg dgVar = this.c.a;
            long[] jArr = dgVar.a;
            this.a = i2;
            long j = jArr[i2];
            Object[] objArr = dgVar.b;
            this.b = i2 + 1;
            consumer.accept(new i(j, objArr[i2]));
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.c.a.c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        dg dgVar = this.c.a;
        long[] jArr = dgVar.a;
        int i = this.b;
        this.a = i;
        long j = jArr[i];
        Object[] objArr = dgVar.b;
        this.b = i + 1;
        return new i(j, objArr[i]);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.a == -1) {
            throw new IllegalStateException();
        }
        this.a = -1;
        dg dgVar = this.c.a;
        int i = dgVar.c;
        dgVar.c = i - 1;
        int i2 = this.b;
        int i3 = i2 - 1;
        this.b = i3;
        int i4 = i - i2;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i2, jArr, i3, i4);
        Object[] objArr = this.c.a.b;
        int i5 = this.b;
        System.arraycopy(objArr, i5 + 1, objArr, i5, i4);
        dg dgVar2 = this.c.a;
        dgVar2.b[dgVar2.c] = null;
    }
}
