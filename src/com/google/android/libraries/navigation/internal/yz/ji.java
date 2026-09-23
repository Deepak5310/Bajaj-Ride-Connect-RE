package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ji extends WeakReference implements jh {
    final ih a;

    public ji(ReferenceQueue referenceQueue, Object obj, ih ihVar) {
        super(obj, referenceQueue);
        this.a = ihVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jh
    public final ih a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jh
    public final jh b(ReferenceQueue referenceQueue, ih ihVar) {
        return new ji(referenceQueue, get(), ihVar);
    }
}
