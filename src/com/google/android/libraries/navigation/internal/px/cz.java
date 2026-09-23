package com.google.android.libraries.navigation.internal.px;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.LabelRenderer;
import com.google.android.libraries.geo.mapcore.renderer.LayeredLabelRenderer;
import com.google.android.libraries.navigation.internal.agi.ge;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.ku;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cz implements com.google.android.libraries.geo.mapcore.renderer.cy {
    private static final Comparator f = new cx();
    public volatile boolean a;
    public volatile boolean b;
    public volatile boolean c;
    public final com.google.android.libraries.navigation.internal.nt.p d;
    public final com.google.android.libraries.navigation.internal.nt.p e;
    private final cn g;
    private final com.google.android.libraries.navigation.internal.pb.t j;
    private final com.google.android.libraries.geo.mapcore.renderer.ax k;
    private final cu l;
    private boolean m;
    private final com.google.android.libraries.navigation.internal.kl.b r;
    private final bb s;
    private final com.google.android.libraries.navigation.internal.ni.a t;
    private final com.google.android.libraries.navigation.internal.po.dg u;
    private final List h = new ArrayList();
    private final Set i = new HashSet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Set f542n = new HashSet();
    private final ArrayList o = new ArrayList();
    private Set p = new HashSet();
    private Set q = new HashSet();

    public cz(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.po.dg dgVar, bb bbVar, cn cnVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.nt.p pVar, com.google.android.libraries.navigation.internal.nt.p pVar2) {
        new ArrayList();
        this.j = tVar;
        this.k = axVar;
        this.l = new cu();
        this.r = bVar;
        this.u = dgVar;
        this.s = bbVar;
        this.g = cnVar;
        this.t = aVar;
        this.d = pVar;
        this.e = pVar2;
    }

    private final synchronized void h() {
        long jA = this.t.a();
        List list = this.h;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            cy cyVar = (cy) list.get(i);
            ai aiVar = cyVar.c;
            ai aiVar2 = cyVar.b;
            int i2 = cyVar.a;
            int i3 = 2;
            if (i2 == 1) {
                if (!this.f542n.contains(aiVar2)) {
                    aiVar2.C(8);
                    this.f542n.add(aiVar2);
                }
                aiVar2.K(jA, 2);
            } else if (i2 != 2) {
                if (aiVar != null && this.f542n.contains(aiVar)) {
                    this.f542n.remove(aiVar);
                    aiVar.D(8);
                }
                if (!this.f542n.contains(aiVar2)) {
                    aiVar2.C(8);
                    this.f542n.add(aiVar2);
                }
                if (!aiVar2.p()) {
                    i3 = 4;
                }
                aiVar2.K(jA, i3);
            } else if (this.f542n.contains(aiVar2)) {
                aiVar2.K(jA, 3);
            }
        }
        Iterator it2 = this.i.iterator();
        while (it2.hasNext()) {
            ((ai) it2.next()).D(16);
        }
        this.i.clear();
        list.clear();
    }

    public final synchronized void a(ai aiVar) {
        this.d.c(false);
        this.e.c(false);
        if (!this.i.contains(aiVar)) {
            aiVar.C(16);
            this.i.add(aiVar);
        }
        this.h.add(new cy(1, aiVar));
    }

    public final synchronized void b() {
        Iterator it2 = this.i.iterator();
        while (it2.hasNext()) {
            ((ai) it2.next()).D(16);
        }
        Iterator it3 = this.f542n.iterator();
        while (it3.hasNext()) {
            ((ai) it3.next()).D(8);
        }
        this.h.clear();
        this.i.clear();
        this.f542n.clear();
        this.g.c();
        this.m = true;
        this.d.c(true);
        this.e.c(true);
    }

    public final synchronized void c(ai aiVar) {
        this.d.c(false);
        this.e.c(false);
        if (!this.i.contains(aiVar)) {
            aiVar.C(16);
            this.i.add(aiVar);
        }
        this.h.add(new cy(2, aiVar));
    }

    public final synchronized void d(ai aiVar, ai aiVar2) {
        this.d.c(false);
        this.e.c(false);
        if (aiVar.A().X() == aiVar2.A().X()) {
            aiVar2.o(aiVar);
            if (aiVar2.p()) {
                aiVar2.k();
            }
        }
        if (!this.i.contains(aiVar)) {
            aiVar.C(16);
            this.i.add(aiVar);
        }
        if (!this.i.contains(aiVar2)) {
            aiVar2.C(16);
            this.i.add(aiVar2);
        }
        this.h.add(new cy(aiVar2, aiVar));
    }

    public final void e() {
        this.k.o();
    }

    /* JADX WARN: Code duplicated, block: B:186:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:195:0x05cd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v33, types: [com.google.android.libraries.navigation.internal.ol.o, com.google.android.libraries.navigation.internal.ol.u, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.libraries.geo.mapcore.renderer.cy
    public final void f(LabelRenderer labelRenderer, int i, int i2) throws Throwable {
        ev evVarO;
        Map map;
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th;
        ci ciVar;
        fy fyVarO;
        boolean z;
        float[] fArr;
        com.google.android.libraries.navigation.internal.agg.be beVar;
        boolean z2;
        int i3;
        ai aiVar;
        boolean z3;
        int i4;
        boolean z4;
        ai aiVar2;
        boolean z5;
        int i5;
        Set setD;
        float[] fArr2;
        LabelRenderer labelRenderer2 = labelRenderer;
        ((com.google.android.libraries.navigation.internal.km.t) this.r.a(com.google.android.libraries.navigation.internal.km.p.f)).b();
        labelRenderer2.c = i;
        labelRenderer2.d = i2;
        labelRenderer2.b.c();
        LayeredLabelRenderer layeredLabelRenderer = labelRenderer2.a;
        if (layeredLabelRenderer != null) {
            layeredLabelRenderer.d.c();
        }
        this.a = true;
        h();
        cn cnVar = this.g;
        synchronized (cnVar.c) {
            if (!cnVar.c.isEmpty()) {
                ((com.google.android.libraries.navigation.internal.kk.k) cnVar.a.a(com.google.android.libraries.navigation.internal.km.p.aA)).a(cnVar.c.size());
            }
            evVarO = ev.o(cnVar.c);
            cnVar.c.clear();
        }
        synchronized (cnVar) {
            no it2 = evVarO.iterator();
            while (it2.hasNext()) {
                cl clVar = (cl) it2.next();
                int i6 = clVar.g;
                int i7 = i6 - 1;
                if (i6 == 0) {
                    throw null;
                }
                switch (i7) {
                    case 0:
                        if (clVar.a()) {
                            com.google.android.libraries.navigation.internal.agg.be beVar2 = cnVar.e;
                            int i8 = clVar.a;
                            com.google.android.libraries.navigation.internal.ol.d dVar2 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar2.e(clVar.b.V());
                            dVar2.g(clVar.b.o());
                            dVar2.c(!clVar.b.ai());
                            dVar2.b(clVar.c);
                            dVar2.h(com.google.android.libraries.navigation.internal.ol.ap.PLACED_FULLY);
                            dVar2.f(com.google.android.libraries.navigation.internal.yx.an.i(clVar.e));
                            dVar2.d(com.google.android.libraries.navigation.internal.yx.an.i(clVar.f));
                            beVar2.a(i8, dVar2.a());
                        } else {
                            cnVar.d(clVar);
                        }
                        break;
                    case 1:
                        if (clVar.a()) {
                            com.google.android.libraries.navigation.internal.agg.be beVar3 = cnVar.e;
                            int i9 = clVar.a;
                            com.google.android.libraries.navigation.internal.ol.d dVar3 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar3.e(clVar.b.V());
                            dVar3.g(clVar.b.o());
                            dVar3.c(!clVar.b.ai());
                            dVar3.b(clVar.c);
                            dVar3.h(com.google.android.libraries.navigation.internal.ol.ap.SECONDARY_HIDDEN);
                            dVar3.f(com.google.android.libraries.navigation.internal.yx.an.i(clVar.e));
                            dVar3.d(com.google.android.libraries.navigation.internal.yx.an.i(clVar.f));
                            beVar3.a(i9, dVar3.a());
                        } else {
                            cnVar.d(clVar);
                        }
                        break;
                    case 2:
                        if (clVar.a()) {
                            com.google.android.libraries.navigation.internal.agg.be beVar4 = cnVar.e;
                            int i10 = clVar.a;
                            com.google.android.libraries.navigation.internal.ol.d dVar4 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar4.e(clVar.b.V());
                            dVar4.g(clVar.b.o());
                            dVar4.c(!clVar.b.ai());
                            dVar4.b(clVar.c);
                            dVar4.h(com.google.android.libraries.navigation.internal.ol.ap.TERTIARY_HIDDEN);
                            dVar4.f(com.google.android.libraries.navigation.internal.yx.an.i(clVar.e));
                            dVar4.d(com.google.android.libraries.navigation.internal.yx.an.i(clVar.f));
                            beVar4.a(i10, dVar4.a());
                        } else {
                            cnVar.d(clVar);
                        }
                        break;
                    case 3:
                        if (clVar.a()) {
                            com.google.android.libraries.navigation.internal.agg.be beVar5 = cnVar.e;
                            int i11 = clVar.a;
                            com.google.android.libraries.navigation.internal.ol.d dVar5 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar5.e(clVar.b.V());
                            dVar5.g(clVar.b.o());
                            dVar5.c(!clVar.b.ai());
                            dVar5.b(clVar.c);
                            dVar5.h(com.google.android.libraries.navigation.internal.ol.ap.SECONDARY_AND_TERTIARY_HIDDEN);
                            dVar5.f(com.google.android.libraries.navigation.internal.yx.an.i(clVar.e));
                            dVar5.d(com.google.android.libraries.navigation.internal.yx.an.i(clVar.f));
                            beVar5.a(i11, dVar5.a());
                        } else {
                            cnVar.d(clVar);
                        }
                        break;
                    case 4:
                        if (clVar.a()) {
                            Map map2 = cnVar.f;
                            com.google.android.libraries.navigation.internal.adg.ef efVarO = clVar.b.o();
                            com.google.android.libraries.navigation.internal.ol.d dVar6 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar6.e(clVar.b.V());
                            dVar6.g(clVar.b.o());
                            dVar6.c(!clVar.b.ai());
                            dVar6.b(clVar.c);
                            dVar6.h(com.google.android.libraries.navigation.internal.ol.ap.REPRESSED);
                            map2.put(efVarO, dVar6.a());
                        }
                        break;
                    case 5:
                        if (clVar.a()) {
                            Map map3 = cnVar.f;
                            com.google.android.libraries.navigation.internal.adg.ef efVarO2 = clVar.b.o();
                            com.google.android.libraries.navigation.internal.ol.d dVar7 = new com.google.android.libraries.navigation.internal.ol.d();
                            dVar7.e(clVar.b.V());
                            dVar7.g(clVar.b.o());
                            dVar7.c(!clVar.b.ai());
                            dVar7.b(clVar.c);
                            dVar7.h(com.google.android.libraries.navigation.internal.ol.ap.TRUMPED);
                            map3.put(efVarO2, dVar7.a());
                        }
                        break;
                    case 6:
                        cnVar.e.b(clVar.a);
                        if (cnVar.g.containsKey(Integer.valueOf(clVar.a))) {
                            cnVar.g.remove(Integer.valueOf(clVar.a));
                        }
                        break;
                }
                clVar.b();
                cnVar.b.g(clVar);
            }
        }
        long jA = this.t.a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelingBehavior.commit - animate pois");
        try {
            com.google.android.libraries.navigation.internal.po.dg dgVar = this.u;
            dgVar.b.clear();
            if (dgVar.a.isEmpty()) {
                map = dgVar.b;
            } else {
                dgVar.c.clear();
                synchronized (dgVar.a) {
                    dgVar.c.putAll(dgVar.a);
                }
                for (Map.Entry entry : dgVar.c.entrySet()) {
                    dgVar.b.put((com.google.android.libraries.navigation.internal.ol.u) entry.getKey(), ((com.google.android.libraries.navigation.internal.ol.t) entry.getValue()).a((com.google.android.libraries.navigation.internal.ol.u) entry.getKey()));
                }
                map = dgVar.b;
            }
            HashMap map4 = new HashMap();
            ba baVar = new ba();
            bi biVar = new bi();
            com.google.android.libraries.navigation.internal.oe.ay ayVar = new com.google.android.libraries.navigation.internal.oe.ay();
            float[] fArr3 = new float[8];
            com.google.android.libraries.navigation.internal.agg.be beVar6 = new com.google.android.libraries.navigation.internal.agg.be();
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("render animating-in & animated-in labels");
            try {
                Iterator it3 = this.f542n.iterator();
                while (it3.hasNext()) {
                    try {
                        ((ai) it3.next()).i(this.l, this.j);
                    } catch (Throwable th2) {
                        th = th2;
                        dVar = dVarB2;
                    }
                }
                this.o.clear();
                this.o.ensureCapacity(this.f542n.size());
                this.o.addAll(this.f542n);
                Collections.sort(this.o, f);
                Iterator it4 = this.o.iterator();
                boolean zS = true;
                boolean z6 = false;
                while (it4.hasNext()) {
                    ai aiVar3 = (ai) it4.next();
                    it4 = it4;
                    int iJ = aiVar3.J(jA);
                    jA = jA;
                    if (iJ == 5) {
                        this.f542n.remove(aiVar3);
                        aiVar3.D(8);
                        dVar = dVarB2;
                        z = zS;
                        fArr = fArr3;
                        beVar = beVar6;
                        z2 = z6;
                    } else {
                        ax axVar = aiVar3 instanceof ax ? (ax) aiVar3 : null;
                        if (axVar == null) {
                            i3 = iJ;
                            dVar = dVarB2;
                            aiVar = aiVar3;
                            z = zS;
                            fArr = fArr3;
                            beVar = beVar6;
                            z2 = z6;
                        } else {
                            ?? r3 = axVar.v;
                            if (r3 != 0) {
                                beVar = beVar6;
                                bb bbVar = this.s;
                                dVar = dVarB2;
                                synchronized (((com.google.android.libraries.navigation.internal.po.df) bbVar).a) {
                                    z = zS;
                                    setD = ((com.google.android.libraries.navigation.internal.po.df) bbVar).a.D(r3);
                                }
                                if (setD.isEmpty()) {
                                    i5 = iJ;
                                    aiVar = aiVar3;
                                    fArr2 = fArr3;
                                    z2 = z6;
                                } else {
                                    synchronized (bbVar) {
                                        Iterator it5 = setD.iterator();
                                        while (it5.hasNext()) {
                                            com.google.android.libraries.navigation.internal.po.de deVar = (com.google.android.libraries.navigation.internal.po.de) it5.next();
                                            Iterator it6 = it5;
                                            boolean z7 = z6;
                                            ai aiVar4 = aiVar3;
                                            int i12 = iJ;
                                            float[] fArr4 = fArr3;
                                            ba baVar2 = (ba) ((com.google.android.libraries.navigation.internal.po.df) bbVar).c.put(deVar.a, new ba(deVar.b, deVar.c, deVar.d));
                                            if (baVar2 != null) {
                                                ku kuVar = ((com.google.android.libraries.navigation.internal.po.df) bbVar).d;
                                                com.google.android.libraries.navigation.internal.ol.u uVar = baVar2.c;
                                                com.google.android.libraries.navigation.internal.yx.ar.q(uVar);
                                                kuVar.remove(uVar);
                                            }
                                            ((com.google.android.libraries.navigation.internal.po.df) bbVar).d.add(deVar.b);
                                            it5 = it6;
                                            z6 = z7;
                                            aiVar3 = aiVar4;
                                            iJ = i12;
                                            fArr3 = fArr4;
                                        }
                                        i5 = iJ;
                                        aiVar = aiVar3;
                                        fArr2 = fArr3;
                                        z2 = z6;
                                    }
                                }
                                if (this.s.c(r3)) {
                                    map4.put(r3, axVar);
                                }
                                com.google.android.libraries.navigation.internal.ol.bd bdVar = (com.google.android.libraries.navigation.internal.ol.bd) map.get(r3);
                                boolean zContains = this.p.contains(r3);
                                if (bdVar != null) {
                                    this.q.add(r3);
                                    axVar.x(bdVar, !zContains);
                                    i3 = i5;
                                    fArr = fArr2;
                                } else {
                                    if (zContains) {
                                        com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("clearTransformation");
                                        try {
                                            synchronized (axVar.q) {
                                                try {
                                                    axVar.w = false;
                                                } catch (Throwable th3) {
                                                    throw th3;
                                                }
                                            }
                                            if (dVarB3 != null) {
                                                Trace.endSection();
                                            }
                                        } catch (Throwable th4) {
                                            if (dVarB3 == null) {
                                                throw th4;
                                            }
                                            try {
                                                Trace.endSection();
                                                throw th4;
                                            } catch (Throwable th5) {
                                                th4.addSuppressed(th5);
                                                throw th4;
                                            }
                                        }
                                    }
                                    if (this.s.b(r3, baVar)) {
                                        com.google.android.libraries.navigation.internal.ol.u uVar2 = baVar.c;
                                        com.google.android.libraries.navigation.internal.yx.ar.q(uVar2);
                                        ax axVar2 = (ax) map4.get(uVar2);
                                        if (axVar2 != null && axVar2.y(biVar)) {
                                            com.google.android.libraries.navigation.internal.pb.t tVar = this.j;
                                            float f2 = baVar.a;
                                            float f3 = baVar.b;
                                            int i13 = biVar.g;
                                            int i14 = i13 - 1;
                                            if (i13 == 0) {
                                                throw null;
                                            }
                                            if (i14 == 1) {
                                                com.google.android.libraries.navigation.internal.oe.x xVar = bi.a;
                                                com.google.android.libraries.navigation.internal.oe.x xVar2 = biVar.c;
                                                float f4 = xVar2.a;
                                                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = biVar.e;
                                                float f5 = f4 + (ayVar2.b * f2);
                                                com.google.android.libraries.navigation.internal.oe.ay ayVar3 = biVar.f;
                                                xVar.J((int) (f5 + (ayVar3.b * f3)), (int) (xVar2.b + (ayVar2.c * f2) + (ayVar3.c * f3)));
                                                if (!com.google.android.libraries.navigation.internal.pb.j.n(tVar, bi.a, ayVar, bi.b)) {
                                                    fArr = fArr2;
                                                }
                                                labelRenderer2 = labelRenderer;
                                                fArr3 = fArr;
                                                beVar6 = beVar;
                                                dVarB2 = dVar;
                                                zS = z;
                                                z6 = z2;
                                            } else if (i14 == 2) {
                                                ayVar.r(biVar.d);
                                                com.google.android.libraries.navigation.internal.oe.ay ayVar4 = biVar.e;
                                                ayVar.i(ayVar4.b * f2, ayVar4.c * f2);
                                                com.google.android.libraries.navigation.internal.oe.ay ayVar5 = biVar.f;
                                                ayVar.i(ayVar5.b * f3, ayVar5.c * f3);
                                            }
                                            fArr = fArr2;
                                            com.google.android.libraries.navigation.internal.oe.x xVarJ = com.google.android.libraries.navigation.internal.pb.j.j(this.j, ayVar.b, ayVar.c, fArr);
                                            if (xVarJ != null) {
                                                com.google.android.libraries.navigation.internal.ol.ay ayVar6 = (com.google.android.libraries.navigation.internal.ol.ay) com.google.android.libraries.navigation.internal.ol.bd.a.q();
                                                com.google.android.libraries.navigation.internal.acc.c cVar = (com.google.android.libraries.navigation.internal.acc.c) com.google.android.libraries.navigation.internal.acc.d.a.q();
                                                double dB = xVarJ.b();
                                                if (!cVar.b.H()) {
                                                    cVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.acc.d dVar8 = (com.google.android.libraries.navigation.internal.acc.d) cVar.b;
                                                dVar8.b |= 2;
                                                dVar8.d = dB;
                                                double d = xVarJ.d();
                                                if (!cVar.b.H()) {
                                                    cVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.acc.d dVar9 = (com.google.android.libraries.navigation.internal.acc.d) cVar.b;
                                                dVar9.b |= 1;
                                                dVar9.c = d;
                                                if (!ayVar6.b.H()) {
                                                    ayVar6.v();
                                                }
                                                com.google.android.libraries.navigation.internal.ol.bd bdVar2 = (com.google.android.libraries.navigation.internal.ol.bd) ayVar6.b;
                                                com.google.android.libraries.navigation.internal.acc.d dVar10 = (com.google.android.libraries.navigation.internal.acc.d) cVar.t();
                                                dVar10.getClass();
                                                bdVar2.c = dVar10;
                                                z4 = true;
                                                bdVar2.b |= 1;
                                                com.google.android.libraries.navigation.internal.ol.bd bdVar3 = (com.google.android.libraries.navigation.internal.ol.bd) ayVar6.t();
                                                z3 = false;
                                                axVar.x(bdVar3, false);
                                                axVar.i(this.l, this.j);
                                                i3 = i5;
                                            } else {
                                                labelRenderer2 = labelRenderer;
                                                fArr3 = fArr;
                                                beVar6 = beVar;
                                                dVarB2 = dVar;
                                                zS = z;
                                                z6 = z2;
                                            }
                                        }
                                        fArr = fArr2;
                                    } else {
                                        fArr = fArr2;
                                    }
                                    i4 = 2;
                                    if (i3 != i4 || i3 == 3) {
                                        aiVar2 = aiVar;
                                    } else {
                                        if (i3 == 4) {
                                            try {
                                                aiVar2 = aiVar;
                                                if (aiVar2.v(4) > 0) {
                                                }
                                                z6 = z2 | z5;
                                                zS = z & aiVar2.s(this.l, this.j, labelRenderer);
                                                labelRenderer2 = labelRenderer;
                                                beVar6 = beVar;
                                                fArr3 = fArr;
                                                dVarB2 = dVar;
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                        } else {
                                            aiVar2 = aiVar;
                                        }
                                        z5 = z3;
                                        z6 = z2 | z5;
                                        zS = z & aiVar2.s(this.l, this.j, labelRenderer);
                                        labelRenderer2 = labelRenderer;
                                        beVar6 = beVar;
                                        fArr3 = fArr;
                                        dVarB2 = dVar;
                                    }
                                    z5 = z4;
                                    z6 = z2 | z5;
                                    zS = z & aiVar2.s(this.l, this.j, labelRenderer);
                                    labelRenderer2 = labelRenderer;
                                    beVar6 = beVar;
                                    fArr3 = fArr;
                                    dVarB2 = dVar;
                                }
                                th = th6;
                                th = th;
                                if (dVar == null) {
                                    throw th;
                                }
                                try {
                                    Trace.endSection();
                                    throw th;
                                } catch (Throwable th7) {
                                    th.addSuppressed(th7);
                                    throw th;
                                }
                            }
                            i5 = iJ;
                            dVar = dVarB2;
                            aiVar = aiVar3;
                            z = zS;
                            fArr = fArr3;
                            beVar = beVar6;
                            z2 = z6;
                            z3 = false;
                            z4 = true;
                            i3 = i5;
                            i4 = 2;
                            if (i3 != i4) {
                                aiVar2 = aiVar;
                                z5 = z4;
                            } else {
                                aiVar2 = aiVar;
                                z5 = z4;
                            }
                            z6 = z2 | z5;
                            zS = z & aiVar2.s(this.l, this.j, labelRenderer);
                            labelRenderer2 = labelRenderer;
                            beVar6 = beVar;
                            fArr3 = fArr;
                            dVarB2 = dVar;
                        }
                        z3 = false;
                        i4 = 2;
                        z4 = true;
                        if (i3 != i4) {
                            aiVar2 = aiVar;
                            z5 = z4;
                        } else {
                            aiVar2 = aiVar;
                            z5 = z4;
                        }
                        z6 = z2 | z5;
                        zS = z & aiVar2.s(this.l, this.j, labelRenderer);
                        labelRenderer2 = labelRenderer;
                        beVar6 = beVar;
                        fArr3 = fArr;
                        dVarB2 = dVar;
                    }
                    labelRenderer2 = labelRenderer;
                    fArr3 = fArr;
                    beVar6 = beVar;
                    dVarB2 = dVar;
                    zS = z;
                    z6 = z2;
                }
                LabelRenderer labelRenderer3 = labelRenderer2;
                boolean z8 = zS;
                com.google.android.libraries.navigation.internal.agg.be beVar7 = beVar6;
                boolean z9 = z6;
                boolean z10 = false;
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                Set set = this.p;
                this.p = this.q;
                this.q = set;
                set.clear();
                synchronized (this) {
                    if (z8 && !z9) {
                        z10 = true;
                    }
                    this.m = z10;
                    this.d.c(Boolean.valueOf(z8));
                    this.e.c(Boolean.valueOf(this.m));
                    if (!z8 || z9 || !this.p.isEmpty()) {
                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("EntityRenderer.requestRender");
                        try {
                            this.k.o();
                            if (dVarB4 != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th8) {
                            if (dVarB4 == null) {
                                throw th8;
                            }
                            try {
                                Trace.endSection();
                                throw th8;
                            } catch (Throwable th9) {
                                th8.addSuppressed(th9);
                                throw th8;
                            }
                        }
                    }
                }
                labelRenderer3.b.d();
                LayeredLabelRenderer layeredLabelRenderer2 = labelRenderer3.a;
                if (layeredLabelRenderer2 != null) {
                    layeredLabelRenderer2.d.d();
                }
                cn cnVar2 = this.g;
                com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("LabelSnapshotManager.commit");
                try {
                    synchronized (cnVar2) {
                        HashMap map5 = new HashMap();
                        map5.putAll(cnVar2.f);
                        ge geVarA = cnVar2.e.l().listIterator();
                        while (geVarA.hasNext()) {
                            com.google.android.libraries.navigation.internal.agg.ba next = ((com.google.android.libraries.navigation.internal.agg.aw) geVarA).next();
                            int iA = next.a();
                            com.google.android.libraries.navigation.internal.ol.ao aoVar = (com.google.android.libraries.navigation.internal.ol.ao) next.getValue();
                            com.google.android.libraries.navigation.internal.agg.be beVar8 = beVar7;
                            if (beVar8.c(iA)) {
                                com.google.android.libraries.navigation.internal.o.c cVar2 = (com.google.android.libraries.navigation.internal.o.c) beVar8.p(iA);
                                com.google.android.libraries.navigation.internal.ol.an anVarB = aoVar.b();
                                com.google.android.libraries.navigation.internal.yx.an anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(cVar2);
                                Objects.requireNonNull(anVarJ);
                                ((com.google.android.libraries.navigation.internal.ol.d) anVarB).a = anVarJ;
                                com.google.android.libraries.navigation.internal.ol.ao aoVarA = anVarB.a();
                                map5.put(((com.google.android.libraries.navigation.internal.ol.e) aoVarA).a, aoVarA);
                            } else {
                                map5.put(aoVar.g(), aoVar);
                            }
                            beVar7 = beVar8;
                        }
                        Map mapUnmodifiableMap = Collections.unmodifiableMap(map5);
                        int i15 = cnVar2.h.get();
                        cn.a(cnVar2.i);
                        ev.o(cnVar2.g.values());
                        ciVar = new ci(mapUnmodifiableMap, i15);
                    }
                    Iterator it7 = cnVar2.d.iterator();
                    while (it7.hasNext()) {
                        ((com.google.android.libraries.navigation.internal.ol.am) it7.next()).a(ciVar);
                    }
                    if (dVarB5 != null) {
                        Trace.endSection();
                    }
                    bb bbVar2 = this.s;
                    synchronized (bbVar2) {
                        fyVarO = fy.o(((com.google.android.libraries.navigation.internal.po.df) bbVar2).b);
                        ((com.google.android.libraries.navigation.internal.po.df) bbVar2).b.clear();
                    }
                    synchronized (((com.google.android.libraries.navigation.internal.po.df) bbVar2).a) {
                        nn nnVarListIterator = fyVarO.listIterator();
                        while (nnVarListIterator.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.po.df) bbVar2).a.D((com.google.android.libraries.navigation.internal.ol.u) nnVarListIterator.next());
                        }
                    }
                    ((com.google.android.libraries.navigation.internal.km.t) this.r.a(com.google.android.libraries.navigation.internal.km.p.f)).c();
                    ((com.google.android.libraries.navigation.internal.km.t) this.r.a(com.google.android.libraries.navigation.internal.km.p.f)).a();
                } catch (Throwable th10) {
                    if (dVarB5 == null) {
                        throw th10;
                    }
                    try {
                        Trace.endSection();
                        throw th10;
                    } catch (Throwable th11) {
                        th10.addSuppressed(th11);
                        throw th10;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                dVar = dVarB2;
            }
        } catch (Throwable th13) {
            if (dVarB == null) {
                throw th13;
            }
            try {
                Trace.endSection();
                throw th13;
            } catch (Throwable th14) {
                th13.addSuppressed(th14);
                throw th13;
            }
        }
    }

    public final synchronized boolean g() {
        return this.m;
    }
}
