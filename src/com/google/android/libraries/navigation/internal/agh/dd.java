package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dd implements com.google.android.libraries.navigation.internal.agi.gi {
    int a = 0;
    final /* synthetic */ df b;

    public dd(df dfVar) {
        this.b = dfVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.b.a.c;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            Object[] objArr = this.b.a.b;
            this.a = i2 + 1;
            consumer.accept(objArr[i2]);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.b.a.b;
        int i = this.a;
        this.a = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        if (i == 0) {
            throw new IllegalStateException();
        }
        dg dgVar = this.b.a;
        int i2 = dgVar.c - i;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i, jArr, i - 1, i2);
        Object[] objArr = this.b.a.b;
        int i3 = this.a;
        System.arraycopy(objArr, i3, objArr, i3 - 1, i2);
        dg dgVar2 = this.b.a;
        int i4 = dgVar2.c - 1;
        dgVar2.c = i4;
        this.a--;
        dgVar2.b[i4] = null;
    }
}
