package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cx implements com.google.android.libraries.navigation.internal.agi.gi {
    int a = 0;
    int b = -1;
    final i c = new i();
    final /* synthetic */ cz d;

    public cx(cz czVar) {
        this.d = czVar;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.d.a.c;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            i iVar = this.c;
            dg dgVar = this.d.a;
            long[] jArr = dgVar.a;
            this.b = i2;
            iVar.a = jArr[i2];
            Object[] objArr = dgVar.b;
            this.a = i2 + 1;
            iVar.b = objArr[i2];
            consumer.accept(iVar);
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
        i iVar = this.c;
        dg dgVar = this.d.a;
        long[] jArr = dgVar.a;
        int i = this.a;
        this.b = i;
        iVar.a = jArr[i];
        Object[] objArr = dgVar.b;
        this.a = i + 1;
        iVar.b = objArr[i];
        return iVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.b = -1;
        dg dgVar = this.d.a;
        int i = dgVar.c;
        dgVar.c = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        int i4 = i - i2;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i2, jArr, i3, i4);
        Object[] objArr = this.d.a.b;
        int i5 = this.a;
        System.arraycopy(objArr, i5 + 1, objArr, i5, i4);
        dg dgVar2 = this.d.a;
        dgVar2.b[dgVar2.c] = null;
    }
}
