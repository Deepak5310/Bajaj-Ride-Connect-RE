package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.ace.mk;
import com.google.android.libraries.navigation.internal.ace.ml;
import com.google.android.libraries.navigation.internal.ace.ns;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fb;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.afl.fr;
import com.google.android.libraries.navigation.internal.agi.hc;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.fd;
import j$.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class by {
    public final Executor a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public final ao c;
    public final com.google.android.libraries.navigation.internal.fz.d d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final com.google.android.libraries.navigation.internal.tj.z f;
    public final com.google.android.libraries.navigation.internal.rw.f g;
    public int h;
    public long i;
    public boolean j;
    final bm k;
    final bm l;
    private final com.google.android.libraries.navigation.internal.iv.f p;
    private final com.google.android.libraries.navigation.internal.sl.l q;
    private final bk r;
    private final com.google.android.libraries.navigation.internal.dx.o s;
    private final br t;
    private final com.google.android.libraries.navigation.internal.tj.ac u;
    private final com.google.android.libraries.navigation.internal.tj.ae v;
    private final com.google.android.libraries.navigation.internal.so.a w;
    private final com.google.android.libraries.navigation.internal.av.a x;
    public final bx o = new bx(this);
    public final Set m = new hc();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set f581n = new hc();

    public by(Executor executor, com.google.android.libraries.navigation.internal.ia.e eVar, ao aoVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.dx.a aVar2, com.google.android.libraries.navigation.internal.dx.o oVar, com.google.android.libraries.navigation.internal.sl.l lVar, bk bkVar, br brVar, com.google.android.libraries.navigation.internal.tj.ac acVar, com.google.android.libraries.navigation.internal.tj.z zVar, com.google.android.libraries.navigation.internal.tj.ae aeVar, com.google.android.libraries.navigation.internal.so.a aVar3, com.google.android.libraries.navigation.internal.rw.f fVar2, com.google.android.libraries.navigation.internal.av.a aVar4) {
        this.a = executor;
        this.b = eVar;
        this.c = aoVar;
        this.d = dVar;
        this.p = fVar;
        this.e = aVar;
        this.q = lVar;
        this.r = bkVar;
        this.s = oVar;
        this.t = brVar;
        this.f = zVar;
        this.u = acVar;
        this.v = aeVar;
        this.w = aVar3;
        this.g = fVar2;
        this.x = aVar4;
        com.google.android.libraries.navigation.internal.yx.as asVar = new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.sv.bt
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                el elVar = (el) obj;
                fb fbVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).m;
                if (fbVar == null) {
                    fbVar = fb.a;
                }
                return fbVar.f;
            }
        };
        ml mlVar = dVar.w().d;
        this.k = new bm(asVar, fd.i(de.d((mlVar == null ? ml.a : mlVar).b).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sv.bu
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                mk mkVar = (mk) obj;
                Cdo cdoB = Cdo.b(mkVar.b);
                if (cdoB == null) {
                    cdoB = Cdo.INCIDENT_ROAD_CLOSED;
                }
                return new AbstractMap.SimpleImmutableEntry(cdoB, Integer.valueOf(mkVar.c));
            }
        })), aVar2);
        com.google.android.libraries.navigation.internal.yx.as asVar2 = new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.sv.bv
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                el elVar = (el) obj;
                return ((elVar.c == 22 ? (fh) elVar.d : fh.a).b & 16384) != 0;
            }
        };
        ml mlVar2 = dVar.w().e;
        this.l = new bm(asVar2, fd.i(de.d((mlVar2 == null ? ml.a : mlVar2).b).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sv.bw
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                mk mkVar = (mk) obj;
                Cdo cdoB = Cdo.b(mkVar.b);
                if (cdoB == null) {
                    cdoB = Cdo.INCIDENT_ROAD_CLOSED;
                }
                return new AbstractMap.SimpleImmutableEntry(cdoB, Integer.valueOf(mkVar.c));
            }
        })), aVar2);
    }

    private final ns g() {
        return this.d.x().d();
    }

    public final fr a() {
        fr frVar = this.d.b().a.aF;
        return frVar == null ? fr.a : frVar;
    }

    public final void b(com.google.android.libraries.navigation.internal.tt.d dVar) {
        if (this.q.a() != com.google.android.libraries.navigation.internal.sl.m.MUTED) {
            bj bjVarA = this.r.a(dVar);
            if (bjVarA.b) {
                bjVarA.a.d(com.google.android.libraries.navigation.internal.km.af.d);
            }
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.tt.d dVar, boolean z) {
        bj bjVarA = this.r.a(dVar);
        if (bjVarA.b) {
            bjVarA.a.d(com.google.android.libraries.navigation.internal.km.af.b);
        }
    }

    public final boolean d(long j) {
        return this.p.y(com.google.android.libraries.navigation.internal.iv.ab.bO, true) && j - this.i < Duration.ofSeconds((long) a().c).toMillis();
    }

    public final boolean e(long j) {
        if (!this.p.y(com.google.android.libraries.navigation.internal.iv.ab.bO, true)) {
            return false;
        }
        if (j - this.i < Duration.ofSeconds(a().c).toMillis() || this.h >= g().b) {
            return true;
        }
        long j2 = j - 86400000;
        Iterator it2 = this.p.k(com.google.android.libraries.navigation.internal.iv.ab.bJ, new ArrayList()).iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (Long.parseLong((String) it2.next()) > j2) {
                i++;
            }
        }
        return i >= g().c;
    }

    public final void f(long j) {
        this.h++;
        List listK = this.p.k(com.google.android.libraries.navigation.internal.iv.ab.bJ, new ArrayList());
        listK.add(0, Long.toString(j));
        this.p.u(com.google.android.libraries.navigation.internal.iv.ab.bJ, listK.subList(0, Math.min(listK.size(), g().c)));
    }
}
