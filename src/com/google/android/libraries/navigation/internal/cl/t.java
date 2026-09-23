package com.google.android.libraries.navigation.internal.cl;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.ace.nq;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gl;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public static final Duration a = Duration.ofSeconds(0);
    private final Context b;
    private final com.google.android.libraries.navigation.internal.ol.ax c;
    private final com.google.android.libraries.navigation.internal.op.i d;
    private final boolean e;
    private final boolean f;
    private final com.google.android.libraries.navigation.internal.iv.f g;
    private final com.google.android.libraries.navigation.internal.fz.d h;
    private final com.google.android.libraries.navigation.internal.mj.a i;
    private final com.google.android.libraries.navigation.internal.dx.i j;
    private nq k;
    private gl l;
    private aj m;

    public t(Context context, com.google.android.libraries.navigation.internal.ol.ax axVar, com.google.android.libraries.navigation.internal.op.i iVar, boolean z, boolean z2, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.dx.i iVar2) {
        this.b = context;
        this.c = axVar;
        this.d = iVar;
        this.e = z;
        this.f = z2;
        this.m = new aj(context, axVar, z);
        this.g = fVar;
        this.h = dVar;
        if (dVar != null && (dVar.x().c().b & 2) != 0 && (dVar.x().c().b & 4) != 0) {
            nq nqVarC = dVar.x().c();
            this.k = nqVarC;
            this.l = gl.y(de.d(nqVarC.d).c(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.cl.r
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    Duration duration = t.a;
                    return ((Long) obj).longValue() > 0;
                }
            }).f());
        }
        this.i = aVar;
        this.j = iVar2;
    }

    public static int a(el elVar, boolean z, boolean z2) {
        if (z2) {
            Cdo cdoB = Cdo.b(elVar.u);
            if (cdoB == null) {
                cdoB = Cdo.INCIDENT_OTHER;
            }
            if (cdoB == Cdo.INCIDENT_ROAD_CLOSED) {
                return Integer.MIN_VALUE;
            }
        }
        com.google.android.libraries.navigation.internal.aap.d dVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).d;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        int i = -dVar.c;
        int i2 = 1;
        if (z && z2) {
            i2 = 10000;
        }
        return i * i2;
    }

    private final String r(long j) {
        gl glVar = this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(glVar);
        Long lValueOf = Long.valueOf(j);
        com.google.android.libraries.navigation.internal.yx.an anVarI = com.google.android.libraries.navigation.internal.yx.an.i((Long) glVar.floor(lValueOf));
        Long l = (Long) anVarI.e(lValueOf);
        long jLongValue = l.longValue();
        com.google.android.libraries.navigation.internal.iv.f fVar = this.g;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar);
        List listK = fVar.k(com.google.android.libraries.navigation.internal.iv.ab.bU, new ArrayList());
        int size = listK.size();
        nq nqVar = this.k;
        com.google.android.libraries.navigation.internal.yx.ar.q(nqVar);
        if (size >= nqVar.c) {
            return anVarI.g() ? this.b.getString(com.google.android.libraries.navigation.internal.qr.e.e, l) : Long.toString(jLongValue);
        }
        String string = this.b.getString(anVarI.g() ? com.google.android.libraries.navigation.internal.qr.e.d : com.google.android.libraries.navigation.internal.qr.e.f, l);
        com.google.android.libraries.navigation.internal.mj.a aVar = this.i;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        long epochMilli = aVar.f().toEpochMilli();
        final long millis = epochMilli - TimeUnit.DAYS.toMillis(1L);
        if (de.d(listK).i(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.cl.s
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                return Long.parseLong((String) obj) > millis;
            }
        })) {
            return string;
        }
        listK.add(Long.toString(epochMilli));
        com.google.android.libraries.navigation.internal.iv.f fVar2 = this.g;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar2);
        fVar2.u(com.google.android.libraries.navigation.internal.iv.ab.bU, listK);
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized void s(com.google.android.libraries.navigation.internal.oj.c cVar, com.google.android.libraries.navigation.internal.adg.Cdo cdo, Object obj, String str, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, boolean z, Object obj2, Object obj3, Object obj4, Object obj5) {
        dq dqVarB = cVar.b(obj2);
        int i = ev.d;
        eq eqVar = new eq();
        eqVar.h(cdo);
        if (str != null) {
            com.google.android.libraries.navigation.internal.adg.Cdo cdoA = cVar.a(obj3);
            if (!cdoA.b.H()) {
                cdoA.v();
            }
            dp dpVar = (dp) cdoA.b;
            dp dpVar2 = dp.a;
            dpVar.b |= 1;
            dpVar.c = StringUtils.SPACE;
            eqVar.h(cdoA);
            if (obj != null) {
                eqVar.h(cVar.a(obj));
                com.google.android.libraries.navigation.internal.adg.Cdo cdoA2 = cVar.a(obj4);
                if (!cdoA2.b.H()) {
                    cdoA2.v();
                }
                dp dpVar3 = (dp) cdoA2.b;
                dpVar3.b |= 1;
                dpVar3.c = str;
                eqVar.h(cdoA2);
            } else if (z) {
                com.google.android.libraries.navigation.internal.adg.Cdo cdoA3 = cVar.a(obj5);
                if (!cdoA3.b.H()) {
                    cdoA3.v();
                }
                dp dpVar4 = (dp) cdoA3.b;
                dpVar4.b |= 1;
                dpVar4.c = str;
                eqVar.h(cdoA3);
            } else {
                com.google.android.libraries.navigation.internal.adg.Cdo cdoA4 = cVar.a(obj4);
                if (!cdoA4.b.H()) {
                    cdoA4.v();
                }
                dp dpVar5 = (dp) cdoA4.b;
                dpVar5.b |= 1;
                dpVar5.c = str;
                eqVar.h(cdoA4);
            }
        }
        ev evVarH = com.google.android.libraries.navigation.internal.gz.i.a(this.b) ? eqVar.g().h() : eqVar.g();
        int size = evVarH.size();
        for (int i2 = 0; i2 < size; i2++) {
            dqVarB.d((com.google.android.libraries.navigation.internal.adg.Cdo) evVarH.get(i2));
        }
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar = (com.google.android.libraries.navigation.internal.adg.b) aj.b.get(0);
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar.d = bVar.j;
        dVar.b |= 2;
        if (xVar != null) {
            com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(xVar);
            if (!cVar2.b.H()) {
                cVar2.v();
            }
            com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
            hVarA.getClass();
            dVar2.c = hVarA;
            dVar2.b |= 1;
        }
        dy dyVarC = cVar.c();
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar = (ef) dyVarC.b;
        dt dtVar = (dt) dqVarB.t();
        ef efVar2 = ef.a;
        dtVar.getClass();
        efVar.c = dtVar;
        efVar.b |= 1;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar3 = (ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar3 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        dVar3.getClass();
        efVar3.e = dVar3;
        efVar3.b |= 8;
        if (elVar != null) {
            com.google.android.libraries.navigation.internal.br.l.e(elVar);
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.oj.c b() {
        com.google.android.libraries.navigation.internal.op.i iVar;
        if (this.m != null && (iVar = this.d) != null) {
            com.google.android.libraries.navigation.internal.yx.ar.r(iVar, "Attempted to create a V3 callout builder when V3 APIs are disabled");
            aj ajVar = this.m;
            com.google.android.libraries.navigation.internal.yx.ar.r(ajVar, "Attempted to create a callout after styles were destroyed");
            return com.google.android.libraries.navigation.internal.oj.c.f(iVar, ajVar.i(), new com.google.android.libraries.navigation.internal.op.b());
        }
        return null;
    }

    public final synchronized com.google.android.libraries.navigation.internal.oj.c c() {
        aj ajVar = this.m;
        if (ajVar == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.yx.ar.r(ajVar, "Attempted to create a callout after styles were destroyed");
        return com.google.android.libraries.navigation.internal.oj.c.g(ajVar.b());
    }

    public final synchronized void d() {
        aj ajVar = this.m;
        if (ajVar != null) {
            ajVar.n();
            this.m = null;
        }
    }

    public final synchronized void e() {
        if (this.m == null) {
            this.m = new aj(this.b, this.c, this.e);
        }
    }

    public final synchronized boolean f(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, String str3, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, Boolean bool, int i) {
        com.google.android.libraries.navigation.internal.oo.f fVarB;
        boolean z = false;
        if (cVar != null) {
            aj ajVar = this.m;
            if (ajVar != null) {
                com.google.android.libraries.navigation.internal.yx.ar.q(ajVar);
                ai aiVar = this.f ? ai.CAR : ai.PHONE;
                com.google.android.libraries.navigation.internal.adg.Cdo cdoA = cVar.a(ajVar.h(str, aiVar, i));
                com.google.android.libraries.navigation.internal.oo.f fVarK = str2 != null ? ajVar.k(str2, aiVar) : null;
                boolean zBooleanValue = bool.booleanValue();
                if (str3 != null && !str3.isEmpty()) {
                    z = true;
                }
                boolean zA = com.google.android.libraries.navigation.internal.gz.i.a(this.b);
                if (z) {
                    fVarB = zA ? ((ah) ajVar.j.a()).b() : ((ah) ajVar.i.a()).b();
                } else {
                    fVarB = ((ah) ajVar.h.a()).b();
                }
                s(cVar, cdoA, fVarK, str3, xVar, elVar, zBooleanValue, fVarB, ajVar.j(), ajVar.m(aiVar), ajVar.l(aiVar));
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean g(com.google.android.libraries.navigation.internal.oj.c cVar, Duration duration, String str, el elVar) {
        String string;
        string = null;
        if (duration.compareTo(a) > 0) {
            Context context = this.b;
            int i = com.google.android.libraries.navigation.internal.qr.e.g;
            Resources resources = this.b.getResources();
            com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.hf.u.a;
            string = context.getString(i, com.google.android.libraries.navigation.internal.hf.u.f(resources, (int) duration.toSeconds(), 2, null).toString());
        }
        return o(cVar, str, string, null, elVar, true);
    }

    public final boolean h(com.google.android.libraries.navigation.internal.oj.c cVar, String str, el elVar) {
        return o(cVar, str, null, null, elVar, false);
    }

    public final synchronized boolean j(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, String str3, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, int i) {
        return k(cVar, str, str2, str3, xVar, elVar, true, i);
    }

    public final synchronized boolean k(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, String str3, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, Boolean bool, int i) {
        if (cVar != null) {
            aj ajVar = this.m;
            if (ajVar != null) {
                com.google.android.libraries.navigation.internal.yx.ar.q(ajVar);
                ai aiVar = this.f ? ai.CAR : ai.PHONE;
                s(cVar, cVar.a(ajVar.c(str, aiVar, i)), str2 != null ? ajVar.e(str2, aiVar) : null, str3, xVar, elVar, bool.booleanValue(), ajVar.b(), ajVar.d(), ajVar.g(aiVar), ajVar.f(aiVar));
                return true;
            }
        }
        return false;
    }

    public final boolean l(com.google.android.libraries.navigation.internal.oj.c cVar, int i, String str, el elVar) {
        String string;
        if (cVar == null) {
            return false;
        }
        if (i > 0) {
            Context context = this.b;
            string = context.getString(com.google.android.libraries.navigation.internal.qr.e.g, com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), i, 2).toString());
        } else {
            string = null;
        }
        return p(cVar, str, string, elVar);
    }

    public final boolean m(com.google.android.libraries.navigation.internal.oj.c cVar, String str, el elVar) {
        return p(cVar, str, null, elVar);
    }

    public final boolean n(com.google.android.libraries.navigation.internal.oj.c cVar, long j, String str, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, int i) {
        String str2;
        if (j < 1 || this.h == null || !this.j.p() || !this.h.x().g() || !this.h.K().h || this.k == null || this.l == null || this.g == null || this.i == null) {
            return j(cVar, str, null, null, xVar, elVar, i);
        }
        String strR = r(j);
        if (this.e) {
            nq nqVar = this.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(nqVar);
            str2 = nqVar.f;
        } else {
            nq nqVar2 = this.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(nqVar2);
            str2 = nqVar2.e;
        }
        return j(cVar, str, str2, strR, xVar, elVar, i);
    }

    public final synchronized boolean o(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, Boolean bool) {
        return f(cVar, str, null, str2, xVar, elVar, bool, 1);
    }

    public final synchronized boolean p(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, el elVar) {
        return j(cVar, str, null, str2, null, elVar, 1);
    }

    public final synchronized boolean q(com.google.android.libraries.navigation.internal.oj.c cVar, String str, String str2, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, Boolean bool) {
        return k(cVar, str, null, str2, xVar, elVar, bool, 1);
    }

    public final boolean i(com.google.android.libraries.navigation.internal.oj.c cVar, long j, String str, com.google.android.libraries.navigation.internal.oe.x xVar, el elVar, int i) {
        String str2;
        if (j < 1 || this.h == null || !this.j.p() || !this.h.x().g() || !this.h.K().h || this.k == null || this.l == null || this.g == null || this.i == null) {
            return f(cVar, str, null, null, xVar, elVar, false, i);
        }
        String strR = r(j);
        if (this.e) {
            nq nqVar = this.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(nqVar);
            str2 = nqVar.f;
        } else {
            nq nqVar2 = this.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(nqVar2);
            str2 = nqVar2.e;
        }
        return f(cVar, str, str2, strR, xVar, elVar, false, i);
    }
}
