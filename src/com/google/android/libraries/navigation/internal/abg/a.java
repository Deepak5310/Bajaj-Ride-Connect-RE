package com.google.android.libraries.navigation.internal.abg;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements ServiceConnection {
    final /* synthetic */ d a;

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.j) {
            com.google.android.libraries.navigation.internal.abf.p.f(d.d, 3);
            d dVar = this.a;
            IInterface iInterfaceA = dVar.a(iBinder);
            com.google.android.libraries.navigation.internal.abf.s.j(iInterfaceA);
            dVar.k = iInterfaceA;
            this.a.l = 3;
            while (!this.a.g.isEmpty()) {
                d dVar2 = this.a;
                dVar2.f.execute((Runnable) dVar2.g.poll());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.j) {
            com.google.android.libraries.navigation.internal.abf.p.f(d.d, 3);
            d dVar = this.a;
            dVar.k = null;
            dVar.l = 2;
        }
    }
}
