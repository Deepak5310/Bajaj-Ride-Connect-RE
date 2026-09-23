package com.google.android.libraries.navigation.internal.lh;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae implements ServiceConnection {
    public final Map a = new HashMap();
    public int b = 2;
    public boolean c;
    public IBinder d;
    public final ac e;
    public ComponentName f;
    final /* synthetic */ ag g;

    public ae(ag agVar, ac acVar) {
        this.g = agVar;
        this.e = acVar;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b6 A[Catch: all -> 0x00e6, TryCatch #0 {all -> 0x00e6, blocks: (B:29:0x008c, B:38:0x00ae, B:39:0x00b2, B:41:0x00b6, B:42:0x00cf, B:43:0x00d2, B:44:0x00db, B:32:0x0097, B:33:0x009b), top: B:55:0x008c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf A[Catch: all -> 0x00e6, TRY_LEAVE, TryCatch #0 {all -> 0x00e6, blocks: (B:29:0x008c, B:38:0x00ae, B:39:0x00b2, B:41:0x00b6, B:42:0x00cf, B:43:0x00d2, B:44:0x00db, B:32:0x0097, B:33:0x009b), top: B:55:0x008c }] */
    static /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.lc.a c(ae aeVar) {
        boolean zBindService;
        com.google.android.libraries.navigation.internal.lc.a aVar;
        Bundle bundleCall;
        PendingIntent pendingIntent;
        try {
            ac acVar = aeVar.e;
            Context context = aeVar.g.g;
            Intent intent = null;
            if (acVar.e) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", acVar.b);
                try {
                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(ac.a);
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        throw new RemoteException("Failed to acquire ContentProviderClient");
                    }
                    try {
                        bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle);
                        try {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                        } catch (RemoteException | IllegalArgumentException unused) {
                        }
                        if (bundleCall != null && (intent = (Intent) bundleCall.getParcelable("serviceResponseIntentKey")) == null && (pendingIntent = (PendingIntent) bundleCall.getParcelable("serviceMissingResolutionIntentKey")) != null) {
                            throw new bf(new com.google.android.libraries.navigation.internal.lc.a(25, pendingIntent));
                        }
                    } catch (Throwable th) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        throw th;
                    }
                } catch (RemoteException | IllegalArgumentException unused2) {
                    bundleCall = null;
                }
            }
            if (intent == null) {
                intent = new Intent(acVar.b).setPackage(acVar.c);
            }
            aeVar.b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
            }
            try {
                Context context2 = aeVar.g.g;
                ComponentName component = intent.getComponent();
                if (component != null) {
                    try {
                        zBindService = false;
                        if ((com.google.android.libraries.navigation.internal.ln.d.b(context2).a(component.getPackageName(), 0).flags & 2097152) == 0) {
                        }
                    } catch (PackageManager.NameNotFoundException unused3) {
                    }
                    aeVar.c = zBindService;
                    if (zBindService) {
                        aeVar.g.h.sendMessageDelayed(aeVar.g.h.obtainMessage(1, aeVar.e), aeVar.g.j);
                        aVar = com.google.android.libraries.navigation.internal.lc.a.a;
                    } else {
                        aeVar.b = 2;
                        try {
                            ag agVar = aeVar.g;
                            agVar.i.a(agVar.g, aeVar);
                        } catch (IllegalArgumentException unused4) {
                        }
                        aVar = new com.google.android.libraries.navigation.internal.lc.a(16);
                    }
                    return aVar;
                }
                zBindService = context2.bindService(intent, aeVar, ad.a);
                aeVar.c = zBindService;
                if (zBindService) {
                    aeVar.g.h.sendMessageDelayed(aeVar.g.h.obtainMessage(1, aeVar.e), aeVar.g.j);
                    aVar = com.google.android.libraries.navigation.internal.lc.a.a;
                } else {
                    aeVar.b = 2;
                    ag agVar2 = aeVar.g;
                    agVar2.i.a(agVar2.g, aeVar);
                    aVar = new com.google.android.libraries.navigation.internal.lc.a(16);
                }
                return aVar;
            } finally {
                StrictMode.setVmPolicy(vmPolicy);
            }
        } catch (bf e) {
            return e.a;
        }
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final boolean b() {
        return this.a.isEmpty();
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f) {
            this.g.h.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            Iterator it2 = this.a.values().iterator();
            while (it2.hasNext()) {
                ((ServiceConnection) it2.next()).onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f) {
            this.g.h.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            Iterator it2 = this.a.values().iterator();
            while (it2.hasNext()) {
                ((ServiceConnection) it2.next()).onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
