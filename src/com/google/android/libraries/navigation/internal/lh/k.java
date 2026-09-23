package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class k {
    private static final com.google.android.libraries.navigation.internal.lc.d[] s = new com.google.android.libraries.navigation.internal.lc.d[0];
    ai a;
    public final Context b;
    final Handler c;
    public as f;
    protected e g;
    public final int j;
    public volatile String k;
    public volatile com.google.android.libraries.navigation.internal.ln.a l;
    public final z q;
    public final aa r;
    private final ad u;
    private IInterface v;
    private g w;
    private final String x;
    private volatile String t = null;
    public final Object d = new Object();
    public final Object e = new Object();
    public final ArrayList h = new ArrayList();
    public int i = 1;
    public com.google.android.libraries.navigation.internal.lc.a m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f480n = false;
    public volatile r o = null;
    protected final AtomicInteger p = new AtomicInteger(0);

    protected k(Context context, Looper looper, ad adVar, com.google.android.libraries.navigation.internal.lc.i iVar, int i, z zVar, aa aaVar, String str) {
        be.k(context, "Context must not be null");
        this.b = context;
        be.k(looper, "Looper must not be null");
        be.k(adVar, "Supervisor must not be null");
        this.u = adVar;
        be.k(iVar, "API availability must not be null");
        this.c = new c(this, looper);
        this.j = i;
        this.q = zVar;
        this.r = aaVar;
        this.x = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i, IInterface iInterface) {
        ai aiVar;
        be.a((i == 4) == (iInterface != null));
        synchronized (this.d) {
            this.i = i;
            this.v = iInterface;
            Bundle bundle = null;
            if (i == 1) {
                g gVar = this.w;
                if (gVar != null) {
                    ad adVar = this.u;
                    String str = this.a.a;
                    be.j(str);
                    ai aiVar2 = this.a;
                    String str2 = aiVar2.b;
                    int i2 = aiVar2.c;
                    adVar.a(str, str2, ad.a, gVar, v(), this.a.d);
                    this.w = null;
                }
            } else if (i == 2 || i == 3) {
                g gVar2 = this.w;
                if (gVar2 != null && (aiVar = this.a) != null) {
                    String str3 = aiVar.a;
                    ad adVar2 = this.u;
                    be.j(str3);
                    ai aiVar3 = this.a;
                    String str4 = aiVar3.b;
                    int i3 = aiVar3.c;
                    adVar2.a(str3, str4, ad.a, gVar2, v(), this.a.d);
                    this.p.incrementAndGet();
                }
                g gVar3 = new g(this, this.p.get());
                this.w = gVar3;
                ai aiVar4 = new ai("com.google.android.gms", d(), ad.a, z());
                this.a = aiVar4;
                if (aiVar4.d && a() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(aiVar4.a)));
                }
                ad adVar3 = this.u;
                String str5 = aiVar4.a;
                be.j(str5);
                ai aiVar5 = this.a;
                String str6 = aiVar5.b;
                int i4 = aiVar5.c;
                String strV = v();
                boolean z = this.a.d;
                E();
                com.google.android.libraries.navigation.internal.lc.a aVarB = adVar3.b(new ac(str5, str6, ad.a, z), gVar3, strV);
                if (!aVarB.c()) {
                    ai aiVar6 = this.a;
                    String str7 = aiVar6.a;
                    String str8 = aiVar6.b;
                    int i5 = aVarB.c;
                    if (i5 == -1) {
                        i5 = 16;
                    }
                    if (aVarB.d != null) {
                        bundle = new Bundle();
                        bundle.putParcelable(BaseGmsClient.KEY_PENDING_INTENT, aVarB.d);
                    }
                    x(i5, bundle, this.p.get());
                }
            } else if (i == 4) {
                be.j(iInterface);
            }
        }
    }

    public final boolean A() {
        return this.o != null;
    }

    public boolean B() {
        return false;
    }

    public com.google.android.libraries.navigation.internal.lc.d[] C() {
        throw null;
    }

    protected void E() {
        throw null;
    }

    protected void F() {
    }

    public Account I() {
        throw null;
    }

    public com.google.android.libraries.navigation.internal.lc.d[] J() {
        return s;
    }

    public int a() {
        throw null;
    }

    protected abstract IInterface b(IBinder iBinder);

    protected abstract String c();

    protected abstract String d();

    public final String f() {
        return this.t;
    }

    public final void h(e eVar) {
        this.g = eVar;
        H(2, null);
    }

    public void i() {
        this.p.incrementAndGet();
        synchronized (this.h) {
            int size = this.h.size();
            for (int i = 0; i < size; i++) {
                ((d) this.h.get(i)).e();
            }
            this.h.clear();
        }
        synchronized (this.e) {
            this.f = null;
        }
        H(1, null);
    }

    public final void j(String str) {
        this.t = str;
        i();
    }

    public final void k(al alVar, Set set) {
        AttributionSource attributionSource;
        Bundle bundleT = t();
        String attributionTag = (Build.VERSION.SDK_INT < 31 || this.l == null || (attributionSource = this.l.a) == null || attributionSource.getAttributionTag() == null) ? this.k : attributionSource.getAttributionTag();
        String str = attributionTag;
        int i = this.j;
        int i2 = com.google.android.libraries.navigation.internal.lc.i.c;
        com.google.android.libraries.navigation.internal.ld.z[] zVarArr = x.a;
        Bundle bundle = new Bundle();
        com.google.android.libraries.navigation.internal.lc.d[] dVarArr = x.b;
        x xVar = new x(6, i, i2, null, null, zVarArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        xVar.f = this.b.getPackageName();
        xVar.i = bundleT;
        if (set != null) {
            xVar.h = (com.google.android.libraries.navigation.internal.ld.z[]) set.toArray(new com.google.android.libraries.navigation.internal.ld.z[0]);
        }
        if (n()) {
            Account accountI = I();
            if (accountI == null) {
                accountI = new Account("<<default account>>", "com.google");
            }
            xVar.j = accountI;
            if (alVar != null) {
                xVar.g = alVar.asBinder();
            }
        }
        xVar.k = C();
        xVar.l = J();
        if (B()) {
            xVar.o = true;
        }
        try {
            try {
                synchronized (this.e) {
                    as asVar = this.f;
                    if (asVar != null) {
                        asVar.a(new f(this, this.p.get()), xVar);
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                w(8, null, null, this.p.get());
            }
        } catch (DeadObjectException unused2) {
            Handler handler = this.c;
            handler.sendMessage(handler.obtainMessage(6, this.p.get(), 3));
        } catch (SecurityException e) {
            throw e;
        }
    }

    public final boolean l() {
        boolean z;
        synchronized (this.d) {
            z = this.i == 4;
        }
        return z;
    }

    public final boolean m() {
        boolean z;
        synchronized (this.d) {
            int i = this.i;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public boolean n() {
        return false;
    }

    public final com.google.android.libraries.navigation.internal.lc.d[] o() {
        r rVar = this.o;
        if (rVar == null) {
            return null;
        }
        return rVar.b;
    }

    public final void p(com.google.android.libraries.navigation.internal.le.ad adVar) {
        adVar.a.i.p.post(new com.google.android.libraries.navigation.internal.le.ac(adVar));
    }

    public final void q() {
        if (!l() || this.a == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    public final void r() {
    }

    protected Bundle t() {
        return new Bundle();
    }

    public final IInterface u() throws DeadObjectException {
        IInterface iInterface;
        synchronized (this.d) {
            if (this.i == 5) {
                throw new DeadObjectException();
            }
            if (!l()) {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
            iInterface = this.v;
            be.k(iInterface, "Client is connected but service is null");
        }
        return iInterface;
    }

    protected final String v() {
        String str = this.x;
        return str == null ? this.b.getClass().getName() : str;
    }

    protected final void w(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.c.sendMessage(this.c.obtainMessage(1, i2, -1, new i(this, i, iBinder, bundle)));
    }

    protected final void x(int i, Bundle bundle, int i2) {
        this.c.sendMessage(this.c.obtainMessage(7, i2, -1, new j(this, i, bundle)));
    }

    public final boolean y(int i, int i2, IInterface iInterface) {
        synchronized (this.d) {
            if (this.i != i) {
                return false;
            }
            H(i2, iInterface);
            return true;
        }
    }

    protected boolean z() {
        return false;
    }
}
