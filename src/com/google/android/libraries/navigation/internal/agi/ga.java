package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ga implements gi {
    int a = 0;
    final /* synthetic */ gc b;

    public ga(gc gcVar) {
        this.b = gcVar;
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
        gc gcVar = this.b;
        int i = gcVar.b;
        gcVar.b = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        Object[] objArr = gcVar.a;
        System.arraycopy(objArr, i2, objArr, i3, i - i2);
        gc gcVar2 = this.b;
        gcVar2.a[gcVar2.b] = null;
    }
}
