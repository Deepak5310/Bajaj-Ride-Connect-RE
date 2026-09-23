package com.google.android.libraries.navigation.internal.yz;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i extends nn {
    private Object a;
    private int b = 2;

    protected i() {
    }

    protected abstract Object a();

    protected final void b() {
        this.b = 3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.b != 4);
        int i = this.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.b = 4;
            this.a = a();
            if (this.b != 3) {
                this.b = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = 2;
        Object obj = this.a;
        this.a = null;
        return obj;
    }
}
