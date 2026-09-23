package com.google.android.libraries.navigation.internal.xe;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad implements ServiceConnection {
    final /* synthetic */ ae a;

    public ad(ae aeVar) {
        this.a = aeVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.e = new Messenger(iBinder);
        this.a.f = true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.a();
    }
}
