package com.google.android.libraries.navigation.internal.lh;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements ServiceConnection {
    final /* synthetic */ k a;
    private final int b;

    public g(k kVar, int i) {
        this.a = kVar;
        this.b = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        if (iBinder != null) {
            synchronized (this.a.e) {
                k kVar = this.a;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                kVar.f = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof as)) ? new ar(iBinder) : (as) iInterfaceQueryLocalInterface;
            }
            this.a.x(0, null, this.b);
            return;
        }
        k kVar2 = this.a;
        synchronized (kVar2.d) {
            i = kVar2.i;
        }
        if (i == 3) {
            kVar2.f480n = true;
            i2 = 5;
        } else {
            i2 = 4;
        }
        Handler handler = kVar2.c;
        handler.sendMessage(handler.obtainMessage(i2, kVar2.p.get(), 16));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.e) {
            this.a.f = null;
        }
        k kVar = this.a;
        int i = this.b;
        Handler handler = kVar.c;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
