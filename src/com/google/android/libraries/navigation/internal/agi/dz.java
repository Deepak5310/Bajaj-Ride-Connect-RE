package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dz implements gi {
    int a = 0;
    final /* synthetic */ eb b;

    public dz(eb ebVar) {
        this.b = ebVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.b.a.c;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            Object[] objArr = this.b.a.a;
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
        Object[] objArr = this.b.a.a;
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
        ef efVar = this.b.a;
        int i2 = efVar.c - i;
        Object[] objArr = efVar.a;
        System.arraycopy(objArr, i, objArr, i - 1, i2);
        Object[] objArr2 = this.b.a.b;
        int i3 = this.a;
        System.arraycopy(objArr2, i3, objArr2, i3 - 1, i2);
        ef efVar2 = this.b.a;
        int i4 = efVar2.c - 1;
        efVar2.c = i4;
        this.a--;
        efVar2.a[i4] = null;
        efVar2.b[i4] = null;
    }
}
