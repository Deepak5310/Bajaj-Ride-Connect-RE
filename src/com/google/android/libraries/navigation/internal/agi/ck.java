package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ck implements gi {
    int a = -1;
    int b = 0;
    final /* synthetic */ cn c;

    public ck(cn cnVar) {
        this.c = cnVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.c.a.d;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            cu cuVar = this.c.a;
            Object[] objArr = cuVar.b;
            this.a = i2;
            Object obj = objArr[i2];
            long[] jArr = cuVar.c;
            this.b = i2 + 1;
            consumer.accept(new g(obj, jArr[i2]));
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.c.a.d;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        cu cuVar = this.c.a;
        Object[] objArr = cuVar.b;
        int i = this.b;
        this.a = i;
        Object obj = objArr[i];
        long[] jArr = cuVar.c;
        this.b = i + 1;
        return new g(obj, jArr[i]);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.a == -1) {
            throw new IllegalStateException();
        }
        this.a = -1;
        cu cuVar = this.c.a;
        int i = cuVar.d;
        cuVar.d = i - 1;
        int i2 = this.b;
        int i3 = i2 - 1;
        this.b = i3;
        int i4 = i - i2;
        Object[] objArr = cuVar.b;
        System.arraycopy(objArr, i2, objArr, i3, i4);
        long[] jArr = this.c.a.c;
        int i5 = this.b;
        System.arraycopy(jArr, i5 + 1, jArr, i5, i4);
        cu cuVar2 = this.c.a;
        cuVar2.b[cuVar2.d] = null;
    }
}
