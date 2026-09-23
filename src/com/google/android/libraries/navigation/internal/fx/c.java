package com.google.android.libraries.navigation.internal.fx;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements ServiceConnection {
    final /* synthetic */ e a;
    final /* synthetic */ f b;

    public c(e eVar, f fVar) {
        this.b = fVar;
        this.a = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.libraries.navigation.internal.lx.b aVar;
        if (iBinder == null) {
            aVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.auth.IApiTokenService");
            aVar = iInterfaceQueryLocalInterface instanceof com.google.android.libraries.navigation.internal.lx.b ? (com.google.android.libraries.navigation.internal.lx.b) iInterfaceQueryLocalInterface : new com.google.android.libraries.navigation.internal.lx.a(iBinder);
        }
        this.a.c.execute(new b(this, aVar, this.b, this));
    }
}
