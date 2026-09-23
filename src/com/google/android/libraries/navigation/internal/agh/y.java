package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y implements com.google.android.libraries.navigation.internal.agi.gi {
    int a = -1;
    int b = 0;
    final /* synthetic */ ab c;

    public y(ab abVar) {
        this.c = abVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.c.a.d;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            ai aiVar = this.c.a;
            long[] jArr = aiVar.b;
            this.a = i2;
            long j = jArr[i2];
            double[] dArr = aiVar.c;
            this.b = i2 + 1;
            consumer.accept(new b(j, dArr[i2]));
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
        ai aiVar = this.c.a;
        long[] jArr = aiVar.b;
        int i = this.b;
        this.a = i;
        long j = jArr[i];
        double[] dArr = aiVar.c;
        this.b = i + 1;
        return new b(j, dArr[i]);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.a == -1) {
            throw new IllegalStateException();
        }
        this.a = -1;
        ai aiVar = this.c.a;
        int i = aiVar.d;
        aiVar.d = i - 1;
        int i2 = this.b;
        int i3 = i2 - 1;
        this.b = i3;
        int i4 = i - i2;
        long[] jArr = aiVar.b;
        System.arraycopy(jArr, i2, jArr, i3, i4);
        double[] dArr = this.c.a.c;
        int i5 = this.b;
        System.arraycopy(dArr, i5 + 1, dArr, i5, i4);
    }
}
