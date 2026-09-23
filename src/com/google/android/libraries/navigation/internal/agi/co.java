package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co implements gi {
    int a = 0;
    final /* synthetic */ cq b;

    public co(cq cqVar) {
        this.b = cqVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.b.a.d;
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
        return this.a < this.b.a.d;
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
        cu cuVar = this.b.a;
        int i2 = cuVar.d - i;
        Object[] objArr = cuVar.b;
        System.arraycopy(objArr, i, objArr, i - 1, i2);
        long[] jArr = this.b.a.c;
        int i3 = this.a;
        System.arraycopy(jArr, i3, jArr, i3 - 1, i2);
        cu cuVar2 = this.b.a;
        int i4 = cuVar2.d - 1;
        cuVar2.d = i4;
        this.a--;
        cuVar2.b[i4] = null;
    }
}
