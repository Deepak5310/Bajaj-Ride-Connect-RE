package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cl implements gi {
    int a = 0;
    int b = -1;
    final g c = new g();
    final /* synthetic */ cn d;

    public cl(cn cnVar) {
        this.d = cnVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final dc next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        g gVar = this.c;
        cu cuVar = this.d.a;
        Object[] objArr = cuVar.b;
        int i = this.a;
        this.b = i;
        gVar.a = objArr[i];
        long[] jArr = cuVar.c;
        this.a = i + 1;
        gVar.b = jArr[i];
        return gVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.d.a.d;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            g gVar = this.c;
            cu cuVar = this.d.a;
            Object[] objArr = cuVar.b;
            this.b = i2;
            gVar.a = objArr[i2];
            long[] jArr = cuVar.c;
            this.a = i2 + 1;
            gVar.b = jArr[i2];
            consumer.accept(gVar);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.a.d;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.b = -1;
        cu cuVar = this.d.a;
        int i = cuVar.d;
        cuVar.d = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        int i4 = i - i2;
        Object[] objArr = cuVar.b;
        System.arraycopy(objArr, i2, objArr, i3, i4);
        long[] jArr = this.d.a.c;
        int i5 = this.a;
        System.arraycopy(jArr, i5 + 1, jArr, i5, i4);
        cu cuVar2 = this.d.a;
        cuVar2.b[cuVar2.d] = null;
    }
}
