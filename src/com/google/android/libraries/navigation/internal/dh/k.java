package com.google.android.libraries.navigation.internal.dh;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public com.google.android.libraries.navigation.internal.kl.a b;
    private final Executor c;
    private final n d;

    public k(com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, Context context, com.google.android.libraries.navigation.internal.ct.a aVar, BluetoothAdapter bluetoothAdapter) {
        this.a = eVar;
        this.c = executor;
        this.d = new n(new j(this), context, aVar, bluetoothAdapter);
    }

    public final void a(az azVar) {
        n nVar = this.d;
        nVar.d = azVar.a;
        nVar.a();
    }

    public final void b(com.google.android.libraries.navigation.internal.kl.a aVar) {
        com.google.android.libraries.navigation.internal.ra.c.g.f();
        this.b = aVar;
        com.google.android.apps.gmm.location.navigation.ap.a(aVar, 15, true);
        fd fdVarK = fd.k(com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS, this.c);
        fz fzVar = new fz();
        fzVar.b(az.class, new l(az.class, this, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS, l.b(com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS, fdVarK)));
        this.a.c(this, fzVar.a());
        n nVar = this.d;
        nVar.b = true;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            return;
        }
        nVar.a.registerReceiver(nVar.e, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), null, new Handler(looperMyLooper));
        nVar.a();
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.ra.c.g.f();
        this.a.e(this);
        n nVar = this.d;
        nVar.b = false;
        nVar.a.unregisterReceiver(nVar.e);
        nVar.a();
        if (nVar.c) {
            nVar.f.a(21);
        }
        this.b = null;
    }
}
