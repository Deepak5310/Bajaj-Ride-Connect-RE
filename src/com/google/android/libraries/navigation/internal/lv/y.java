package com.google.android.libraries.navigation.internal.lv;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.le.bk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y extends i {
    final /* synthetic */ com.google.android.libraries.navigation.internal.me.aa a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.lu.s b;

    public y(com.google.android.libraries.navigation.internal.me.aa aaVar, com.google.android.libraries.navigation.internal.lu.s sVar) {
        this.a = aaVar;
        this.b = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lv.j
    public final void e(f fVar) {
        bk.a(fVar.a, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.lv.j
    public final void f() throws RemoteException {
        this.b.g();
    }
}
