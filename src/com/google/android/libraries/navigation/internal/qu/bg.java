package com.google.android.libraries.navigation.internal.qu;

import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.yz.ho;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg implements cb {
    private static final com.google.android.libraries.navigation.internal.zb.j k = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.bg");
    private final com.google.android.libraries.navigation.internal.pm.d A;
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.aac.bn b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public final ho d;
    public final ho e;
    public final pw f;
    public final Map g;
    final bc h;
    public final bf i;
    public final AtomicBoolean j;
    private final com.google.android.libraries.navigation.internal.afo.a l;
    private final com.google.android.libraries.navigation.internal.afo.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.om.p f562n;
    private boolean o;
    private boolean p;
    private final int q;
    private final com.google.android.libraries.navigation.internal.fq.k r;
    private final com.google.android.libraries.navigation.internal.fq.k s;
    private final com.google.android.libraries.navigation.internal.fq.k t;
    private final Object u;
    private final Object v;
    private final com.google.android.libraries.navigation.internal.yx.br w;
    private int x;
    private volatile com.google.android.libraries.navigation.internal.adi.d y;
    private final com.google.android.libraries.navigation.internal.aac.bn z;

    public bg(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.aac.bn bnVar2, com.google.android.libraries.navigation.internal.afo.a aVar5, pw pwVar, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.pm.d dVar) {
        com.google.android.libraries.navigation.internal.fq.k kVar = new com.google.android.libraries.navigation.internal.fq.k(pwVar.d);
        this.d = new com.google.android.libraries.navigation.internal.yz.aw();
        this.e = new com.google.android.libraries.navigation.internal.yz.aw();
        this.o = false;
        this.p = true;
        this.u = new Object();
        this.v = new Object();
        this.g = new HashMap();
        this.x = 0;
        this.i = new bf();
        this.j = new AtomicBoolean(false);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlobalStyleTablesFetcher");
        try {
            this.h = new bc(this, aVar5);
            this.c = aVar;
            this.l = aVar2;
            this.m = aVar3;
            this.a = aVar4;
            this.b = bnVar;
            this.z = bnVar2;
            int i = pwVar.d;
            this.q = i;
            this.r = new com.google.android.libraries.navigation.internal.fq.k(i);
            this.s = new com.google.android.libraries.navigation.internal.fq.k(i + i);
            this.t = kVar;
            this.f = pwVar;
            this.w = brVar;
            this.A = dVar;
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static com.google.android.libraries.navigation.internal.xn.a s() {
        return com.google.android.libraries.navigation.internal.xn.a.d("");
    }

    static final boolean u(com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, String str, Map map) {
        return !Objects.equals(str, "") && map != null && map.containsKey(str) && ((Map) map.get(str)).containsKey(aqVar);
    }

    private final com.google.android.libraries.geo.mapcore.internal.model.bd w(String str) {
        try {
            com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
            if (cVarA != null) {
                return cVarA.a(str, false);
            }
        } catch (IOException | OutOfMemoryError unused) {
        }
        return null;
    }

    private final com.google.android.libraries.geo.mapcore.internal.model.bv x(String str) {
        try {
            com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
            if (cVarA != null) {
                return cVarA.b(str);
            }
        } catch (IOException | OutOfMemoryError unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    private final void y(int i, com.google.android.libraries.navigation.internal.adi.c cVar, final bj bjVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, String str, String str2) {
        boolean z = aqVar.F;
        com.google.android.libraries.navigation.internal.om.p pVar = this.f562n;
        if (pVar != null && ((com.google.android.libraries.navigation.internal.om.d) pVar.b()).e) {
            if (z) {
                z = true;
            } else {
                com.google.android.libraries.navigation.internal.om.p pVar2 = this.f562n;
                com.google.android.libraries.navigation.internal.yx.ar.q(pVar2);
                if (pVar2.d().c.contains(aqVar.E)) {
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (!z || p(str, i, aqVar)) {
            return;
        }
        com.google.android.libraries.navigation.internal.xn.a aVarA = com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTables.prefetchNextMissingStyleTable"), s());
        final bx bxVar = new bx(i, aqVar, str, cVar, str2);
        com.google.android.libraries.navigation.internal.qz.l lVar = (com.google.android.libraries.navigation.internal.qz.l) com.google.android.libraries.navigation.internal.qz.m.a.q();
        if (u(aqVar, str2, bjVar.g)) {
            if (!lVar.b.H()) {
                lVar.v();
            }
            com.google.android.libraries.navigation.internal.qz.m.b((com.google.android.libraries.navigation.internal.qz.m) lVar.b);
        }
        e(bxVar.d, aVarA, new bb(this, str, new be() { // from class: com.google.android.libraries.navigation.internal.qu.ak
            @Override // com.google.android.libraries.navigation.internal.qu.be
            public final void a(byte[] bArr) {
                this.a.l(bxVar, bArr, bjVar);
            }
        }, new bd() { // from class: com.google.android.libraries.navigation.internal.qu.al
            @Override // com.google.android.libraries.navigation.internal.qu.bd
            public final void a(String str3) {
                this.a.i(bxVar, bjVar, null, str3);
            }
        }, (com.google.android.libraries.navigation.internal.qz.m) lVar.t()), false, (com.google.android.libraries.navigation.internal.qz.m) lVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final com.google.android.libraries.navigation.internal.adi.d a(int i) {
        com.google.android.libraries.navigation.internal.adi.d dVar;
        com.google.android.libraries.navigation.internal.adi.d dVar2 = this.y;
        if (dVar2 != null && dVar2.b == i) {
            return dVar2;
        }
        try {
            com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
            if (cVarA != null) {
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.getEpochResources");
                try {
                    com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                    String strB = com.google.android.libraries.navigation.internal.b.b.b(i, "ER");
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    iVar.b |= 2;
                    iVar.d = strB;
                    int i2 = com.google.android.libraries.navigation.internal.dm.m.e;
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    if (i2 == 0) {
                        throw null;
                    }
                    iVar2.c = i2;
                    iVar2.b |= 1;
                    com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
                    try {
                        com.google.android.libraries.navigation.internal.dm.g gVarB = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).c.b(iVar3);
                        if (gVarB == null) {
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            dVar = null;
                        } else {
                            try {
                                com.google.android.libraries.navigation.internal.dm.k kVar = gVarB.b;
                                if (kVar == null) {
                                    kVar = com.google.android.libraries.navigation.internal.dm.k.a;
                                }
                                if (kVar.f != 0) {
                                    byte[] bArrB = gVarB.c.B();
                                    com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.adi.d.a, bArrB, 0, bArrB.length, com.google.android.libraries.navigation.internal.ael.ar.b());
                                    com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                                    dVar = (com.google.android.libraries.navigation.internal.adi.d) biVarV;
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                } else {
                                    try {
                                        ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).c.e(iVar3);
                                    } catch (com.google.android.libraries.geo.mapcore.internal.store.diskcache.d unused) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1245)).q("Failed to delete resource %s :", i);
                                    }
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    dVar = null;
                                }
                            } catch (IOException unused2) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1244)).q("Failed to unpack epoch resources %s", i);
                            }
                        }
                    } catch (IOException unused3) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1246)).q("Failed to get epoch resources %s", i);
                        if (dVarB != null) {
                        }
                        dVar = null;
                    }
                    if (dVar != null) {
                        this.y = dVar;
                    }
                    return dVar;
                } catch (Throwable th) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1158)).p("Disk cache get epoch resources failed.");
            }
        } catch (IOException unused4) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1158)).p("Disk cache get epoch resources failed.");
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final Iterable b() {
        Collection collectionI;
        synchronized (this.u) {
            collectionI = this.r.i();
        }
        return collectionI;
    }

    public final void c() {
        this.p = false;
        synchronized (this.u) {
            this.r.j(this.q + 2);
        }
        synchronized (this.v) {
            this.t.j(this.q + 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        if (r12.n((com.google.android.libraries.navigation.internal.dm.i) r2.t()) != false) goto L24;
     */
    @Override // com.google.android.libraries.navigation.internal.qu.cb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(final bj bjVar, final int i, bz bzVar) {
        final com.google.android.libraries.navigation.internal.xn.a aVarD = com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTables.fetchCommonStyleData");
        this.i.g.incrementAndGet();
        ho hoVar = this.e;
        final String str = bjVar.b;
        synchronized (hoVar) {
            this.e.t(str, new ay(bzVar, i));
        }
        final bw bwVar = new bw(i, str);
        if (str != null) {
            if (((com.google.android.libraries.navigation.internal.aac.bj) this.t.e(str)) == null) {
                com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
                if (cVarA != null) {
                    try {
                        com.google.android.libraries.geo.mapcore.internal.store.diskcache.g gVar = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).c;
                        com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                        int i2 = com.google.android.libraries.navigation.internal.dm.m.d;
                        if (!hVar.b.H()) {
                            hVar.v();
                        }
                        com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                        if (i2 == 0) {
                            throw null;
                        }
                        iVar.c = i2;
                        iVar.b |= 1;
                        if (!hVar.b.H()) {
                            hVar.v();
                        }
                        com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                        iVar2.b |= 2;
                        iVar2.d = str;
                    } catch (IOException unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1247)).s("Failed to check for style table %s", str);
                    }
                }
                ((com.google.android.libraries.navigation.internal.qy.f) this.m.a()).b(str, null, null);
            }
            this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.ac
                @Override // java.lang.Runnable
                public final void run() {
                    final bg bgVar = this.a;
                    final bw bwVar2 = bwVar;
                    String str2 = str;
                    final com.google.android.libraries.navigation.internal.aac.bj bjVarR = bgVar.r(str2);
                    final bj bjVar2 = bjVar;
                    if (bjVarR == null) {
                        bgVar.e(bwVar2.d, aVarD, new bb(bgVar, str2, new be() { // from class: com.google.android.libraries.navigation.internal.qu.ar
                            @Override // com.google.android.libraries.navigation.internal.qu.be
                            public final void a(byte[] bArr) {
                                bgVar.k(bwVar2, bArr, bjVar2);
                            }
                        }, new bd() { // from class: com.google.android.libraries.navigation.internal.qu.as
                            @Override // com.google.android.libraries.navigation.internal.qu.bd
                            public final void a(String str3) {
                                bgVar.g(bwVar2, bjVar2, null, str3);
                            }
                        }, com.google.android.libraries.navigation.internal.qz.m.a), false, com.google.android.libraries.navigation.internal.qz.m.a);
                    } else if (bjVarR.isDone()) {
                        bgVar.h(bwVar2, bjVarR, bjVar2);
                    } else {
                        bjVarR.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.aq
                            @Override // java.lang.Runnable
                            public final void run() {
                                bgVar.h(bwVar2, bjVarR, bjVar2);
                            }
                        }, bgVar.b);
                    }
                }
            });
            return;
        }
        e(bwVar.d, aVarD, new bb(this, str, new be() { // from class: com.google.android.libraries.navigation.internal.qu.an
            @Override // com.google.android.libraries.navigation.internal.qu.be
            public final void a(byte[] bArr) {
                this.a.k(bwVar, bArr, bjVar);
            }
        }, new bd() { // from class: com.google.android.libraries.navigation.internal.qu.ap
            @Override // com.google.android.libraries.navigation.internal.qu.bd
            public final void a(String str2) {
                this.a.g(bwVar, bjVar, null, str2);
            }
        }, com.google.android.libraries.navigation.internal.qz.m.a), false, com.google.android.libraries.navigation.internal.qz.m.a);
    }

    public final void e(final String str, final com.google.android.libraries.navigation.internal.xn.a aVar, final bb bbVar, boolean z, com.google.android.libraries.navigation.internal.qz.m mVar) {
        synchronized (this.g) {
            final int i = this.x;
            this.x = i + 1;
            Integer num = (Integer) this.g.get(str);
            if (num == null || z) {
                this.g.put(str, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
                com.google.android.libraries.navigation.internal.nw.e.e(aVar, i);
                final com.google.android.libraries.navigation.internal.qz.k kVarE = ((com.google.android.libraries.navigation.internal.qy.h) this.l.a()).e(str, null, new com.google.android.libraries.navigation.internal.qz.g() { // from class: com.google.android.libraries.navigation.internal.qu.ai
                    @Override // com.google.android.libraries.navigation.internal.qz.g
                    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
                        com.google.android.libraries.navigation.internal.nw.e.f(aVar, i);
                        bbVar.a(kVar);
                    }
                }, true, mVar);
                ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) this.a.a()).a(com.google.android.libraries.navigation.internal.km.p.j)).a();
                if (kVarE.p()) {
                    com.google.android.libraries.navigation.internal.nw.e.f(aVar, i);
                    bbVar.a(kVarE);
                    this.i.d.incrementAndGet();
                } else {
                    kVarE.h(new ax(this, str));
                    com.google.android.libraries.navigation.internal.hx.n.a(this.b.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.aj
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (kVarE.p()) {
                                return;
                            }
                            String str2 = str;
                            bg bgVar = this.a;
                            if (bgVar.d.s(str2) || bgVar.e.s(str2)) {
                                ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) bgVar.a.a()).a(com.google.android.libraries.navigation.internal.km.p.f471n)).a(60000L);
                            }
                        }
                    }, 60L, TimeUnit.SECONDS), this.b);
                    this.i.c.incrementAndGet();
                }
            }
        }
    }

    final void f(int i, com.google.android.libraries.navigation.internal.adi.c cVar, bj bjVar) {
        if (this.p && this.j.get()) {
            synchronized (this.g) {
                if (this.g.isEmpty()) {
                    Iterator it2 = bjVar.a.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        y(i, cVar, bjVar, (com.google.android.libraries.geo.mapcore.internal.model.aq) entry.getKey(), (String) entry.getValue(), "");
                    }
                    for (Map.Entry entry2 : bjVar.g.entrySet()) {
                        String str = (String) entry2.getKey();
                        for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                            y(i, cVar, bjVar, (com.google.android.libraries.geo.mapcore.internal.model.aq) entry3.getKey(), (String) entry3.getValue(), str);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.libraries.navigation.internal.qu.bz, java.lang.Object] */
    final void g(bw bwVar, bj bjVar, com.google.android.libraries.geo.mapcore.internal.model.bd bdVar, String str) {
        List<ay> listD;
        synchronized (this.e) {
            listD = this.e.d(bwVar.d);
        }
        for (ay ayVar : listD) {
            ayVar.a.j(ayVar.b, bdVar, str);
            this.i.i.incrementAndGet();
        }
        f(bwVar.e, bjVar.f, bjVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(bw bwVar, com.google.android.libraries.navigation.internal.aac.bj bjVar, bj bjVar2) {
        try {
            g(bwVar, bjVar2, (com.google.android.libraries.geo.mapcore.internal.model.bd) bjVar.get(), null);
        } catch (InterruptedException | ExecutionException e) {
            g(bwVar, bjVar2, null, e.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.libraries.navigation.internal.qu.ca, java.lang.Object] */
    final void i(bx bxVar, bj bjVar, com.google.android.libraries.geo.mapcore.internal.model.bv bvVar, String str) {
        List<ay> listD;
        synchronized (this.d) {
            listD = this.d.d(bxVar.d);
        }
        for (ay ayVar : listD) {
            ayVar.a.k(ayVar.b, bxVar.b, bvVar, str, bxVar.a, bxVar.d);
            this.i.i.incrementAndGet();
        }
        this.o = true;
        com.google.android.libraries.navigation.internal.adi.c cVar = bxVar.c;
        if (cVar == null) {
            return;
        }
        f(bxVar.e, cVar, bjVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(bx bxVar, bj bjVar, com.google.android.libraries.navigation.internal.aac.bj bjVar2) {
        try {
            i(bxVar, bjVar, (com.google.android.libraries.geo.mapcore.internal.model.bv) bjVar2.get(), null);
        } catch (InterruptedException | ExecutionException e) {
            i(bxVar, bjVar, null, e.toString());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k(final bw bwVar, final byte[] bArr, bj bjVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlobalStyleTables.processCommonResource");
        try {
            com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
            try {
                synchronized (this.v) {
                    this.t.m(bwVar.d, caVar);
                }
                com.google.android.libraries.geo.mapcore.internal.model.bd bdVarA = com.google.android.libraries.geo.mapcore.internal.model.bd.a(bArr);
                caVar.d(bdVarA);
                this.i.j.incrementAndGet();
                final com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
                if (cVarA != null) {
                    this.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.aw
                        @Override // java.lang.Runnable
                        public final void run() {
                            bg bgVar = this.a;
                            com.google.android.libraries.navigation.internal.qv.c cVar = cVarA;
                            bw bwVar2 = bwVar;
                            byte[] bArr2 = bArr;
                            try {
                                String str = bwVar2.d;
                                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.insertCommonStyleData");
                                try {
                                    int length = bArr2.length;
                                    byte[] bArrA = com.google.android.libraries.navigation.internal.rq.k.a(bArr2, length);
                                    com.google.android.libraries.navigation.internal.dm.j jVar = (com.google.android.libraries.navigation.internal.dm.j) com.google.android.libraries.navigation.internal.dm.k.a.q();
                                    com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                                    int i = com.google.android.libraries.navigation.internal.dm.m.d;
                                    if (!hVar.b.H()) {
                                        hVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                                    if (i == 0) {
                                        throw null;
                                    }
                                    iVar.c = i;
                                    iVar.b |= 1;
                                    if (!hVar.b.H()) {
                                        hVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                                    str.getClass();
                                    iVar2.b |= 2;
                                    iVar2.d = str;
                                    if (!jVar.b.H()) {
                                        jVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.k kVar = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                    com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
                                    iVar3.getClass();
                                    kVar.c = iVar3;
                                    kVar.b |= 1;
                                    long epochMilli = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVar).d.f().toEpochMilli() + com.google.android.libraries.geo.mapcore.internal.store.diskcache.n.b;
                                    if (!jVar.b.H()) {
                                        jVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.k kVar2 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                    kVar2.b |= 8;
                                    kVar2.e = epochMilli;
                                    long j = length;
                                    if (!jVar.b.H()) {
                                        jVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.k kVar3 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                    kVar3.b |= 16;
                                    kVar3.f = j;
                                    try {
                                        ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVar).c.i((com.google.android.libraries.navigation.internal.dm.k) jVar.t(), bArrA);
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1249)).p("Failed to insert resource:");
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                        }
                                        bgVar.c();
                                        return;
                                    }
                                } catch (Throwable th) {
                                    if (dVarB2 != null) {
                                        try {
                                            Trace.endSection();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException unused2) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1160)).p("Disk cache insertion for style data failed.");
                            }
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1160)).p("Disk cache insertion for style data failed.");
                        }
                    });
                } else {
                    c();
                }
                synchronized (this.g) {
                    this.g.remove(bwVar.d);
                }
                g(bwVar, bjVar, bdVarA, null);
            } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1163)).p("InvalidProtocolBufferException processing common resource");
                synchronized (this.g) {
                    this.g.remove(bwVar.d);
                    synchronized (this.v) {
                        if (((com.google.android.libraries.navigation.internal.aac.bj) this.t.f(bwVar.d)) == caVar) {
                        }
                        caVar.ap(e);
                        this.i.k.incrementAndGet();
                        g(bwVar, bjVar, null, "Parse Error " + e.getMessage());
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    final void l(final bx bxVar, final byte[] bArr, final bj bjVar) {
        final boolean zS;
        com.google.android.libraries.geo.mapcore.internal.model.an anVar;
        com.google.android.libraries.navigation.internal.nw.d dVarA = com.google.android.libraries.navigation.internal.nw.e.a(new com.google.android.libraries.navigation.internal.nw.c() { // from class: com.google.android.libraries.navigation.internal.qu.am
            @Override // com.google.android.libraries.navigation.internal.nw.c
            public final com.google.android.libraries.navigation.internal.xn.a a() {
                return com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTables.processLegendResource "), bg.s());
            }
        });
        try {
            final com.google.android.libraries.navigation.internal.adi.c cVar = bxVar.c;
            synchronized (this.d) {
                zS = this.d.s(bxVar.d);
            }
            if (zS) {
                com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
                try {
                    synchronized (this.u) {
                        this.r.m(bxVar.d, caVar);
                    }
                    com.google.android.libraries.geo.mapcore.internal.model.an anVarI = com.google.android.libraries.geo.mapcore.internal.model.bv.i(bArr, bxVar.c, this.f);
                    caVar.d(anVarI);
                    this.i.j.incrementAndGet();
                    this.s.m(bxVar.d, "network");
                    anVar = anVarI;
                } catch (IOException e) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1165)).p("IOException processing legend resource");
                    com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
                    int i = com.google.android.libraries.navigation.internal.km.n.d;
                    int i2 = i - 1;
                    if (i == 0) {
                        throw null;
                    }
                    kVar.a(i2);
                    synchronized (this.g) {
                        this.g.remove(bxVar.d);
                        synchronized (this.u) {
                            if (((com.google.android.libraries.navigation.internal.aac.bj) this.r.f(bxVar.d)) == caVar) {
                            }
                            caVar.ap(e);
                            this.i.k.incrementAndGet();
                            i(bxVar, bjVar, null, "Parse Error " + e.getMessage());
                        }
                    }
                }
            } else {
                anVar = null;
            }
            final com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
            if (cVarA == null) {
                c();
                synchronized (this.g) {
                    this.g.remove(bxVar.d);
                }
                i(bxVar, bjVar, anVar, null);
            } else {
                this.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.ao
                    /* JADX WARN: Code duplicated, block: B:10:0x0038 A[Catch: IOException -> 0x013a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x013a, blocks: (B:3:0x000d, B:10:0x0038, B:43:0x0127, B:38:0x0110, B:54:0x0139, B:53:0x0136, B:49:0x0130, B:4:0x0015, B:8:0x0021, B:15:0x0045, B:17:0x0064, B:18:0x0067, B:20:0x006d, B:22:0x007c, B:23:0x007f, B:25:0x0095, B:26:0x0098, B:28:0x00c4, B:29:0x00c7, B:31:0x00db, B:32:0x00de, B:34:0x00f2, B:35:0x00f5, B:36:0x0107, B:40:0x0114, B:45:0x012b), top: B:71:0x000d, inners: #1, #4 }] */
                    /* JADX WARN: Code duplicated, block: B:57:0x0150  */
                    /* JADX WARN: Code duplicated, block: B:60:0x0157  */
                    /* JADX WARN: Code duplicated, block: B:69:0x016b A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:70:0x016c  */
                    /* JADX WARN: Code duplicated, block: B:76:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.libraries.navigation.internal.kk.k kVar2;
                        int i3;
                        int i4;
                        String str;
                        bg bgVar = this.a;
                        com.google.android.libraries.navigation.internal.qv.c cVar2 = cVarA;
                        bx bxVar2 = bxVar;
                        byte[] bArr2 = bArr;
                        com.google.android.libraries.navigation.internal.adi.c cVar3 = cVar;
                        try {
                            String str2 = bxVar2.d;
                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.insertStyleEntryTable");
                            try {
                                int iOrdinal = cVar3.ordinal();
                                if (iOrdinal == 0) {
                                    str = "1";
                                } else {
                                    if (iOrdinal != 1) {
                                        if (iOrdinal != 2) {
                                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.geo.mapcore.internal.store.diskcache.n.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1251)).s("Unsupported style table format %s", cVar3);
                                            if (dVarB != null) {
                                                Trace.endSection();
                                            }
                                        } else {
                                            str = ExifInterface.GPS_MEASUREMENT_3D;
                                        }
                                        bgVar.c();
                                        if (zS) {
                                        }
                                        synchronized (bgVar.g) {
                                            bgVar.g.remove(bxVar2.d);
                                        }
                                        bgVar.i(bxVar2, bjVar, null, null);
                                    }
                                    str = ExifInterface.GPS_MEASUREMENT_2D;
                                }
                                int length = bArr2.length;
                                byte[] bArrA = com.google.android.libraries.navigation.internal.rq.k.a(bArr2, length);
                                com.google.android.libraries.navigation.internal.dm.j jVar = (com.google.android.libraries.navigation.internal.dm.j) com.google.android.libraries.navigation.internal.dm.k.a.q();
                                com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                                int i5 = com.google.android.libraries.navigation.internal.dm.m.b;
                                if (!hVar.b.H()) {
                                    hVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                                if (i5 == 0) {
                                    throw null;
                                }
                                iVar.c = i5;
                                iVar.b |= 1;
                                if (!hVar.b.H()) {
                                    hVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                                str2.getClass();
                                iVar2.b |= 2;
                                iVar2.d = str2;
                                if (!jVar.b.H()) {
                                    jVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.k kVar3 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
                                iVar3.getClass();
                                kVar3.c = iVar3;
                                kVar3.b = 1 | kVar3.b;
                                long epochMilli = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVar2).d.f().toEpochMilli() + com.google.android.libraries.geo.mapcore.internal.store.diskcache.n.b;
                                if (!jVar.b.H()) {
                                    jVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.k kVar4 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                kVar4.b |= 8;
                                kVar4.e = epochMilli;
                                if (!jVar.b.H()) {
                                    jVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.k kVar5 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                kVar5.b = 2 | kVar5.b;
                                kVar5.d = str;
                                long j = length;
                                if (!jVar.b.H()) {
                                    jVar.v();
                                }
                                com.google.android.libraries.navigation.internal.dm.k kVar6 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                                kVar6.b |= 16;
                                kVar6.f = j;
                                try {
                                    ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVar2).c.i((com.google.android.libraries.navigation.internal.dm.k) jVar.t(), bArrA);
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                } catch (IOException unused) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1252)).p("Failed to insert resource:");
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    bgVar.c();
                                }
                                if (zS) {
                                    synchronized (bgVar.g) {
                                        bgVar.g.remove(bxVar2.d);
                                        bgVar.i(bxVar2, bjVar, null, null);
                                    }
                                }
                            } catch (Throwable th) {
                                if (dVarB == null) {
                                    throw th;
                                }
                                try {
                                    Trace.endSection();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            kVar2 = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) bgVar.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
                            i3 = com.google.android.libraries.navigation.internal.km.n.a;
                            i4 = i3 - 1;
                            if (i3 != 0) {
                                throw null;
                            }
                            kVar2.a(i4);
                        }
                        kVar2 = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) bgVar.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
                        i3 = com.google.android.libraries.navigation.internal.km.n.a;
                        i4 = i3 - 1;
                        if (i3 != 0) {
                            throw null;
                        }
                        kVar2.a(i4);
                        if (zS) {
                            synchronized (bgVar.g) {
                                bgVar.g.remove(bxVar2.d);
                                bgVar.i(bxVar2, bjVar, null, null);
                            }
                        }
                    }
                });
                if (zS) {
                    synchronized (this.g) {
                        this.g.remove(bxVar.d);
                    }
                    i(bxVar, bjVar, anVar, null);
                }
            }
            if (dVarA != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarA == null) {
                throw th;
            }
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final void m(com.google.android.libraries.navigation.internal.om.p pVar) {
        this.f562n = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final void n(int i, com.google.android.libraries.navigation.internal.adi.c cVar, bj bjVar) {
        this.j.set(true);
        f(i, cVar, bjVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final void o(int i, com.google.android.libraries.navigation.internal.adi.d dVar) {
        this.y = dVar;
        try {
            com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
            if (cVarA != null) {
                byte[] bArrM = dVar.m();
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskStyleTableCache.insertEpochResources");
                try {
                    com.google.android.libraries.navigation.internal.dm.j jVar = (com.google.android.libraries.navigation.internal.dm.j) com.google.android.libraries.navigation.internal.dm.k.a.q();
                    com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                    int i2 = com.google.android.libraries.navigation.internal.dm.m.e;
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    if (i2 == 0) {
                        throw null;
                    }
                    iVar.c = i2;
                    iVar.b |= 1;
                    String strB = com.google.android.libraries.navigation.internal.b.b.b(i, "ER");
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    iVar2.b |= 2;
                    iVar2.d = strB;
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.k kVar = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                    com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
                    iVar3.getClass();
                    kVar.c = iVar3;
                    kVar.b |= 1;
                    long epochMilli = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).d.f().toEpochMilli() + com.google.android.libraries.geo.mapcore.internal.store.diskcache.n.b;
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.k kVar2 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                    kVar2.b |= 8;
                    kVar2.e = epochMilli;
                    long length = bArrM.length;
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.k kVar3 = (com.google.android.libraries.navigation.internal.dm.k) jVar.b;
                    kVar3.b |= 16;
                    kVar3.f = length;
                    try {
                        ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).c.i((com.google.android.libraries.navigation.internal.dm.k) jVar.t(), bArrM);
                        if (dVarB != null) {
                            Trace.endSection();
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1250)).p("Failed to insert resource:");
                        if (dVarB != null) {
                            Trace.endSection();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1166)).p("Disk cache insertion for epoch resources failed.");
            }
        } catch (IOException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1166)).p("Disk cache insertion for epoch resources failed.");
        }
    }

    public final boolean p(String str, int i, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        if (((com.google.android.libraries.navigation.internal.aac.bj) this.r.e(str)) != null) {
            return true;
        }
        com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
        if (cVarA != null) {
            try {
                com.google.android.libraries.geo.mapcore.internal.store.diskcache.g gVar = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.n) cVarA).c;
                com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                int i2 = com.google.android.libraries.navigation.internal.dm.m.b;
                if (!hVar.b.H()) {
                    hVar.v();
                }
                com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                if (i2 == 0) {
                    throw null;
                }
                iVar.c = i2;
                iVar.b |= 1;
                if (!hVar.b.H()) {
                    hVar.v();
                }
                com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                str.getClass();
                iVar2.b |= 2;
                iVar2.d = str;
                if (gVar.n((com.google.android.libraries.navigation.internal.dm.i) hVar.t())) {
                    return true;
                }
            } catch (IOException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1248)).s("Failed to check for style table %s", str);
            }
        }
        ((com.google.android.libraries.navigation.internal.qy.f) this.m.a()).b(str, Integer.valueOf(i), aqVar);
        return false;
    }

    public final boolean q(final String str, final com.google.android.libraries.navigation.internal.qz.m mVar, final bb bbVar) {
        boolean zS;
        boolean zS2;
        synchronized (this.d) {
            zS = this.d.s(str);
        }
        if (!zS) {
            synchronized (this.e) {
                zS2 = this.e.s(str);
            }
            if (!zS2) {
                return false;
            }
        }
        synchronized (this.g) {
            Integer num = (Integer) this.g.get(str);
            if (num == null) {
                return false;
            }
            if (num.intValue() > ((Integer) this.w.a()).intValue()) {
                return false;
            }
            com.google.android.libraries.navigation.internal.hx.n.a(this.b.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.ad
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(str, com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTablesFetcher.scheduleRetryIfNecessary"), bbVar, true, mVar);
                }
            }, Math.min(1 << (num.intValue() - 1), 20), TimeUnit.SECONDS), this.b);
            return true;
        }
    }

    public final com.google.android.libraries.navigation.internal.aac.bj r(String str) {
        com.google.android.libraries.geo.mapcore.internal.model.bd bdVarW;
        com.google.android.libraries.navigation.internal.aac.bj bjVar = (com.google.android.libraries.navigation.internal.aac.bj) this.t.f(str);
        if (bjVar != null) {
            return bjVar;
        }
        synchronized (this.v) {
            com.google.android.libraries.navigation.internal.aac.bj bjVar2 = (com.google.android.libraries.navigation.internal.aac.bj) this.t.f(str);
            if (bjVar2 != null) {
                return bjVar2;
            }
            com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
            this.t.m(str, caVar);
            try {
                try {
                    com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
                    bdVarW = cVarA != null ? cVarA.a(str, false) : null;
                    if (bdVarW != null) {
                        try {
                            this.i.a.incrementAndGet();
                            this.s.m(str, "disk");
                        } catch (IOException unused) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1150)).p("IOException reading style table from disk cache");
                        }
                    }
                } catch (OutOfMemoryError unused2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1151)).p("OOM caught while getting style table. Recovering.");
                    synchronized (this.v) {
                        this.t.k();
                        this.t.m(str, caVar);
                        bdVarW = w(str);
                    }
                }
            } catch (IOException unused3) {
                bdVarW = null;
            }
            if (bdVarW == null) {
                try {
                    ((com.google.android.libraries.navigation.internal.qy.f) this.m.a()).c(str);
                } catch (IOException unused4) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1149)).p("IOException parsing offline paint resource");
                }
            }
            if (bdVarW != null) {
                caVar.d(bdVarW);
                this.i.j.incrementAndGet();
                return caVar;
            }
            synchronized (this.v) {
            }
            caVar.ap(new IOException("isCommonStyleDataAvailable returned true but data is unavailable"));
            this.i.k.incrementAndGet();
            return null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final com.google.android.libraries.navigation.internal.aac.bj t(String str, int i, final com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        com.google.android.libraries.navigation.internal.aac.ca caVar;
        com.google.android.libraries.geo.mapcore.internal.model.bv bvVarX;
        com.google.android.libraries.navigation.internal.aac.bj bjVar;
        com.google.android.libraries.navigation.internal.aac.bj bjVar2 = (com.google.android.libraries.navigation.internal.aac.bj) this.r.f(str);
        if (bjVar2 != null) {
            return bjVar2;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarA = com.google.android.libraries.navigation.internal.nw.e.a(new com.google.android.libraries.navigation.internal.nw.c() { // from class: com.google.android.libraries.navigation.internal.qu.ae
            @Override // com.google.android.libraries.navigation.internal.nw.c
            public final com.google.android.libraries.navigation.internal.xn.a a() {
                return com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTables.getTable"), bg.s());
            }
        });
        try {
            synchronized (this.u) {
                com.google.android.libraries.navigation.internal.aac.bj bjVar3 = (com.google.android.libraries.navigation.internal.aac.bj) this.r.f(str);
                if (bjVar3 != null) {
                    bjVar = bjVar3;
                } else {
                    caVar = new com.google.android.libraries.navigation.internal.aac.ca();
                    this.r.m(str, caVar);
                    try {
                        try {
                            com.google.android.libraries.navigation.internal.qv.c cVarA = this.h.a();
                            bvVarX = cVarA != null ? cVarA.b(str) : null;
                            if (bvVarX != null) {
                                try {
                                    this.i.a.incrementAndGet();
                                    this.s.m(str, "disk");
                                } catch (IOException unused) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1155)).p("IOException reading style table from disk cache");
                                    com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
                                    int i2 = com.google.android.libraries.navigation.internal.km.n.b;
                                    int i3 = i2 - 1;
                                    if (i2 == 0) {
                                        throw null;
                                    }
                                    kVar.a(i3);
                                }
                            }
                        } catch (IOException unused2) {
                            bvVarX = null;
                        }
                    } catch (OutOfMemoryError unused3) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1156)).p("OOM caught while getting style table. Recovering.");
                        synchronized (this.u) {
                            this.r.k();
                            this.r.m(str, caVar);
                            bvVarX = x(str);
                        }
                    }
                    if (bvVarX == null) {
                        try {
                            ((com.google.android.libraries.navigation.internal.qy.f) this.m.a()).c(str);
                        } catch (IOException unused4) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1154)).p("IOException parsing style table from offline paint resources");
                            com.google.android.libraries.navigation.internal.kk.k kVar2 = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
                            int i4 = com.google.android.libraries.navigation.internal.km.n.d;
                            int i5 = i4 - 1;
                            if (i4 == 0) {
                                throw null;
                            }
                            kVar2.a(i5);
                        }
                    }
                    if (bvVarX == null) {
                        synchronized (this.u) {
                        }
                        caVar.ap(new IOException("isTableAvailable returned true but table is unavailable"));
                        this.i.k.incrementAndGet();
                        if (dVarA != null) {
                            Trace.endSection();
                        }
                        return null;
                    }
                    caVar.d(bvVarX);
                    this.i.j.incrementAndGet();
                }
            }
            if (dVarA != null) {
                bjVar = caVar;
                Trace.endSection();
            }
            bjVar = caVar;
            return bjVar;
        } catch (Throwable th) {
            if (dVarA != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.qu.cb
    public final int v(final bj bjVar, final int i, final com.google.android.libraries.navigation.internal.adi.c cVar, final com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, ca caVar, String str) {
        String str2;
        int i2 = com.google.android.libraries.navigation.internal.zt.p.a;
        final com.google.android.libraries.navigation.internal.xn.a aVarA = com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("GlobalStyleTables.fetchStyleTables"), s());
        com.google.android.libraries.navigation.internal.qz.l lVar = (com.google.android.libraries.navigation.internal.qz.l) com.google.android.libraries.navigation.internal.qz.m.a.q();
        if (u(aqVar, str, bjVar.g)) {
            if (!lVar.b.H()) {
                lVar.v();
            }
            com.google.android.libraries.navigation.internal.qz.m.b((com.google.android.libraries.navigation.internal.qz.m) lVar.b);
        }
        final com.google.android.libraries.navigation.internal.qz.m mVar = (com.google.android.libraries.navigation.internal.qz.m) lVar.t();
        if (bjVar.g.containsKey(str) && ((Map) bjVar.g.get(str)).containsKey(aqVar)) {
            str2 = (String) ((Map) bjVar.g.get(str)).get(aqVar);
        } else {
            com.google.android.libraries.navigation.internal.om.p pVar = this.f562n;
            com.google.android.libraries.navigation.internal.yx.ar.q(pVar);
            com.google.android.libraries.navigation.internal.om.v vVarD = pVar.d();
            str2 = (vVarD.f(str) || Objects.equals(str, "") || bjVar.g.containsKey(str) || !vVarD.g(aqVar.E)) ? (String) bjVar.a.get(aqVar) : null;
        }
        final String str3 = str2;
        if (str3 == null) {
            this.i.h.incrementAndGet();
            return i2;
        }
        this.i.g.incrementAndGet();
        synchronized (this.d) {
            this.d.t(str3, new ay(caVar, i));
        }
        final bx bxVar = new bx(i, aqVar, str3, cVar, str);
        if (p(str3, i, aqVar)) {
            this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.at
                @Override // java.lang.Runnable
                public final void run() {
                    final bg bgVar = this.a;
                    String str4 = str3;
                    final bx bxVar2 = bxVar;
                    int i3 = i;
                    final bj bjVar2 = bjVar;
                    final com.google.android.libraries.navigation.internal.aac.bj bjVarT = bgVar.t(str4, i3, aqVar);
                    if (bjVarT == null) {
                        com.google.android.libraries.navigation.internal.qz.m mVar2 = mVar;
                        bgVar.e(bxVar2.d, aVarA, new bb(bgVar, str4, new be() { // from class: com.google.android.libraries.navigation.internal.qu.ag
                            @Override // com.google.android.libraries.navigation.internal.qu.be
                            public final void a(byte[] bArr) {
                                bgVar.l(bxVar2, bArr, bjVar2);
                            }
                        }, new bd() { // from class: com.google.android.libraries.navigation.internal.qu.ah
                            @Override // com.google.android.libraries.navigation.internal.qu.bd
                            public final void a(String str5) {
                                bgVar.i(bxVar2, bjVar2, null, str5);
                            }
                        }, mVar2), false, mVar2);
                    } else if (bjVarT.isDone()) {
                        bgVar.j(bxVar2, bjVar2, bjVarT);
                    } else {
                        bjVarT.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.af
                            @Override // java.lang.Runnable
                            public final void run() {
                                bgVar.j(bxVar2, bjVar2, bjVarT);
                            }
                        }, bgVar.b);
                    }
                }
            });
            return com.google.android.libraries.navigation.internal.zt.p.b;
        }
        e(bxVar.d, aVarA, new bb(this, str3, new be() { // from class: com.google.android.libraries.navigation.internal.qu.au
            @Override // com.google.android.libraries.navigation.internal.qu.be
            public final void a(byte[] bArr) {
                this.a.l(bxVar, bArr, bjVar);
            }
        }, new bd() { // from class: com.google.android.libraries.navigation.internal.qu.av
            @Override // com.google.android.libraries.navigation.internal.qu.bd
            public final void a(String str4) {
                this.a.i(bxVar, bjVar, null, str4);
            }
        }, mVar), false, mVar);
        return this.o ? com.google.android.libraries.navigation.internal.zt.p.c : com.google.android.libraries.navigation.internal.zt.p.d;
    }
}
