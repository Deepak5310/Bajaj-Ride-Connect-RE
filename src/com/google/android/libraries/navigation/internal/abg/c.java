package com.google.android.libraries.navigation.internal.abg;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements Callable {
    final /* synthetic */ d c;

    public c(d dVar) {
        this.c = dVar;
    }

    public abstract void a(IInterface iInterface) throws RemoteException;

    @Override // java.util.concurrent.Callable
    public final Object call() throws RemoteException {
        IInterface iInterface;
        synchronized (this.c.j) {
            iInterface = this.c.k;
        }
        if (iInterface == null) {
            throw new RemoteException("Service was closed in the middle of the execution.");
        }
        a(iInterface);
        return null;
    }
}
