package com.google.android.libraries.navigation.internal.uj;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.tracing.Trace;
import com.google.android.apps.gmm.base.views.viewpager.ArrowViewPager;
import com.google.android.libraries.navigation.internal.bp.ac;
import com.google.android.libraries.navigation.internal.bp.bn;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.bp.bz;
import com.google.android.libraries.navigation.internal.ch.f;
import com.google.android.libraries.navigation.internal.jy.o;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.sn.h;
import com.google.android.libraries.navigation.internal.uc.g;
import com.google.android.libraries.navigation.internal.uc.j;
import com.google.android.libraries.navigation.internal.uh.n;
import com.google.android.libraries.navigation.internal.uh.p;
import com.google.android.libraries.navigation.internal.uh.w;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d implements com.google.android.libraries.navigation.internal.uk.b, ArrowViewPager.a, com.google.android.libraries.navigation.internal.uk.a.c {
    protected final n a;
    protected final p b;
    protected final Context c;
    private final b d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final com.google.android.libraries.navigation.internal.afo.a f;
    private com.google.android.libraries.navigation.internal.ui.a g;
    private com.google.android.libraries.navigation.internal.se.b h;
    private bq i;
    private final at j;
    private boolean k;
    private List l;
    private List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f617n;
    private String o;
    private Runnable p;
    private final f q;
    private int s;

    public d(n nVar, p pVar, Context context, b bVar, com.google.android.libraries.navigation.internal.afo.a<com.google.android.libraries.navigation.internal.sl.d> aVar, com.google.android.libraries.navigation.internal.afo.a<h> aVar2, at atVar) {
        int i = ev.d;
        ev evVar = lv.a;
        this.l = evVar;
        this.m = evVar;
        this.p = new Runnable() { // from class: com.google.android.libraries.navigation.internal.uj.c
            @Override // java.lang.Runnable
            public final void run() {
            }
        };
        this.a = nVar;
        this.b = pVar;
        this.c = context;
        this.d = bVar;
        this.e = aVar;
        this.f = aVar2;
        this.j = atVar;
        this.q = f.a;
    }

    @Override // com.google.android.apps.gmm.base.views.viewpager.ArrowViewPager.a
    public void a(int i, ArrowViewPager.b bVar, o oVar) {
        if (!this.a.c() || this.m.size() <= i) {
            return;
        }
        bq bqVarF = ((a) this.m.get(i)).f();
        View viewC = cy.c(this);
        if (viewC != null) {
            viewC.announceForAccessibility(((a) this.m.get(i)).E());
        }
        if (bVar != ArrowViewPager.b.PROGRAMMATIC) {
            this.b.g(bqVarF);
        }
        if (this.m.size() >= this.l.size() || i < this.m.size() - 1) {
            return;
        }
        n nVar = this.a;
        int i2 = com.google.android.libraries.navigation.internal.dw.h.a;
        nVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public ArrowViewPager.a b() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public com.google.android.libraries.navigation.internal.uk.a c() {
        return this.f617n;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public Boolean d() {
        boolean z = false;
        if (this.o != null && this.g != null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public Boolean e() {
        com.google.android.libraries.navigation.internal.ui.a aVar = this.g;
        boolean z = false;
        if (aVar != null && aVar.i) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public String f() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public List<? extends com.google.android.libraries.navigation.internal.uk.a> g() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void h() {
        int i = ev.d;
        this.m = lv.a;
        this.l = lv.a;
        this.f617n = null;
        this.i = null;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a.c
    public void i(bq bqVar) {
        com.google.android.libraries.navigation.internal.ui.a aVar;
        bw bwVarC;
        if (this.a.c() && (aVar = this.g) != null) {
            if (aVar.c.a == g.INSPECT_STEP) {
                w wVar = (w) this.b;
                if (!wVar.k.a()) {
                    ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).b(wVar.j);
                    wVar.q();
                    return;
                }
                com.google.android.libraries.navigation.internal.ea.c cVar = wVar.b;
                j jVarA = cVar.c.a();
                jVarA.d();
                jVarA.c();
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVarA.a());
                wVar.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).a();
                wVar.c();
                return;
            }
            this.b.g(bqVar);
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.c.getSystemService("accessibility");
            if ((accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) || bqVar != this.i || this.h == null) {
                return;
            }
            h hVar = (h) this.f.a();
            com.google.android.libraries.navigation.internal.se.b bVar = this.h;
            bq bqVar2 = bVar.c;
            bw bwVar = bqVar2 != null ? (bw) gs.c(bqVar2.A, null) : null;
            int i = bVar.f;
            com.google.android.libraries.navigation.internal.vn.d dVarD = (bwVar == null || i == -1) ? null : hVar.d(bwVar, bVar.b.Y, i, bVar.p, 0);
            if (dVarD == null) {
                if (bqVar2 == null || (bwVarC = bqVar2.c()) == null) {
                    dVarD = null;
                } else {
                    for (bz bzVar : bwVarC.c()) {
                        if (bzVar.f()) {
                            bn bnVarA = h.a(bzVar.c());
                            if (bnVarA == null) {
                                break;
                            } else {
                                dVarD = com.google.android.libraries.navigation.internal.vn.d.b(bwVarC, bnVarA.a, ac.b(bnVarA.b), bnVarA.c);
                            }
                        }
                    }
                    dVarD = null;
                }
            }
            ((com.google.android.libraries.navigation.internal.sl.d) this.e.a()).i(dVarD, com.google.android.libraries.navigation.internal.sl.h.c, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void j() {
        List listSubList;
        d dVar = this;
        if (dVar.g == null || dVar.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        bq bqVar = dVar.i;
        int i = bqVar == null ? 0 : bqVar.i;
        ev evVarP = ev.p(dVar.h.b.l);
        List list = dVar.m;
        com.google.android.libraries.navigation.internal.uk.a aVar = (list == null || dVar.i == null || list.isEmpty()) ? null : (com.google.android.libraries.navigation.internal.uk.a) dVar.m.get(0);
        int i2 = i;
        while (i2 < ((lv) evVarP).c) {
            bq bqVar2 = (bq) evVarP.get(i2);
            b bVar = dVar.d;
            Context context = dVar.c;
            com.google.android.libraries.navigation.internal.ui.a aVar2 = dVar.g;
            boolean z = aVar2.i;
            com.google.android.libraries.navigation.internal.uk.a aVar3 = i2 == i ? aVar : null;
            Runnable runnable = dVar.p;
            boolean z2 = dVar.k;
            int i3 = dVar.s;
            com.google.android.libraries.navigation.internal.up.g gVar = (com.google.android.libraries.navigation.internal.up.g) bVar.a.a();
            gVar.getClass();
            com.google.android.libraries.navigation.internal.hf.c cVar = (com.google.android.libraries.navigation.internal.hf.c) bVar.b.a();
            cVar.getClass();
            com.google.android.libraries.navigation.internal.bn.d dVar2 = (com.google.android.libraries.navigation.internal.bn.d) bVar.c.a();
            dVar2.getClass();
            a.C0036a c0036a = (a.C0036a) bVar.d.a();
            c0036a.getClass();
            com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a interfaceC0037a = (com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a) bVar.e.a();
            interfaceC0037a.getClass();
            com.google.android.libraries.navigation.internal.uk.a.b bVar2 = (com.google.android.libraries.navigation.internal.uk.a.b) bVar.f.a();
            bVar2.getClass();
            com.google.android.libraries.navigation.internal.uk.a.d dVar3 = (com.google.android.libraries.navigation.internal.uk.a.d) bVar.g.a();
            dVar3.getClass();
            com.google.android.libraries.navigation.internal.um.d dVar4 = (com.google.android.libraries.navigation.internal.um.d) bVar.h.a();
            dVar4.getClass();
            com.google.android.libraries.navigation.internal.um.d.a aVar4 = (com.google.android.libraries.navigation.internal.um.d.a) bVar.i.a();
            aVar4.getClass();
            com.google.android.libraries.navigation.internal.uz.c cVar2 = (com.google.android.libraries.navigation.internal.uz.c) bVar.j.a();
            com.google.android.libraries.navigation.internal.fz.d dVar5 = (com.google.android.libraries.navigation.internal.fz.d) bVar.k.a();
            dVar5.getClass();
            com.google.android.libraries.navigation.internal.cc.b bVar3 = (com.google.android.libraries.navigation.internal.cc.b) bVar.l.a();
            context.getClass();
            bqVar2.getClass();
            aVar2.getClass();
            runnable.getClass();
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new a(gVar, cVar, dVar2, c0036a, interfaceC0037a, bVar2, dVar3, dVar4, aVar4, cVar2, dVar5, bVar3, context, bqVar2, aVar2, this, z, aVar3, null, runnable, z2, false, i3));
            i2++;
            dVar = this;
            arrayList = arrayList2;
            evVarP = evVarP;
            i = i;
        }
        d dVar6 = dVar;
        dVar6.l = arrayList;
        if (dVar6.g.a) {
            listSubList = dVar6.l.subList(0, Math.min(dVar6.l.size(), 6));
        } else {
            listSubList = dVar6.l;
        }
        dVar6.m = listSubList;
        dVar6.f617n = null;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void k(Runnable runnable) {
        this.p = runnable;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0091 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:3:0x0006, B:6:0x000c, B:8:0x0021, B:12:0x0033, B:14:0x0039, B:16:0x003d, B:18:0x0041, B:20:0x0048, B:21:0x004a, B:23:0x0052, B:25:0x0060, B:27:0x0068, B:28:0x0073, B:30:0x0079, B:31:0x007f, B:33:0x0085, B:49:0x00e7, B:51:0x00eb, B:53:0x00f1, B:55:0x00f7, B:56:0x00fd, B:58:0x0103, B:60:0x010f, B:34:0x0091, B:36:0x0095, B:39:0x009a, B:41:0x00a3, B:43:0x00b3, B:45:0x00cd, B:46:0x00de, B:47:0x00e1, B:48:0x00e4, B:9:0x002e), top: B:71:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:3:0x0006, B:6:0x000c, B:8:0x0021, B:12:0x0033, B:14:0x0039, B:16:0x003d, B:18:0x0041, B:20:0x0048, B:21:0x004a, B:23:0x0052, B:25:0x0060, B:27:0x0068, B:28:0x0073, B:30:0x0079, B:31:0x007f, B:33:0x0085, B:49:0x00e7, B:51:0x00eb, B:53:0x00f1, B:55:0x00f7, B:56:0x00fd, B:58:0x0103, B:60:0x010f, B:34:0x0091, B:36:0x0095, B:39:0x009a, B:41:0x00a3, B:43:0x00b3, B:45:0x00cd, B:46:0x00de, B:47:0x00e1, B:48:0x00e4, B:9:0x002e), top: B:71:0x0006 }] */
    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void l(com.google.android.libraries.navigation.internal.ui.a aVar) {
        com.google.android.libraries.navigation.internal.se.b bVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("HeaderViewModelImpl.setFragmentState");
        try {
            com.google.android.libraries.navigation.internal.tj.j jVar = aVar.h;
            if (jVar != null) {
                com.google.android.libraries.navigation.internal.ui.a aVar2 = this.g;
                this.g = aVar;
                com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
                this.h = bVarC;
                this.i = bVarC.c;
                if (com.google.android.libraries.navigation.internal.up.b.b(jVar)) {
                    this.o = this.c.getString(com.google.android.libraries.navigation.internal.up.b.a(jVar));
                } else {
                    this.o = null;
                }
                if (aVar2 != null && aVar.a == aVar2.a) {
                    bq bqVar = this.i;
                    if (bqVar == null && (bVar = this.h) != null) {
                        bq[] bqVarArr = bVar.b.l;
                        if (bqVarArr.length > 0) {
                            bqVar = bqVarArr[0];
                        }
                    }
                    if (!this.m.isEmpty() && ((a) this.m.get(0)).f() == bqVar) {
                        if (!this.m.isEmpty()) {
                            ((a) this.m.get(0)).H(aVar);
                        }
                        if (aVar.i != aVar2.i) {
                            Iterator it2 = this.m.iterator();
                            while (it2.hasNext()) {
                                ((com.google.android.libraries.navigation.internal.uk.a) it2.next()).G(aVar.i);
                            }
                        }
                    } else if (this.g != null) {
                        j();
                    } else {
                        j();
                    }
                } else if (this.g != null || this.h == null || this.l.size() <= 1 || ((a) this.l.get(1)).f() != this.i) {
                    j();
                } else {
                    this.l.remove(0);
                    ((a) this.l.get(0)).I(this.g);
                    this.f617n = null;
                    this.m = this.g.a ? this.l.subList(0, Math.min(this.l.size(), 6)) : this.l;
                }
                com.google.android.libraries.navigation.internal.ui.a aVar3 = this.g;
                if (aVar3 != null) {
                    bq bqVar2 = aVar3.j;
                    a aVar4 = this.f617n;
                    if (aVar4 == null || aVar4.f() != bqVar2) {
                        for (a aVar5 : this.m) {
                            if (aVar5.f() == bqVar2) {
                                this.f617n = aVar5;
                                break;
                            }
                        }
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

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void m(int i) {
        this.s = i;
    }

    @Override // com.google.android.libraries.navigation.internal.uk.b
    public void n(boolean z) {
        if (this.k != z) {
            this.k = z;
            j();
        }
    }
}
