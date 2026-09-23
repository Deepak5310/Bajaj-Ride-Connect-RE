package com.google.android.libraries.navigation.internal.kf;

import android.view.View;
import android.view.ViewParent;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class q extends l {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.kf.q");
    private final com.google.android.libraries.navigation.internal.jy.af e;
    private final com.google.android.libraries.navigation.internal.mj.a f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final com.google.android.libraries.navigation.internal.jy.w h;
    private final com.google.android.libraries.navigation.internal.kb.c i;
    private final long j;
    private final boolean k;
    private final com.google.android.libraries.navigation.internal.jz.a l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.kb.c f463n;
    private final com.google.android.libraries.navigation.internal.jy.m p;
    final LinkedHashMap c = new LinkedHashMap();
    private List m = new ArrayList();
    private boolean o = false;

    public q(com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.jy.w wVar, com.google.android.libraries.navigation.internal.kb.c cVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.h = wVar;
        this.i = cVar;
        this.j = aVar.a();
        this.e = afVar;
        this.f = aVar;
        this.g = aVar2;
        com.google.android.libraries.navigation.internal.kb.c cVarA = cVar.a(afVar.b(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK));
        this.f463n = cVarA;
        this.p = com.google.android.libraries.navigation.internal.jy.m.e(cVarA, 0, com.google.android.libraries.navigation.internal.yx.a.a);
        this.k = true;
        this.l = null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:9:0x001b, B:11:0x0033, B:27:0x0069, B:29:0x0079, B:30:0x0082, B:32:0x0084, B:34:0x008a, B:36:0x0099, B:37:0x00ae, B:35:0x008d, B:13:0x0037, B:15:0x0043, B:26:0x0064, B:18:0x0048, B:20:0x0051, B:23:0x005e, B:22:0x005b), top: B:49:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:9:0x001b, B:11:0x0033, B:27:0x0069, B:29:0x0079, B:30:0x0082, B:32:0x0084, B:34:0x008a, B:36:0x0099, B:37:0x00ae, B:35:0x008d, B:13:0x0037, B:15:0x0043, B:26:0x0064, B:18:0x0048, B:20:0x0051, B:23:0x005e, B:22:0x005b), top: B:49:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008a A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:9:0x001b, B:11:0x0033, B:27:0x0069, B:29:0x0079, B:30:0x0082, B:32:0x0084, B:34:0x008a, B:36:0x0099, B:37:0x00ae, B:35:0x008d, B:13:0x0037, B:15:0x0043, B:26:0x0064, B:18:0x0048, B:20:0x0051, B:23:0x005e, B:22:0x005b), top: B:49:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008d A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:9:0x001b, B:11:0x0033, B:27:0x0069, B:29:0x0079, B:30:0x0082, B:32:0x0084, B:34:0x008a, B:36:0x0099, B:37:0x00ae, B:35:0x008d, B:13:0x0037, B:15:0x0043, B:26:0x0064, B:18:0x0048, B:20:0x0051, B:23:0x005e, B:22:0x005b), top: B:49:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00be  */
    private final com.google.android.libraries.navigation.internal.jy.o e(com.google.android.libraries.navigation.internal.jy.aa aaVar, an anVar) {
        i iVar;
        com.google.android.libraries.navigation.internal.jy.m mVar;
        com.google.android.libraries.navigation.internal.jy.o oVarA;
        com.google.android.libraries.navigation.internal.jy.m mVar2;
        com.google.android.libraries.navigation.internal.jy.m mVar3;
        com.google.android.libraries.navigation.internal.afd.a aVar;
        an anVarJ;
        com.google.android.libraries.navigation.internal.afd.a aVar2;
        int iA;
        if (!aaVar.j()) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(String.format("Invalid UserEvent3Params: %s, see http://go/gmm-logging-errors#general-validity.", aaVar)))).F((char) 762)).o();
            return com.google.android.libraries.navigation.internal.jy.o.a;
        }
        if (anVar.g()) {
            com.google.android.libraries.navigation.internal.jw.e.f((View) anVar.c(), aaVar);
        }
        d.a(aaVar);
        synchronized (this.c) {
            int size = this.m.size() + 1;
            long jA = this.f.a();
            long j = this.j;
            if (anVar.g()) {
                ViewParent parent = ((View) anVar.c()).getParent();
                while (true) {
                    if (parent != null) {
                        if ((parent instanceof View) && (oVarA = com.google.android.libraries.navigation.internal.jw.e.a((View) parent)) != null) {
                            if (this.i.equals(oVarA.c)) {
                                com.google.android.libraries.navigation.internal.jy.m mVar4 = oVarA.b;
                                if (mVar4 != null) {
                                    mVar2 = mVar4;
                                }
                            }
                            iVar = new i(aaVar, jA, j, size, mVar2);
                            mVar3 = (com.google.android.libraries.navigation.internal.jy.m) this.c.get(iVar);
                            if (mVar3 != null) {
                                return new com.google.android.libraries.navigation.internal.jy.o(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, mVar3, this.i);
                            }
                            com.google.android.libraries.navigation.internal.kb.c cVar = this.f463n;
                            aVar = aaVar.k;
                            if (aVar == null) {
                                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                            } else {
                                anVarJ = an.j(Integer.valueOf(aVar.a()));
                            }
                            com.google.android.libraries.navigation.internal.jy.m mVarE = com.google.android.libraries.navigation.internal.jy.m.e(cVar, size, anVarJ);
                            this.c.put(iVar, mVarE);
                            this.m.add(iVar);
                            this.e.h(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, aaVar);
                            aVar2 = ((com.google.android.libraries.navigation.internal.kd.a) this.h).b.k;
                            if (aVar2 != null) {
                                iA = aVar2.a();
                            } else {
                                iA = -1;
                            }
                            this.e.i(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, aaVar, iA);
                            return new com.google.android.libraries.navigation.internal.jy.o(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, mVarE, this.i);
                        }
                        parent = parent.getParent();
                    }
                    mVar = this.p;
                }
            } else {
                mVar = this.p;
            }
            mVar2 = mVar;
            iVar = new i(aaVar, jA, j, size, mVar2);
            mVar3 = (com.google.android.libraries.navigation.internal.jy.m) this.c.get(iVar);
            if (mVar3 != null) {
                return new com.google.android.libraries.navigation.internal.jy.o(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, mVar3, this.i);
            }
            com.google.android.libraries.navigation.internal.kb.c cVar2 = this.f463n;
            aVar = aaVar.k;
            if (aVar == null) {
                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
            } else {
                anVarJ = an.j(Integer.valueOf(aVar.a()));
            }
            com.google.android.libraries.navigation.internal.jy.m mVarE2 = com.google.android.libraries.navigation.internal.jy.m.e(cVar2, size, anVarJ);
            this.c.put(iVar, mVarE2);
            this.m.add(iVar);
            this.e.h(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, aaVar);
            aVar2 = ((com.google.android.libraries.navigation.internal.kd.a) this.h).b.k;
            if (aVar2 != null) {
                iA = aVar2.a();
            } else {
                iA = -1;
            }
            this.e.i(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, aaVar, iA);
            return new com.google.android.libraries.navigation.internal.jy.o(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, mVarE2, this.i);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.jy.r
    public final com.google.android.libraries.navigation.internal.jy.o a(View view) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        com.google.android.libraries.navigation.internal.jy.aa aaVarC = com.google.android.libraries.navigation.internal.jw.e.c(view);
        ar.q(aaVarC);
        return e(aaVarC, an.j(view));
    }

    @Override // com.google.android.libraries.navigation.internal.jy.r
    public final com.google.android.libraries.navigation.internal.jy.o b(com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        return e(aaVar, com.google.android.libraries.navigation.internal.yx.a.a);
    }

    @Override // com.google.android.libraries.navigation.internal.kf.l, com.google.android.libraries.navigation.internal.jy.r
    public final com.google.android.libraries.navigation.internal.jz.a c() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.r
    public final void d() {
        com.google.android.libraries.navigation.internal.ke.s sVar;
        com.google.android.libraries.navigation.internal.adq.ak akVar;
        synchronized (this.c) {
            if (this.m.isEmpty()) {
                return;
            }
            synchronized (this.c) {
                com.google.android.libraries.navigation.internal.jy.aa aaVar = ((com.google.android.libraries.navigation.internal.kd.a) this.h).b;
                d.a(aaVar);
                sVar = new com.google.android.libraries.navigation.internal.ke.s(this.m, an.i(aaVar), this.f, this.j, this.g, this.o);
                String str = this.f463n.a;
                if (str.isEmpty()) {
                    ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).F(763)).p("Error encoding event id during impression flushing");
                } else {
                    sVar.h(str);
                }
                com.google.android.libraries.navigation.internal.zt.d dVarA = com.google.android.libraries.navigation.internal.kb.a.a(this.f463n.a);
                ar.q(dVarA);
                sVar.u(((Long) ((dVarA.b & 2) != 0 ? an.j(Long.valueOf(dVarA.d)) : com.google.android.libraries.navigation.internal.yx.a.a).e(0L)).intValue());
                String str2 = this.o ? ((com.google.android.libraries.navigation.internal.jy.c) this.p).a.a : this.i.a;
                if (sVar.d() == null) {
                    akVar = (com.google.android.libraries.navigation.internal.adq.ak) al.a.q();
                } else {
                    al alVarD = sVar.d();
                    bb bbVar = (bb) alVarD.aH(5, null);
                    bbVar.x(alVarD);
                    akVar = (com.google.android.libraries.navigation.internal.adq.ak) bbVar;
                }
                if (!akVar.b.H()) {
                    akVar.v();
                }
                al alVar = (al) akVar.b;
                al alVar2 = al.a;
                alVar.b |= 2;
                alVar.d = str2;
                sVar.i((al) akVar.t());
                this.m = new ArrayList();
                this.c.clear();
                this.f463n = this.i.a(this.e.b(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK));
                this.o = true;
            }
            this.e.e(sVar);
        }
    }
}
