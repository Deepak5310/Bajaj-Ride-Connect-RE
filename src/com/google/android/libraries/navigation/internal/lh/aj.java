package com.google.android.libraries.navigation.internal.lh;

import android.util.SparseIntArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {
    public final SparseIntArray a;
    public com.google.android.libraries.navigation.internal.lc.i b;

    public aj() {
        this(com.google.android.libraries.navigation.internal.lc.h.a);
    }

    public final void a() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public final int b(int i) {
        int i2;
        synchronized (this.a) {
            i2 = this.a.get(i, -1);
        }
        return i2;
    }

    public aj(com.google.android.libraries.navigation.internal.lc.i iVar) {
        this.a = new SparseIntArray();
        be.j(iVar);
        this.b = iVar;
    }
}
