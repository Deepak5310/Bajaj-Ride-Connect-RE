package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends b {
    public final com.google.android.apps.gmm.offline.routing.a c;
    public final q d;
    public final l e;

    public v(com.google.android.apps.gmm.offline.routing.a aVar, int i, q qVar, l lVar, String str) {
        super(aVar, i);
        this.c = aVar;
        this.d = qVar;
        this.e = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fl.b, com.google.android.libraries.navigation.internal.qv.g
    public final cc b(cd cdVar) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void o(com.google.android.libraries.navigation.internal.dm.s sVar, byte[] bArr, com.google.android.libraries.navigation.internal.mj.a aVar) {
        c(new u(this, sVar, bArr, aVar));
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void t() {
        throw new UnsupportedOperationException();
    }
}
