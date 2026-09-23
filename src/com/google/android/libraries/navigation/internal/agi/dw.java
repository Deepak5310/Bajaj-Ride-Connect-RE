package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dw implements gi {
    int a = 0;
    int b = -1;
    final j c = new j();
    final /* synthetic */ dy d;

    public dw(dy dyVar) {
        this.d = dyVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.d.a.c;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            j jVar = this.c;
            ef efVar = this.d.a;
            Object[] objArr = efVar.a;
            this.b = i2;
            jVar.a = objArr[i2];
            Object[] objArr2 = efVar.b;
            this.a = i2 + 1;
            jVar.b = objArr2[i2];
            consumer.accept(jVar);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.a.c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        j jVar = this.c;
        ef efVar = this.d.a;
        Object[] objArr = efVar.a;
        int i = this.a;
        this.b = i;
        jVar.a = objArr[i];
        Object[] objArr2 = efVar.b;
        this.a = i + 1;
        jVar.b = objArr2[i];
        return jVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.b = -1;
        ef efVar = this.d.a;
        int i = efVar.c;
        efVar.c = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        int i4 = i - i2;
        Object[] objArr = efVar.a;
        System.arraycopy(objArr, i2, objArr, i3, i4);
        Object[] objArr2 = this.d.a.b;
        int i5 = this.a;
        System.arraycopy(objArr2, i5 + 1, objArr2, i5, i4);
        ef efVar2 = this.d.a;
        Object[] objArr3 = efVar2.a;
        int i6 = efVar2.c;
        objArr3[i6] = null;
        efVar2.b[i6] = null;
    }
}
