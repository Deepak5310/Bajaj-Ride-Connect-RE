package com.google.android.libraries.navigation.internal.le;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends b {
    public final ax b;

    public d(ax axVar, com.google.android.libraries.navigation.internal.me.aa aaVar) {
        super(3, aaVar);
        this.b = axVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final boolean a(ae aeVar) {
        return this.b.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final com.google.android.libraries.navigation.internal.lc.d[] b(ae aeVar) {
        return this.b.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.le.b
    public final void c(ae aeVar) throws RemoteException {
        this.b.a.b(aeVar.b, this.a);
        ao aoVarA = this.b.a.a();
        if (aoVarA != null) {
            aeVar.d.put(aoVarA, this.b);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.b, com.google.android.libraries.navigation.internal.le.g
    public final /* bridge */ /* synthetic */ void g(u uVar, boolean z) {
    }
}
