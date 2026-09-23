package com.google.android.libraries.navigation.internal.abe;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.z;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable, com.google.android.libraries.navigation.internal.abg.f, g {
    static final long a = TimeUnit.MINUTES.toMillis(5);
    static final long b = TimeUnit.MINUTES.toMillis(1);
    static final long c = TimeUnit.SECONDS.toMillis(10);
    static final long d = TimeUnit.HOURS.toMillis(1);
    static final long e = TimeUnit.SECONDS.toMillis(5);
    public static final /* synthetic */ int k = 0;
    private static final String l = "f";
    public final Context f;
    public final String g;
    public long h;
    public final i i;
    public final h j;
    private final com.google.android.libraries.navigation.internal.abf.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ScheduledExecutorService f111n;
    private Future o;
    private final Random p;
    private int q;
    private a r;
    private final Set s = new HashSet();
    private final Executor t;

    public f(Context context, String str, com.google.android.libraries.navigation.internal.abf.a aVar, Random random, ScheduledExecutorService scheduledExecutorService, i iVar, h hVar, Executor executor) {
        this.f = context;
        this.g = str;
        this.m = aVar;
        this.p = random;
        this.f111n = scheduledExecutorService;
        this.i = iVar;
        this.j = hVar;
        this.t = executor;
    }

    public static boolean g(Context context) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private final void i(long j) {
        Future future = this.o;
        if (future != null) {
            future.cancel(true);
        }
        if (j != 0) {
            this.o = this.f111n.schedule(this, j, TimeUnit.MILLISECONDS);
        } else {
            this.o = null;
            run();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.f
    public final synchronized String a() {
        if (!f()) {
            return null;
        }
        return this.r.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.f
    public final void b(com.google.android.libraries.navigation.internal.abg.e eVar) {
        boolean zIsEmpty;
        if (f()) {
            eVar.a(this);
            return;
        }
        synchronized (this.s) {
            zIsEmpty = this.s.isEmpty();
            this.s.add(eVar);
        }
        if (zIsEmpty) {
            i(0L);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.f
    public final void c() {
        p.f(l, 4);
        synchronized (this) {
            this.r = null;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < this.h + b) {
                return;
            }
            this.h = jCurrentTimeMillis;
            this.i.b();
        }
    }

    public final void d() {
        i(Math.min(d, (long) ((c * Math.pow(1.6d, this.q)) + (this.p.nextDouble() * e))));
        this.q++;
    }

    public final void e(String str, long j, long j2) {
        this.q = 0;
        long j3 = j2 - a;
        if (j3 > 0) {
            p.f(l, 4);
            i(j3);
        }
        synchronized (this) {
            this.r = new a(str, j);
        }
        synchronized (this.s) {
            for (com.google.android.libraries.navigation.internal.abg.e eVar : this.s) {
                if (eVar != null) {
                    eVar.a(this);
                }
            }
            this.s.clear();
        }
    }

    public final synchronized boolean f() {
        return this.r != null;
    }

    @Override // com.google.android.libraries.navigation.internal.abe.g
    public final void h() {
        p.f(l, 6);
        Future future = this.o;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        a aVarA = this.i.a(this.g);
        if (aVarA != null) {
            long j = aVarA.b;
            long jCurrentTimeMillis = j - System.currentTimeMillis();
            if (jCurrentTimeMillis > a) {
                String str = aVarA.a;
                p.f(l, 4);
                e(str, j, jCurrentTimeMillis);
                return;
            }
            p.f(l, 4);
            c();
        }
        if (g(this.f)) {
            this.j.b(this);
        } else {
            p.f(l, 4);
            this.t.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abe.d
                @Override // java.lang.Runnable
                public final void run() {
                    f fVar = this.a;
                    e eVar = new e(fVar);
                    z.a.a();
                    eVar.a = true;
                    fVar.f.registerReceiver(eVar, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                }
            });
        }
    }
}
