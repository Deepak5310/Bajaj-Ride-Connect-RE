package com.google.android.libraries.navigation.internal.le;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends b {
    public final ao b;

    public f(ao aoVar, com.google.android.libraries.navigation.internal.me.aa aaVar) {
        super(4, aaVar);
        this.b = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final boolean a(ae aeVar) {
        ax axVar = (ax) aeVar.d.get(this.b);
        return axVar != null && axVar.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.le.a
    public final com.google.android.libraries.navigation.internal.lc.d[] b(ae aeVar) {
        ax axVar = (ax) aeVar.d.get(this.b);
        if (axVar == null) {
            return null;
        }
        return axVar.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.le.b
    public final void c(ae aeVar) throws RemoteException {
        ax axVar = (ax) aeVar.d.remove(this.b);
        if (axVar == null) {
            this.a.a.o(false);
            return;
        }
        ((ba) axVar.b).a.b.a(aeVar.b, this.a);
        axVar.a.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.le.b, com.google.android.libraries.navigation.internal.le.g
    public final /* bridge */ /* synthetic */ void g(u uVar, boolean z) {
    }
}
