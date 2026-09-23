package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dv implements gi {
    int a = -1;
    int b = 0;
    final /* synthetic */ dy c;

    public dv(dy dyVar) {
        this.c = dyVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.c.a.c;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            ef efVar = this.c.a;
            Object[] objArr = efVar.a;
            this.a = i2;
            Object obj = objArr[i2];
            Object[] objArr2 = efVar.b;
            this.b = i2 + 1;
            consumer.accept(new j(obj, objArr2[i2]));
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
        ef efVar = this.c.a;
        Object[] objArr = efVar.a;
        int i = this.b;
        this.a = i;
        Object obj = objArr[i];
        Object[] objArr2 = efVar.b;
        this.b = i + 1;
        return new j(obj, objArr2[i]);
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.a == -1) {
            throw new IllegalStateException();
        }
        this.a = -1;
        ef efVar = this.c.a;
        int i = efVar.c;
        efVar.c = i - 1;
        int i2 = this.b;
        int i3 = i2 - 1;
        this.b = i3;
        int i4 = i - i2;
        Object[] objArr = efVar.a;
        System.arraycopy(objArr, i2, objArr, i3, i4);
        Object[] objArr2 = this.c.a.b;
        int i5 = this.b;
        System.arraycopy(objArr2, i5 + 1, objArr2, i5, i4);
        ef efVar2 = this.c.a;
        Object[] objArr3 = efVar2.a;
        int i6 = efVar2.c;
        objArr3[i6] = null;
        efVar2.b[i6] = null;
    }
}
