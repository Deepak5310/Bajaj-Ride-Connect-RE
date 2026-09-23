package com.google.android.libraries.navigation.internal.yy;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc extends WeakReference implements ax {
    final bj a;

    public bc(ReferenceQueue referenceQueue, Object obj, bj bjVar) {
        super(obj, referenceQueue);
        this.a = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final int a() {
        return 1;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final ax b(ReferenceQueue referenceQueue, Object obj, bj bjVar) {
        return new bc(referenceQueue, obj, bjVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final bj c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final Object d() {
        return get();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final void e(Object obj) {
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final boolean g() {
        return false;
    }
}
