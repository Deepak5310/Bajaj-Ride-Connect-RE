package com.google.android.libraries.navigation.internal.qx;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends com.google.android.libraries.navigation.internal.kt.a {
    final /* synthetic */ com.google.android.libraries.navigation.internal.qz.k a;

    public k(com.google.android.libraries.navigation.internal.qz.k kVar) {
        this.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kt.a
    public final void a(Bitmap bitmap) {
        synchronized (this.a) {
            com.google.android.libraries.navigation.internal.qz.k kVar = this.a;
            ar.q(bitmap);
            kVar.l(bitmap);
            this.a.i();
        }
    }
}
