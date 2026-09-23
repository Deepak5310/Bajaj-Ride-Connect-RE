package com.google.android.libraries.navigation.internal.sx;

import android.app.Application;
import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.afx.ci;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f583n = 0;
    private com.google.android.libraries.navigation.internal.fw.g B;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.jy.af e;
    public com.google.android.libraries.navigation.internal.gg.b f;
    public com.google.android.libraries.navigation.internal.gg.b g;
    public com.google.android.libraries.navigation.internal.bi.j h;
    public as i;
    public am j;
    public an k;
    public final i m;
    private final com.google.android.libraries.navigation.internal.fr.d p;
    private final com.google.android.libraries.navigation.internal.bi.o q;
    private final com.google.android.libraries.navigation.internal.es.b r;
    private final bn s;
    private final Executor t;
    private final com.google.android.libraries.navigation.internal.kk.m u;
    private final com.google.android.libraries.navigation.internal.kk.m v;
    private final com.google.android.libraries.navigation.internal.bi.m w;
    private com.google.android.libraries.navigation.internal.bi.j x;
    private long y;
    private static final com.google.android.libraries.navigation.internal.zb.j o = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sx.ab");
    static final long a = TimeUnit.SECONDS.toMillis(2);
    static final long b = TimeUnit.SECONDS.toMillis(5);
    private boolean z = true;
    private boolean A = false;
    public final bk l = new bk(new Callable() { // from class: com.google.android.libraries.navigation.internal.sx.v
        @Override // java.util.concurrent.Callable
        public final Object call() throws am, an {
            ab abVar = this.a;
            am amVar = abVar.j;
            if (amVar != null) {
                throw amVar;
            }
            an anVar = abVar.k;
            if (anVar == null) {
                return (as) Objects.requireNonNull(abVar.i);
            }
            throw anVar;
        }
    });
    private final AtomicBoolean C = new AtomicBoolean(false);
    private final com.google.android.libraries.navigation.internal.gg.e D = new y(this);
    private final com.google.android.libraries.navigation.internal.gg.e E = new z(this);

    public ab(Application application, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fr.d dVar, com.google.android.libraries.navigation.internal.bi.o oVar, com.google.android.libraries.navigation.internal.es.b bVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.bi.m mVar, com.google.android.libraries.navigation.internal.kk.m mVar2, com.google.android.libraries.navigation.internal.kk.m mVar3, i iVar) {
        this.c = application;
        this.d = aVar;
        this.p = dVar;
        this.q = oVar;
        this.r = bVar;
        this.s = bnVar;
        this.t = executor;
        this.e = afVar;
        this.w = mVar;
        this.u = mVar2;
        this.v = mVar3;
        this.m = iVar;
    }

    private final synchronized long g() {
        if (this.x != null && this.B == null) {
            return Math.max(this.y - this.d.a(), 0L);
        }
        return 0L;
    }

    private final void h(lz lzVar, long j) {
        m(l.a(this.c, lzVar, j, false, this.D, this.w));
        this.t.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sx.x
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.gg.o oVar;
                com.google.android.libraries.navigation.internal.fw.g gVar = com.google.android.libraries.navigation.internal.fw.g.SINGLE_REQUEST_FATAL_ERROR;
                com.google.android.libraries.navigation.internal.gg.o oVar2 = com.google.android.libraries.navigation.internal.gg.o.a;
                if (gVar == null) {
                    oVar = com.google.android.libraries.navigation.internal.gg.o.a;
                } else {
                    ci ciVar = ci.OK;
                    int iOrdinal = gVar.ordinal();
                    if (iOrdinal == 13) {
                        oVar = com.google.android.libraries.navigation.internal.gg.o.b;
                    } else if (iOrdinal != 15) {
                        switch (iOrdinal) {
                            case 0:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.e;
                                break;
                            case 1:
                            case 5:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.f;
                                break;
                            case 2:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.h;
                                break;
                            case 3:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.m;
                                break;
                            case 4:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.j;
                                break;
                            case 6:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.c;
                                break;
                            case 7:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.k;
                                break;
                            case 8:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.i;
                                break;
                            case 9:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.f438n;
                                break;
                            case 10:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.g;
                                break;
                            default:
                                oVar = com.google.android.libraries.navigation.internal.gg.o.a;
                                break;
                        }
                    } else {
                        oVar = com.google.android.libraries.navigation.internal.gg.o.d;
                    }
                }
                this.a.d(null, oVar);
            }
        });
    }

    private static void i(com.google.android.libraries.navigation.internal.kk.m mVar) {
        if (mVar != null) {
            mVar.a();
        }
    }

    private final void j(as asVar, com.google.android.libraries.navigation.internal.fw.g gVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(this.x);
        if (asVar == null) {
            this.j = new am(this.x, this.c, (com.google.android.libraries.navigation.internal.fw.g) Objects.requireNonNull(gVar));
            this.l.run();
        }
        if (e()) {
            if (asVar != null) {
                b((as) Objects.requireNonNull(asVar));
            }
            com.google.android.libraries.navigation.internal.gg.b bVar = this.g;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    private static void k(com.google.android.libraries.navigation.internal.kk.m mVar) {
        if (mVar != null) {
            mVar.b();
        }
    }

    private final synchronized void l(com.google.android.libraries.navigation.internal.bi.j jVar, boolean z) {
        this.h = jVar;
        this.y = this.d.a() + (z ? b : a);
    }

    private final synchronized void m(com.google.android.libraries.navigation.internal.bi.j jVar) {
        this.x = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sx.m
    public final bj a() {
        if (this.C.compareAndSet(false, true)) {
            com.google.android.libraries.navigation.internal.aac.az.o(this.l, new aa(this), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        }
        return this.l;
    }

    public final void b(as asVar) {
        this.i = asVar;
        this.l.run();
    }

    public final synchronized void c(final as asVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        i(this.v);
        final com.google.android.libraries.navigation.internal.fw.g gVar = oVar == null ? null : oVar.p;
        if (asVar != null) {
            com.google.android.libraries.navigation.internal.bp.af afVar = asVar.c;
            com.google.android.libraries.navigation.internal.yx.ar.r(afVar, "Offline response must have directions");
            i iVar = this.m;
            n nVar = (n) u.a.q();
            int i = q.e;
            if (!nVar.b.H()) {
                nVar.v();
            }
            u uVar = (u) nVar.b;
            uVar.c = q.a(i);
            uVar.b |= 1;
            if (!nVar.b.H()) {
                nVar.v();
            }
            mf mfVar = afVar.a;
            u uVar2 = (u) nVar.b;
            mfVar.getClass();
            uVar2.e = mfVar;
            uVar2.b |= 4;
            iVar.a((u) nVar.t());
        } else {
            this.m.a(e.b(q.g, oVar));
        }
        if (this.z) {
            if ((asVar == null || asVar.a != com.google.android.libraries.navigation.internal.adr.at.SUCCESS) && this.x != null) {
                com.google.android.libraries.navigation.internal.fw.g gVar2 = this.B;
                if (gVar2 != null) {
                    j(null, gVar2);
                }
            } else {
                this.s.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sx.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab abVar = this.a;
                        com.google.android.libraries.navigation.internal.bi.j jVar = abVar.h;
                        com.google.android.libraries.navigation.internal.yx.ar.q(jVar);
                        if (abVar.e()) {
                            as asVar2 = asVar;
                            if (asVar2 == null) {
                                abVar.j = new am(jVar, abVar.c, (com.google.android.libraries.navigation.internal.fw.g) Objects.requireNonNull(gVar));
                                abVar.l.run();
                            }
                            if (asVar2 != null) {
                                abVar.b((as) Objects.requireNonNull(asVar2));
                            }
                            com.google.android.libraries.navigation.internal.gg.b bVar = abVar.f;
                            if (bVar != null) {
                                bVar.a();
                            }
                            com.google.android.libraries.navigation.internal.bp.af afVar2 = asVar2 == null ? null : asVar2.c;
                            if (afVar2 != null) {
                                abVar.e.e(new com.google.android.libraries.navigation.internal.ew.a(abVar.d, ((com.google.android.libraries.navigation.internal.bi.b) jVar).a, afVar2.a));
                            }
                        }
                    }
                }, g(), TimeUnit.MILLISECONDS);
            }
        }
        this.A = true;
    }

    public final synchronized boolean e() {
        if (!this.z) {
            return false;
        }
        this.z = false;
        return true;
    }

    public final void f(lz lzVar, boolean z, boolean z2, boolean z3) {
        long epochMilli = this.d.f().toEpochMilli();
        if (!com.google.android.libraries.navigation.internal.bi.m.b(lzVar)) {
            h(lzVar, epochMilli);
            return;
        }
        boolean zD = this.p.d();
        if (zD) {
            i iVar = this.m;
            n nVar = (n) u.a.q();
            int i = q.b;
            if (!nVar.b.H()) {
                nVar.v();
            }
            u uVar = (u) nVar.b;
            uVar.c = q.a(i);
            uVar.b |= 1;
            if (!nVar.b.H()) {
                nVar.v();
            }
            u uVar2 = (u) nVar.b;
            lzVar.getClass();
            uVar2.d = lzVar;
            uVar2.b |= 2;
            iVar.a((u) nVar.t());
            com.google.android.libraries.navigation.internal.bi.j jVarA = l.a(this.c, lzVar, epochMilli, z, this.D, this.w);
            m(jVarA);
            k(this.u);
            this.m.b(((com.google.android.libraries.navigation.internal.bi.b) jVarA).a);
            this.f = this.q.a(jVarA);
        }
        if (z2) {
            i iVar2 = this.m;
            n nVar2 = (n) u.a.q();
            int i2 = q.c;
            if (!nVar2.b.H()) {
                nVar2.v();
            }
            u uVar3 = (u) nVar2.b;
            uVar3.c = q.a(i2);
            uVar3.b |= 1;
            if (!nVar2.b.H()) {
                nVar2.v();
            }
            u uVar4 = (u) nVar2.b;
            lzVar.getClass();
            uVar4.d = lzVar;
            uVar4.b |= 2;
            iVar2.a((u) nVar2.t());
            com.google.android.libraries.navigation.internal.bi.j jVarA2 = l.a(this.c, lzVar, epochMilli, z, this.E, this.w);
            l(jVarA2, z3);
            k(this.v);
            com.google.android.libraries.navigation.internal.bi.b bVar = (com.google.android.libraries.navigation.internal.bi.b) jVarA2;
            this.m.b(bVar.a);
            this.g = this.r.a(bVar.a, bVar.b, bVar.c, this.s);
        }
        if (zD || z2) {
            return;
        }
        this.k = new an(com.google.android.libraries.navigation.internal.fw.g.SINGLE_REQUEST_FATAL_ERROR);
        this.l.run();
        h(lzVar, epochMilli);
    }

    public final synchronized void d(as asVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        com.google.android.libraries.navigation.internal.fw.g gVar = oVar == null ? null : oVar.p;
        if (asVar != null) {
            i(this.u);
            com.google.android.libraries.navigation.internal.bp.af afVar = asVar.c;
            com.google.android.libraries.navigation.internal.yx.ar.r(afVar, "Online response must have directions");
            i iVar = this.m;
            n nVar = (n) u.a.q();
            int i = q.d;
            if (!nVar.b.H()) {
                nVar.v();
            }
            u uVar = (u) nVar.b;
            uVar.c = q.a(i);
            uVar.b |= 1;
            if (!nVar.b.H()) {
                nVar.v();
            }
            mf mfVar = afVar.a;
            u uVar2 = (u) nVar.b;
            mfVar.getClass();
            uVar2.e = mfVar;
            uVar2.b |= 4;
            iVar.a((u) nVar.t());
        } else {
            this.m.a(e.b(q.f, oVar));
        }
        if (gVar == null || this.h == null || this.A) {
            j(asVar, gVar);
        } else {
            this.B = gVar;
        }
    }
}
