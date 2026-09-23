package com.google.android.libraries.navigation.internal.lv;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface l extends IInterface {
    void e(ai aiVar, com.google.android.libraries.navigation.internal.lu.z zVar, com.google.android.libraries.navigation.internal.le.al alVar) throws RemoteException;

    void f(PendingIntent pendingIntent) throws RemoteException;

    void g(ai aiVar, com.google.android.libraries.navigation.internal.le.al alVar) throws RemoteException;

    void h(d dVar) throws RemoteException;

    @Deprecated
    void i(am amVar) throws RemoteException;
}
