package com.google.android.libraries.navigation.internal.vl;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.f.h;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.be;
import com.google.android.libraries.navigation.internal.rw.q;
import com.google.android.libraries.navigation.internal.sv.bk;
import com.google.android.libraries.navigation.internal.tj.ab;
import com.google.android.libraries.navigation.internal.tj.ae;
import com.google.android.libraries.navigation.internal.tj.j;
import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.tj.x;
import com.google.android.libraries.navigation.internal.uh.m;
import com.google.android.libraries.navigation.internal.uh.n;
import com.google.android.libraries.navigation.internal.uh.p;
import com.google.android.libraries.navigation.internal.uq.o;
import com.google.android.libraries.navigation.internal.us.ah;
import com.google.android.libraries.navigation.internal.us.ai;
import com.google.android.libraries.navigation.internal.uz.i;
import com.google.android.libraries.navigation.internal.vi.l;
import com.google.android.libraries.navigation.internal.vi.v;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends m implements com.google.android.libraries.navigation.internal.vk.b {
    protected final com.google.android.libraries.navigation.internal.ia.e a;
    protected final Context b;
    protected final com.google.android.libraries.navigation.internal.uk.b c;
    protected final com.google.android.libraries.navigation.internal.uz.d d;
    protected CharSequence e;
    protected CharSequence f;
    protected String g;
    protected CharSequence h;
    protected String i;
    private final t j;
    private final com.google.android.libraries.navigation.internal.hf.c k;
    private final o l;
    private final Executor m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.ut.d f641n;
    private int o;
    private String p;
    private final List q;

    public c(n nVar, p pVar, Context context, t tVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.hf.c cVar, com.google.android.libraries.navigation.internal.uk.b bVar, o oVar, Executor executor, com.google.android.libraries.navigation.internal.uz.d dVar) {
        super(nVar, pVar);
        this.o = -1;
        this.q = new ArrayList();
        this.b = context;
        this.j = tVar;
        this.k = cVar;
        Pattern pattern = com.google.android.libraries.navigation.internal.hf.n.a;
        context.getResources();
        this.a = eVar;
        this.c = bVar;
        bVar.k(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vl.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s();
            }
        });
        this.l = oVar;
        this.m = executor;
        this.d = dVar;
    }

    private static CharSequence w(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null || !charSequence.toString().contentEquals(charSequence2)) {
            return charSequence2;
        }
        if ((charSequence instanceof Spanned) && (charSequence2 instanceof Spanned)) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), CharacterStyle.class);
            CharacterStyle[] characterStyleArr2 = (CharacterStyle[]) ((Spanned) charSequence2).getSpans(0, charSequence2.length(), CharacterStyle.class);
            if (characterStyleArr.length != characterStyleArr2.length) {
                return charSequence2;
            }
            for (int i = 0; i < characterStyleArr.length; i++) {
                if ((characterStyleArr[i].getUnderlying() instanceof ForegroundColorSpan) && (characterStyleArr2[i].getUnderlying() instanceof ForegroundColorSpan) && ((ForegroundColorSpan) characterStyleArr[i].getUnderlying()).getForegroundColor() != ((ForegroundColorSpan) characterStyleArr2[i].getUnderlying()).getForegroundColor()) {
                    return charSequence2;
                }
            }
        }
        return charSequence;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.a
    public com.google.android.libraries.navigation.internal.ut.d a() {
        return this.f641n;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public void aC() {
        this.a.e(this);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public void ay(Configuration configuration) {
        s();
    }

    @Override // com.google.android.libraries.navigation.internal.vk.b
    public CharSequence c() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.b
    public CharSequence d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.vk.b
    public String e() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SharedGuidedNavViewModelImpl.onNavigationUiStateChanged");
        try {
            j jVar = aVar.h;
            if (jVar == null) {
                this.c.h();
            } else {
                boolean z = aVar.i;
                jVar.d();
                this.c.l(aVar);
                this.d.e(jVar, aVar.i, this.c.g(), this);
                i iVarC = this.d.c();
                CharSequence charSequenceW = w(this.e, iVarC.b());
                CharSequence charSequenceW2 = w(this.f, iVarC.a());
                com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
                int iC = bVarC.c();
                this.o = iC;
                int i = bVarC.k;
                com.google.android.libraries.navigation.internal.ut.d bVar = null;
                if (iC == -1 || i == -1 || charSequenceW == null || charSequenceW2 == null) {
                    this.g = null;
                    this.p = null;
                    this.h = null;
                } else {
                    String strD = this.k.d(i, bVarC.b.O, true, true);
                    this.g = strD;
                    this.p = strD + "  •  " + charSequenceW2.toString();
                    String string = charSequenceW2.toString();
                    if (!string.substring(string.lastIndexOf(" ") + 1).isEmpty()) {
                        this.j.d().b(aa.k(com.google.android.libraries.navigation.internal.afe.i.c));
                    }
                    String str = this.p;
                    if (str != null) {
                        this.h = w(this.h, TextUtils.concat(charSequenceW, "  •  ", str));
                    }
                    this.e = charSequenceW;
                    this.f = charSequenceW2;
                }
                CharSequence charSequenceD = this.d.d();
                com.google.android.libraries.navigation.internal.hf.b bVar2 = new com.google.android.libraries.navigation.internal.hf.b(this.b);
                bVar2.a(charSequenceD);
                bVar2.a(this.b.getString(h.a));
                com.google.android.libraries.navigation.internal.hf.b bVar3 = new com.google.android.libraries.navigation.internal.hf.b(this.b);
                bVar3.a(charSequenceD);
                bVar3.a(this.b.getString(h.b));
                this.i = bVar3.toString();
                u uVar = aVar.b;
                com.google.android.libraries.navigation.internal.ut.d dVar = this.f641n;
                if ((dVar == null ? null : dVar.l()) != uVar) {
                    if (uVar == null) {
                        this.f641n = null;
                    } else {
                        o oVar = this.l;
                        Context context = this.b;
                        com.google.android.libraries.navigation.internal.ut.d dVarA = ((com.google.android.libraries.navigation.internal.uq.c) oVar).b.a(context, uVar, new com.google.android.libraries.navigation.internal.ut.d.a() { // from class: com.google.android.libraries.navigation.internal.vl.b
                            @Override // com.google.android.libraries.navigation.internal.ut.d.a
                            public final int a() {
                                return this.a.o;
                            }
                        }, false);
                        if (dVarA != null) {
                            bVar = dVarA;
                        } else {
                            com.google.android.libraries.navigation.internal.uq.j jVar2 = ((com.google.android.libraries.navigation.internal.uq.c) oVar).a;
                            if (uVar instanceof ab) {
                                ab abVar = (ab) uVar;
                                abVar.c.D();
                                if (abVar.e) {
                                    bVar = ((v) jVar2.d).a(context, abVar);
                                } else {
                                    ai aiVar = jVar2.c;
                                    context.getClass();
                                    com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) aiVar.a.a();
                                    eVar.getClass();
                                    com.google.android.libraries.navigation.internal.sl.d dVar2 = (com.google.android.libraries.navigation.internal.sl.d) aiVar.b.a();
                                    dVar2.getClass();
                                    com.google.android.libraries.navigation.internal.sn.h hVar = (com.google.android.libraries.navigation.internal.sn.h) aiVar.c.a();
                                    hVar.getClass();
                                    com.google.android.libraries.navigation.internal.mj.a aVar3 = (com.google.android.libraries.navigation.internal.mj.a) aiVar.d.a();
                                    aVar3.getClass();
                                    af afVar = (af) aiVar.e.a();
                                    afVar.getClass();
                                    t tVar = (t) aiVar.f.a();
                                    tVar.getClass();
                                    bn bnVar = (bn) aiVar.g.a();
                                    bnVar.getClass();
                                    Executor executor = (Executor) aiVar.h.a();
                                    executor.getClass();
                                    com.google.android.libraries.navigation.internal.uq.m mVar = (com.google.android.libraries.navigation.internal.uq.m) aiVar.i.a();
                                    mVar.getClass();
                                    com.google.android.libraries.navigation.internal.qy.h hVar2 = (com.google.android.libraries.navigation.internal.qy.h) aiVar.j.a();
                                    hVar2.getClass();
                                    com.google.android.libraries.navigation.internal.hf.c cVar = (com.google.android.libraries.navigation.internal.hf.c) aiVar.k.a();
                                    cVar.getClass();
                                    at atVar = (at) aiVar.l.a();
                                    atVar.getClass();
                                    com.google.android.libraries.navigation.internal.fz.d dVar3 = (com.google.android.libraries.navigation.internal.fz.d) aiVar.m.a();
                                    dVar3.getClass();
                                    com.google.android.libraries.navigation.internal.ch.b bVar4 = (com.google.android.libraries.navigation.internal.ch.b) aiVar.f622n.a();
                                    bVar4.getClass();
                                    q qVar = (q) aiVar.o.a();
                                    qVar.getClass();
                                    com.google.android.libraries.navigation.internal.dx.i iVar = (com.google.android.libraries.navigation.internal.dx.i) aiVar.p.a();
                                    iVar.getClass();
                                    bk bkVar = (bk) aiVar.q.a();
                                    bkVar.getClass();
                                    ae aeVar = (ae) aiVar.r.a();
                                    aeVar.getClass();
                                    bVar = new ah(context, eVar, dVar2, hVar, aVar3, afVar, tVar, bnVar, executor, mVar, hVar2, cVar, atVar, dVar3, abVar, bVar4, qVar, iVar, bkVar, aeVar);
                                }
                            } else if (uVar instanceof x) {
                                x xVar = (x) uVar;
                                com.google.android.libraries.navigation.internal.vd.n nVar = jVar2.b;
                                context.getClass();
                                com.google.android.libraries.navigation.internal.dy.b.a aVar4 = (com.google.android.libraries.navigation.internal.dy.b.a) ((com.google.android.libraries.navigation.internal.vi.m) nVar).a.a();
                                aVar4.getClass();
                                com.google.android.libraries.navigation.internal.afo.a aVar5 = (com.google.android.libraries.navigation.internal.afo.a) ((com.google.android.libraries.navigation.internal.vi.m) nVar).b.a();
                                aVar5.getClass();
                                com.google.android.libraries.navigation.internal.ia.e eVar2 = (com.google.android.libraries.navigation.internal.ia.e) ((com.google.android.libraries.navigation.internal.vi.m) nVar).c.a();
                                eVar2.getClass();
                                f fVar = (f) ((com.google.android.libraries.navigation.internal.vi.m) nVar).d.a();
                                fVar.getClass();
                                com.google.android.libraries.navigation.internal.sl.d dVar4 = (com.google.android.libraries.navigation.internal.sl.d) ((com.google.android.libraries.navigation.internal.vi.m) nVar).e.a();
                                dVar4.getClass();
                                com.google.android.libraries.navigation.internal.sn.h hVar3 = (com.google.android.libraries.navigation.internal.sn.h) ((com.google.android.libraries.navigation.internal.vi.m) nVar).f.a();
                                hVar3.getClass();
                                com.google.android.libraries.navigation.internal.mj.a aVar6 = (com.google.android.libraries.navigation.internal.mj.a) ((com.google.android.libraries.navigation.internal.vi.m) nVar).g.a();
                                aVar6.getClass();
                                af afVar2 = (af) ((com.google.android.libraries.navigation.internal.vi.m) nVar).h.a();
                                afVar2.getClass();
                                t tVar2 = (t) ((com.google.android.libraries.navigation.internal.vi.m) nVar).i.a();
                                tVar2.getClass();
                                bn bnVar2 = (bn) ((com.google.android.libraries.navigation.internal.vi.m) nVar).j.a();
                                bnVar2.getClass();
                                Executor executor2 = (Executor) ((com.google.android.libraries.navigation.internal.vi.m) nVar).k.a();
                                executor2.getClass();
                                com.google.android.libraries.navigation.internal.uq.m mVar2 = (com.google.android.libraries.navigation.internal.uq.m) ((com.google.android.libraries.navigation.internal.vi.m) nVar).l.a();
                                mVar2.getClass();
                                com.google.android.libraries.navigation.internal.vi.f.a aVar7 = (com.google.android.libraries.navigation.internal.vi.f.a) ((com.google.android.libraries.navigation.internal.vi.m) nVar).m.a();
                                aVar7.getClass();
                                com.google.android.libraries.navigation.internal.fz.d dVar5 = (com.google.android.libraries.navigation.internal.fz.d) ((com.google.android.libraries.navigation.internal.vi.m) nVar).f639n.a();
                                dVar5.getClass();
                                com.google.android.libraries.navigation.internal.so.a aVar8 = (com.google.android.libraries.navigation.internal.so.a) ((com.google.android.libraries.navigation.internal.vi.m) nVar).o.a();
                                aVar8.getClass();
                                com.google.android.libraries.navigation.internal.ch.b bVar5 = (com.google.android.libraries.navigation.internal.ch.b) ((com.google.android.libraries.navigation.internal.vi.m) nVar).p.a();
                                bVar5.getClass();
                                com.google.android.libraries.navigation.internal.dx.o oVar2 = (com.google.android.libraries.navigation.internal.dx.o) ((com.google.android.libraries.navigation.internal.vi.m) nVar).q.a();
                                oVar2.getClass();
                                com.google.android.libraries.navigation.internal.dx.i iVar2 = (com.google.android.libraries.navigation.internal.dx.i) ((com.google.android.libraries.navigation.internal.vi.m) nVar).r.a();
                                iVar2.getClass();
                                at atVar2 = (at) ((com.google.android.libraries.navigation.internal.vi.m) nVar).s.a();
                                atVar2.getClass();
                                be beVar = (be) ((com.google.android.libraries.navigation.internal.vi.m) nVar).t.a();
                                beVar.getClass();
                                bVar = new l(context, xVar, aVar4, aVar5, eVar2, fVar, dVar4, hVar3, aVar6, afVar2, tVar2, bnVar2, executor2, mVar2, aVar7, dVar5, aVar8, bVar5, oVar2, iVar2, atVar2, beVar);
                            } else if (uVar instanceof com.google.android.libraries.navigation.internal.tj.l) {
                                com.google.android.libraries.navigation.internal.vi.c cVar2 = jVar2.a;
                                context.getClass();
                                com.google.android.libraries.navigation.internal.bn.d dVar6 = (com.google.android.libraries.navigation.internal.bn.d) cVar2.a.a();
                                dVar6.getClass();
                                com.google.android.libraries.navigation.internal.ia.e eVar3 = (com.google.android.libraries.navigation.internal.ia.e) cVar2.b.a();
                                eVar3.getClass();
                                com.google.android.libraries.navigation.internal.fz.d dVar7 = (com.google.android.libraries.navigation.internal.fz.d) cVar2.c.a();
                                dVar7.getClass();
                                com.google.android.libraries.navigation.internal.sl.d dVar8 = (com.google.android.libraries.navigation.internal.sl.d) cVar2.d.a();
                                dVar8.getClass();
                                com.google.android.libraries.navigation.internal.sn.h hVar4 = (com.google.android.libraries.navigation.internal.sn.h) cVar2.e.a();
                                hVar4.getClass();
                                com.google.android.libraries.navigation.internal.mj.a aVar9 = (com.google.android.libraries.navigation.internal.mj.a) cVar2.f.a();
                                aVar9.getClass();
                                af afVar3 = (af) cVar2.g.a();
                                afVar3.getClass();
                                t tVar3 = (t) cVar2.h.a();
                                tVar3.getClass();
                                bn bnVar3 = (bn) cVar2.i.a();
                                bnVar3.getClass();
                                Executor executor3 = (Executor) cVar2.j.a();
                                executor3.getClass();
                                com.google.android.libraries.navigation.internal.uq.m mVar3 = (com.google.android.libraries.navigation.internal.uq.m) cVar2.k.a();
                                mVar3.getClass();
                                at atVar3 = (at) cVar2.l.a();
                                atVar3.getClass();
                                com.google.android.libraries.navigation.internal.ch.b bVar6 = (com.google.android.libraries.navigation.internal.ch.b) cVar2.m.a();
                                bVar6.getClass();
                                com.google.android.libraries.navigation.internal.dx.o oVar3 = (com.google.android.libraries.navigation.internal.dx.o) cVar2.f638n.a();
                                oVar3.getClass();
                                bVar = new com.google.android.libraries.navigation.internal.vi.b(context, dVar6, eVar3, dVar7, dVar8, hVar4, aVar9, afVar3, tVar3, bnVar3, executor3, mVar3, atVar3, bVar6, oVar3, (com.google.android.libraries.navigation.internal.tj.l) uVar);
                            }
                        }
                        this.f641n = bVar;
                    }
                    az().b();
                }
                s();
            }
            if (dVarB != null) {
                Trace.endSection();
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
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public void h(Bundle bundle) {
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.fn.a.class, new d(com.google.android.libraries.navigation.internal.fn.a.class, this, ap.UI_THREAD));
        this.a.c(this, fzVar.a());
    }

    public com.google.android.libraries.navigation.internal.uk.b n() {
        return this.c;
    }

    public Boolean o() {
        return Boolean.valueOf(this.f641n != null);
    }

    @Override // com.google.android.libraries.navigation.internal.vk.b
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public String b() {
        return this.i;
    }

    public synchronized void r(Runnable runnable) {
        this.q.add(runnable);
    }

    public synchronized void s() {
        Iterator it2 = this.q.iterator();
        while (it2.hasNext()) {
            this.m.execute((Runnable) it2.next());
        }
    }

    public void t(com.google.android.libraries.navigation.internal.fn.a aVar) {
        u();
    }

    public void u() {
        this.c.j();
    }

    public synchronized void v(Runnable runnable) {
        this.q.remove(runnable);
    }
}
