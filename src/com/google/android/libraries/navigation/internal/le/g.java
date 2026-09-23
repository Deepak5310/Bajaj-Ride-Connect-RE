package com.google.android.libraries.navigation.internal.le;

import android.os.DeadObjectException;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    public final int c;

    public g(int i) {
        this.c = i;
    }

    public static com.google.android.libraries.navigation.internal.ld.ab h(RemoteException remoteException) {
        return new com.google.android.libraries.navigation.internal.ld.ab(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void d(com.google.android.libraries.navigation.internal.ld.ab abVar);

    public abstract void e(Exception exc);

    public abstract void f(ae aeVar) throws DeadObjectException;

    public abstract void g(u uVar, boolean z);
}
