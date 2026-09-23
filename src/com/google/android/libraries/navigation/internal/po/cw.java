package com.google.android.libraries.navigation.internal.po;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cw {
    private final SparseArray a = new SparseArray();
    private final SparseIntArray b = new SparseIntArray();

    private final synchronized void e(int i) {
        if (this.b.indexOfKey(i) >= 0) {
            this.a.delete(this.b.get(i));
            this.b.delete(i);
        }
    }

    final synchronized bb a(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        return (bb) this.a.get(System.identityHashCode(efVar));
    }

    final synchronized void b(com.google.android.libraries.navigation.internal.adg.ef efVar, com.google.android.libraries.navigation.internal.adg.ef efVar2) {
        int iIdentityHashCode = System.identityHashCode(efVar);
        int iIdentityHashCode2 = System.identityHashCode(efVar2);
        e(iIdentityHashCode);
        if (this.a.indexOfKey(iIdentityHashCode) >= 0) {
            this.a.put(iIdentityHashCode2, (bb) this.a.get(iIdentityHashCode));
        }
        this.b.put(iIdentityHashCode, iIdentityHashCode2);
    }

    final synchronized void c(com.google.android.libraries.navigation.internal.adg.ef efVar, bb bbVar) {
        this.a.put(System.identityHashCode(efVar), bbVar);
    }

    final synchronized void d(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        int iIdentityHashCode = System.identityHashCode(efVar);
        e(iIdentityHashCode);
        this.a.delete(iIdentityHashCode);
    }
}
