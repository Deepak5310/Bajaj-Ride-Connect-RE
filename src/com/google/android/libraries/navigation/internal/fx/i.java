package com.google.android.libraries.navigation.internal.fx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.xe.dy;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i implements com.google.android.libraries.navigation.internal.fw.b {
    public static final /* synthetic */ int s = 0;
    public final Context f;
    public final String g;
    public final com.google.android.libraries.navigation.internal.mj.a h;
    public Future i;
    public final Random j;
    public int k;
    public long l;
    public final k m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f434n;
    public final e p;
    public dy q;
    private final bn u;
    private static final com.google.android.libraries.navigation.internal.zb.j t = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fx.i");
    static final long a = TimeUnit.MINUTES.toMillis(5);
    static final long b = TimeUnit.MINUTES.toMillis(1);
    static final long c = TimeUnit.SECONDS.toMillis(10);
    static final long d = TimeUnit.HOURS.toMillis(1);
    static final long e = TimeUnit.SECONDS.toMillis(5);
    private final Set v = new HashSet();
    public short o = 0;
    public final f r = new f(this);
    private final Runnable w = new g(this);

    public i(Context context, String str, com.google.android.libraries.navigation.internal.mj.a aVar, Random random, bn bnVar, k kVar, e eVar) {
        this.f = context;
        this.g = str;
        this.h = aVar;
        this.j = random;
        this.u = bnVar;
        this.m = kVar;
        this.p = eVar;
    }

    public static boolean g(Context context) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.google.android.libraries.navigation.internal.fw.b
    public final synchronized String a() {
        a aVar = this.f434n;
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.b
    public final void b(com.google.android.libraries.navigation.internal.fw.a aVar) {
        boolean zIsEmpty;
        ar.r(aVar, "callback");
        if (f()) {
            aVar.a();
            return;
        }
        synchronized (this.v) {
            zIsEmpty = this.v.isEmpty();
            this.v.add(aVar);
        }
        if (zIsEmpty) {
            d(0L);
        }
    }

    public final synchronized short c() {
        return this.o;
    }

    public final void d(long j) {
        Future future = this.i;
        if (future != null) {
            future.cancel(true);
        }
        if (j != 0) {
            this.i = this.u.schedule(this.w, j, TimeUnit.MILLISECONDS);
        } else {
            this.i = null;
            this.w.run();
        }
    }

    public final void e(String str, long j, long j2) {
        this.k = 0;
        long j3 = j2 - a;
        if (j3 > 0) {
            d(j3);
        }
        synchronized (this) {
            this.f434n = new a(str, j);
        }
        synchronized (this.v) {
            for (com.google.android.libraries.navigation.internal.fw.a aVar : this.v) {
                if (aVar != null) {
                    aVar.a();
                }
            }
            this.v.clear();
        }
    }

    public final synchronized boolean f() {
        return this.f434n != null;
    }

    public final synchronized void h(dy dyVar) {
        this.q = dyVar;
    }
}
