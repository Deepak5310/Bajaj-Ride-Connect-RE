package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z implements com.google.android.libraries.navigation.internal.agi.gi {
    int a = 0;
    int b = -1;
    final b c = new b();
    final /* synthetic */ ab d;

    public z(ab abVar) {
        this.d = abVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.d.a.d;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            b bVar = this.c;
            ai aiVar = this.d.a;
            long[] jArr = aiVar.b;
            this.b = i2;
            bVar.a = jArr[i2];
            double[] dArr = aiVar.c;
            this.a = i2 + 1;
            bVar.b = dArr[i2];
            consumer.accept(bVar);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.a.d;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        b bVar = this.c;
        ai aiVar = this.d.a;
        long[] jArr = aiVar.b;
        int i = this.a;
        this.b = i;
        bVar.a = jArr[i];
        double[] dArr = aiVar.c;
        this.a = i + 1;
        bVar.b = dArr[i];
        return bVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.b = -1;
        ai aiVar = this.d.a;
        int i = aiVar.d;
        aiVar.d = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        int i4 = i - i2;
        long[] jArr = aiVar.b;
        System.arraycopy(jArr, i2, jArr, i3, i4);
        double[] dArr = this.d.a.c;
        int i5 = this.a;
        System.arraycopy(dArr, i5 + 1, dArr, i5, i4);
    }
}
