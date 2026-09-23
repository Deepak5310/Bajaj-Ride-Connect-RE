package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ic extends WeakReference implements ih {
    final int a;

    public ic(ReferenceQueue referenceQueue, Object obj, int i) {
        super(obj, referenceQueue);
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ih
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ih
    public ih b() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ih
    public final Object c() {
        return get();
    }
}
