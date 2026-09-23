package com.google.android.libraries.navigation.internal.ck;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.du;
import com.google.android.libraries.navigation.internal.adg.dv;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.po.fk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    private final com.google.android.libraries.navigation.internal.oa.e a;
    private final com.google.android.libraries.navigation.internal.bp.bg b;
    private final com.google.android.libraries.navigation.internal.ot.h c;
    private final com.google.android.libraries.navigation.internal.fz.d d;
    private final Context e;
    private final boolean f;
    private final ex g;
    private final ex h;
    private final ex i;
    private final ex j;
    private final boolean k;
    private final boolean l;
    private List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f371n;
    private final com.google.android.libraries.navigation.internal.cr.f o;

    static {
        Intrinsics.checkNotNullExpressionValue(com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.s"), "forInjectedClassName(...)");
    }

    public s(com.google.android.libraries.navigation.internal.oa.e googleMap, com.google.android.libraries.navigation.internal.bp.bg routeDescription, com.google.android.libraries.navigation.internal.ot.h labelManager, com.google.android.libraries.navigation.internal.cr.f compositePickHandler, com.google.android.libraries.navigation.internal.fz.d clientParameters, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(googleMap, "googleMap");
        Intrinsics.checkNotNullParameter(routeDescription, "routeDescription");
        Intrinsics.checkNotNullParameter(labelManager, "labelManager");
        Intrinsics.checkNotNullParameter(compositePickHandler, "compositePickHandler");
        Intrinsics.checkNotNullParameter(clientParameters, "clientParameters");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = googleMap;
        this.b = routeDescription;
        this.c = labelManager;
        this.o = compositePickHandler;
        this.d = clientParameters;
        this.e = context;
        this.f = false;
        this.g = com.google.android.libraries.navigation.internal.gz.i.a(context) ? ex.LEGEND_STYLE_EPHEMERAL_EV_STOP_EXTENDED_LABEL_LAYOUT_RTL : ex.LEGEND_STYLE_EPHEMERAL_EV_STOP_EXTENDED_LABEL_LAYOUT;
        this.h = com.google.android.libraries.navigation.internal.gz.i.a(context) ? ex.LEGEND_STYLE_EPHEMERAL_AUTO_ADDED_EV_STOP_EXTENDED_LABEL_LAYOUT_RTL : ex.LEGEND_STYLE_EPHEMERAL_AUTO_ADDED_EV_STOP_EXTENDED_LABEL_LAYOUT;
        this.i = com.google.android.libraries.navigation.internal.gz.i.a(context) ? ex.LEGEND_STYLE_EPHEMERAL_EV_STOP_EXTENDED_LABEL_TITLE_TEXT_RTL : ex.LEGEND_STYLE_EPHEMERAL_EV_STOP_EXTENDED_LABEL_TITLE_TEXT;
        this.j = ex.LEGEND_STYLE_EPHEMERAL_EV_STOP_EXTENDED_LABEL_ICON;
        int i = 0;
        for (int i2 = 0; i2 < routeDescription.g.b(); i2++) {
            if (com.google.android.libraries.navigation.internal.bp.bg.V(routeDescription.g.c(i2).d)) {
                i++;
            }
        }
        this.k = i > 8;
        this.l = this.d.B().b;
        this.m = CollectionsKt.emptyList();
        this.f371n = CollectionsKt.emptyList();
    }

    private final com.google.android.libraries.navigation.internal.oe.x c(int i) {
        return this.b.aa()[i - 1].c;
    }

    private final ex d(int i) {
        return this.g;
    }

    private final boolean f(int i) {
        int iM = this.b.m() - 1;
        com.google.android.libraries.navigation.internal.bp.bg bgVar = this.b;
        int i2 = i - 1;
        return i != iM && (bgVar.g.b() <= i2 ? false : com.google.android.libraries.navigation.internal.bp.bg.V(bgVar.g.c(i2).d));
    }

    private static final boolean g(com.google.android.libraries.navigation.internal.fz.d dVar) {
        return dVar.n().c;
    }

    public final void a() {
        dp dpVar;
        com.google.android.libraries.navigation.internal.po.bb bbVarB;
        dp dpVar2;
        com.google.android.libraries.navigation.internal.ot.q qVar;
        if (!this.k || this.l) {
            if (g(this.d)) {
                List list = CollectionsKt.toList(RangesKt.until(1, this.b.m()));
                ArrayList arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    int iIntValue = ((Number) it2.next()).intValue();
                    if (f(iIntValue)) {
                        com.google.android.libraries.navigation.internal.oe.x xVarC = c(iIntValue);
                        String strE = e(iIntValue);
                        if (strE == null) {
                            dpVar2 = (dp) ((fk) this.a).I.f(this.j).b().t();
                        } else {
                            Cdo cdoB = ((fk) this.a).I.f(this.i).b();
                            if (!cdoB.b.H()) {
                                cdoB.v();
                            }
                            dp dpVar3 = (dp) cdoB.b;
                            dp dpVar4 = dp.a;
                            dpVar3.b |= 1;
                            dpVar3.c = strE;
                            dpVar2 = (dp) cdoB.t();
                        }
                        Intrinsics.checkNotNull(dpVar2);
                        com.google.android.libraries.navigation.internal.ot.h hVar = this.c;
                        com.google.android.libraries.navigation.internal.rd.e eVarD = com.google.android.libraries.navigation.internal.rd.e.d(d(iIntValue));
                        com.google.android.libraries.navigation.internal.ot.f fVarB = com.google.android.libraries.navigation.internal.ot.g.b();
                        fVarB.b(jr.WORLD_ENCODING_LAT_LNG_E7);
                        com.google.android.libraries.navigation.internal.rj.b bVarC = hVar.c(eVarD, fVarB.a());
                        dy dyVar = bVarC.a;
                        dv dvVarA = du.a((dq) dt.a.q());
                        dvVarA.c(dvVarA.b(), dpVar2);
                        dt dtVarA = dvVarA.a();
                        if (!dyVar.b.H()) {
                            dyVar.v();
                        }
                        ef efVar = (ef) dyVar.b;
                        ef efVar2 = ef.a;
                        dtVarA.getClass();
                        efVar.c = dtVarA;
                        efVar.b |= 1;
                        if (!dyVar.b.H()) {
                            dyVar.v();
                        }
                        ef efVar3 = (ef) dyVar.b;
                        efVar3.b |= 64;
                        efVar3.h = 1;
                        com.google.android.libraries.navigation.internal.adg.f fVarA = com.google.android.libraries.navigation.internal.adg.e.a((com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q());
                        fVarA.c(com.google.android.libraries.navigation.internal.on.k.a(xVarC));
                        fVarA.b(com.google.android.libraries.navigation.internal.adg.b.TOP);
                        com.google.android.libraries.navigation.internal.adg.d dVarA = fVarA.a();
                        if (!dyVar.b.H()) {
                            dyVar.v();
                        }
                        ef efVar4 = (ef) dyVar.b;
                        dVarA.getClass();
                        efVar4.e = dVarA;
                        efVar4.b |= 8;
                        com.google.android.libraries.navigation.internal.rp.c.g(dyVar);
                        qVar = (com.google.android.libraries.navigation.internal.ot.q) bVarC.c();
                        this.o.d(qVar, new com.google.android.libraries.navigation.internal.cs.a() { // from class: com.google.android.libraries.navigation.internal.ck.q
                        });
                    } else {
                        qVar = null;
                    }
                    if (qVar != null) {
                        arrayList.add(qVar);
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.ot.q) it3.next()).d();
                }
                this.f371n = arrayList;
                return;
            }
            List list2 = CollectionsKt.toList(RangesKt.until(1, this.b.m()));
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                int iIntValue2 = ((Number) it4.next()).intValue();
                if (f(iIntValue2)) {
                    com.google.android.libraries.navigation.internal.oe.x xVarC2 = c(iIntValue2);
                    com.google.android.libraries.navigation.internal.oa.e eVar = this.a;
                    String strE2 = e(iIntValue2);
                    if (strE2 == null) {
                        dpVar = (dp) ((fk) this.a).I.f(this.j).b().t();
                    } else {
                        Cdo cdoB2 = ((fk) this.a).I.f(this.i).b();
                        if (!cdoB2.b.H()) {
                            cdoB2.v();
                        }
                        dp dpVar5 = (dp) cdoB2.b;
                        dp dpVar6 = dp.a;
                        dpVar5.b |= 1;
                        dpVar5.c = strE2;
                        dpVar = (dp) cdoB2.t();
                    }
                    Intrinsics.checkNotNull(dpVar);
                    dy dyVarD = ((fk) this.a).I.f(d(iIntValue2)).d();
                    dv dvVarA2 = du.a((dq) dt.a.q());
                    dvVarA2.c(dvVarA2.b(), dpVar);
                    dt dtVarA2 = dvVarA2.a();
                    if (!dyVarD.b.H()) {
                        dyVarD.v();
                    }
                    ef efVar5 = (ef) dyVarD.b;
                    ef efVar6 = ef.a;
                    dtVarA2.getClass();
                    efVar5.c = dtVarA2;
                    efVar5.b |= 1;
                    if (!dyVarD.b.H()) {
                        dyVarD.v();
                    }
                    ef efVar7 = (ef) dyVarD.b;
                    efVar7.b |= 64;
                    efVar7.h = 1;
                    com.google.android.libraries.navigation.internal.adg.f fVarA2 = com.google.android.libraries.navigation.internal.adg.e.a((com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q());
                    fVarA2.c(com.google.android.libraries.navigation.internal.on.k.a(xVarC2));
                    fVarA2.b(com.google.android.libraries.navigation.internal.adg.b.TOP);
                    com.google.android.libraries.navigation.internal.adg.d dVarA2 = fVarA2.a();
                    if (!dyVarD.b.H()) {
                        dyVarD.v();
                    }
                    dh dhVar = ((fk) eVar).H;
                    ef efVar8 = (ef) dyVarD.b;
                    dVarA2.getClass();
                    efVar8.e = dVarA2;
                    efVar8.b |= 8;
                    com.google.android.libraries.navigation.internal.rp.c.g(dyVarD);
                    com.google.android.libraries.navigation.internal.ael.bi biVarT = dyVarD.t();
                    Intrinsics.checkNotNullExpressionValue(biVarT, "build(...)");
                    bbVarB = dhVar.b((ef) biVarT, jr.WORLD_ENCODING_LAT_LNG_E7);
                    bbVarB.k(new r());
                } else {
                    bbVarB = null;
                }
                if (bbVarB != null) {
                    arrayList2.add(bbVarB);
                }
            }
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                ((fk) this.a).H.m((com.google.android.libraries.navigation.internal.ol.u) it5.next());
            }
            this.m = arrayList2;
        }
    }

    public final void b() {
        if (g(this.d)) {
            Iterator it2 = this.f371n.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.ot.q) it2.next()).c();
            }
            this.f371n = CollectionsKt.emptyList();
            return;
        }
        for (com.google.android.libraries.navigation.internal.ol.u uVar : this.m) {
            ((fk) this.a).H.i(uVar);
            ((fk) this.a).H.g(uVar);
        }
        this.m = CollectionsKt.emptyList();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    private final String e(int i) {
        com.google.android.libraries.navigation.internal.adr.z zVar;
        Duration durationM3699boximpl;
        com.google.android.libraries.navigation.internal.bp.cf cfVar = this.b.g;
        if (cfVar.b() >= i && (zVar = cfVar.c(i - 1).d) != null) {
            int iA = com.google.android.libraries.navigation.internal.adr.y.a(zVar.c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adr.y.a;
            }
            if (iA == com.google.android.libraries.navigation.internal.adr.y.b) {
                Duration.Companion companion = Duration.INSTANCE;
                durationM3699boximpl = Duration.m3699boximpl(DurationKt.toDuration(zVar.b, DurationUnit.SECONDS));
            } else {
                durationM3699boximpl = null;
            }
        } else {
            durationM3699boximpl = null;
        }
        if (durationM3699boximpl == null) {
            return null;
        }
        long rawValue = durationM3699boximpl.getRawValue();
        Duration.Companion companion2 = Duration.INSTANCE;
        return com.google.android.libraries.navigation.internal.hf.u.e(this.e.getResources(), (int) Duration.m3722getInWholeSecondsimpl(rawValue), Duration.m3700compareToLRDsOJo(rawValue, DurationKt.toDuration(1, DurationUnit.HOURS)) >= 0 ? 3 : 2).toString();
    }
}
