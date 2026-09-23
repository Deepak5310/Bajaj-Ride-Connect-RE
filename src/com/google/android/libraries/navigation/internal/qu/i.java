package com.google.android.libraries.navigation.internal.qu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements Runnable {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.internal.model.cd a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qv.i b;
    final /* synthetic */ k c;

    public i(k kVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar) {
        this.a = cdVar;
        this.b = iVar;
        this.c = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f(this.a, this.b, com.google.android.libraries.navigation.internal.qv.h.NETWORK_ERROR, null);
    }
}
