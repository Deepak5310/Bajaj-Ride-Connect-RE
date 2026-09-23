package com.google.android.libraries.navigation.internal.cu;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ke.i;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.oa.k;
import com.google.android.libraries.navigation.internal.ob.h;
import com.google.android.libraries.navigation.internal.wb.m;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.cv.c {
    public static final ev a;
    public final f b;
    public final Map c;
    public EnumSet d;
    public ev e;
    public final d g;
    private final com.google.android.libraries.navigation.internal.afo.a i;
    private final com.google.android.libraries.navigation.internal.mj.a j;
    private final k k;
    private final af l;
    private final com.google.android.libraries.navigation.internal.fz.d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private fy f381n;
    private final r p;
    private final com.google.android.libraries.navigation.internal.afo.a q;
    private final m r;
    public com.google.android.libraries.navigation.internal.cv.e f = null;
    private final t o = new t() { // from class: com.google.android.libraries.navigation.internal.cu.a
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.libraries.navigation.internal.nt.t
        public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
            b bVar = this.a;
            EnumSet enumSetCopyOf = EnumSet.copyOf(bVar.d);
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LayersControllerImpl.applyLayerOverridesAndUpdate");
            try {
                ar.q(bVar.e);
                bVar.d.clear();
                if (!bVar.g.a()) {
                    bVar.d.addAll(bVar.b.j(ab.aB, com.google.android.libraries.navigation.internal.cv.a.class));
                } else if (bVar.f != null) {
                    bVar.d.addAll(com.google.android.libraries.navigation.internal.cv.e.b());
                }
                if (!bVar.e.isEmpty()) {
                    EnumSet<com.google.android.libraries.navigation.internal.cv.a> enumSetNoneOf = EnumSet.noneOf(com.google.android.libraries.navigation.internal.cv.a.class);
                    ev evVar = bVar.e;
                    int i = ((lv) evVar).c;
                    for (int i2 = 0; i2 < i; i2++) {
                        com.google.android.libraries.navigation.internal.cv.b bVar2 = (com.google.android.libraries.navigation.internal.cv.b) evVar.get(i2);
                        if (bVar2.b()) {
                            enumSetNoneOf.add(bVar2.a());
                        } else {
                            bVar.d.remove(bVar2.a());
                        }
                    }
                    ev evVar2 = b.a;
                    int i3 = ((lv) evVar2).c;
                    for (int i4 = 0; i4 < i3; i4++) {
                        com.google.android.libraries.navigation.internal.cv.a aVar = (com.google.android.libraries.navigation.internal.cv.a) evVar2.get(i4);
                        if (enumSetNoneOf.contains(aVar) && bVar.c.containsKey(aVar)) {
                            enumSetNoneOf.removeAll((Collection) bVar.c.get(aVar));
                            break;
                        }
                    }
                    for (com.google.android.libraries.navigation.internal.cv.a aVar2 : enumSetNoneOf) {
                        if (!bVar.d.contains(aVar2)) {
                            bVar.d.add(aVar2);
                            if (bVar.c.containsKey(aVar2)) {
                                bVar.d.removeAll((Collection) bVar.c.get(aVar2));
                                break;
                            }
                        }
                    }
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                if (!bVar.d.equals(enumSetCopyOf)) {
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LayersControllerImpl.triggerOnLayerStateChangeCallback");
                    try {
                        bVar.e(enumSetCopyOf);
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                    } finally {
                        if (dVarB2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                    }
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("LayersControllerImpl.reflectLayerStateOnMap");
                try {
                    bVar.a();
                    if (dVarB3 != null) {
                    }
                } catch (Throwable th2) {
                    if (dVarB3 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                }
                throw th4;
            }
        }
    };

    static {
        ez ezVar = new ez();
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.BICYCLING, fy.r(com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, fy.r(com.google.android.libraries.navigation.internal.cv.a.TRANSIT, com.google.android.libraries.navigation.internal.cv.a.COVID19, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.TRANSIT, fy.s(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.SATELLITE, fy.r(com.google.android.libraries.navigation.internal.cv.a.TERRAIN, com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.TERRAIN, fy.r(com.google.android.libraries.navigation.internal.cv.a.SATELLITE, com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.STREETVIEW, fy.r(com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, fy.u(com.google.android.libraries.navigation.internal.cv.a.BICYCLING, com.google.android.libraries.navigation.internal.cv.a.TRANSIT, com.google.android.libraries.navigation.internal.cv.a.SATELLITE, com.google.android.libraries.navigation.internal.cv.a.TERRAIN, com.google.android.libraries.navigation.internal.cv.a.STREETVIEW, com.google.android.libraries.navigation.internal.cv.a.COVID19, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.COVID19, fy.u(com.google.android.libraries.navigation.internal.cv.a.BICYCLING, com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, com.google.android.libraries.navigation.internal.cv.a.TRANSIT, com.google.android.libraries.navigation.internal.cv.a.TERRAIN, com.google.android.libraries.navigation.internal.cv.a.SATELLITE, com.google.android.libraries.navigation.internal.cv.a.STREETVIEW, com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY));
        ezVar.f(com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY, fy.u(com.google.android.libraries.navigation.internal.cv.a.BICYCLING, com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, com.google.android.libraries.navigation.internal.cv.a.TRANSIT, com.google.android.libraries.navigation.internal.cv.a.STREETVIEW, com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, com.google.android.libraries.navigation.internal.cv.a.COVID19, new com.google.android.libraries.navigation.internal.cv.a[0]));
        ezVar.d();
        com.google.android.libraries.navigation.internal.cv.a aVar = com.google.android.libraries.navigation.internal.cv.a.TRAFFIC;
        com.google.android.libraries.navigation.internal.cv.a aVar2 = com.google.android.libraries.navigation.internal.cv.a.TRANSIT;
        com.google.android.libraries.navigation.internal.cv.a aVar3 = com.google.android.libraries.navigation.internal.cv.a.BICYCLING;
        com.google.android.libraries.navigation.internal.cv.a aVar4 = com.google.android.libraries.navigation.internal.cv.a.SATELLITE;
        com.google.android.libraries.navigation.internal.cv.a aVar5 = com.google.android.libraries.navigation.internal.cv.a.TERRAIN;
        com.google.android.libraries.navigation.internal.cv.a aVar6 = com.google.android.libraries.navigation.internal.cv.a.COVID19;
        com.google.android.libraries.navigation.internal.cv.a aVar7 = com.google.android.libraries.navigation.internal.cv.a.STREETVIEW;
        com.google.android.libraries.navigation.internal.cv.a aVar8 = com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL;
        com.google.android.libraries.navigation.internal.cv.a aVar9 = com.google.android.libraries.navigation.internal.cv.a.AIR_QUALITY;
        int i = ev.d;
        a = ev.m(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public b(m mVar, f fVar, k kVar, af afVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, Map map, d dVar2, r rVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3) {
        this.r = mVar;
        ar.q(fVar);
        this.b = fVar;
        ar.q(kVar);
        this.k = kVar;
        this.i = aVar3;
        this.m = dVar;
        this.p = rVar;
        this.j = aVar;
        this.l = afVar;
        this.c = map;
        this.g = dVar2;
        this.q = aVar2;
        if (dVar2.a()) {
            this.d = EnumSet.noneOf(com.google.android.libraries.navigation.internal.cv.a.class);
        } else {
            EnumSet enumSetJ = fVar.j(ab.aB, com.google.android.libraries.navigation.internal.cv.a.class);
            if (enumSetJ.contains(com.google.android.libraries.navigation.internal.cv.a.REALTIME)) {
                enumSetJ.remove(com.google.android.libraries.navigation.internal.cv.a.REALTIME);
            }
            for (com.google.android.libraries.navigation.internal.cv.a aVar4 : com.google.android.libraries.navigation.internal.cv.a.values()) {
                if (!aVar4.m) {
                    enumSetJ.remove(aVar4);
                }
            }
            fVar.p(ab.aB, enumSetJ);
            this.d = EnumSet.copyOf(enumSetJ);
        }
        this.f381n = mb.a;
        int i = ev.d;
        this.e = lv.a;
    }

    private final EnumSet f(EnumSet enumSet, com.google.android.libraries.navigation.internal.cv.a aVar, boolean z) {
        EnumSet enumSetCopyOf = EnumSet.copyOf(enumSet);
        if (z) {
            if (this.c.containsKey(aVar)) {
                enumSetCopyOf.removeAll((Collection) this.c.get(aVar));
            }
            enumSetCopyOf.add(aVar);
        } else {
            enumSetCopyOf.remove(aVar);
        }
        return enumSetCopyOf;
    }

    private final boolean g(h hVar) {
        return h() ? ((com.google.android.libraries.navigation.internal.ok.b) this.q.a()).c(hVar) : this.k.J(hVar);
    }

    private final boolean h() {
        return ((fj) this.p.b()).e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        ev evVarQ;
        for (com.google.android.libraries.navigation.internal.cv.a aVar : com.google.android.libraries.navigation.internal.cv.a.values()) {
            boolean zContains = this.d.contains(aVar);
            switch (aVar) {
                case TRAFFIC:
                    evVarQ = ev.q(h.TRAFFIC);
                    break;
                case BICYCLING:
                    evVarQ = ev.q(h.BICYCLING);
                    break;
                case TRANSIT:
                    evVarQ = ev.q(h.TRANSIT);
                    break;
                case SATELLITE:
                    evVarQ = ev.q(h.SATELLITE);
                    break;
                case TERRAIN:
                    evVarQ = ev.q(h.TERRAIN);
                    break;
                case REALTIME:
                    evVarQ = ev.q(h.REALTIME);
                    break;
                case STREETVIEW:
                    evVarQ = ev.q(h.STREETVIEW);
                    break;
                case THREE_DIMENSIONAL:
                    evVarQ = ev.q(h.THREE_DIMENSIONAL);
                    break;
                case COVID19:
                    evVarQ = ev.q(h.COVID19);
                    break;
                case AIR_QUALITY:
                    int i = ev.d;
                    eq eqVar = new eq();
                    eqVar.h(h.AIR_QUALITY);
                    eqVar.h(h.AIR_QUALITY_HEATMAP);
                    evVarQ = eqVar.g();
                    break;
                case WILDFIRES:
                    evVarQ = ev.q(h.WILDFIRES);
                    break;
                default:
                    int i2 = ev.d;
                    evVarQ = lv.a;
                    break;
            }
            if (aVar.f382n) {
                int i3 = ((lv) evVarQ).c;
                for (int i4 = 0; i4 < i3; i4++) {
                    h hVar = (h) evVarQ.get(i4);
                    if (g(hVar) != zContains) {
                        if (!h()) {
                            this.k.x(hVar, zContains);
                        } else if (zContains) {
                            ((com.google.android.libraries.navigation.internal.ok.b) this.q.a()).b(hVar);
                        } else {
                            ((com.google.android.libraries.navigation.internal.ok.b) this.q.a()).a(hVar);
                        }
                    }
                }
            }
        }
        if (this.d.contains(com.google.android.libraries.navigation.internal.cv.a.SATELLITE)) {
            if (!g(h.SATELLITE)) {
                ((com.google.android.libraries.navigation.internal.oi.c) this.i.a()).b();
            }
        } else if (!this.d.contains(com.google.android.libraries.navigation.internal.cv.a.TERRAIN)) {
            com.google.android.libraries.navigation.internal.afo.a aVar2 = this.i;
            if (aVar2 != null) {
                ((com.google.android.libraries.navigation.internal.oi.c) aVar2.a()).a();
            } else {
                this.k.A();
            }
        } else if (!g(h.TERRAIN)) {
            com.google.android.libraries.navigation.internal.afo.a aVar3 = this.i;
            if (aVar3 != null) {
                ((com.google.android.libraries.navigation.internal.oi.c) aVar3.a()).e();
            } else {
                this.k.F();
            }
        }
        if (this.m.G().s && !this.d.equals(this.f381n)) {
            this.f381n = mp.b(this.d);
            this.l.e(new i(this.f381n, this.j));
        }
        StringBuilder sb = new StringBuilder();
        if (!this.g.a()) {
            Iterator it2 = this.b.j(ab.aB, com.google.android.libraries.navigation.internal.cv.a.class).iterator();
            while (it2.hasNext()) {
                sb.append(((com.google.android.libraries.navigation.internal.cv.a) it2.next()).name());
                sb.append(StringUtils.SPACE);
            }
        } else if (this.f != null) {
            Iterator it3 = com.google.android.libraries.navigation.internal.cv.e.b().iterator();
            while (it3.hasNext()) {
                sb.append(((com.google.android.libraries.navigation.internal.cv.a) it3.next()).name());
                sb.append(StringUtils.SPACE);
            }
        }
        com.google.android.libraries.navigation.internal.hx.k.a("enabledLayers", sb.toString());
    }

    @Override // com.google.android.libraries.navigation.internal.cv.c
    public final boolean b(com.google.android.libraries.navigation.internal.cv.a aVar) {
        return this.d.contains(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.cv.c
    public final void c(com.google.android.libraries.navigation.internal.cv.e eVar) {
        if (this.g.a()) {
            com.google.android.libraries.navigation.internal.cv.e eVar2 = this.f;
            if (eVar2 != null) {
                eVar2.a().h(this.o);
            }
            this.f = eVar;
            if (eVar != null) {
                eVar.a().e(this.o, ac.INSTANCE);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cv.c
    public final void d(com.google.android.libraries.navigation.internal.cv.a aVar, boolean z) {
        com.google.android.libraries.navigation.internal.cv.b bVar;
        if (this.g.a()) {
            return;
        }
        EnumSet enumSetF = f(this.d, aVar, z);
        ev evVar = this.e;
        int i = ((lv) evVar).c;
        int i2 = 0;
        do {
            if (i2 >= i) {
                EnumSet enumSetCopyOf = EnumSet.copyOf(this.d);
                this.d = EnumSet.copyOf(enumSetF);
                e(enumSetCopyOf);
                break;
            } else {
                bVar = (com.google.android.libraries.navigation.internal.cv.b) evVar.get(i2);
                i2++;
            }
        } while (bVar.b() == enumSetF.contains(bVar.a()));
        a();
        if (this.d.contains(aVar) == z) {
            f fVar = this.b;
            fVar.p(ab.aB, f(fVar.j(ab.aB, com.google.android.libraries.navigation.internal.cv.a.class), aVar, z));
        }
    }

    public final void e(EnumSet enumSet) {
        EnumSet enumSetCopyOf = EnumSet.copyOf(this.d);
        mp.e(mp.d(enumSet, enumSetCopyOf), mp.d(enumSetCopyOf, enumSet));
    }
}
