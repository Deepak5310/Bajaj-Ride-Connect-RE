package com.google.android.libraries.navigation.internal.jj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.libraries.navigation.internal.acd.lv;
import com.google.android.libraries.navigation.internal.acd.ua;
import com.google.android.libraries.navigation.internal.acd.ub;
import com.google.android.libraries.navigation.internal.adq.aj;
import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.adq.v;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adu.u;
import com.google.android.libraries.navigation.internal.adu.w;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afe.k;
import com.google.android.libraries.navigation.internal.afe.m;
import com.google.android.libraries.navigation.internal.afl.ob;
import com.google.android.libraries.navigation.internal.afl.oc;
import com.google.android.libraries.navigation.internal.hf.l;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.qy.h;
import com.google.android.libraries.navigation.internal.xe.bl;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zp.n;
import com.google.android.libraries.navigation.internal.zp.q;
import com.google.android.libraries.navigation.internal.zp.r;
import com.google.android.libraries.navigation.internal.zp.s;
import com.google.android.libraries.navigation.internal.zq.i;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f implements com.google.android.libraries.navigation.internal.ji.a {
    private static final al s;
    private final t A;
    private final h B;
    private final boolean C;
    private final boolean D;
    private com.google.android.libraries.navigation.internal.aap.d E;
    private com.google.android.libraries.navigation.internal.aap.d F;
    private com.google.android.libraries.navigation.internal.aap.d G;
    private CharSequence H;
    private CharSequence I;
    private CharSequence J;
    private CharSequence K;
    private final String L;
    private CharSequence M;
    private String N;
    private aa O;
    private long P;
    private y Q;
    private final com.google.android.libraries.navigation.internal.gs.f R;
    final com.google.android.libraries.navigation.internal.gg.e a;
    final com.google.android.libraries.navigation.internal.qz.g b;
    public final Executor c;
    public final Context d;
    public final at e;
    public com.google.android.libraries.navigation.internal.ji.a.EnumC0033a f;
    public CharSequence g;
    public ah h;
    public CharSequence i;
    public CharSequence j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f456n;
    public boolean o;
    final e p;
    public final bl q;
    private final com.google.android.libraries.navigation.internal.hf.c t;
    private final com.google.android.libraries.navigation.internal.afo.a u;
    private final com.google.android.libraries.navigation.internal.afo.a v;
    private final com.google.android.libraries.navigation.internal.fz.d w;
    private final com.google.android.libraries.navigation.internal.eb.a x;
    private final com.google.android.libraries.navigation.internal.jo.a y;
    private final com.google.android.libraries.navigation.internal.eb.b z;

    static {
        ak akVar = (ak) al.a.q();
        int i = v.e;
        if (!akVar.b.H()) {
            akVar.v();
        }
        al alVar = (al) akVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        alVar.h = i2;
        alVar.b |= 65536;
        int i3 = n.w.a;
        if (!akVar.b.H()) {
            akVar.v();
        }
        al alVar2 = (al) akVar.b;
        alVar2.b |= 64;
        alVar2.e = i3;
        s = (al) akVar.t();
    }

    public f(com.google.android.libraries.navigation.internal.hf.c cVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, t tVar, h hVar, com.google.android.libraries.navigation.internal.gs.b bVar, com.google.android.libraries.navigation.internal.gs.f fVar, at atVar, Executor executor, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.eb.a aVar3, com.google.android.libraries.navigation.internal.jo.a aVar4, com.google.android.libraries.navigation.internal.eb.b bVar2, bl blVar, Context context, com.google.android.libraries.navigation.internal.tt.d dVar2) {
        a aVar5 = new a(this);
        this.a = aVar5;
        this.b = new c(this);
        this.p = new e(this);
        this.c = executor;
        this.q = blVar;
        this.d = context;
        this.t = cVar;
        this.u = aVar;
        this.v = aVar2;
        this.w = dVar;
        this.x = aVar3;
        this.y = aVar4;
        this.z = bVar2;
        this.A = tVar;
        this.B = hVar;
        this.C = true;
        this.e = atVar;
        this.D = true;
        this.R = fVar;
        this.g = context.getString(com.google.android.libraries.navigation.internal.f.h.E);
        this.E = com.google.android.libraries.navigation.internal.aap.d.a;
        com.google.android.libraries.navigation.internal.aap.d dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
        this.F = dVar3;
        this.G = dVar3;
        this.f = com.google.android.libraries.navigation.internal.ji.a.EnumC0033a.LOADING;
        this.Q = y.UNKNOWN_INCIDENT_TYPE;
        boolean z = dVar.D().c;
        if (dVar2.t() == null || dVar2.v() == null) {
            ob obVar = (ob) oc.a.q();
            obVar.c(dVar2.b());
            if (!obVar.b.H()) {
                obVar.v();
            }
            oc.e((oc) obVar.b);
            bVar.a((oc) obVar.t(), aVar5, executor);
        } else {
            R(dVar2);
            this.f = com.google.android.libraries.navigation.internal.ji.a.EnumC0033a.LOADED;
        }
        this.L = dVar2.x();
    }

    private final aa S(com.google.android.libraries.navigation.internal.afd.a aVar) {
        j jVar = aa.a;
        x xVar = new x();
        xVar.i = aVar;
        q qVar = (q) r.a.q();
        s sVar = (s) com.google.android.libraries.navigation.internal.zp.t.a.q();
        y yVar = this.Q;
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.t tVar = (com.google.android.libraries.navigation.internal.zp.t) sVar.b;
        tVar.c = yVar.x;
        tVar.b |= 1;
        if (!qVar.b.H()) {
            qVar.v();
        }
        r rVar = (r) qVar.b;
        com.google.android.libraries.navigation.internal.zp.t tVar2 = (com.google.android.libraries.navigation.internal.zp.t) sVar.t();
        tVar2.getClass();
        rVar.d = tVar2;
        rVar.c |= 8192;
        xVar.g((r) qVar.t());
        return xVar.b();
    }

    private final cs.a T(int i, int i2) {
        if (!x().booleanValue() || !C().booleanValue()) {
            return cs.a.a;
        }
        if (this.z != null) {
            throw null;
        }
        ua uaVar = (ua) ub.a.q();
        al alVar = s;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar = (ub) uaVar.b;
        alVar.getClass();
        ubVar.c = alVar;
        ubVar.b |= 1;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar2 = (ub) uaVar.b;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        ubVar2.d = i3;
        ubVar2.b |= 2;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar3 = (ub) uaVar.b;
        int i4 = i - 1;
        if (i == 0) {
            throw null;
        }
        ubVar3.e = i4;
        ubVar3.b |= 4;
        y yVar = this.Q;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar4 = (ub) uaVar.b;
        ubVar4.f = yVar.x;
        ubVar4.b |= 8;
        long j = this.P;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar5 = (ub) uaVar.b;
        ubVar5.b |= 16;
        ubVar5.g = j;
        this.R.a((ub) uaVar.t(), this.p, this.c);
        this.k = true;
        this.e.a(this);
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean A() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean B() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean C() {
        boolean z = false;
        if (x().booleanValue() && !this.k) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean D() {
        if (this.z == null) {
            return false;
        }
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence E() {
        return this.H;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence F() {
        com.google.android.libraries.navigation.internal.dk.c cVar = (com.google.android.libraries.navigation.internal.dk.c) ((an) this.v.a()).f();
        com.google.android.libraries.navigation.internal.dk.b bVarA = (cVar == null || TextUtils.isEmpty(this.K)) ? null : cVar.a();
        if (bVarA == null) {
            return null;
        }
        String string = this.d.getString(com.google.android.libraries.navigation.internal.jl.b.e);
        lv lvVar = bVarA.a.c;
        if (lvVar == null) {
            lvVar = lv.a;
        }
        return string + StringUtils.SPACE + lvVar.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence G() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence H() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence I() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence J() {
        return this.I;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public CharSequence K() {
        return this.J;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String L() {
        if (this.w.w().j) {
            return this.L;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String M() {
        return this.G.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String N() {
        return this.F.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String O() {
        return this.E.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String P() {
        return this.d.getString(com.google.android.libraries.navigation.internal.jl.b.g);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public String Q() {
        return this.d.getString(com.google.android.libraries.navigation.internal.jl.b.h);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public View.AccessibilityDelegate a() {
        return new d();
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public com.google.android.libraries.navigation.internal.ji.a.EnumC0033a b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public aa c() {
        return this.O;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public aa d() {
        return S(m.t);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public aa e() {
        return S(m.u);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public aa f() {
        j jVar = aa.a;
        x xVar = new x();
        xVar.i = k.s;
        return xVar.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public aa g() {
        return S(m.v);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a h() {
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a i() {
        if (this.q.a()) {
            ((com.google.android.libraries.navigation.internal.wb.t) this.u.a()).c();
        }
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a j() {
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a k() {
        this.m = true;
        return T(u.e, w.d);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a l() {
        this.f456n = true;
        return T(u.e, w.e);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a m() {
        this.l = true;
        return T(u.e, w.f);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public cs.a n() {
        D().booleanValue();
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public ah o() {
        return com.google.android.libraries.navigation.internal.nc.j.h(com.google.android.libraries.navigation.internal.jl.a.b, this.l ? com.google.android.libraries.navigation.internal.ju.b.h : com.google.android.libraries.navigation.internal.w.a.g());
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public ah p() {
        return com.google.android.libraries.navigation.internal.nc.j.h(com.google.android.libraries.navigation.internal.jl.a.a, this.m ? com.google.android.libraries.navigation.internal.ju.b.h : com.google.android.libraries.navigation.internal.w.a.g());
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public ah q() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public ah r() {
        return com.google.android.libraries.navigation.internal.nc.j.h(com.google.android.libraries.navigation.internal.jl.a.c, this.f456n ? com.google.android.libraries.navigation.internal.ju.b.h : com.google.android.libraries.navigation.internal.w.a.g());
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean s() {
        return Boolean.valueOf(this.o);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean t() {
        return Boolean.valueOf(this.D);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean u() {
        return Boolean.valueOf(!TextUtils.isEmpty(M()));
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean v() {
        return Boolean.valueOf(!TextUtils.isEmpty(N()));
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean w() {
        return Boolean.valueOf(!TextUtils.isEmpty(O()));
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean x() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.j)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean y() {
        return Boolean.valueOf(!TextUtils.isEmpty(this.I));
    }

    @Override // com.google.android.libraries.navigation.internal.ji.a
    public Boolean z() {
        return Boolean.valueOf(!TextUtils.isEmpty(this.J));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c6  */
    final void R(com.google.android.libraries.navigation.internal.tt.d dVar) {
        eq eqVar;
        String strT;
        Context context;
        float fA;
        t tVar;
        bm bmVarK;
        bm.a aVarB;
        com.google.android.libraries.navigation.internal.hf.c cVar;
        float f;
        bm.a aVarB2;
        int iRound;
        l lVarE;
        String strT2;
        Cdo cdoM = dVar.m();
        if (cdoM != null) {
            switch (cdoM) {
                case INCIDENT_ROAD_CLOSED:
                case INCIDENT_SPEED_TRAP:
                case INCIDENT_SPEED_CAMERA:
                case INCIDENT_SUSPECTED_JAM:
                case INCIDENT_SUSPECTED_CLOSURE:
                case INCIDENT_LANE_CLOSURE:
                case INCIDENT_STALLED_VEHICLE:
                case INCIDENT_OBJECT_ON_ROAD:
                case INCIDENT_POLICE_PRESENCE:
                case INCIDENT_MOBILE_SPEED_CAMERA:
                case INCIDENT_ICE:
                case INCIDENT_SNOW:
                case INCIDENT_FOG:
                case INCIDENT_FLOOD:
                case INCIDENT_CHECKPOINT:
                case INCIDENT_RAILROAD_CROSSING:
                case INCIDENT_TRAFFIC_LIGHT:
                case INCIDENT_STOP_SIGN:
                    Cdo cdoM2 = dVar.m();
                    String strZ = dVar.z();
                    if (cdoM2 != Cdo.INCIDENT_CHECKPOINT || strZ == null) {
                        strZ = dVar.q();
                    }
                    this.g = strZ;
                    break;
                case INCIDENT_CRASH:
                case INCIDENT_CONSTRUCTION:
                case INCIDENT_JAM:
                case INCIDENT_SPEED_LIMIT:
                case INCIDENT_HAZARD:
                case INCIDENT_BROKEN_TRAFFIC_LIGHT:
                case INCIDENT_POTHOLE:
                case INCIDENT_WEATHER:
                case INCIDENT_SLIPPERY_ROAD:
                default:
                    int i = ev.d;
                    eqVar = new eq();
                    strT = dVar.t();
                    if (TextUtils.isEmpty(strT)) {
                        context = this.d;
                        if (context != null) {
                            eqVar.h(context.getString(com.google.android.libraries.navigation.internal.jl.b.a));
                        }
                    } else {
                        eqVar.h(strT);
                    }
                    fA = dVar.a();
                    if (fA > 0.0f) {
                        tVar = this.A;
                        if (tVar != null) {
                            com.google.android.libraries.navigation.internal.jy.r rVarD = tVar.d();
                            j jVar = aa.a;
                            x xVar = new x();
                            xVar.b = dVar.r();
                            rVarD.b(com.google.android.libraries.navigation.internal.jw.e.g(xVar.a(dVar.B()).c(), m.q));
                        }
                        bmVarK = dVar.K();
                        if (bmVarK != null) {
                            aVarB = null;
                        } else {
                            aVarB = null;
                        }
                        cVar = this.t;
                        ar.q(cVar);
                        f = fA * 3600.0f;
                        aVarB2 = cVar.b(aVarB);
                        bm.a aVar = bm.a.KILOMETERS;
                        if (aVarB2.ordinal() != 0) {
                            iRound = Math.round(f / 1609.344f);
                        } else {
                            iRound = Math.round(f / 1000.0f);
                        }
                        if (aVarB2.ordinal() != 0) {
                            lVarE = cVar.b.e(com.google.android.libraries.navigation.internal.f.h.z);
                        } else {
                            lVarE = cVar.b.e(com.google.android.libraries.navigation.internal.f.h.y);
                        }
                        lVarE.a(Integer.toString(iRound));
                        eqVar.h(lVarE.b());
                    }
                    this.g = TextUtils.join(" · ", eqVar.g());
                    break;
            }
        } else {
            int i2 = ev.d;
            eqVar = new eq();
            strT = dVar.t();
            if (TextUtils.isEmpty(strT)) {
                eqVar.h(strT);
            } else {
                context = this.d;
                if (context != null) {
                    eqVar.h(context.getString(com.google.android.libraries.navigation.internal.jl.b.a));
                }
            }
            fA = dVar.a();
            if (fA > 0.0f) {
                tVar = this.A;
                if (tVar != null) {
                    com.google.android.libraries.navigation.internal.jy.r rVarD2 = tVar.d();
                    j jVar2 = aa.a;
                    x xVar2 = new x();
                    xVar2.b = dVar.r();
                    rVarD2.b(com.google.android.libraries.navigation.internal.jw.e.g(xVar2.a(dVar.B()).c(), m.q));
                }
                bmVarK = dVar.K();
                if (bmVarK != null || (bmVarK.b & 4) == 0) {
                    aVarB = null;
                } else {
                    aVarB = bm.a.b(bmVarK.d);
                    if (aVarB == null) {
                        aVarB = bm.a.REGIONAL;
                    }
                }
                cVar = this.t;
                ar.q(cVar);
                f = fA * 3600.0f;
                aVarB2 = cVar.b(aVarB);
                bm.a aVar2 = bm.a.KILOMETERS;
                if (aVarB2.ordinal() != 0) {
                    iRound = Math.round(f / 1609.344f);
                } else {
                    iRound = Math.round(f / 1000.0f);
                }
                if (aVarB2.ordinal() != 0) {
                    lVarE = cVar.b.e(com.google.android.libraries.navigation.internal.f.h.z);
                } else {
                    lVarE = cVar.b.e(com.google.android.libraries.navigation.internal.f.h.y);
                }
                lVarE.a(Integer.toString(iRound));
                eqVar.h(lVarE.b());
            }
            this.g = TextUtils.join(" · ", eqVar.g());
        }
        Cdo cdoM3 = dVar.m();
        if (cdoM3 != null) {
            switch (cdoM3) {
                case INCIDENT_ROAD_CLOSED:
                case INCIDENT_SUSPECTED_CLOSURE:
                case INCIDENT_CHECKPOINT:
                    strT2 = dVar.t();
                    break;
                case INCIDENT_CRASH:
                case INCIDENT_SPEED_TRAP:
                case INCIDENT_SPEED_CAMERA:
                case INCIDENT_SUSPECTED_JAM:
                case INCIDENT_LANE_CLOSURE:
                case INCIDENT_STALLED_VEHICLE:
                case INCIDENT_OBJECT_ON_ROAD:
                case INCIDENT_POLICE_PRESENCE:
                case INCIDENT_MOBILE_SPEED_CAMERA:
                case INCIDENT_ICE:
                case INCIDENT_SNOW:
                case INCIDENT_FOG:
                case INCIDENT_FLOOD:
                case INCIDENT_RAILROAD_CROSSING:
                case INCIDENT_TRAFFIC_LIGHT:
                case INCIDENT_STOP_SIGN:
                    strT2 = null;
                    break;
                case INCIDENT_CONSTRUCTION:
                case INCIDENT_JAM:
                case INCIDENT_SPEED_LIMIT:
                case INCIDENT_HAZARD:
                case INCIDENT_BROKEN_TRAFFIC_LIGHT:
                case INCIDENT_POTHOLE:
                case INCIDENT_WEATHER:
                case INCIDENT_SLIPPERY_ROAD:
                default:
                    strT2 = dVar.q();
                    break;
            }
        } else {
            strT2 = dVar.q();
        }
        this.H = strT2;
        this.I = dVar.y();
        aj ajVar = (aj) com.google.android.libraries.navigation.internal.hc.a.e(dVar.k(), (dg) aj.a.aH(7, null), aj.a);
        if (ajVar != null) {
            this.N = ajVar.d;
            String str = ajVar.e;
            this.M = str;
            if (str.toString().isEmpty()) {
                this.M = this.N;
            }
        } else {
            this.N = null;
            this.M = null;
        }
        this.J = dVar.A();
        this.K = dVar.s();
        String strD = com.google.android.libraries.navigation.internal.jk.a.d(dVar.v());
        h hVar = this.B;
        ar.q(hVar);
        this.h = com.google.android.libraries.navigation.internal.jk.a.c(strD, hVar, this.b);
        this.E = dVar.J();
        com.google.android.libraries.navigation.internal.hc.a aVarI = dVar.i();
        this.F = aVarI == null ? com.google.android.libraries.navigation.internal.aap.d.a : (com.google.android.libraries.navigation.internal.aap.d) aVarI.d((dg) com.google.android.libraries.navigation.internal.aap.d.a.aH(7, null), com.google.android.libraries.navigation.internal.aap.d.a);
        com.google.android.libraries.navigation.internal.hc.a aVarC = dVar.c();
        this.G = aVarC == null ? com.google.android.libraries.navigation.internal.aap.d.a : (com.google.android.libraries.navigation.internal.aap.d) aVarC.d((dg) com.google.android.libraries.navigation.internal.aap.d.a.aH(7, null), com.google.android.libraries.navigation.internal.aap.d.a);
        this.P = dVar.b();
        Cdo cdoM4 = dVar.m();
        if (cdoM4 != null) {
            this.Q = com.google.android.libraries.navigation.internal.tt.e.a(cdoM4);
        }
        j jVar3 = aa.a;
        x xVarA = new x().a(dVar.B());
        i iVar = (i) com.google.android.libraries.navigation.internal.zq.l.a.q();
        int i3 = this.C ? com.google.android.libraries.navigation.internal.zq.k.c : com.google.android.libraries.navigation.internal.zq.k.b;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zq.l lVar = (com.google.android.libraries.navigation.internal.zq.l) iVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        lVar.c = i4;
        lVar.b |= 1;
        xVarA.f((com.google.android.libraries.navigation.internal.zq.l) iVar.t());
        this.O = xVarA.c();
    }
}
