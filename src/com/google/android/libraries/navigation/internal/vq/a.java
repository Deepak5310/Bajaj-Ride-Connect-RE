package com.google.android.libraries.navigation.internal.vq;

import com.google.android.libraries.navigation.internal.aac.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.vp.a a;

    public a(com.google.android.libraries.navigation.internal.vp.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        throw new IllegalStateException(th.getMessage());
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void b(Object obj) {
        this.a.a(obj);
    }
}
