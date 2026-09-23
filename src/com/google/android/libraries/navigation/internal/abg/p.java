package com.google.android.libraries.navigation.internal.abg;

import android.content.SharedPreferences;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.BuildConfig;
import com.google.android.libraries.navigation.internal.abh.ba;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.afl.ao;
import com.google.android.libraries.navigation.internal.afl.ar;
import com.google.android.libraries.navigation.internal.afl.at;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.zr.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements q, e {
    public static final String a = "p";
    private static final long f = TimeUnit.SECONDS.toMillis(15);
    private static final long g = TimeUnit.SECONDS.toMillis(2);
    private static final long h = TimeUnit.SECONDS.toMillis(30);
    private boolean C;
    private int D;
    private final com.google.android.libraries.navigation.internal.wx.c E;
    public final m b;
    public final CopyOnWriteArrayList d;
    public final SharedPreferences e;
    private final Random i;
    private final String j;
    private final String k;
    private final String l;
    private final br m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final f f112n;
    private final com.google.android.libraries.navigation.internal.wc.b o;
    private final com.google.android.libraries.navigation.internal.b.w p;
    private final ThreadFactory q;
    private final com.google.android.libraries.navigation.internal.abf.a r;
    private ar s;
    private final ArrayList t;
    private boolean u;
    private boolean v;
    private ArrayList w;
    private boolean x;
    private boolean y;
    private long z;
    public Long c = null;
    private long A = Long.MIN_VALUE;
    private volatile int B = 0;

    public p(String str, String str2, br brVar, ar arVar, SharedPreferences sharedPreferences, com.google.android.libraries.navigation.internal.b.w wVar, f fVar, com.google.android.libraries.navigation.internal.abf.a aVar, Random random, ThreadFactory threadFactory, com.google.android.libraries.navigation.internal.wc.b bVar, com.google.android.libraries.navigation.internal.wx.c cVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, "serverAddress");
        this.j = str;
        com.google.android.libraries.navigation.internal.abf.s.k(str2, "platformID");
        this.k = str2;
        this.l = BuildConfig.VERSION_NAME;
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "distributionChannelSupplier");
        this.m = brVar;
        com.google.android.libraries.navigation.internal.abf.s.k(arVar, "ClientPropertiesRequestProto");
        this.s = arVar;
        com.google.android.libraries.navigation.internal.abf.s.k(sharedPreferences, "SharedPreferences");
        this.e = sharedPreferences;
        com.google.android.libraries.navigation.internal.abf.s.k(wVar, "RequestQueue");
        this.p = wVar;
        this.f112n = fVar;
        this.r = aVar;
        this.i = random;
        this.q = threadFactory;
        this.o = bVar;
        this.E = cVar;
        synchronized (this) {
            this.d = new CopyOnWriteArrayList();
            this.t = new ArrayList();
            this.w = new ArrayList();
            this.x = false;
            this.u = false;
            this.v = true;
            this.z = 0L;
            this.y = false;
            this.C = false;
            this.D = -1;
            this.b = new m(this);
        }
    }

    private final synchronized void B() {
        this.A = Long.MIN_VALUE;
        this.y = false;
        this.z = 0L;
        this.D = -1;
    }

    private static void C(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        StrictMode.ThreadPolicy threadPolicyB = com.google.android.libraries.navigation.internal.abf.w.a.b();
        try {
            editorEdit.commit();
        } finally {
            com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
        }
    }

    private static void D(ds dsVar) {
        if (com.google.android.libraries.navigation.internal.abf.p.f(a, 3)) {
            Base64.encodeToString(dsVar.m(), 2);
        }
    }

    public final synchronized void A(int i) {
        boolean z;
        com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        synchronized (this) {
            this.D = i;
            z = false;
            if (i == 4) {
                long j = this.z;
                if (j == 0 || this.y) {
                    B();
                    this.D = 4;
                    this.z = 200L;
                } else if (j < h) {
                    this.z = j + j;
                }
            } else if (this.y) {
                long j2 = this.z;
                long j3 = g;
                if (j2 >= j3) {
                    j3 = (j2 * 5) / 4;
                }
                this.z = j3;
                long j4 = h;
                if (j3 > j4) {
                    this.z = j4;
                }
            } else {
                this.z = 200L;
                long j5 = this.A;
                if (j5 == Long.MIN_VALUE) {
                    this.A = SystemClock.elapsedRealtime();
                } else if (j5 + f < SystemClock.elapsedRealtime()) {
                    z = true;
                }
            }
        }
        if (z) {
            n(i);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.e
    public final void a(f fVar) {
        String strA = fVar.a();
        synchronized (this) {
            ar arVar = this.s;
            bb bbVar = (bb) arVar.aH(5, null);
            bbVar.x(arVar);
            ao aoVar = (ao) bbVar;
            if (strA != null) {
                if (!aoVar.b.H()) {
                    aoVar.v();
                }
                ar arVar2 = (ar) aoVar.b;
                ar arVar3 = ar.a;
                arVar2.c |= 32;
                arVar2.u = strA;
            } else {
                if (!aoVar.b.H()) {
                    aoVar.v();
                }
                ar arVar4 = (ar) aoVar.b;
                ar arVar5 = ar.a;
                arVar4.c &= -33;
                arVar4.u = ar.a.u;
            }
            this.s = (ar) aoVar.t();
        }
        g();
    }

    public final synchronized long b() {
        Long l = this.c;
        if (l != null) {
            return l.longValue();
        }
        long j = this.e.getLong("SessionID", 0L);
        if (j == 0) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
            j(new w(this));
        } else {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        }
        Long lValueOf = Long.valueOf(j);
        this.c = lValueOf;
        return lValueOf.longValue();
    }

    public final synchronized long c() {
        if (this.D != 4) {
            return this.z;
        }
        return this.z + 800 + (this.i.nextLong() % this.z);
    }

    public final synchronized ar d() {
        return this.s;
    }

    public final synchronized String e() {
        ar arVar = this.s;
        if ((arVar.c & 64) == 0) {
            return null;
        }
        return arVar.v;
    }

    public final synchronized String f() {
        ar arVar = this.s;
        if ((arVar.b & 1024) == 0) {
            return null;
        }
        return arVar.h;
    }

    public final void g() {
        s sVar;
        if (w()) {
            synchronized (this) {
                sVar = null;
                if (!this.w.isEmpty() && this.x) {
                    ArrayList arrayList = this.w;
                    this.w = new ArrayList();
                    this.x = false;
                    String strA = this.f112n.a();
                    if (strA != null) {
                        synchronized (this) {
                            ar arVar = this.s;
                            if (!com.google.android.libraries.navigation.internal.abf.r.a((arVar.c & 32) != 0 ? arVar.u : null, strA)) {
                                ar arVar2 = this.s;
                                bb bbVar = (bb) arVar2.aH(5, null);
                                bbVar.x(arVar2);
                                ao aoVar = (ao) bbVar;
                                if (!aoVar.b.H()) {
                                    aoVar.v();
                                }
                                ar arVar3 = (ar) aoVar.b;
                                arVar3.c |= 32;
                                arVar3.u = strA;
                                this.s = (ar) aoVar.t();
                            }
                        }
                    }
                    sVar = new s(this, arrayList, com.google.android.libraries.navigation.internal.abf.e.k, this.f112n, this.p, this.r, this.j, this.k, this.l, this.m, this.q);
                }
            }
            if (sVar != null) {
                sVar.b.l();
                sVar.e.newThread(sVar).start();
            }
        }
    }

    public final void h() {
        if (x()) {
            g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.q
    public final synchronized void i(g gVar) {
        if (this.t.contains(gVar)) {
            return;
        }
        this.t.add(gVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.q
    public final void j(n nVar) {
        nVar.d();
        if (com.google.android.libraries.navigation.internal.abf.p.f(a, 3)) {
            nVar.h();
        }
        synchronized (this) {
            if (nVar.e()) {
                this.x = true;
            }
            this.w.add(nVar);
        }
        if (nVar.e()) {
            g();
        }
    }

    public final synchronized void k() {
        this.B--;
    }

    public final synchronized void l() {
        this.B++;
    }

    public final synchronized void m() {
        if (this.o == null) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
            return;
        }
        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        String string = this.e.getString("ServerVersionMetadata", null);
        if (string != null) {
            byte[] bArrDecode = Base64.decode(string, 0);
            try {
                bi biVarV = bi.v(ds.a, bArrDecode, 0, bArrDecode.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                bi.I(biVarV);
                ds dsVar = (ds) biVarV;
                this.o.a = dsVar;
                D(dsVar);
            } catch (cc e) {
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 3)) {
                    e.getMessage();
                }
            }
        }
    }

    public final void n(int i) {
        boolean z;
        synchronized (this) {
            if (this.y) {
                z = false;
            } else {
                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                z = true;
                this.y = true;
                this.A = Long.MIN_VALUE;
            }
        }
        if (z) {
            for (ba baVar : this.d) {
            }
        }
    }

    public final synchronized void p(at atVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(atVar, "ClientPropertiesResponseProto");
        com.google.android.libraries.navigation.internal.wc.b bVar = this.o;
        if (bVar == null || (atVar.b & 128) == 0) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        } else {
            ds dsVar = atVar.i;
            if (dsVar == null) {
                dsVar = ds.a;
            }
            bVar.b(dsVar);
            com.google.android.libraries.navigation.internal.wc.b bVar2 = this.o;
            if (bVar2 != null) {
                C(this.e, "ServerVersionMetadata", Base64.encodeToString(bVar2.b.m(), 0));
                D(this.o.b);
            }
            ds dsVar2 = atVar.i;
            if (dsVar2 == null) {
                dsVar2 = ds.a;
            }
            D(dsVar2);
        }
        int i = atVar.b;
        String str = (i & 1) != 0 ? atVar.c : null;
        String str2 = (i & 2) != 0 ? atVar.d : null;
        String str3 = (i & 8) != 0 ? atVar.e : null;
        if (str == null && str2 == null && str3 == null) {
            return;
        }
        ar arVar = this.s;
        bb bbVar = (bb) arVar.aH(5, null);
        bbVar.x(arVar);
        ao aoVar = (ao) bbVar;
        if (str != null) {
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar2 = (ar) aoVar.b;
            ar arVar3 = ar.a;
            arVar2.b |= 1;
            arVar2.e = str;
            C(this.e, "Cohort", str);
        }
        if (str2 != null) {
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar4 = (ar) aoVar.b;
            ar arVar5 = ar.a;
            arVar4.b |= 4;
            arVar4.f = str2;
            C(this.e, "LegalCountry", str2);
        }
        if (str3 != null) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar6 = (ar) aoVar.b;
            ar arVar7 = ar.a;
            arVar6.b |= 4096;
            arVar6.j = str3;
            if (com.google.android.libraries.navigation.internal.afu.d.l()) {
                this.E.b(str3);
            } else {
                C(this.e, "ZwiebackNid", str3);
            }
        }
        this.s = (ar) aoVar.t();
    }

    public final synchronized void q() {
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((g) arrayList.get(i)).a();
        }
    }

    public final synchronized void r() {
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((g) arrayList.get(i)).b();
        }
    }

    public final void s(n nVar) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((ba) it2.next()).b(nVar);
        }
    }

    public final synchronized void t() {
        this.C = true;
        B();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.q
    public final void u() {
        synchronized (this) {
            this.u = true;
        }
        h();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.q
    public final synchronized void v() {
        this.u = false;
    }

    public final synchronized boolean w() {
        boolean z = false;
        if (y() && this.B < 10) {
            if (this.C) {
                z = true;
            } else if (this.B == 0) {
                return true;
            }
        }
        return z;
    }

    public final synchronized boolean x() {
        return this.x;
    }

    public final synchronized boolean y() {
        return this.u;
    }

    public final synchronized boolean z() {
        return this.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void o() {
        String string;
        String string2 = (this.s.b & 1) != 0 ? null : this.e.getString("Cohort", null);
        String string3 = (this.s.b & 4) != 0 ? null : this.e.getString("LegalCountry", null);
        if ((this.s.b & 4096) != 0) {
            string = null;
        } else if (com.google.android.libraries.navigation.internal.afu.d.l()) {
            try {
                string = (String) this.E.a().get();
            } catch (InterruptedException | ExecutionException e) {
                if (com.google.android.libraries.navigation.internal.abf.p.f(a, 6)) {
                    e.getMessage();
                }
                string = null;
            }
        } else {
            string = this.e.getString("ZwiebackNid", null);
        }
        if (string2 == null && string3 == null && string == null) {
            return;
        }
        ar arVar = this.s;
        bb bbVar = (bb) arVar.aH(5, null);
        bbVar.x(arVar);
        ao aoVar = (ao) bbVar;
        if (string2 != null) {
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar2 = (ar) aoVar.b;
            arVar2.b |= 1;
            arVar2.e = string2;
        }
        if (string3 != null) {
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar3 = (ar) aoVar.b;
            arVar3.b |= 4;
            arVar3.f = string3;
        }
        if (!aq.c(string)) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar4 = (ar) aoVar.b;
            string.getClass();
            arVar4.b |= 4096;
            arVar4.j = string;
        }
        this.s = (ar) aoVar.t();
    }
}
