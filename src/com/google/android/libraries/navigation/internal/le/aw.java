package com.google.android.libraries.navigation.internal.le;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aw {
    public final aq a;
    public final com.google.android.libraries.navigation.internal.lc.d[] b;
    public final boolean c;
    public final int d;

    protected aw(aq aqVar, com.google.android.libraries.navigation.internal.lc.d[] dVarArr, boolean z, int i) {
        this.a = aqVar;
        this.b = dVarArr;
        this.c = z;
        this.d = i;
    }

    public final ao a() {
        return this.a.b;
    }

    protected abstract void b(com.google.android.libraries.navigation.internal.ld.b bVar, com.google.android.libraries.navigation.internal.me.aa aaVar) throws RemoteException;
}
