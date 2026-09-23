package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u implements br {
    final /* synthetic */ com.google.android.libraries.navigation.internal.dm.s a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.mj.a c;
    final /* synthetic */ v d;

    public u(v vVar, com.google.android.libraries.navigation.internal.dm.s sVar, byte[] bArr, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = sVar;
        this.b = bArr;
        this.c = aVar;
        this.d = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.dm.s sVar = this.a;
        int i = sVar.b & 256;
        v vVar = this.d;
        int i2 = i != 0 ? sVar.k : vVar.b;
        com.google.android.apps.gmm.offline.routing.a aVar = vVar.c;
        byte[] bArr = this.b;
        com.google.android.libraries.navigation.internal.mj.a aVar2 = this.c;
        long jA = vVar.e.a(an.GMM_ROAD_GRAPH);
        long epochMilli = jA == -1 ? -1L : aVar2.f().plusMillis(jA).toEpochMilli();
        aVar.b(bArr, i2, epochMilli == -1 ? Long.MAX_VALUE : (epochMilli + 999) / 1000);
        this.d.d.a();
        return null;
    }
}
