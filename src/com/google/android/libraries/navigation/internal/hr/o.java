package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class o {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hr.o");
    private static final long u = TimeUnit.HOURS.toMillis(6);
    private static final long v = TimeUnit.MINUTES.toMillis(1);
    private final Object A;
    private final com.google.android.libraries.navigation.internal.ip.a B;
    private int C;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final b e;
    public final com.google.android.libraries.navigation.internal.afo.a f;
    public final bn g;
    public final com.google.android.libraries.navigation.internal.mj.a h;
    public final Object i;
    public final com.google.android.libraries.navigation.internal.fz.d j;
    public final Map k;
    public com.google.android.libraries.navigation.internal.hj.i l;
    public Locale m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f446n;
    public long o;
    public final AtomicBoolean p;
    int q;
    public final List r;
    public int s;
    public p t;
    private m w;
    private String x;
    private int y;
    private final boolean z;

    public o(b bVar, an anVar, an anVar2, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.afo.a aVar6, com.google.android.libraries.navigation.internal.ip.a aVar7) {
        ArrayList arrayList = new ArrayList();
        this.i = new Object();
        this.k = new HashMap();
        this.t = null;
        this.l = com.google.android.libraries.navigation.internal.hj.c.b;
        this.m = null;
        this.w = null;
        this.f446n = 0L;
        this.x = "";
        this.y = 0;
        this.o = 0L;
        this.z = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.p = atomicBoolean;
        this.q = 10000;
        this.A = new Object();
        this.C = 0;
        this.s = 1;
        this.r = arrayList;
        this.e = bVar;
        this.f = (com.google.android.libraries.navigation.internal.afo.a) anVar.f();
        this.g = bnVar;
        this.h = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.j = dVar;
        this.d = aVar4;
        this.B = aVar7;
        atomicBoolean.set(false);
        arrayList.add(new e(this, aVar5));
        arrayList.add(new g(this));
        arrayList.add(new i(this, aVar6));
    }

    public final long a(long j, com.google.android.libraries.navigation.internal.mj.a aVar) {
        if (j <= 0) {
            return 0L;
        }
        long jB = b();
        return Math.min(jB, Math.max(0L, jB - (aVar.f().toEpochMilli() - j)));
    }

    final long b() {
        return Math.max(v, Math.min(u, TimeUnit.MINUTES.toMillis(com.google.android.libraries.navigation.internal.fz.b.a(this.j).l)));
    }

    public final void c(long j, com.google.android.libraries.navigation.internal.ir.a aVar) {
        d(j, aVar, null);
    }

    public final void d(long j, com.google.android.libraries.navigation.internal.ir.a aVar, String str) {
        synchronized (this.i) {
            String str2 = aVar.l;
            this.h.f().toEpochMilli();
            m mVar = this.w;
            if (mVar != null) {
                if (am.a(mVar.a, this.l) && this.w.b.equals(this.m) && this.w.e) {
                    return;
                } else {
                    this.w.a();
                }
            }
            m mVar2 = new m(this, this.l, this.m, aVar, str, j == 0);
            this.w = mVar2;
            com.google.android.libraries.navigation.internal.hx.n.a(this.g.schedule(mVar2, j, TimeUnit.MILLISECONDS), this.g);
            if (j == 0 && aVar.equals(com.google.android.libraries.navigation.internal.ir.a.SERVER_RESET_SIGNAL)) {
                ((com.google.android.libraries.navigation.internal.kl.a) this.b.a()).d(com.google.android.libraries.navigation.internal.hw.a.c);
            }
        }
    }

    public final void f(m mVar, com.google.android.libraries.navigation.internal.afl.am amVar, com.google.android.libraries.navigation.internal.gg.o oVar, com.google.android.libraries.navigation.internal.hu.b bVar) {
        synchronized (this.i) {
            if (mVar.f) {
                return;
            }
            ar.a(mVar == this.w);
            this.w = null;
            long jMax = 0;
            if (amVar == null) {
                long jA = a(this.f446n, this.h);
                if (jA <= 0) {
                    jA = 10000;
                    if (!am.a(oVar, com.google.android.libraries.navigation.internal.gg.o.b) && !am.a(oVar, com.google.android.libraries.navigation.internal.gg.o.k)) {
                        int i = this.q;
                        jA = i;
                        this.q = Math.min(1800000, (int) (i * 1.1f));
                    }
                }
                c(jA, com.google.android.libraries.navigation.internal.ir.a.RETRY);
                return;
            }
            long epochMilli = this.h.f().toEpochMilli();
            long jConvert = TimeUnit.MINUTES.convert(epochMilli - this.f446n, TimeUnit.MILLISECONDS);
            if (this.f446n != 0) {
                jMax = Math.max(1L, jConvert);
            }
            ((com.google.android.libraries.navigation.internal.kl.a) this.b.a()).f(com.google.android.libraries.navigation.internal.hw.a.a, jMax);
            this.f446n = epochMilli;
            this.x = mVar.c.l;
            String str = mVar.d;
            if (str != null) {
                this.x = this.x + " from " + str + " thread";
            }
            if ((amVar.b & 4) != 0) {
                this.o = amVar.e;
            }
            c(b(), com.google.android.libraries.navigation.internal.ir.a.REFRESH);
            this.q = 10000;
            int i2 = this.y + 1;
            this.y = i2;
            p pVar = this.t;
            synchronized (this.A) {
                if (i2 <= this.C) {
                    return;
                }
                this.C = i2;
                ar.k(mVar.b != null);
                pVar.a.e(amVar, false, mVar.a, mVar.b, bVar);
            }
        }
    }

    protected final void finalize() {
        Iterator it2 = this.r.iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).c();
        }
    }
}
