package com.google.android.libraries.navigation.internal.sk;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class dp implements dr, com.google.android.libraries.navigation.internal.sl.a {
    private static final com.google.android.libraries.navigation.internal.zb.j v = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.dp");
    public final Executor a;
    public final com.google.android.libraries.navigation.internal.aac.bn b;
    public final ck c;
    public final com.google.android.libraries.navigation.internal.vn.d d;
    public final af e;
    public final ce f;
    public final com.google.android.libraries.navigation.internal.sl.q g;
    public final com.google.android.libraries.navigation.internal.iv.f h;
    public c i;
    public final com.google.android.libraries.navigation.internal.sl.c j;
    public final com.google.android.libraries.navigation.internal.sl.h k;
    public final Context l;
    public final Resources m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.rw.f f575n;
    public final com.google.android.libraries.navigation.internal.fz.d o;
    public final dm p;
    public final dn q;
    public Runnable s;
    private final Executor w;
    public final AtomicBoolean r = new AtomicBoolean(false);
    public final AtomicBoolean t = new AtomicBoolean(false);
    public final a u = new dk(this);

    public dp(Executor executor, com.google.android.libraries.navigation.internal.aac.bn bnVar, af afVar, ck ckVar, com.google.android.libraries.navigation.internal.vn.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.sl.h hVar, com.google.android.libraries.navigation.internal.sl.c cVar, Context context, Resources resources, com.google.android.libraries.navigation.internal.sl.q qVar, ce ceVar, com.google.android.libraries.navigation.internal.rw.f fVar2, com.google.android.libraries.navigation.internal.fz.d dVar2, dm dmVar, dn dnVar) {
        this.a = executor;
        this.b = bnVar;
        this.w = new com.google.android.libraries.navigation.internal.aac.bz(bnVar);
        this.c = ckVar;
        this.d = dVar;
        this.h = fVar;
        this.k = hVar;
        this.j = cVar;
        this.l = context;
        this.m = resources;
        this.g = qVar;
        this.f = ceVar;
        this.e = afVar;
        this.f575n = fVar2;
        this.o = dVar2;
        this.p = dmVar;
        this.q = dnVar;
    }

    final com.google.android.libraries.navigation.internal.aac.bj a(final boolean z) {
        this.d.c();
        return com.google.android.libraries.navigation.internal.aac.j.h(b(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sk.cx
            /* JADX WARN: Code duplicated, block: B:101:0x01e5  */
            /* JADX WARN: Code duplicated, block: B:121:0x025a  */
            /* JADX WARN: Code duplicated, block: B:69:0x0132  */
            /* JADX WARN: Code duplicated, block: B:92:0x01ba  */
            /* JADX WARN: Code duplicated, block: B:94:0x01ca  */
            /* JADX WARN: Code duplicated, block: B:95:0x01cc  */
            /* JADX WARN: Code duplicated, block: B:97:0x01d4  */
            /* JADX WARN: Code duplicated, block: B:98:0x01db A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:99:0x01dd  */
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                eq eqVar;
                c cVarA;
                c cVarA2;
                int i;
                long[] jArr;
                com.google.android.libraries.navigation.internal.bp.bw bwVar;
                long[] jArr2;
                em emVar;
                dp dpVar = this.a;
                if (dpVar.i != null) {
                    return true;
                }
                boolean z2 = z;
                if ((z2 || dpVar.s == null) && !dpVar.r.get()) {
                    ArrayList arrayList = new ArrayList();
                    if (dpVar.d.c == com.google.android.libraries.navigation.internal.vn.c.SILENT) {
                        dpVar.f(dpVar.f.a(dpVar.m, com.google.android.libraries.navigation.internal.dw.g.A, com.google.android.libraries.navigation.internal.sl.s.NORMAL));
                        return true;
                    }
                    com.google.android.libraries.navigation.internal.vn.d dVar = dpVar.d;
                    com.google.android.libraries.navigation.internal.vn.c cVar = dVar.c;
                    if (cVar == com.google.android.libraries.navigation.internal.vn.c.DELAY) {
                        dpVar.f(new by(Long.parseLong(dVar.c())));
                        return true;
                    }
                    c bwVar2 = null;
                    if (cVar == com.google.android.libraries.navigation.internal.vn.c.URI) {
                        throw null;
                    }
                    if (cVar == com.google.android.libraries.navigation.internal.vn.c.PREROLL_SOUND_ONLY) {
                        if (dpVar.c.d(dpVar.k)) {
                            return false;
                        }
                        dpVar.f(dpVar.p.b().a(dpVar.d));
                        return true;
                    }
                    if (x.y(dpVar.k, dpVar.g, dpVar.f575n)) {
                        dm dmVar = dpVar.p;
                        com.google.android.libraries.navigation.internal.vn.d dVar2 = dpVar.d;
                        z zVarC = dmVar.c();
                        com.google.android.libraries.navigation.internal.bp.bw bwVar3 = dVar2.d;
                        if (bwVar3 == null) {
                            emVar = null;
                        } else {
                            com.google.android.libraries.navigation.internal.vn.c cVar2 = dVar2.c;
                            com.google.android.libraries.navigation.internal.bp.bq bqVarA = bwVar3.a();
                            if (cVar2 == com.google.android.libraries.navigation.internal.vn.c.ERROR) {
                                jArr2 = en.d;
                            } else if (com.google.android.libraries.navigation.internal.bp.ca.d(bqVarA.d)) {
                                int iOrdinal = bqVarA.e.ordinal();
                                if (iOrdinal != 0) {
                                    jArr2 = iOrdinal != 1 ? en.c : en.b;
                                } else {
                                    jArr2 = en.a;
                                }
                            } else {
                                jArr2 = en.e;
                            }
                            emVar = new em(((en) zVarC).f, jArr2);
                        }
                        bu.a(emVar, arrayList);
                    }
                    if (x.z(dpVar.k, dpVar.g, dpVar.f575n)) {
                        dm dmVar2 = dpVar.p;
                        com.google.android.libraries.navigation.internal.vn.d dVar3 = dpVar.d;
                        er erVarF = dmVar2.f();
                        int iOrdinal2 = dVar3.c.ordinal();
                        if (iOrdinal2 == 0) {
                            i = com.google.android.libraries.navigation.internal.kv.a.g;
                        } else if (iOrdinal2 == 1 && (bwVar = dVar3.d) != null) {
                            com.google.android.libraries.navigation.internal.vn.c cVar3 = dVar3.c;
                            com.google.android.libraries.navigation.internal.bp.bq bqVarA2 = bwVar.a();
                            if (cVar3 == com.google.android.libraries.navigation.internal.vn.c.ERROR) {
                                i = com.google.android.libraries.navigation.internal.kv.a.f;
                            } else if (com.google.android.libraries.navigation.internal.bp.ca.d(bqVarA2.d)) {
                                int iOrdinal3 = bqVarA2.e.ordinal();
                                if (iOrdinal3 == 0) {
                                    i = com.google.android.libraries.navigation.internal.kv.a.b;
                                } else if (iOrdinal3 == 1) {
                                    i = com.google.android.libraries.navigation.internal.kv.a.c;
                                } else if (iOrdinal3 != 2) {
                                    i = com.google.android.libraries.navigation.internal.kv.a.e;
                                } else {
                                    i = com.google.android.libraries.navigation.internal.kv.a.d;
                                }
                            } else {
                                i = com.google.android.libraries.navigation.internal.kv.a.e;
                            }
                        } else {
                            i = com.google.android.libraries.navigation.internal.kv.a.h;
                        }
                        com.google.android.libraries.navigation.internal.ia.e eVar = erVarF.g;
                        int i2 = i - 1;
                        if (i == 0) {
                            throw null;
                        }
                        switch (i2) {
                            case 0:
                            case 7:
                                jArr = er.f;
                                break;
                            case 1:
                                jArr = er.a;
                                break;
                            case 2:
                                jArr = er.b;
                                break;
                            case 3:
                                jArr = er.c;
                                break;
                            case 4:
                            case 6:
                                jArr = er.e;
                                break;
                            case 5:
                                jArr = er.d;
                                break;
                            default:
                                jArr = er.f;
                                break;
                        }
                        eqVar = new eq(eVar, jArr, i, dVar3.c());
                    } else {
                        eqVar = new eq(dpVar.p.f().g, er.f, com.google.android.libraries.navigation.internal.kv.a.h, dpVar.d.c());
                    }
                    bu.a(eqVar, arrayList);
                    if (x.x(dpVar.k, dpVar.c, dpVar.f575n)) {
                        bu.a(dpVar.p.b().a(dpVar.d), arrayList);
                        dm dmVar3 = dpVar.p;
                        com.google.android.libraries.navigation.internal.sl.h hVar = dpVar.k;
                        dt dtVarD = dmVar3.d();
                        if (((com.google.android.libraries.navigation.internal.sl.k) hVar.l).b || dpVar.o.R().c) {
                            if (!dpVar.h.i(com.google.android.libraries.navigation.internal.iv.ab.aH, "").isEmpty()) {
                                cVarA = null;
                            } else if (dtVarD.f(dpVar.d)) {
                                cVarA = dtVarD.a(dpVar.d);
                            } else {
                                if (z2) {
                                    dtVarD.d(dpVar.d, dpVar, com.google.android.libraries.navigation.internal.tv.c.NOW, dpVar.k);
                                    dpVar.p.e().a(dpVar.d);
                                    return false;
                                }
                                cVarA = dtVarD.a(dpVar.d);
                                if (cVarA == null) {
                                    dpVar.p.h().i();
                                }
                            }
                        } else if (x.a.contains(dpVar.d.c)) {
                            cVarA = null;
                        } else if (!dpVar.h.i(com.google.android.libraries.navigation.internal.iv.ab.aH, "").isEmpty()) {
                            cVarA = null;
                        } else if (dtVarD.f(dpVar.d)) {
                            cVarA = dtVarD.a(dpVar.d);
                        } else {
                            if (z2) {
                                dtVarD.d(dpVar.d, dpVar, com.google.android.libraries.navigation.internal.tv.c.NOW, dpVar.k);
                                dpVar.p.e().a(dpVar.d);
                                return false;
                            }
                            cVarA = dtVarD.a(dpVar.d);
                            if (cVarA == null) {
                                dpVar.p.h().i();
                            }
                        }
                        if (cVarA == null) {
                            cVarA = dpVar.p.e().a(dpVar.d);
                        }
                        if (cVarA == null) {
                            if (!z2) {
                                return false;
                            }
                            dm dmVar4 = dpVar.p;
                            com.google.android.libraries.navigation.internal.vn.d dVar4 = dpVar.d;
                            bz bzVar = (bz) dmVar4.a();
                            com.google.android.libraries.navigation.internal.sl.s sVarA = com.google.android.libraries.navigation.internal.sl.s.a(bzVar.c);
                            int iOrdinal4 = dVar4.c.ordinal();
                            if (iOrdinal4 == 0) {
                                cVarA2 = bzVar.b.a(bzVar.a, com.google.android.libraries.navigation.internal.dw.g.f, sVarA);
                            } else if (iOrdinal4 == 1) {
                                cVarA2 = bzVar.b.a(bzVar.a, com.google.android.libraries.navigation.internal.dw.g.a, sVarA);
                            } else if (iOrdinal4 != 3) {
                                cVarA2 = iOrdinal4 != 6 ? null : bzVar.b.a(bzVar.a, com.google.android.libraries.navigation.internal.dw.g.B, sVarA);
                            } else {
                                cVarA2 = bzVar.b.a(bzVar.a, com.google.android.libraries.navigation.internal.dw.g.b, sVarA);
                            }
                            bu.a(cVarA2, arrayList);
                        }
                        bu.a(cVarA, arrayList);
                    }
                    if (!arrayList.isEmpty()) {
                        bwVar2 = arrayList.size() == 1 ? (c) arrayList.get(0) : new bw((c[]) arrayList.toArray(new c[arrayList.size()]));
                    }
                    dpVar.f(bwVar2);
                    return true;
                }
                return false;
            }
        }, this.b);
    }

    final com.google.android.libraries.navigation.internal.aac.bj b() {
        return com.google.android.libraries.navigation.internal.aac.az.k(new dl(this), this.w);
    }

    public final void c() {
        this.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.da
            @Override // java.lang.Runnable
            public final void run() {
                dp dpVar = this.a;
                dpVar.q.n();
                x.o(dpVar.j);
            }
        });
    }

    public final void d() {
        com.google.android.libraries.navigation.internal.aac.az.o(b(), new dj(this), this.b);
    }

    final void e() {
        com.google.android.libraries.navigation.internal.aac.az.o(a(true), new dd(this), this.b);
    }

    final void f(final c cVar) {
        this.w.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.db
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i = cVar;
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dr
    public final void g() {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cy
            @Override // java.lang.Runnable
            public final void run() {
                dp dpVar = this.a;
                if (dpVar.s != null) {
                    dpVar.s = null;
                    dpVar.e();
                }
            }
        });
    }
}
