package com.google.android.libraries.navigation.internal.vd;

import android.content.Context;
import android.util.LongSparseArray;
import com.google.android.libraries.navigation.internal.acd.ua;
import com.google.android.libraries.navigation.internal.acd.ub;
import com.google.android.libraries.navigation.internal.ace.nv;
import com.google.android.libraries.navigation.internal.ace.oa;
import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.adq.v;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adu.aa;
import com.google.android.libraries.navigation.internal.adu.ac;
import com.google.android.libraries.navigation.internal.adu.ae;
import com.google.android.libraries.navigation.internal.adu.ag;
import com.google.android.libraries.navigation.internal.adu.ai;
import com.google.android.libraries.navigation.internal.adu.aj;
import com.google.android.libraries.navigation.internal.adu.u;
import com.google.android.libraries.navigation.internal.adu.w;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.adu.z;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zs.ce;
import com.google.android.libraries.navigation.internal.zs.cf;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.so.a, com.google.android.libraries.navigation.internal.sp.b {
    public static final /* synthetic */ int e = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.vd.c");
    private static final al g;
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final af b;
    public final Context c;
    private final com.google.android.libraries.navigation.internal.di.b h;
    private final com.google.android.libraries.navigation.internal.fz.d i;
    private final com.google.android.libraries.navigation.internal.mj.a j;
    private final Executor k;
    private final com.google.android.libraries.navigation.internal.dx.i m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.iv.f f635n;
    private final br o;
    private final com.google.android.libraries.navigation.internal.dx.o p;
    private final com.google.android.libraries.navigation.internal.gs.f r;
    private final int s;
    private final Set q = new HashSet();
    public final List d = new ArrayList();
    private final LongSparseArray l = new LongSparseArray();

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
        int i3 = com.google.android.libraries.navigation.internal.zp.n.w.a;
        if (!akVar.b.H()) {
            akVar.v();
        }
        al alVar2 = (al) akVar.b;
        alVar2.b |= 64;
        alVar2.e = i3;
        if (!akVar.b.H()) {
            akVar.v();
        }
        al alVar3 = (al) akVar.b;
        alVar3.b |= 512;
        alVar3.f = true;
        g = (al) akVar.t();
    }

    public c(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.di.b bVar, Executor executor, com.google.android.libraries.navigation.internal.gs.f fVar, com.google.android.libraries.navigation.internal.dx.i iVar, af afVar, int i, com.google.android.libraries.navigation.internal.iv.f fVar2, br brVar, com.google.android.libraries.navigation.internal.dx.o oVar, Context context) {
        this.k = executor;
        this.h = bVar;
        this.i = dVar;
        this.j = aVar;
        this.a = eVar;
        this.r = fVar;
        this.m = iVar;
        this.b = afVar;
        this.s = i;
        this.f635n = fVar2;
        this.o = brVar;
        this.p = oVar;
        this.c = context;
    }

    private static final int j(boolean z) {
        return z ? com.google.android.libraries.navigation.internal.aed.c.b : com.google.android.libraries.navigation.internal.aed.c.c;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.d.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.l.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.so.a
    public final void c(x xVar, y yVar) {
        oa oaVarI = this.m.i(yVar);
        if (oaVarI == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.dx.i iVar = this.m;
        int iA = nv.a(oaVarI.h);
        if (iA == 0) {
            iA = nv.a;
        }
        Integer numQ = iVar.q(iA);
        if (numQ != null) {
            int i = oaVarI.b;
            if ((i & 4) == 0 || (i & 8) == 0) {
                return;
            }
            this.a.a(new com.google.android.libraries.navigation.internal.ve.b(xVar, new com.google.android.libraries.navigation.internal.vg.a(oaVarI.d, oaVarI.e), null, this.c.getResources().getString(numQ.intValue())));
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0131  */
    /* JADX WARN: Code duplicated, block: B:56:0x0143  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0160  */
    /* JADX WARN: Code duplicated, block: B:64:0x016b  */
    /* JADX WARN: Code duplicated, block: B:66:0x017a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0193  */
    /* JADX WARN: Code duplicated, block: B:69:0x0194  */
    @Override // com.google.android.libraries.navigation.internal.so.a
    public final void d(x xVar, y yVar, Float f2, String str, boolean z) {
        aa aaVar;
        int i;
        com.google.android.libraries.navigation.internal.adu.af afVar;
        int i2;
        int i3;
        com.google.android.libraries.navigation.internal.adu.af afVar2;
        int i4;
        if (this.m.i(yVar) == null) {
            return;
        }
        if (y.INCIDENT_SUSPECTED_CLOSURE.equals(yVar)) {
            this.a.a(new com.google.android.libraries.navigation.internal.ss.c());
            return;
        }
        com.google.android.libraries.navigation.internal.gs.f fVar = this.r;
        ag agVar = (ag) aj.a.q();
        int i5 = ai.b;
        if (!agVar.b.H()) {
            agVar.v();
        }
        aj ajVar = (aj) agVar.b;
        int i6 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        ajVar.c = i6;
        ajVar.b |= 1;
        if (!Float.isNaN(f2.floatValue())) {
            float fFloatValue = f2.floatValue();
            if (!agVar.b.H()) {
                agVar.v();
            }
            aj ajVar2 = (aj) agVar.b;
            ajVar2.b |= 2;
            ajVar2.d = fFloatValue;
        }
        if (str != null) {
            if (!agVar.b.H()) {
                agVar.v();
            }
            aj ajVar3 = (aj) agVar.b;
            ajVar3.b |= 4;
            ajVar3.e = str;
        }
        z zVar = (z) com.google.android.libraries.navigation.internal.adu.ak.a.q();
        com.google.android.libraries.navigation.internal.adu.i iVar = (com.google.android.libraries.navigation.internal.adu.i) com.google.android.libraries.navigation.internal.adu.j.a.q();
        double dB = xVar.b();
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.j jVar = (com.google.android.libraries.navigation.internal.adu.j) iVar.b;
        jVar.b |= 1;
        jVar.c = dB;
        double d = xVar.d();
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.j jVar2 = (com.google.android.libraries.navigation.internal.adu.j) iVar.b;
        jVar2.b |= 2;
        jVar2.d = d;
        if (!zVar.b.H()) {
            zVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.ak akVar = (com.google.android.libraries.navigation.internal.adu.ak) zVar.b;
        com.google.android.libraries.navigation.internal.adu.j jVar3 = (com.google.android.libraries.navigation.internal.adu.j) iVar.t();
        jVar3.getClass();
        bz bzVar = akVar.c;
        if (!bzVar.c()) {
            akVar.c = bi.A(bzVar);
        }
        akVar.c.add(jVar3);
        if (!zVar.b.H()) {
            zVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.ak akVar2 = (com.google.android.libraries.navigation.internal.adu.ak) zVar.b;
        aj ajVar4 = (aj) agVar.t();
        ajVar4.getClass();
        akVar2.e = ajVar4;
        akVar2.b |= 32;
        int iOrdinal = yVar.ordinal();
        if (iOrdinal != 2 && iOrdinal != 3) {
            if (iOrdinal == 4) {
                aa aaVar2 = (aa) com.google.android.libraries.navigation.internal.adu.af.a.q();
                int i7 = ac.b;
                if (!aaVar2.b.H()) {
                    aaVar2.v();
                }
                com.google.android.libraries.navigation.internal.adu.af afVar3 = (com.google.android.libraries.navigation.internal.adu.af) aaVar2.b;
                int i8 = i7 - 1;
                if (i7 == 0) {
                    throw null;
                }
                afVar3.c = i8;
                afVar3.b |= 1;
                int i9 = ae.c;
                if (!aaVar2.b.H()) {
                    aaVar2.v();
                }
                com.google.android.libraries.navigation.internal.adu.af afVar4 = (com.google.android.libraries.navigation.internal.adu.af) aaVar2.b;
                int i10 = i9 - 1;
                if (i9 == 0) {
                    throw null;
                }
                afVar4.d = i10;
                afVar4.b |= 2;
                if (!zVar.b.H()) {
                    zVar.v();
                }
                com.google.android.libraries.navigation.internal.adu.ak akVar3 = (com.google.android.libraries.navigation.internal.adu.ak) zVar.b;
                com.google.android.libraries.navigation.internal.adu.af afVar5 = (com.google.android.libraries.navigation.internal.adu.af) aaVar2.t();
                afVar5.getClass();
                akVar3.d = afVar5;
                akVar3.b |= 16;
            } else if (iOrdinal != 5) {
                if (iOrdinal != 6) {
                    switch (iOrdinal) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        case 13:
                            aaVar = (aa) com.google.android.libraries.navigation.internal.adu.af.a.q();
                            i = ac.b;
                            if (!aaVar.b.H()) {
                                aaVar.v();
                            }
                            afVar = (com.google.android.libraries.navigation.internal.adu.af) aaVar.b;
                            i2 = i - 1;
                            if (i != 0) {
                                throw null;
                            }
                            afVar.c = i2;
                            afVar.b |= 1;
                            i3 = ae.b;
                            if (!aaVar.b.H()) {
                                aaVar.v();
                            }
                            afVar2 = (com.google.android.libraries.navigation.internal.adu.af) aaVar.b;
                            i4 = i3 - 1;
                            if (i3 != 0) {
                                throw null;
                            }
                            afVar2.d = i4;
                            afVar2.b |= 2;
                            if (!zVar.b.H()) {
                                zVar.v();
                            }
                            com.google.android.libraries.navigation.internal.adu.ak akVar4 = (com.google.android.libraries.navigation.internal.adu.ak) zVar.b;
                            com.google.android.libraries.navigation.internal.adu.af afVar6 = (com.google.android.libraries.navigation.internal.adu.af) aaVar.t();
                            afVar6.getClass();
                            akVar4.d = afVar6;
                            akVar4.b |= 16;
                            break;
                            break;
                        default:
                            switch (iOrdinal) {
                                case 19:
                                case 20:
                                case 21:
                                    break;
                                default:
                                    throw new IllegalArgumentException("UserIncidentType");
                            }
                            break;
                    }
                }
            } else {
                aaVar = (aa) com.google.android.libraries.navigation.internal.adu.af.a.q();
                i = ac.b;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                afVar = (com.google.android.libraries.navigation.internal.adu.af) aaVar.b;
                i2 = i - 1;
                if (i != 0) {
                    throw null;
                }
                afVar.c = i2;
                afVar.b |= 1;
                i3 = ae.b;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                afVar2 = (com.google.android.libraries.navigation.internal.adu.af) aaVar.b;
                i4 = i3 - 1;
                if (i3 != 0) {
                    throw null;
                }
                afVar2.d = i4;
                afVar2.b |= 2;
                if (!zVar.b.H()) {
                    zVar.v();
                }
                com.google.android.libraries.navigation.internal.adu.ak akVar5 = (com.google.android.libraries.navigation.internal.adu.ak) zVar.b;
                com.google.android.libraries.navigation.internal.adu.af afVar7 = (com.google.android.libraries.navigation.internal.adu.af) aaVar.t();
                afVar7.getClass();
                akVar5.d = afVar7;
                akVar5.b |= 16;
            }
        }
        int iJ = j(z);
        ua uaVar = (ua) ub.a.q();
        al alVar = g;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar = (ub) uaVar.b;
        alVar.getClass();
        ubVar.c = alVar;
        ubVar.b |= 1;
        long jA = com.google.android.libraries.navigation.internal.aaa.b.a(this.j.f());
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar2 = (ub) uaVar.b;
        ubVar2.b |= 32;
        ubVar2.h = jA;
        int i11 = w.b;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar3 = (ub) uaVar.b;
        int i12 = i11 - 1;
        if (i11 == 0) {
            throw null;
        }
        ubVar3.d = i12;
        ubVar3.b |= 2;
        int i13 = this.s;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar4 = (ub) uaVar.b;
        int i14 = i13 - 1;
        if (i13 == 0) {
            throw null;
        }
        ubVar4.e = i14;
        ubVar4.b = 4 | ubVar4.b;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar5 = (ub) uaVar.b;
        ubVar5.f = yVar.x;
        ubVar5.b |= 8;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar6 = (ub) uaVar.b;
        com.google.android.libraries.navigation.internal.adu.ak akVar6 = (com.google.android.libraries.navigation.internal.adu.ak) zVar.t();
        akVar6.getClass();
        ubVar6.i = akVar6;
        ubVar6.b |= 64;
        com.google.android.libraries.navigation.internal.aed.a aVar = (com.google.android.libraries.navigation.internal.aed.a) com.google.android.libraries.navigation.internal.aed.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.aed.d dVar = (com.google.android.libraries.navigation.internal.aed.d) aVar.b;
        int i15 = iJ - 1;
        if (iJ == 0) {
            throw null;
        }
        dVar.c = i15;
        dVar.b |= 1;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar7 = (ub) uaVar.b;
        com.google.android.libraries.navigation.internal.aed.d dVar2 = (com.google.android.libraries.navigation.internal.aed.d) aVar.t();
        dVar2.getClass();
        ubVar7.j = dVar2;
        ubVar7.b |= 256;
        fVar.a(i(uaVar), new b(this, yVar), this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.so.a
    public final boolean e(long j) {
        return this.l.get(j) != null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    @Override // com.google.android.libraries.navigation.internal.so.a
    public final boolean f(com.google.android.libraries.navigation.internal.tt.d dVar) {
        boolean z;
        com.google.android.libraries.navigation.internal.tt.b bVar = (com.google.android.libraries.navigation.internal.tt.b) dVar;
        if (!bVar.l) {
            return false;
        }
        if (this.i.x().i()) {
            z = true;
        } else {
            if (Cdo.INCIDENT_SPEED_LIMIT.equals(bVar.h)) {
                z = true;
            } else {
                z = false;
            }
        }
        br brVar = this.o;
        if (brVar != null) {
            return ((Boolean) brVar.a()).booleanValue() && z;
        }
        com.google.android.libraries.navigation.internal.di.b bVar2 = this.h;
        bVar2.c();
        bVar2.a();
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.so.a
    public final void g(long j, y yVar, int i, long j2, List list, boolean z, Optional optional) {
        if (i == w.f && !list.isEmpty()) {
            this.a.a(new com.google.android.libraries.navigation.internal.ss.a(ev.o(list)));
        }
        if (i == w.a) {
            throw new IllegalArgumentException("Unsupported UserIncidentReportType.");
        }
        this.l.put(j, Long.valueOf(j2));
        Iterator it2 = this.q.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        int iJ = com.google.android.libraries.navigation.internal.aed.c.a;
        if (optional.isPresent()) {
            iJ = j(((Boolean) optional.get()).booleanValue());
        }
        ua uaVar = (ua) ub.a.q();
        al alVar = g;
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
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        ubVar2.d = i2;
        ubVar2.b |= 2;
        int i3 = this.s;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar3 = (ub) uaVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        ubVar3.e = i4;
        ubVar3.b |= 4;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar4 = (ub) uaVar.b;
        ubVar4.f = yVar.x;
        ubVar4.b |= 8;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar5 = (ub) uaVar.b;
        ubVar5.b |= 16;
        ubVar5.g = j;
        com.google.android.libraries.navigation.internal.aed.a aVar = (com.google.android.libraries.navigation.internal.aed.a) com.google.android.libraries.navigation.internal.aed.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.aed.d dVar = (com.google.android.libraries.navigation.internal.aed.d) aVar.b;
        int i5 = iJ - 1;
        if (iJ == 0) {
            throw null;
        }
        dVar.c = i5;
        dVar.b |= 1;
        if (!uaVar.b.H()) {
            uaVar.v();
        }
        ub ubVar6 = (ub) uaVar.b;
        com.google.android.libraries.navigation.internal.aed.d dVar2 = (com.google.android.libraries.navigation.internal.aed.d) aVar.t();
        dVar2.getClass();
        ubVar6.j = dVar2;
        ubVar6.b |= 256;
        this.r.a(i(uaVar), new a(this, z, i, yVar), this.k);
    }

    public final void h(int i, y yVar) {
        cz czVar = (cz) db.a.q();
        ce ceVar = (ce) cf.a.q();
        if (!ceVar.b.H()) {
            ceVar.v();
        }
        cf cfVar = (cf) ceVar.b;
        cfVar.c = yVar.x;
        cfVar.b |= 1;
        if (!ceVar.b.H()) {
            ceVar.v();
        }
        cf cfVar2 = (cf) ceVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        cfVar2.d = i2;
        cfVar2.b |= 2;
        if (!czVar.b.H()) {
            czVar.v();
        }
        db dbVar = (db) czVar.b;
        cf cfVar3 = (cf) ceVar.t();
        cfVar3.getClass();
        dbVar.d = cfVar3;
        dbVar.c = 32;
        this.a.a(new com.google.android.libraries.navigation.internal.tf.d((db) czVar.t()));
    }

    private final ub i(ua uaVar) {
        if (this.f635n != null) {
            int i = this.s;
            boolean z = i == u.h;
            if (i == 0) {
                throw null;
            }
            if (z) {
                long jB = this.f635n.b(ab.bg, 0L);
                if (jB != 0) {
                    com.google.android.libraries.navigation.internal.adx.a aVar = (com.google.android.libraries.navigation.internal.adx.a) com.google.android.libraries.navigation.internal.adx.b.a.q();
                    String strValueOf = String.valueOf(jB);
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adx.b bVar = (com.google.android.libraries.navigation.internal.adx.b) aVar.b;
                    strValueOf.getClass();
                    bVar.b = 1 | bVar.b;
                    bVar.c = strValueOf;
                    if (!uaVar.b.H()) {
                        uaVar.v();
                    }
                    ub ubVar = (ub) uaVar.b;
                    com.google.android.libraries.navigation.internal.adx.b bVar2 = (com.google.android.libraries.navigation.internal.adx.b) aVar.t();
                    ub ubVar2 = ub.a;
                    bVar2.getClass();
                    ubVar.k = bVar2;
                    ubVar.b |= 512;
                }
            }
        }
        return (ub) uaVar.t();
    }
}
