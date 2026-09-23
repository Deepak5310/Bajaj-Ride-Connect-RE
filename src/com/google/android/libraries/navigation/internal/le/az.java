package com.google.android.libraries.navigation.internal.le;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends aw {
    final /* synthetic */ bb e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(bb bbVar, aq aqVar, com.google.android.libraries.navigation.internal.lc.d[] dVarArr, boolean z, int i) {
        super(aqVar, dVarArr, z, i);
        this.e = bbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.aw
    protected final void b(com.google.android.libraries.navigation.internal.ld.b bVar, com.google.android.libraries.navigation.internal.me.aa aaVar) throws RemoteException {
        this.e.a.a(bVar, aaVar);
    }
}
