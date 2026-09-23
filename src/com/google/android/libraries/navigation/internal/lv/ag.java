package com.google.android.libraries.navigation.internal.lv;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag extends com.google.android.libraries.navigation.internal.lu.r {
    public final w a;

    public ag(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lu.s
    public final void e(com.google.android.libraries.navigation.internal.lu.v vVar) throws RemoteException {
        this.a.b().b(new ae(vVar));
    }

    @Override // com.google.android.libraries.navigation.internal.lu.s
    public final void f(com.google.android.libraries.navigation.internal.lu.ab abVar) throws RemoteException {
        this.a.b().b(new ad(abVar));
    }

    @Override // com.google.android.libraries.navigation.internal.lu.s
    public final void g() {
        this.a.b().b(new af(this));
    }
}
