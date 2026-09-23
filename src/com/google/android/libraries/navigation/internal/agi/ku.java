package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ku implements gi {
    int a = 0;
    final /* synthetic */ kw b;

    public ku(kw kwVar) {
        this.b = kwVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.b.a;
        int i = this.a;
        this.a = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        kw kwVar = this.b;
        int i = kwVar.b;
        kwVar.b = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        Object[] objArr = kwVar.a;
        System.arraycopy(objArr, i2, objArr, i3, i - i2);
        kw kwVar2 = this.b;
        kwVar2.a[kwVar2.b] = null;
    }
}
