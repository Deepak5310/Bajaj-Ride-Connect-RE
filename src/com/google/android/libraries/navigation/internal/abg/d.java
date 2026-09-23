package com.google.android.libraries.navigation.internal.abg;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d {
    public static final String d = "d";
    public final Context e;
    public final Executor f;
    protected final String h;
    protected final String i;
    public IInterface k;
    public final Queue g = new ArrayDeque();
    public final ServiceConnection j = new a(this);
    public int l = 1;

    public d(Context context, Executor executor) {
        com.google.android.libraries.navigation.internal.abf.s.k(context, "processContext");
        this.e = context;
        this.h = "com.google.android.gms";
        this.i = "com.google.android.gms.maps.auth.ApiTokenService";
        com.google.android.libraries.navigation.internal.abf.s.k(executor, "executor");
        this.f = executor;
    }

    protected abstract IInterface a(IBinder iBinder);

    public final void d() {
        synchronized (this.j) {
            if (this.l != 3) {
                com.google.android.libraries.navigation.internal.abf.p.f(d, 6);
            } else {
                this.l = 1;
                this.e.unbindService(this.j);
            }
        }
    }
}
