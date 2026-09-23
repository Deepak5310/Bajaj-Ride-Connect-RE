package com.google.android.libraries.navigation.internal.le;

import android.os.DeadObjectException;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class b extends a {
    protected final com.google.android.libraries.navigation.internal.me.aa a;

    public b(int i, com.google.android.libraries.navigation.internal.me.aa aaVar) {
        super(i);
        this.a = aaVar;
    }

    protected abstract void c(ae aeVar) throws RemoteException;

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void d(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        this.a.c(new com.google.android.libraries.navigation.internal.ld.l(abVar));
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void e(Exception exc) {
        this.a.c(exc);
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public final void f(ae aeVar) throws DeadObjectException {
        try {
            c(aeVar);
        } catch (DeadObjectException e) {
            d(g.h(e));
            throw e;
        } catch (RemoteException e2) {
            d(g.h(e2));
        } catch (RuntimeException e3) {
            e(e3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.le.g
    public void g(u uVar, boolean z) {
    }
}
