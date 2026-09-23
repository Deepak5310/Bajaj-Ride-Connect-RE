package com.google.android.libraries.navigation.internal.bp;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.acd.nv;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.dh;
import com.google.android.libraries.navigation.internal.adr.dx;
import com.google.android.libraries.navigation.internal.adr.ec;
import com.google.android.libraries.navigation.internal.adr.ef;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.eo;
import com.google.android.libraries.navigation.internal.adr.ep;
import com.google.android.libraries.navigation.internal.adr.ew;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fc;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.fv;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.gu;
import com.google.android.libraries.navigation.internal.adr.gv;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.ix;
import com.google.android.libraries.navigation.internal.adr.iy;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.je;
import com.google.android.libraries.navigation.internal.adr.jf;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.ji;
import com.google.android.libraries.navigation.internal.adr.jk;
import com.google.android.libraries.navigation.internal.adr.jm;
import com.google.android.libraries.navigation.internal.adr.jo;
import com.google.android.libraries.navigation.internal.adr.kf;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.adr.ku;
import com.google.android.libraries.navigation.internal.afl.la;
import com.google.android.libraries.navigation.internal.afl.le;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.lo;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.me;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lg;
import com.google.android.libraries.navigation.internal.yz.lp;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.ZoneId;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bg {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.bg");
    private static final fy ab;
    public static final Instant b;
    public static final AtomicLong c;
    public int A;
    public boolean C;
    public int D;
    public volatile jg E;
    public final double[] F;
    final double[] G;
    public final ae H;
    public ev I;
    public int J;
    public final Duration K;
    public final Duration L;
    public final String M;
    public final Duration N;
    public final com.google.android.libraries.navigation.internal.adr.bm.a O;
    public final lr P;
    public final bf Q;
    public final boolean R;
    public com.google.android.libraries.navigation.internal.ael.x U;
    public int V;
    public final List W;
    public final com.google.android.libraries.navigation.internal.ael.x X;
    public final long Y;
    public final String Z;
    public final int aa;
    private final Instant ac;
    private volatile le ae;
    private final Duration af;
    public final mf d;
    public final String e;
    public final int f;
    public final cf g;
    public ev h;
    public Instant i;
    public final com.google.android.libraries.navigation.internal.ady.al j;
    public final boolean k;
    public final bq[] l;
    public final com.google.android.libraries.navigation.internal.oe.ad m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.geo.mapcore.internal.model.bp f353n;
    public final int o;
    public ev p;
    public final ev q;
    public final String r;
    public volatile ao s;
    public volatile ao t;
    public volatile ii u;
    public volatile nv v;
    public final b w;
    public volatile bl x;
    public volatile String y;
    public String z;
    private ce ad = null;
    public String B = "";
    public final be S = new be();
    public ii.a T = ii.a.DELAY_NODATA;

    static {
        new com.google.android.libraries.navigation.internal.yz.ba(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bp.bc
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return Integer.valueOf(((bt) obj).b);
            }
        }, lg.a);
        b = Instant.EPOCH;
        ab = fy.s(com.google.android.libraries.navigation.internal.ady.al.DRIVE, com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER, com.google.android.libraries.navigation.internal.ady.al.TAXI, com.google.android.libraries.navigation.internal.ady.al.TAXICAB);
        c = new AtomicLong(1L);
    }

    public bg(bd bdVar) {
        com.google.android.libraries.navigation.internal.ady.al alVar;
        ii.a aVarB;
        this.i = Instant.EPOCH;
        cf cfVar = bdVar.a;
        this.g = cfVar;
        this.Y = c.incrementAndGet();
        String str = bdVar.b;
        this.Z = str == null ? UUID.randomUUID().toString() : str;
        this.h = bdVar.c;
        this.x = bdVar.d;
        this.y = bdVar.e;
        this.j = bdVar.f;
        this.i = bdVar.I;
        this.ac = bdVar.J;
        this.aa = bdVar.L;
        bq[] bqVarArr = bdVar.i;
        this.l = bqVarArr == null ? new bq[0] : bqVarArr;
        com.google.android.libraries.navigation.internal.oe.ad adVar = bdVar.j;
        if (adVar == null || adVar.e() == 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('E')).p("Empty polyline in route.");
            this.m = com.google.android.libraries.navigation.internal.oe.ad.n(ev.q(new com.google.android.libraries.navigation.internal.oe.x(0, 0)));
        } else {
            this.m = adVar;
        }
        this.o = bdVar.k;
        this.r = bdVar.l;
        this.J = bdVar.m;
        this.H = bdVar.f352n;
        this.af = bdVar.o;
        this.K = bdVar.q;
        this.L = bdVar.r;
        this.M = bdVar.s;
        this.N = bdVar.t;
        this.k = bdVar.y;
        this.O = bdVar.z;
        this.P = bdVar.A;
        List list = bdVar.D;
        com.google.android.libraries.navigation.internal.yx.ar.q(list);
        this.W = list;
        mf mfVar = bdVar.E;
        af.o(mfVar);
        this.d = mfVar;
        this.e = bdVar.F;
        bf bfVar = bdVar.B;
        if (bfVar == null) {
            int iA = me.a(mfVar.e);
            bfVar = (iA == 0 ? me.a : iA) == me.c ? bf.OFFLINE : bf.ONLINE;
        }
        this.Q = bfVar;
        this.f = bdVar.G;
        this.X = bdVar.K;
        this.E = bdVar.w;
        this.ae = bdVar.x;
        this.w = bdVar.v;
        ki kiVar = cfVar.a;
        if ((kiVar.b & 2097152) != 0) {
            this.U = kiVar.t;
        } else {
            this.U = null;
        }
        this.v = null;
        ev evVar = bdVar.g;
        com.google.android.libraries.navigation.internal.yx.ar.q(evVar);
        this.p = evVar;
        cn.a(evVar.size());
        ev evVar2 = bdVar.h;
        com.google.android.libraries.navigation.internal.yx.ar.q(evVar2);
        this.q = evVar2;
        eq eqVar = new eq();
        boolean z = true;
        if (cfVar.b() > 0) {
            com.google.android.libraries.navigation.internal.yx.ar.k(cfVar.b() == this.p.size() + (-1));
            for (av avVar : cfVar.b) {
                if ((avVar.d().b & 256) != 0) {
                    com.google.android.libraries.navigation.internal.adr.cm cmVar = avVar.d().i;
                    aVarB = ii.a.b((cmVar == null ? com.google.android.libraries.navigation.internal.adr.cm.a : cmVar).d);
                    if (aVarB == null) {
                        aVarB = ii.a.DELAY_NODATA;
                    }
                } else {
                    aVarB = ii.a.DELAY_NODATA;
                }
                eqVar.h(aVarB);
            }
        } else {
            for (int i = 0; i < this.p.size() - 1; i++) {
                eqVar.h(ii.a.DELAY_NODATA);
            }
        }
        this.I = eqVar.g();
        double[] dArr = new double[this.m.e()];
        this.F = dArr;
        double[] dArr2 = new double[this.m.e()];
        this.G = dArr2;
        this.f353n = new com.google.android.libraries.geo.mapcore.internal.model.bp(this.m);
        com.google.android.libraries.navigation.internal.oe.ad adVar2 = this.m;
        if (adVar2.e() != 0) {
            double dC = 0.0d;
            dArr[0] = 0.0d;
            dArr2[0] = 0.0d;
            double d = 0.0d;
            for (int i2 = 1; i2 < dArr.length; i2++) {
                int i3 = i2 - 1;
                dC += (double) adVar2.c(i3);
                d += (double) adVar2.d(i3);
                dArr[i2] = dC;
                dArr2[i2] = d;
            }
        }
        bq[] bqVarArr2 = this.l;
        for (int i4 = 1; i4 < bqVarArr2.length; i4++) {
            bq bqVar = bqVarArr2[i4 - 1];
            bq bqVar2 = bqVarArr2[i4];
            bqVar.M = bqVar2;
            bqVar2.N = bqVar;
        }
        if (this.j == com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
            if (this.J == 0) {
                this.J = (int) Math.round(a(this.m.e() - 1));
            }
            for (bq bqVar3 : this.l) {
                if (this.j == com.google.android.libraries.navigation.internal.ady.al.TRANSIT && bqVar3.l == 0) {
                    double dA = a(bqVar3.k);
                    bq bqVar4 = bqVar3.N;
                    bqVar3.l = (int) Math.round(bqVar4 != null ? dA - a(bqVar4.k) : dA);
                }
            }
        }
        boolean zI = de.d(this.p).i(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.bp.az
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                com.google.android.libraries.navigation.internal.zb.j jVar = bg.a;
                return ((ck) obj).a() > 0;
            }
        });
        bq[] bqVarArr3 = this.l;
        Duration duration = ca.a;
        if (bqVarArr3.length != 0) {
            int i5 = 0;
            while (true) {
                if (i5 >= bqVarArr3.length) {
                    if (!this.ac.isAfter(b) && !zI) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    bq bqVar5 = bqVarArr3[i5];
                    if (bqVar5 != null && !bqVar5.A.isEmpty()) {
                        i5++;
                    }
                }
                z = false;
                break;
            }
        }
        z = false;
        break;
        this.R = z;
        R(ab.contains(this.j) ? bdVar.u : null, 0);
        ll llVar = this.d.c;
        Q((llVar == null ? ll.a : llVar).e, bdVar.G, bdVar.a.h(), o(this.d), bdVar.H);
        if (this.l.length != 0 || (alVar = this.j) == com.google.android.libraries.navigation.internal.ady.al.TAXI || alVar == com.google.android.libraries.navigation.internal.ady.al.FLY || alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE) {
            return;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(70)).x("%s routes must have >=1 steps (trip=%s)", this.j.name(), this.g.i());
    }

    public static dx D(el elVar, int i) {
        int i2;
        dx dxVar = (dx) el.a.r(elVar);
        com.google.android.libraries.navigation.internal.bn.e eVar = com.google.android.libraries.navigation.internal.bn.e.SELECTED_WITH_TRAFFIC;
        int i3 = elVar.c;
        if (i3 == 0) {
            i2 = eo.k;
        } else if (i3 == 18) {
            i2 = eo.a;
        } else if (i3 == 25) {
            i2 = eo.d;
        } else if (i3 == 36) {
            i2 = eo.j;
        } else if (i3 == 22) {
            i2 = eo.b;
        } else if (i3 != 23) {
            switch (i3) {
                case 27:
                    i2 = eo.e;
                    break;
                case 28:
                    i2 = eo.f;
                    break;
                case 29:
                    i2 = eo.g;
                    break;
                case 30:
                    i2 = eo.h;
                    break;
                case 31:
                    i2 = eo.i;
                    break;
                default:
                    i2 = 0;
                    break;
            }
        } else {
            i2 = eo.c;
        }
        if (i2 == 0) {
            throw null;
        }
        int i4 = i2 - 1;
        if (i4 == 0) {
            com.google.android.libraries.navigation.internal.adr.eq eqVar = elVar.c == 18 ? (com.google.android.libraries.navigation.internal.adr.eq) elVar.d : com.google.android.libraries.navigation.internal.adr.eq.a;
            ep epVar = (ep) com.google.android.libraries.navigation.internal.adr.eq.a.r(eqVar);
            int i5 = eqVar.c + i;
            if (!epVar.b.H()) {
                epVar.v();
            }
            com.google.android.libraries.navigation.internal.adr.eq eqVar2 = (com.google.android.libraries.navigation.internal.adr.eq) epVar.b;
            eqVar2.b |= 1;
            eqVar2.c = i5;
            if (!dxVar.b.H()) {
                dxVar.v();
            }
            el elVar2 = (el) dxVar.b;
            com.google.android.libraries.navigation.internal.adr.eq eqVar3 = (com.google.android.libraries.navigation.internal.adr.eq) epVar.t();
            eqVar3.getClass();
            elVar2.d = eqVar3;
            elVar2.c = 18;
        } else if (i4 == 1) {
            fh fhVar = elVar.c == 22 ? (fh) elVar.d : fh.a;
            com.google.android.libraries.navigation.internal.adr.ev evVar = (com.google.android.libraries.navigation.internal.adr.ev) fh.a.r(fhVar);
            if ((fhVar.b & 256) != 0) {
                ex exVar = fhVar.i;
                if (exVar == null) {
                    exVar = ex.a;
                }
                ex exVarAe = ae(exVar, i);
                if (!evVar.b.H()) {
                    evVar.v();
                }
                fh fhVar2 = (fh) evVar.b;
                exVarAe.getClass();
                fhVar2.i = exVarAe;
                fhVar2.b |= 256;
            }
            fg fgVar = fhVar.k;
            if (fgVar == null) {
                fgVar = fg.a;
            }
            if (fgVar.c == 4) {
                fg fgVar2 = fhVar.k;
                if (fgVar2 == null) {
                    fgVar2 = fg.a;
                }
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) fgVar2.aH(5, null);
                bbVar.x(fgVar2);
                fc fcVar = (fc) bbVar;
                fg fgVar3 = fhVar.k;
                if (fgVar3 == null) {
                    fgVar3 = fg.a;
                }
                ex exVarAe2 = ae(fgVar3.c == 4 ? (ex) fgVar3.d : ex.a, i);
                if (!fcVar.b.H()) {
                    fcVar.v();
                }
                fg fgVar4 = (fg) fcVar.b;
                exVarAe2.getClass();
                fgVar4.d = exVarAe2;
                fgVar4.c = 4;
                if (!evVar.b.H()) {
                    evVar.v();
                }
                fh fhVar3 = (fh) evVar.b;
                fg fgVar5 = (fg) fcVar.t();
                fgVar5.getClass();
                fhVar3.k = fgVar5;
                fhVar3.b |= 512;
            }
            if (!dxVar.b.H()) {
                dxVar.v();
            }
            el elVar3 = (el) dxVar.b;
            fh fhVar4 = (fh) evVar.t();
            fhVar4.getClass();
            elVar3.d = fhVar4;
            elVar3.c = 22;
        } else if (i4 == 7) {
            ef efVar = elVar.c == 30 ? (ef) elVar.d : ef.a;
            ec ecVar = (ec) ef.a.r(efVar);
            if ((efVar.b & 1) != 0) {
                com.google.android.libraries.navigation.internal.adr.bm bmVar = efVar.c;
                if (bmVar == null) {
                    bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                com.google.android.libraries.navigation.internal.adr.bk bkVar = (com.google.android.libraries.navigation.internal.adr.bk) com.google.android.libraries.navigation.internal.adr.bm.a.r(bmVar);
                int i6 = bmVar.c + i;
                if (!bkVar.b.H()) {
                    bkVar.v();
                }
                com.google.android.libraries.navigation.internal.adr.bm bmVar2 = (com.google.android.libraries.navigation.internal.adr.bm) bkVar.b;
                bmVar2.b |= 1;
                bmVar2.c = i6;
                if (!ecVar.b.H()) {
                    ecVar.v();
                }
                ef efVar2 = (ef) ecVar.b;
                com.google.android.libraries.navigation.internal.adr.bm bmVar3 = (com.google.android.libraries.navigation.internal.adr.bm) bkVar.t();
                bmVar3.getClass();
                efVar2.c = bmVar3;
                efVar2.b |= 1;
            }
            if (!dxVar.b.H()) {
                dxVar.v();
            }
            el elVar4 = (el) dxVar.b;
            ef efVar3 = (ef) ecVar.t();
            efVar3.getClass();
            elVar4.d = efVar3;
            elVar4.c = 30;
        }
        return dxVar;
    }

    public static jg F(jg jgVar, int i) {
        iz izVar = jgVar.j;
        if (izVar == null) {
            izVar = iz.a;
        }
        if ((izVar.b & 1) == 0) {
            return jgVar;
        }
        iz izVar2 = jgVar.j;
        if (izVar2 == null) {
            izVar2 = iz.a;
        }
        jf jfVar = izVar2.c;
        if (jfVar == null) {
            jfVar = jf.a;
        }
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) jgVar.aH(5, null);
        bbVar.x(jgVar);
        ix ixVar = (ix) bbVar;
        iz izVar3 = jgVar.j;
        if (izVar3 == null) {
            izVar3 = iz.a;
        }
        com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) izVar3.aH(5, null);
        bbVar2.x(izVar3);
        iy iyVar = (iy) bbVar2;
        com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) jfVar.aH(5, null);
        bbVar3.x(jfVar);
        je jeVar = (je) bbVar3;
        int i2 = jfVar.c + i;
        if (!jeVar.b.H()) {
            jeVar.v();
        }
        jf jfVar2 = (jf) jeVar.b;
        jfVar2.b |= 1;
        jfVar2.c = i2;
        if (!iyVar.b.H()) {
            iyVar.v();
        }
        iz izVar4 = (iz) iyVar.b;
        jf jfVar3 = (jf) jeVar.t();
        jfVar3.getClass();
        izVar4.c = jfVar3;
        izVar4.b |= 1;
        if (!ixVar.b.H()) {
            ixVar.v();
        }
        jg jgVar2 = (jg) ixVar.b;
        iz izVar5 = (iz) iyVar.t();
        izVar5.getClass();
        jgVar2.j = izVar5;
        jgVar2.b |= 64;
        return (jg) ixVar.t();
    }

    /* JADX WARN: Code duplicated, block: B:214:0x04b1  */
    /* JADX WARN: Multi-variable type inference failed */
    public static bd ad(af afVar, Instant instant, Instant instant2, int i, Context context, int i2, ev evVar, ev evVar2, boolean z, lr lrVar) {
        ev evVarO;
        Duration durationA;
        String str;
        bd bdVar;
        cf cfVar;
        int length;
        bt btVar;
        bt btVar2;
        jg jgVar;
        jo joVar;
        el elVar;
        cf cfVar2;
        av avVar;
        bd bdVar2;
        aw awVar;
        com.google.android.libraries.navigation.internal.adr.fy fyVar;
        String quantityString;
        String str2;
        Resources resources;
        bq bqVar;
        if (afVar == null) {
            return null;
        }
        cf cfVarE = afVar.e(i);
        if (cfVarE != null) {
            com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(cfVarE.f().c);
            if (alVarB == null) {
                alVarB = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
            }
            if (alVarB != com.google.android.libraries.navigation.internal.ady.al.BIKESHARING ? cfVarE.j() : cfVarE.j() && x.d(cfVarE).d) {
                com.google.android.libraries.navigation.internal.ady.al alVarB2 = com.google.android.libraries.navigation.internal.ady.al.b(cfVarE.f().c);
                if (alVarB2 == null) {
                    alVarB2 = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
                }
                int iB = afVar.l() ? afVar.b() : afVar.a();
                if (iB < 0 || iB >= afVar.c()) {
                    iB = 0;
                }
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) lrVar.aH(5, null);
                bbVar.x(lrVar);
                lo loVar = (lo) bbVar;
                com.google.android.libraries.navigation.internal.ady.n nVar = ((lr) loVar.b).t;
                if (nVar == null) {
                    nVar = com.google.android.libraries.navigation.internal.ady.n.a;
                }
                if ((nVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.ady.n nVar2 = ((lr) loVar.b).t;
                    if (nVar2 == null) {
                        nVar2 = com.google.android.libraries.navigation.internal.ady.n.a;
                    }
                    com.google.android.libraries.navigation.internal.ady.i iVar = (com.google.android.libraries.navigation.internal.ady.i) com.google.android.libraries.navigation.internal.ady.n.a.r(nVar2);
                    if (!iVar.b.H()) {
                        iVar.v();
                    }
                    com.google.android.libraries.navigation.internal.ady.n nVar3 = (com.google.android.libraries.navigation.internal.ady.n) iVar.b;
                    nVar3.d = null;
                    nVar3.b &= -2;
                    lh lhVar = afVar.j().c;
                    if (lhVar == null) {
                        lhVar = lh.a;
                    }
                    iVar.c(de.d(lhVar.f318n).c(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.bp.ba
                        @Override // com.google.android.libraries.navigation.internal.yx.as
                        public final boolean a(Object obj) {
                            return (((com.google.android.libraries.navigation.internal.afl.lg) obj).b & 1) != 0;
                        }
                    }).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.bp.bb
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            com.google.android.libraries.navigation.internal.zb.j jVar = bg.a;
                            com.google.android.libraries.navigation.internal.ady.j jVar2 = (com.google.android.libraries.navigation.internal.ady.j) com.google.android.libraries.navigation.internal.ady.k.a.q();
                            com.google.android.libraries.navigation.internal.adu.h hVar = ((com.google.android.libraries.navigation.internal.afl.lg) obj).c;
                            if (hVar == null) {
                                hVar = com.google.android.libraries.navigation.internal.adu.h.a;
                            }
                            if (!jVar2.b.H()) {
                                jVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.ady.k kVar = (com.google.android.libraries.navigation.internal.ady.k) jVar2.b;
                            hVar.getClass();
                            kVar.c = hVar;
                            kVar.b |= 2;
                            return (com.google.android.libraries.navigation.internal.ady.k) jVar2.t();
                        }
                    }));
                    if (!loVar.b.H()) {
                        loVar.v();
                    }
                    lr lrVar2 = (lr) loVar.b;
                    com.google.android.libraries.navigation.internal.ady.n nVar4 = (com.google.android.libraries.navigation.internal.ady.n) iVar.t();
                    nVar4.getClass();
                    lrVar2.t = nVar4;
                    lrVar2.c |= 2048;
                }
                bd bdVar3 = new bd(cfVarE);
                if (afVar.b.k.size() != 1) {
                    int i3 = ev.d;
                    evVarO = lv.a;
                    break;
                }
                com.google.android.libraries.navigation.internal.adr.bb bbVar2 = (com.google.android.libraries.navigation.internal.adr.bb) afVar.b.k.get(0);
                int i4 = 0;
                while (true) {
                    if (i4 >= bbVar2.b.size()) {
                        int i5 = ev.d;
                        evVarO = lv.a;
                        break;
                    }
                    com.google.android.libraries.navigation.internal.adr.ba baVar = (com.google.android.libraries.navigation.internal.adr.ba) bbVar2.b.get(i4);
                    if (baVar.b == 1 && ((Integer) baVar.c).intValue() == i) {
                        evVarO = ev.o(baVar.d);
                        break;
                    }
                    i4++;
                }
                bdVar3.c = evVarO;
                bdVar3.I = instant;
                bdVar3.J = instant2;
                bdVar3.f = alVarB2;
                bdVar3.L = i2;
                bdVar3.y = z;
                bdVar3.A = (lr) loVar.t();
                boolean z2 = i == iB;
                bdVar3.E = afVar.a;
                bdVar3.F = afVar.c;
                bdVar3.G = i;
                bdVar3.H = z2;
                bdVar3.C = (afVar.b.b & 4096) != 0 ? com.google.android.libraries.navigation.internal.ael.x.t(afVar.n()) : null;
                com.google.android.libraries.navigation.internal.oe.ad adVarF = afVar.f(cfVarE);
                if (adVarF == null) {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('C')).p("Trip had no compact polyline.");
                } else {
                    bdVar3.k = (cfVarE.j() && cfVarE.a() < afVar.b.i.size()) ? ((la) afVar.b.i.get(cfVarE.a())).e : 0;
                }
                if (adVarF == null || adVarF.e() == 0) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(63)).p("Bad polyline in route builder.");
                    return null;
                }
                if (adVarF.e() == 1) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(66)).p("Single vertex polyline in route builder.");
                }
                bdVar3.j = adVarF;
                Cif cifD = cfVarE.b() > 1 ? cfVarE.c(0).d() : cfVarE.f();
                com.google.android.libraries.navigation.internal.aap.d dVar = cifD.f;
                if (dVar == null) {
                    dVar = com.google.android.libraries.navigation.internal.aap.d.a;
                }
                Duration durationA2 = com.google.android.libraries.navigation.internal.bw.a.a(dVar);
                com.google.android.libraries.navigation.internal.adr.cm cmVar = cifD.i;
                if (cmVar == null) {
                    cmVar = com.google.android.libraries.navigation.internal.adr.cm.a;
                }
                if ((cmVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.aap.d dVar2 = cmVar.c;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
                    }
                    durationA = com.google.android.libraries.navigation.internal.bw.a.a(dVar2);
                } else {
                    durationA = durationA2;
                }
                bdVar3.o = durationA;
                bdVar3.p = durationA.minus(durationA2);
                com.google.android.libraries.navigation.internal.adr.cb cbVar = cmVar.f;
                if (cbVar == null) {
                    cbVar = com.google.android.libraries.navigation.internal.adr.cb.a;
                }
                bdVar3.q = Duration.ofSeconds(cbVar.b);
                com.google.android.libraries.navigation.internal.adr.cb cbVar2 = cmVar.f;
                if (cbVar2 == null) {
                    cbVar2 = com.google.android.libraries.navigation.internal.adr.cb.a;
                }
                bdVar3.r = Duration.ofSeconds(cbVar2.c);
                com.google.android.libraries.navigation.internal.adr.cb cbVar3 = cmVar.f;
                if (cbVar3 == null) {
                    cbVar3 = com.google.android.libraries.navigation.internal.adr.cb.a;
                }
                bdVar3.s = cbVar3.d;
                com.google.android.libraries.navigation.internal.aap.d dVar3 = cmVar.g;
                if (dVar3 == null) {
                    dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
                }
                bdVar3.t = com.google.android.libraries.navigation.internal.bw.a.a(dVar3);
                bdVar3.d = cfVarE.c;
                ki kiVar = cfVarE.a;
                bdVar3.e = (kiVar.b & 524288) != 0 ? kiVar.s : null;
                if ((cmVar.b & 64) != 0) {
                    bdVar3.K = cmVar.h;
                }
                String str3 = "";
                if (alVarB2 == com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                    av avVarC = cfVarE.c(0);
                    ck ckVar = (ck) evVar.get(1);
                    Resources resources2 = context.getResources();
                    com.google.android.libraries.navigation.internal.adr.fy fyVarE = cfVarE.e();
                    aw awVarA = aw.a();
                    int iA = avVarC.a();
                    com.google.android.libraries.navigation.internal.ady.al alVar = null;
                    jo joVar2 = null;
                    int i6 = 0;
                    while (i6 < iA) {
                        bt btVarB = avVarC.b(i6);
                        int i7 = iA;
                        Cif cifG = btVarB.g();
                        com.google.android.libraries.navigation.internal.ady.al alVarB3 = com.google.android.libraries.navigation.internal.ady.al.WALK;
                        String str4 = str3;
                        if ((cifG.b & 1) != 0 && (alVarB3 = com.google.android.libraries.navigation.internal.ady.al.b(cifG.c)) == null) {
                            alVarB3 = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
                        }
                        com.google.android.libraries.navigation.internal.ady.al alVar2 = alVarB3;
                        int iA2 = btVarB.a();
                        if (alVar2 != alVar) {
                            awVarA.d = null;
                            awVarA.c();
                        }
                        if (alVar2 == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar2 == com.google.android.libraries.navigation.internal.ady.al.TAXI || alVar2 == com.google.android.libraries.navigation.internal.ady.al.BICYCLE || alVar2 == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
                            cfVar2 = cfVarE;
                            avVar = avVarC;
                            bdVar2 = bdVar3;
                            awVar = awVarA;
                            fyVar = fyVarE;
                            ax.f(btVarB, awVar, adVarF, ckVar, fyVar);
                        } else {
                            if (alVar2 == com.google.android.libraries.navigation.internal.ady.al.WALK) {
                                int i8 = 0;
                                while (i8 < iA2) {
                                    com.google.android.libraries.navigation.internal.adr.fy fyVar2 = fyVarE;
                                    int i9 = awVarA.c;
                                    Resources resources3 = resources2;
                                    bq bqVarB = btVarB.b(i8, i9, awVarA.a.size());
                                    int i10 = i8;
                                    awVarA.c = i9 + bqVarB.A.size();
                                    String string = bqVarB.p.toString();
                                    if (joVar2 == null || awVarA.a.isEmpty()) {
                                        resources = resources3;
                                        bqVar = bqVarB;
                                    } else {
                                        List list = awVarA.a;
                                        resources = resources3;
                                        bqVar = bqVarB;
                                        list.add(ax.a(list.size(), awVarA.b(), joVar2, bqVar, adVarF, resources));
                                    }
                                    String str5 = (iA2 == 1 && com.google.android.libraries.navigation.internal.yx.aq.c(string) && (cifG.b & 2) != 0) ? cifG.d : string;
                                    com.google.android.libraries.navigation.internal.yx.ao aoVarB = ax.b(adVarF, bqVar.k);
                                    bp bpVarA = bqVar.a();
                                    bpVarA.g = awVarA.a.size();
                                    bpVarA.f = adVarF.l(bqVar.k);
                                    bpVarA.i = str5;
                                    bpVarA.o = ((Float) aoVarB.a).floatValue();
                                    bpVarA.p = ((Float) aoVarB.b).floatValue();
                                    ax.d(bpVarA, awVarA.d);
                                    awVarA.a.add(new bq(bpVarA));
                                    awVarA.d = bqVar.a;
                                    i8 = i10 + 1;
                                    resources2 = resources;
                                    awVarA = awVarA;
                                    fyVarE = fyVar2;
                                    cfVarE = cfVarE;
                                    joVar2 = null;
                                }
                                cfVar2 = cfVarE;
                                awVar = awVarA;
                                fyVar = fyVarE;
                            } else {
                                cfVar2 = cfVarE;
                                awVar = awVarA;
                                fyVar = fyVarE;
                                Resources resources4 = resources2;
                                if (alVar2 != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                                    resources2 = resources4;
                                    avVar = avVarC;
                                    bdVar2 = bdVar3;
                                    alVar2.name();
                                } else if (iA2 <= 0 || !btVarB.j()) {
                                    resources2 = resources4;
                                } else {
                                    int i11 = awVar.c;
                                    bq bqVarB2 = btVarB.b(0, i11, awVar.a.size());
                                    awVar.c = i11 + bqVarB2.A.size();
                                    if (joVar2 == null) {
                                        joVar2 = null;
                                    } else if (!awVar.a.isEmpty()) {
                                        List list2 = awVar.a;
                                        list2.add(ax.a(list2.size(), awVar.b(), joVar2, bqVarB2, adVarF, resources4));
                                    }
                                    jo joVarH = btVarB.h();
                                    jk jkVar = joVarH.c;
                                    if (jkVar == null) {
                                        jkVar = jk.a;
                                    }
                                    String str6 = jkVar.c;
                                    String str7 = cifG.d;
                                    jo joVarH2 = btVarB.h();
                                    String strC = ax.c(btVarB.f().b);
                                    if (strC != null) {
                                        avVar = avVarC;
                                        bdVar2 = bdVar3;
                                    } else {
                                        if (joVarH2.h.size() == 0) {
                                            bdVar2 = bdVar3;
                                            avVar = avVarC;
                                            ((com.google.android.libraries.navigation.internal.zb.h) ax.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('6')).p("Could not compute the route name. No block transfer legs.");
                                        } else {
                                            avVar = avVarC;
                                            bdVar2 = bdVar3;
                                            ji jiVar = ((com.google.android.libraries.navigation.internal.adr.t) joVarH2.h.get(0)).b;
                                            if (jiVar == null) {
                                                jiVar = ji.a;
                                            }
                                            strC = ax.c(jiVar.b);
                                            if (strC == null) {
                                                ((com.google.android.libraries.navigation.internal.zb.h) ax.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('5')).p("Could not find a route name in the renderable components.");
                                            }
                                        }
                                        strC = str4;
                                    }
                                    String strC2 = com.google.android.libraries.navigation.internal.br.s.c(btVarB.f().b);
                                    if (strC2 == null) {
                                        jo joVarH3 = btVarB.h();
                                        if (joVarH3.h.size() == 0) {
                                            strC2 = null;
                                        } else {
                                            ji jiVar2 = ((com.google.android.libraries.navigation.internal.adr.t) joVarH3.h.get(0)).b;
                                            if (jiVar2 == null) {
                                                jiVar2 = ji.a;
                                            }
                                            strC2 = com.google.android.libraries.navigation.internal.br.s.c(jiVar2.b);
                                        }
                                    }
                                    if ((cifG.b & 32) != 0) {
                                        jm jmVar = cifG.g;
                                        if (jmVar == null) {
                                            jmVar = jm.a;
                                        }
                                        int i12 = jmVar.b;
                                        resources2 = resources4;
                                        quantityString = resources2.getQuantityString(com.google.android.libraries.navigation.internal.qr.d.b, i12, Integer.valueOf(i12));
                                    } else {
                                        resources2 = resources4;
                                        quantityString = null;
                                    }
                                    com.google.android.libraries.navigation.internal.adr.de deVar = joVarH.f;
                                    if (deVar == null) {
                                        deVar = com.google.android.libraries.navigation.internal.adr.de.a;
                                    }
                                    if (deVar == null) {
                                        str2 = str4;
                                    } else {
                                        int i13 = deVar.b;
                                        if ((i13 & 2) != 0) {
                                            str2 = deVar.d;
                                        } else if ((i13 & 1) != 0) {
                                            str2 = deVar.c;
                                        } else {
                                            str2 = str4;
                                        }
                                    }
                                    String string2 = joVar2 == null ? resources2.getString(com.google.android.libraries.navigation.internal.qr.e.s, com.google.android.libraries.navigation.internal.br.t.a(resources2, strC, str2, str7), str6) : resources2.getString(com.google.android.libraries.navigation.internal.qr.e.u, com.google.android.libraries.navigation.internal.br.t.a(resources2, strC, str2, str7), str6);
                                    if (string2 != null) {
                                        com.google.android.libraries.navigation.internal.yx.ao aoVarB2 = ax.b(adVarF, bqVarB2.k);
                                        bp bpVarA2 = bqVarB2.a();
                                        bpVarA2.g = awVar.a.size();
                                        bpVarA2.i = string2;
                                        bpVarA2.f = adVarF.l(bqVarB2.k);
                                        bpVarA2.h = bqVarB2.k;
                                        bpVarA2.A = strC2;
                                        bpVarA2.B = quantityString;
                                        bpVarA2.o = ((Float) aoVarB2.a).floatValue();
                                        bpVarA2.p = ((Float) aoVarB2.b).floatValue();
                                        bpVarA2.a = com.google.android.libraries.navigation.internal.aap.l.DEPART;
                                        if (awVar.a.isEmpty()) {
                                            bv bvVar = new bv();
                                            bvVar.a = dh.PREPARE;
                                            bvVar.b();
                                            bpVarA2.s = ev.q(new bw(bvVar));
                                        }
                                        awVar.a.add(new bq(bpVarA2));
                                    }
                                    joVar2 = joVarH;
                                }
                            }
                            avVar = avVarC;
                            bdVar2 = bdVar3;
                        }
                        i6++;
                        avVarC = avVar;
                        iA = i7;
                        awVarA = awVar;
                        fyVarE = fyVar;
                        alVar = alVar2;
                        bdVar3 = bdVar2;
                        cfVarE = cfVar2;
                        str3 = str4;
                    }
                    cf cfVar3 = cfVarE;
                    av avVar2 = avVarC;
                    str = str3;
                    bd bdVar4 = bdVar3;
                    aw awVar2 = awVarA;
                    if (joVar2 == null) {
                        joVar = null;
                    } else if (awVar2.a.isEmpty()) {
                        joVar = joVar2;
                    } else {
                        List list3 = awVar2.a;
                        list3.add(ax.a(list3.size(), awVar2.b(), joVar2, null, adVarF, resources2));
                        joVar = null;
                    }
                    String strV = ckVar.V();
                    if (joVar != null) {
                        jk jkVar2 = joVar.d;
                        if (jkVar2 == null) {
                            jkVar2 = jk.a;
                        }
                        strV = jkVar2.c;
                    }
                    int iE = adVarF.e() - 1;
                    com.google.android.libraries.navigation.internal.yx.ao aoVarB3 = ax.b(adVarF, iE);
                    bp bpVar = new bp();
                    bpVar.f = adVarF.k();
                    bpVar.a = com.google.android.libraries.navigation.internal.aap.l.DESTINATION;
                    bpVar.b = hs.SIDE_UNSPECIFIED;
                    bpVar.c = hu.TURN_UNKNOWN;
                    bpVar.h = iE;
                    bpVar.o = ((Float) aoVarB3.a).floatValue();
                    bpVar.p = ((Float) aoVarB3.b).floatValue();
                    bpVar.i = strV;
                    bpVar.g = awVar2.a.size();
                    int iA3 = avVar2.a();
                    if (iA3 > 0) {
                        bt btVarB2 = avVar2.b(iA3 - 1);
                        elVar = null;
                        for (int iA4 = btVarB2.a() - 1; iA4 >= 0; iA4--) {
                            hv hvVarE = btVarB2.e(iA4);
                            Duration duration = ca.a;
                            Cif cif = hvVarE.d;
                            if (cif == null) {
                                cif = Cif.a;
                            }
                            Iterator it2 = cif.h.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    elVar = null;
                                    break;
                                }
                                el elVar2 = (el) it2.next();
                                fp fpVarB = fp.b(elVar2.g);
                                if (fpVarB == null) {
                                    fpVarB = fp.UNKNOWN;
                                }
                                if (fpVarB.equals(fp.SIDE_OF_ROAD)) {
                                    elVar = elVar2;
                                    break;
                                }
                            }
                            if (elVar != null) {
                                break;
                            }
                        }
                    } else {
                        elVar = null;
                    }
                    if (elVar != null) {
                        bpVar.r = ev.q(elVar);
                    }
                    bv bvVar2 = new bv();
                    bvVar2.a = dh.SUCCESS;
                    bvVar2.b();
                    bpVar.s = ev.q(new bw(bvVar2));
                    awVar2.a.add(new bq(bpVar));
                    bdVar = bdVar4;
                    bdVar.i = awVar2.d();
                    cfVar = cfVar3;
                } else {
                    str = "";
                    bdVar = bdVar3;
                    if (alVarB2 == com.google.android.libraries.navigation.internal.ady.al.BIKESHARING) {
                        Resources resources5 = context.getResources();
                        y yVarD = x.d(cfVarE);
                        cfVar = cfVarE;
                        bq[] bqVarArrE = ax.e(cfVar.b, adVarF, evVar, cfVar.e());
                        if (yVarD.equals(y.DOCKLESS_BIKESHARING)) {
                            int i14 = 0;
                            while (i14 < bqVarArrE.length - 1) {
                                bq bqVar2 = bqVarArrE[i14];
                                int i15 = i14 + 1;
                                bq bqVar3 = bqVarArrE[i15];
                                if (bqVar2.d == com.google.android.libraries.navigation.internal.aap.l.DESTINATION && bqVar2.t && (btVar2 = bqVar3.b) != null) {
                                    Cif cif2 = btVar2.a.c;
                                    if (cif2 == null) {
                                        cif2 = Cif.a;
                                    }
                                    com.google.android.libraries.navigation.internal.adr.p pVar = cif2.k;
                                    if (pVar == null) {
                                        pVar = com.google.android.libraries.navigation.internal.adr.p.a;
                                    }
                                    if ((pVar.b & 1) != 0) {
                                        com.google.android.libraries.navigation.internal.adr.bs bsVarD = btVar2.d();
                                        bq bqVar4 = bqVarArrE[i14];
                                        Duration duration2 = ca.a;
                                        bp bpVarA3 = bqVar4.a();
                                        int i16 = com.google.android.libraries.navigation.internal.bx.g.k;
                                        fv fvVar = bsVarD.d;
                                        if (fvVar == null) {
                                            fvVar = fv.a;
                                        }
                                        bpVarA3.i = resources5.getString(i16, fvVar.c);
                                        bpVarA3.j = null;
                                        fv fvVar2 = bsVarD.d;
                                        if (fvVar2 == null) {
                                            fvVar2 = fv.a;
                                        }
                                        com.google.android.libraries.navigation.internal.adr.ah ahVar = fvVar2.d;
                                        if (ahVar == null) {
                                            ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
                                        }
                                        bpVarA3.A = ahVar.d;
                                        bpVarA3.r = lv.a;
                                        bpVarA3.I = true;
                                        bqVarArrE[i14] = new bq(bpVarA3);
                                    }
                                }
                                i14 = i15;
                            }
                        } else if (yVarD.equals(y.DOCKED_BIKESHARING)) {
                            int i17 = 0;
                            while (true) {
                                length = bqVarArrE.length;
                                if (i17 >= length - 1) {
                                    break;
                                }
                                bq bqVar5 = bqVarArrE[i17];
                                int i18 = i17 + 1;
                                bq bqVar6 = bqVarArrE[i18];
                                if (bqVar5.d == com.google.android.libraries.navigation.internal.aap.l.DESTINATION && bqVar5.t) {
                                    bt btVar3 = bqVar5.b;
                                    if (btVar3 == null || !btVar3.i()) {
                                        bt btVar4 = bqVar6.b;
                                        if (btVar4 != null && btVar4.i()) {
                                            bqVarArrE[i17] = ca.b(resources5, btVar4.c(), bqVarArrE[i17]);
                                        }
                                    } else {
                                        com.google.android.libraries.navigation.internal.adr.bq bqVarC = btVar3.c();
                                        bp bpVarA4 = bqVarArrE[i17].a();
                                        com.google.android.libraries.navigation.internal.adr.bo boVar = bqVarC.e;
                                        if (boVar == null) {
                                            boVar = com.google.android.libraries.navigation.internal.adr.bo.a;
                                        }
                                        int i19 = boVar.d;
                                        bpVarA4.i = resources5.getString(com.google.android.libraries.navigation.internal.bx.g.i) + " · " + resources5.getQuantityString(com.google.android.libraries.navigation.internal.bx.e.b, i19, Integer.valueOf(i19));
                                        bpVarA4.j = null;
                                        fv fvVar3 = bqVarC.c;
                                        if (fvVar3 == null) {
                                            fvVar3 = fv.a;
                                        }
                                        com.google.android.libraries.navigation.internal.adr.ah ahVar2 = fvVar3.d;
                                        if (ahVar2 == null) {
                                            ahVar2 = com.google.android.libraries.navigation.internal.adr.ah.a;
                                        }
                                        bpVarA4.A = ahVar2.d;
                                        bpVarA4.r = lv.a;
                                        bqVarArrE[i17] = new bq(bpVarA4);
                                    }
                                }
                                i17 = i18;
                            }
                            if (length != 0 && (btVar = bqVarArrE[0].b) != null && btVar.i()) {
                                bq bqVarB3 = ca.b(resources5, btVar.c(), bqVarArrE[0]);
                                Object[] objArrA = lp.a(bqVarArrE, length + 1);
                                objArrA[0] = bqVarB3;
                                System.arraycopy(bqVarArrE, 0, objArrA, 1, length);
                                bqVarArrE = (bq[]) objArrA;
                            }
                        }
                        bdVar.i = bqVarArrE;
                    } else {
                        cfVar = cfVarE;
                        if (cfVar.b() > 0) {
                            bdVar.i = ax.e(cfVar.b, adVarF, evVar, cfVar.e());
                        }
                    }
                }
                Cif cifF = cfVar.f();
                com.google.android.libraries.navigation.internal.adr.cm cmVar2 = cifF.i;
                if (cmVar2 == null) {
                    cmVar2 = com.google.android.libraries.navigation.internal.adr.cm.a;
                }
                j jVar = new j();
                com.google.android.libraries.navigation.internal.aap.d dVar4 = cifF.f;
                if (dVar4 == null) {
                    dVar4 = com.google.android.libraries.navigation.internal.aap.d.a;
                }
                jVar.b(com.google.android.libraries.navigation.internal.bw.a.a(dVar4));
                if ((cmVar2.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.aap.d dVar5 = cmVar2.c;
                    if (dVar5 == null) {
                        dVar5 = com.google.android.libraries.navigation.internal.aap.d.a;
                    }
                    jVar.a = com.google.android.libraries.navigation.internal.bw.a.a(dVar5);
                }
                bdVar.f352n = jVar.a();
                com.google.android.libraries.navigation.internal.adr.bm bmVar = cifF.e;
                if (bmVar == null) {
                    bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                bdVar.m = bmVar.c;
                bdVar.l = (cifF.b & 2) != 0 ? cifF.d : str;
                bdVar.g = ev.o(evVar);
                bdVar.h = ev.o(evVar2);
                com.google.android.libraries.navigation.internal.adr.bm bmVar2 = cifF.e;
                if (bmVar2 == null) {
                    bmVar2 = com.google.android.libraries.navigation.internal.adr.bm.a;
                }
                if ((bmVar2.b & 4) != 0) {
                    com.google.android.libraries.navigation.internal.adr.bm bmVar3 = cifF.e;
                    if (bmVar3 == null) {
                        bmVar3 = com.google.android.libraries.navigation.internal.adr.bm.a;
                    }
                    com.google.android.libraries.navigation.internal.adr.bm.a aVarB = com.google.android.libraries.navigation.internal.adr.bm.a.b(bmVar3.d);
                    if (aVarB == null) {
                        aVarB = com.google.android.libraries.navigation.internal.adr.bm.a.REGIONAL;
                    }
                    bdVar.z = aVarB;
                } else {
                    if ((cifF.b & 4) != 0) {
                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('@')).p("Attempt to create a route from a Trip that doesn't have recommended distance units");
                    }
                    bdVar.z = com.google.android.libraries.navigation.internal.adr.bm.a.KILOMETERS;
                }
                bdVar.u = cfVar.g();
                ki kiVar2 = cfVar.a;
                if ((kiVar2.b & 131072) != 0) {
                    jgVar = kiVar2.q;
                    if (jgVar == null) {
                        jgVar = jg.a;
                    }
                } else {
                    jgVar = null;
                }
                bdVar.w = jgVar;
                bdVar.x = (afVar.b.b & 65536) != 0 ? afVar.i() : null;
                bdVar.D = new ArrayList(cfVar.a.m);
                if ((lrVar.c & 8192) != 0) {
                    bdVar.v = f.a(cfVar.b);
                }
                return bdVar;
            }
        }
        return null;
    }

    private static ex ae(ex exVar, int i) {
        ew ewVar = (ew) ex.a.r(exVar);
        int i2 = exVar.c + i;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        ex exVar2 = (ex) ewVar.b;
        exVar2.b |= 1;
        exVar2.c = i2;
        return (ex) ewVar.t();
    }

    private final boolean af(bq bqVar) {
        com.google.android.libraries.navigation.internal.aap.l lVar = bqVar.d;
        com.google.android.libraries.navigation.internal.aap.l lVar2 = com.google.android.libraries.navigation.internal.aap.l.DESTINATION;
        com.google.android.libraries.navigation.internal.ady.al alVar = com.google.android.libraries.navigation.internal.ady.al.TRANSIT;
        boolean z = lVar == lVar2;
        if (this.j == alVar) {
            return z && bqVar.i == j() + (-1);
        }
        return z;
    }

    public static int o(mf mfVar) {
        com.google.android.libraries.navigation.internal.afl.lv lvVar = mfVar.f;
        if (lvVar == null) {
            lvVar = com.google.android.libraries.navigation.internal.afl.lv.a;
        }
        if ((lvVar.b & 1) == 0) {
            return -1;
        }
        com.google.android.libraries.navigation.internal.afl.lv lvVar2 = mfVar.f;
        if (lvVar2 == null) {
            lvVar2 = com.google.android.libraries.navigation.internal.afl.lv.a;
        }
        return lvVar2.c;
    }

    public final ev A() {
        ev evVar = this.p;
        return evVar.subList(1, evVar.size());
    }

    public final ev B() {
        ev evVar = this.p;
        if (evVar != null) {
            return evVar;
        }
        int i = ev.d;
        return lv.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ev C() {
        int i = ev.d;
        eq eqVar = new eq();
        for (int i2 = 1; i2 < this.p.size(); i2++) {
            ck ckVar = (ck) this.p.get(i2);
            com.google.android.libraries.navigation.internal.oe.r rVarN = ckVar.n();
            if (rVarN != null) {
                v vVar = new v();
                vVar.b(0L);
                vVar.c(0);
                vVar.b = 0;
                Objects.requireNonNull(rVarN);
                vVar.a = rVarN;
                com.google.android.libraries.navigation.internal.oe.j jVarM = ckVar.m();
                if (jVarM != null) {
                    vVar.b(jVarM.c);
                }
                int iL = ckVar.L();
                if (iL != 0) {
                    vVar.b = iL;
                    vVar.c(ckVar.a());
                }
                cm cmVarA = vVar.a();
                com.google.android.libraries.navigation.internal.yx.ar.r(((w) cmVarA).a, "Missing required position.");
                eqVar.h(cmVarA);
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('D')).p("Resolved destination with null lat/lng");
            }
        }
        return eqVar.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ii.a E() {
        return (ii.a) this.I.get(0);
    }

    public final String G() {
        return this.g.a.d;
    }

    public final Duration H() {
        return this.j != com.google.android.libraries.navigation.internal.ady.al.TRANSIT ? this.af : I();
    }

    public final Duration I() {
        kf kfVar = this.g.a.v;
        if (kfVar == null) {
            kfVar = kf.a;
        }
        com.google.android.libraries.navigation.internal.aap.d dVar = kfVar.b;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        return Duration.ofSeconds(dVar.e);
    }

    public final Duration J(double d) {
        if (this.t != null) {
            return this.t.c(d);
        }
        return this.s != null ? this.s.c(d) : Duration.ZERO;
    }

    public final Duration K(double d, double d2) {
        return d2 <= d ? Duration.ZERO : J(d).minus(J(d2));
    }

    public final Duration L(double d) {
        return K(d, i());
    }

    public final ZoneId M() {
        if (this.g.a.h.size() <= 0) {
            return ZoneId.systemDefault();
        }
        com.google.android.libraries.navigation.internal.adr.ar arVar = ((gj) this.g.a.h.get(0)).f;
        if (arVar == null) {
            arVar = com.google.android.libraries.navigation.internal.adr.ar.a;
        }
        String str = arVar.c;
        if (com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
            return ZoneId.systemDefault();
        }
        ZoneId zoneIdA = com.google.android.libraries.navigation.internal.ja.b.a(str);
        return zoneIdA != null ? zoneIdA : ZoneId.of(TimeZones.GMT_ID);
    }

    public final List N() {
        return this.m.q();
    }

    public final List O() {
        bq[] bqVarArrAa = aa();
        ArrayList arrayList = new ArrayList(bqVarArrAa.length);
        int i = 0;
        while (i < bqVarArrAa.length) {
            arrayList.add(new com.google.android.libraries.navigation.internal.oe.an(this.m, i == 0 ? 0 : bqVarArrAa[i - 1].k, bqVarArrAa[i].k + 1));
            i++;
        }
        return arrayList;
    }

    public final List P(double d) {
        bq[] bqVarArrAa = aa();
        ArrayList arrayList = new ArrayList(bqVarArrAa.length);
        for (bq bqVar : bqVarArrAa) {
            arrayList.add(K(d, a(bqVar.k)));
        }
        return arrayList;
    }

    public final void Q(String str, int i, String str2, int i2, boolean z) {
        this.A = i;
        this.B = str2;
        this.z = str;
        this.D = i2;
        this.C = z;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void R(ii iiVar, int i) {
        ao aoVar;
        if (this.s == null) {
            this.s = ao.b(this.l);
        }
        if (iiVar == null || iiVar.c.size() < 2) {
            this.t = null;
        } else {
            ao aoVarB = ao.b(this.l);
            if (aoVarB == null) {
                aoVar = new ao(ao.d(iiVar, i));
            } else {
                am[] amVarArrD = ao.d(iiVar, i);
                am[] amVarArr = (am[]) gs.j(Arrays.asList(aoVarB.a), (Object[]) Array.newInstance((Class<?>) am.class, 0));
                int length = amVarArr.length - 1;
                am amVar = amVarArr[length];
                ArrayDeque arrayDeque = new ArrayDeque();
                int length2 = amVarArrD.length;
                Duration durationC = Duration.ZERO;
                int i2 = amVarArrD[length2 - 1].a;
                if (amVar.a > i2) {
                    while (length >= 0) {
                        am amVar2 = amVarArr[length];
                        if (amVar2.a <= i2) {
                            break;
                        }
                        arrayDeque.addFirst(amVar2);
                        length--;
                    }
                    durationC = aoVarB.c(i2);
                }
                int length3 = amVarArrD.length;
                while (true) {
                    length3--;
                    if (length3 < 0) {
                        break;
                    }
                    am amVar3 = amVarArrD[length3];
                    arrayDeque.addFirst(new am(amVar3.a, amVar3.b.plus(durationC), true));
                }
                am amVar4 = (am) arrayDeque.getFirst();
                Duration duration = amVar4.b;
                Duration durationC2 = aoVarB.c(amVar4.a);
                int length4 = amVarArr.length;
                while (true) {
                    length4--;
                    if (length4 < 0) {
                        break;
                    }
                    am amVar5 = amVarArr[length4];
                    if (amVar5.a < amVar4.a) {
                        arrayDeque.addFirst(new am(amVar5.a, duration.plus(amVar5.b.minus(durationC2)), false));
                    }
                }
                aoVar = new ao((am[]) arrayDeque.toArray(new am[0]));
            }
            this.t = aoVar;
        }
        if (iiVar != null) {
            if (iiVar.c.size() >= 2) {
                ii.a aVarB = ii.a.b(iiVar.k);
                if (aVarB == null) {
                    aVarB = ii.a.DELAY_NODATA;
                }
                this.T = aVarB;
            }
            synchronized (this.S) {
                be beVar = this.S;
                beVar.c = null;
                beVar.d = null;
                this.u = iiVar;
            }
        }
        iiVar = null;
        this.T = ii.a.DELAY_NODATA;
        synchronized (this.S) {
            be beVar2 = this.S;
            beVar2.c = null;
            beVar2.d = null;
            this.u = iiVar;
        }
    }

    public final boolean S(bq bqVar) {
        bq[] bqVarArr = this.l;
        int i = bqVar.i;
        return i < bqVarArr.length && bqVarArr[i] == bqVar;
    }

    public final boolean T(int i) {
        return i >= 0 && i < aa().length;
    }

    public final boolean U() {
        ii iiVar = this.u;
        if (iiVar == null || iiVar.c.size() < 2) {
            return false;
        }
        Iterator it2 = iiVar.c.iterator();
        while (it2.hasNext()) {
            int iA = gu.a(((gv) it2.next()).e);
            if (iA == 0) {
                iA = gu.a;
            }
            if (iA != gu.a) {
                return true;
            }
        }
        return false;
    }

    public final boolean W() {
        return this.g.a.p;
    }

    public final boolean X() {
        return ab.contains(this.j);
    }

    public final boolean Y() {
        com.google.android.libraries.navigation.internal.ady.al alVar = this.j;
        if (alVar != com.google.android.libraries.navigation.internal.ady.al.DRIVE && alVar != com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
            return false;
        }
        lr lrVar = this.P;
        if ((lrVar.b & 134217728) == 0) {
            return false;
        }
        com.google.android.libraries.navigation.internal.adr.d dVar = lrVar.r;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.adr.d.a;
        }
        return (dVar.b & 4) != 0;
    }

    public final int[] Z(double d) {
        bq[] bqVarArrAa = aa();
        int[] iArr = new int[bqVarArrAa.length];
        for (int i = 0; i < bqVarArrAa.length; i++) {
            iArr[i] = (int) Math.max(0L, Math.round(a(bqVarArrAa[i].k) - d));
        }
        return iArr;
    }

    public final double a(int i) {
        return this.G[i];
    }

    public final bq[] aa() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            bq[] bqVarArr = this.l;
            if (i >= bqVarArr.length) {
                return (bq[]) arrayList.toArray(new bq[0]);
            }
            bq bqVar = bqVarArr[i];
            if (af(bqVar)) {
                arrayList.add(bqVar);
            }
            i++;
        }
    }

    public final bq[] ab() {
        return (bq[]) Arrays.copyOf(this.l, l());
    }

    public final List ac(com.google.android.libraries.navigation.internal.oe.x xVar, double d, int i, int i2) {
        com.google.android.libraries.geo.mapcore.internal.model.bp bpVar = this.f353n;
        com.google.android.libraries.navigation.internal.yx.ar.b(bpVar.c.e() > 0, "startVertexIndex is out of range.");
        PriorityQueue priorityQueue = new PriorityQueue(Math.min(11, i2), Collections.reverseOrder());
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar4 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVarL = bpVar.c.l(0);
        com.google.android.libraries.geo.mapcore.internal.model.bo boVar = new com.google.android.libraries.geo.mapcore.internal.model.bo(bpVar, com.google.android.libraries.navigation.internal.oe.ai.h(xVar, (int) (d + 1.0d)), 0, i);
        int i3 = -2;
        while (boVar.hasNext()) {
            int iIntValue = boVar.next().intValue();
            bpVar.c.u(iIntValue, xVar2);
            if (iIntValue - i3 > 1) {
                bpVar.c.u(iIntValue, xVar4);
                if (!boVar.hasNext()) {
                    double dH = xVar.h(xVar2);
                    if (dH > d) {
                        break;
                    }
                    com.google.android.libraries.geo.mapcore.internal.model.bp.g(priorityQueue, xVar2, dH, iIntValue, i2);
                    break;
                }
                boVar = boVar;
                xVarL = xVarL;
            } else {
                double dJ = com.google.android.libraries.navigation.internal.oe.x.j(xVar4, xVar2, xVar, xVar3);
                if (dJ <= d) {
                    com.google.android.libraries.geo.mapcore.internal.model.bp.g(priorityQueue, xVar3, dJ, i3, i2);
                }
                xVar4.W(xVar2);
                xVarL.W(xVar3);
            }
            xVarL = xVarL;
            i3 = iIntValue;
            boVar = boVar;
        }
        ArrayList arrayListE = hx.e(priorityQueue.size());
        for (com.google.android.libraries.geo.mapcore.internal.model.bl blVar = (com.google.android.libraries.geo.mapcore.internal.model.bl) priorityQueue.poll(); blVar != null; blVar = (com.google.android.libraries.geo.mapcore.internal.model.bl) priorityQueue.poll()) {
            com.google.android.libraries.navigation.internal.oe.ad adVar = bpVar.c;
            arrayListE.add(blVar.a(adVar, adVar.e() - 1, xVar4, xVar2));
        }
        Collections.reverse(arrayListE);
        return arrayListE;
    }

    public final double b(com.google.android.libraries.navigation.internal.oe.ag agVar) {
        double[] dArr = this.G;
        int i = agVar.c;
        return dArr[i] + ((double) agVar.a.l(this.m.l(i)));
    }

    public final double c(com.google.android.libraries.navigation.internal.aci.d dVar) {
        int i;
        int i2 = dVar.c;
        if (i2 < 0 || (i = i2 + 1) >= this.G.length) {
            return Double.NaN;
        }
        return this.G[i2] + (((double) dVar.d) / com.google.android.libraries.navigation.internal.oe.x.f(com.google.android.libraries.navigation.internal.oe.x.c((this.m.h(i2) + this.m.h(i)) / 2)));
    }

    public final double d(int i) {
        return this.F[i];
    }

    public final double e(com.google.android.libraries.navigation.internal.oe.ag agVar) {
        double[] dArr = this.F;
        int i = agVar.c;
        return dArr[i] + ((double) this.m.l(i).h(agVar.a));
    }

    public final double f(double d) {
        if (d < 0.0d) {
            return -1.0d;
        }
        double[] dArr = this.G;
        if (d > dArr[dArr.length - 1]) {
            return -1.0d;
        }
        int iH = h(d);
        double[] dArr2 = this.G;
        double d2 = dArr2[iH];
        if (d == d2) {
            return this.F[iH];
        }
        if (d <= d2) {
            return -1.0d;
        }
        int i = iH + 1;
        double d3 = dArr2[i];
        if (d >= d3) {
            return -1.0d;
        }
        double d4 = d - d2;
        double d5 = d3 - d2;
        double[] dArr3 = this.F;
        double d6 = dArr3[i];
        double d7 = dArr3[iH];
        return d7 + ((d4 / d5) * (d6 - d7));
    }

    public final int g(double d) {
        int iBinarySearch = Arrays.binarySearch(this.G, d);
        return iBinarySearch < 0 ? Math.min(-(iBinarySearch + 1), this.G.length - 1) : iBinarySearch;
    }

    public final int h(double d) {
        int iBinarySearch = Arrays.binarySearch(this.G, d);
        return iBinarySearch < 0 ? Math.max(0, -(iBinarySearch + 2)) : iBinarySearch;
    }

    public final int i() {
        return (int) Math.round(a(n()));
    }

    public final int j() {
        return this.l.length;
    }

    public final int k(int i) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            bq[] bqVarArr = this.l;
            if (i3 >= bqVarArr.length) {
                return 0;
            }
            i4++;
            if (af(bqVarArr[i3])) {
                i2++;
            }
            if (i2 == i) {
                return i4;
            }
            i3++;
        }
    }

    public final int l() {
        return k(0);
    }

    public final int m() {
        return this.p.size();
    }

    public final int n() {
        bq bqVarQ = q();
        if (bqVarQ == null) {
            return 0;
        }
        return bqVarQ.k;
    }

    public final int p() {
        return this.g.a.r;
    }

    public final bq q() {
        int i = 0;
        while (true) {
            bq[] bqVarArr = this.l;
            if (i >= bqVarArr.length) {
                return null;
            }
            bq bqVar = bqVarArr[i];
            if (af(bqVar)) {
                return bqVar;
            }
            i++;
        }
    }

    public final bq r(int i) {
        return this.l[i];
    }

    public final synchronized ce s() {
        ce ceVar;
        if (this.ad == null) {
            this.ad = new ce(this);
        }
        ceVar = this.ad;
        com.google.android.libraries.navigation.internal.yx.ar.q(ceVar);
        return ceVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ck t() {
        return (ck) this.p.get(0);
    }

    public final String toString() {
        return String.valueOf(this.Y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ck u() {
        return (ck) this.p.get(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ck v(int i) {
        return (ck) this.p.get(i);
    }

    public final com.google.android.libraries.navigation.internal.oe.x w(double d) {
        if (d < 0.0d || d > this.J) {
            return null;
        }
        List listN = N();
        int iH = h(d);
        if (iH == listN.size() - 1) {
            return (com.google.android.libraries.navigation.internal.oe.x) listN.get(iH);
        }
        double dA = a(iH);
        int i = iH + 1;
        double dA2 = a(i) - dA;
        double d2 = dA2 != 0.0d ? (d - dA) / dA2 : 0.0d;
        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) listN.get(iH);
        com.google.android.libraries.navigation.internal.oe.x xVar2 = (com.google.android.libraries.navigation.internal.oe.x) listN.get(i);
        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x.H(xVar, xVar2, (float) d2, xVar3);
        return xVar3;
    }

    public final com.google.android.libraries.navigation.internal.oe.ag x(com.google.android.libraries.navigation.internal.oe.x xVar, double d) {
        com.google.android.libraries.geo.mapcore.internal.model.bp bpVar = this.f353n;
        return bpVar.f(xVar, d, bpVar.c.e() - 1);
    }

    public final com.google.android.libraries.navigation.internal.oe.an y() {
        return new com.google.android.libraries.navigation.internal.oe.an(this.m, 0, n() + 1);
    }

    public final com.google.android.libraries.navigation.internal.yx.an z() {
        ll llVar = this.d.c;
        if (llVar == null) {
            llVar = ll.a;
        }
        lh lhVar = llVar.c;
        if (lhVar == null) {
            lhVar = lh.a;
        }
        ku kuVar = lhVar.j;
        if (kuVar == null) {
            kuVar = ku.a;
        }
        if ((kuVar.b & 2) == 0) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
        kq kqVar = kuVar.d;
        if (kqVar == null) {
            kqVar = kq.a;
        }
        com.google.android.libraries.navigation.internal.ady.ad adVarB = com.google.android.libraries.navigation.internal.ady.ad.b(kqVar.c);
        if (adVarB == null) {
            adVarB = com.google.android.libraries.navigation.internal.ady.ad.REROUTE_TYPE_BETTER_ETA;
        }
        return com.google.android.libraries.navigation.internal.yx.an.j(adVarB);
    }

    public static boolean V(com.google.android.libraries.navigation.internal.adr.z zVar) {
        if (zVar == null) {
            return false;
        }
        int iA = com.google.android.libraries.navigation.internal.adr.y.a(zVar.c);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.adr.y.a;
        }
        boolean z = iA == com.google.android.libraries.navigation.internal.adr.y.b;
        if (iA == 0) {
            throw null;
        }
        if (!z) {
            boolean z2 = iA == com.google.android.libraries.navigation.internal.adr.y.d;
            if (iA == 0) {
                throw null;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }
}
