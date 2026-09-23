package com.google.android.libraries.navigation.internal.le;

import android.os.DeadObjectException;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l extends q implements m {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected l(com.google.android.libraries.navigation.internal.ld.k kVar, com.google.android.libraries.navigation.internal.ld.s sVar) {
        super(sVar);
        com.google.android.libraries.navigation.internal.lh.be.k(sVar, "GoogleApiClient must not be null");
        com.google.android.libraries.navigation.internal.lh.be.k(kVar, "Api must not be null");
    }

    private final void k(RemoteException remoteException) {
        e(new com.google.android.libraries.navigation.internal.ld.ab(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void b(com.google.android.libraries.navigation.internal.ld.b bVar) throws RemoteException;

    public final void d(com.google.android.libraries.navigation.internal.ld.b bVar) throws DeadObjectException {
        try {
            b(bVar);
        } catch (DeadObjectException e) {
            k(e);
            throw e;
        } catch (RemoteException e2) {
            k(e2);
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        com.google.android.libraries.navigation.internal.lh.be.b(!abVar.b(), "Failed result must not be success");
        i(a(abVar));
    }

    @Override // com.google.android.libraries.navigation.internal.le.m
    public final /* bridge */ /* synthetic */ void f() {
        throw null;
    }
}
