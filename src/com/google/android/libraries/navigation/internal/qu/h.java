package com.google.android.libraries.navigation.internal.qu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.internal.model.cd a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qv.i b;
    final /* synthetic */ k c;

    public h(k kVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar) {
        this.a = cdVar;
        this.b = iVar;
        this.c = kVar;
    }

    public final void a() {
        g gVar = new g(this, this.a, this.b);
        k kVar = this.c;
        kVar.j("ApiTileStore.onFailure", kVar.i, gVar);
    }

    public final void b(byte[] bArr) {
        f fVar = new f(this, this.a, this.b, bArr);
        k kVar = this.c;
        kVar.j("ApiTileStore.onSuccess", kVar.i, fVar);
    }
}
