package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.ge;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cn {
    public final com.google.android.libraries.navigation.internal.kl.b a;
    private final boolean j;
    public final com.google.android.libraries.navigation.internal.fq.o b = new cm();
    public final List c = new ArrayList();
    public final Set d = mp.i();
    public final com.google.android.libraries.navigation.internal.agg.be e = new com.google.android.libraries.navigation.internal.agg.be();
    public final Map f = new HashMap();
    public final Map g = new HashMap();
    private int k = 1;
    public final AtomicInteger h = new AtomicInteger();
    public com.google.android.libraries.navigation.internal.qa.a i = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);

    public cn(boolean z, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.j = z;
        this.a = bVar;
    }

    public static com.google.android.libraries.navigation.internal.o.c a(com.google.android.libraries.navigation.internal.qa.a aVar) {
        return new com.google.android.libraries.navigation.internal.o.a((int) aVar.a, (int) aVar.b, (int) aVar.c, (int) aVar.d);
    }

    private final int i() {
        int i = this.k;
        if (i == 0) {
            i = 1;
        }
        this.k = i + 1;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:22:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00de A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:57:0x0110 A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0116 A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0119 A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:62:0x011f A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0122 A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:66:0x012a A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0142 A[Catch: all -> 0x0143, TryCatch #0 {, blocks: (B:48:0x00cb, B:50:0x00de, B:52:0x00f3, B:54:0x0107, B:56:0x010d, B:64:0x0124, B:66:0x012a, B:67:0x0140, B:69:0x0142, B:57:0x0110, B:59:0x0116, B:60:0x0119, B:62:0x011f, B:63:0x0122), top: B:73:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final com.google.android.libraries.navigation.internal.yx.an b(ai aiVar) {
        com.google.android.libraries.navigation.internal.adg.bc bcVar;
        com.google.android.libraries.navigation.internal.ol.c cVar;
        int i;
        ek ekVarA;
        com.google.android.libraries.navigation.internal.oe.q qVar;
        List list;
        cl clVar;
        int i2;
        com.google.android.libraries.navigation.internal.qa.b bVarG;
        com.google.android.libraries.navigation.internal.qa.b bVarH;
        com.google.android.libraries.navigation.internal.o.c cVarA;
        com.google.android.libraries.navigation.internal.o.c cVarA2;
        com.google.android.libraries.navigation.internal.adg.ef efVarA;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2;
        Object objK;
        Object objC;
        com.google.android.libraries.navigation.internal.ra.c.e.f();
        com.google.android.libraries.navigation.internal.adg.ef efVarA2 = aiVar.a();
        if (efVarA2 == null) {
            if (aiVar.a() != null) {
                efVarA = aiVar.a();
                bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ae);
                efVarA.h(bhVarS);
                if (efVarA.w.n(bhVarS.d)) {
                    bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ae);
                    efVarA.h(bhVarS2);
                    objK = efVarA.w.k(bhVarS2.d);
                    if (objK == null) {
                        objC = bhVarS2.b;
                    } else {
                        objC = bhVarS2.c(objK);
                    }
                    bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
                } else {
                    bcVar = null;
                }
            } else {
                bcVar = null;
            }
            if (!aiVar.r() || ((b) aiVar.A()).k != null || bcVar != null) {
                if (this.j) {
                    com.google.android.libraries.navigation.internal.o.c cVarA3 = a(aiVar.f().i);
                    bVarG = aiVar.g();
                    bVarH = aiVar.h();
                    if (bVarG != null || aiVar.H()) {
                        cVarA = null;
                    } else {
                        cVarA = a(bVarG.i);
                    }
                    if (bVarH != null || aiVar.I()) {
                        cVarA2 = null;
                    } else {
                        cVarA2 = a(bVarH.i);
                    }
                    cVar = new com.google.android.libraries.navigation.internal.ol.c(cVarA3, com.google.android.libraries.navigation.internal.yx.an.i(cVarA), com.google.android.libraries.navigation.internal.yx.an.i(cVarA2));
                } else {
                    cVar = null;
                }
                synchronized (this.c) {
                    i = i();
                    ekVarA = aiVar.A();
                    if (((b) ekVarA).f.h()) {
                        com.google.android.libraries.geo.mapcore.internal.model.c cVar2 = ((m) ((b) ekVarA).f).a;
                        com.google.android.libraries.navigation.internal.yx.ar.q(cVar2);
                        qVar = new com.google.android.libraries.navigation.internal.oe.q(cVar2.a);
                    } else {
                        qVar = null;
                    }
                    list = this.c;
                    clVar = (cl) this.b.c();
                    int iZ = aiVar.z();
                    if (!aiVar.I() && aiVar.H()) {
                        i2 = cj.d;
                    } else if (aiVar.H()) {
                        i2 = cj.b;
                    } else if (aiVar.I()) {
                        i2 = cj.c;
                    } else {
                        i2 = cj.a;
                    }
                    clVar.a = iZ;
                    clVar.b = ekVarA;
                    if (i2 != 0) {
                        throw null;
                    }
                    clVar.g = i2;
                    clVar.c = i;
                    clVar.e = qVar;
                    clVar.d = bcVar;
                    clVar.f = cVar;
                    list.add(clVar);
                    com.google.android.libraries.navigation.internal.yx.an anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(new p(i));
                }
                return anVarJ;
            }
        } else {
            fs fsVar = efVarA2.u;
            if (fsVar == null) {
                fsVar = fs.a;
            }
            com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(fu.u);
            fsVar.h(bhVarS3);
            Object objK2 = fsVar.w.k(bhVarS3.d);
            if (!((ge) (objK2 == null ? bhVarS3.b : bhVarS3.c(objK2))).b) {
                if (aiVar.a() != null) {
                    efVarA = aiVar.a();
                    bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ae);
                    efVarA.h(bhVarS);
                    if (efVarA.w.n(bhVarS.d)) {
                        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ae);
                        efVarA.h(bhVarS2);
                        objK = efVarA.w.k(bhVarS2.d);
                        if (objK == null) {
                            objC = bhVarS2.b;
                        } else {
                            objC = bhVarS2.c(objK);
                        }
                        bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
                    } else {
                        bcVar = null;
                    }
                } else {
                    bcVar = null;
                }
                if (!aiVar.r()) {
                }
                if (this.j) {
                    com.google.android.libraries.navigation.internal.o.c cVarA4 = a(aiVar.f().i);
                    bVarG = aiVar.g();
                    bVarH = aiVar.h();
                    if (bVarG != null) {
                        cVarA = null;
                    } else {
                        cVarA = null;
                    }
                    if (bVarH != null) {
                        cVarA2 = null;
                    } else {
                        cVarA2 = null;
                    }
                    cVar = new com.google.android.libraries.navigation.internal.ol.c(cVarA4, com.google.android.libraries.navigation.internal.yx.an.i(cVarA), com.google.android.libraries.navigation.internal.yx.an.i(cVarA2));
                } else {
                    cVar = null;
                }
                synchronized (this.c) {
                    i = i();
                    ekVarA = aiVar.A();
                    if (((b) ekVarA).f.h()) {
                        com.google.android.libraries.geo.mapcore.internal.model.c cVar3 = ((m) ((b) ekVarA).f).a;
                        com.google.android.libraries.navigation.internal.yx.ar.q(cVar3);
                        qVar = new com.google.android.libraries.navigation.internal.oe.q(cVar3.a);
                    } else {
                        qVar = null;
                    }
                    list = this.c;
                    clVar = (cl) this.b.c();
                    int iZ2 = aiVar.z();
                    if (!aiVar.I()) {
                        if (aiVar.H()) {
                            i2 = cj.b;
                        } else if (aiVar.I()) {
                            i2 = cj.c;
                        } else {
                            i2 = cj.a;
                        }
                    } else if (aiVar.H()) {
                        i2 = cj.b;
                    } else if (aiVar.I()) {
                        i2 = cj.c;
                    } else {
                        i2 = cj.a;
                    }
                    clVar.a = iZ2;
                    clVar.b = ekVarA;
                    if (i2 != 0) {
                        throw null;
                    }
                    clVar.g = i2;
                    clVar.c = i;
                    clVar.e = qVar;
                    clVar.d = bcVar;
                    clVar.f = cVar;
                    list.add(clVar);
                    com.google.android.libraries.navigation.internal.yx.an anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(new p(i));
                    return anVarJ2;
                }
            }
        }
        return com.google.android.libraries.navigation.internal.yx.a.a;
    }

    final void c() {
        synchronized (this.c) {
            for (cl clVar : this.c) {
                clVar.b();
                this.b.g(clVar);
            }
            this.c.clear();
        }
        synchronized (this) {
            this.e.clear();
            this.f.clear();
            this.g.clear();
        }
    }

    final void d(cl clVar) {
        if (this.g.containsKey(Integer.valueOf(clVar.a))) {
            return;
        }
        Map map = this.g;
        Integer numValueOf = Integer.valueOf(clVar.a);
        com.google.android.libraries.navigation.internal.adg.bc bcVar = clVar.d;
        com.google.android.libraries.navigation.internal.yx.ar.q(bcVar);
        map.put(numValueOf, bcVar);
    }

    final void e(int i) {
        synchronized (this.c) {
            List list = this.c;
            cl clVar = (cl) this.b.c();
            clVar.a = i;
            clVar.c = -559038737;
            clVar.b = null;
            clVar.g = 7;
            clVar.e = null;
            clVar.d = null;
            clVar.f = null;
            list.add(clVar);
        }
    }

    final synchronized void f() {
        this.f.clear();
    }

    final synchronized boolean g(int i) {
        return this.e.c(i) || this.g.containsKey(Integer.valueOf(i));
    }

    final void h(ek ekVar, int i) {
        fs fsVar = ekVar.o().u;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(fu.u);
        fsVar.h(bhVarS);
        Object objK = fsVar.w.k(bhVarS.d);
        if (((ge) (objK == null ? bhVarS.b : bhVarS.c(objK))).b || ekVar.t() == null) {
            return;
        }
        synchronized (this.c) {
            int i2 = i();
            List list = this.c;
            cl clVar = (cl) this.b.c();
            clVar.a = -559038737;
            clVar.b = ekVar;
            if (i == 0) {
                throw null;
            }
            clVar.g = i;
            clVar.c = i2;
            clVar.e = null;
            clVar.d = null;
            clVar.f = null;
            list.add(clVar);
        }
    }
}
