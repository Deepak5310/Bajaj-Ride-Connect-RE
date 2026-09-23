package com.google.android.libraries.navigation.internal.cl;

import android.content.res.Configuration;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adr.cf;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi implements bh {
    private final br a;

    public bi(br brVar) {
        this.a = brVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cl.bh
    public final ev a(com.google.android.libraries.navigation.internal.oj.c cVar, Configuration configuration, com.google.android.libraries.navigation.internal.oo.f fVar, ev evVar, ev evVar2, boolean z, boolean z2, boolean z3) {
        Cdo cdoA = cVar.a(((h) this.a).a().d.b());
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        dp dpVar = (dp) cdoA.b;
        dp dpVar2 = dp.a;
        dpVar.b |= 1;
        dpVar.c = StringUtils.SPACE;
        dp dpVar3 = (dp) cdoA.t();
        int i = ev.d;
        eq eqVar = new eq();
        if (!z) {
            Cdo cdoA2 = cVar.a(fVar);
            if (!cdoA2.b.H()) {
                cdoA2.v();
            }
            dp dpVar4 = (dp) cdoA2.b;
            dpVar4.b |= 32;
            dpVar4.h = true;
            eqVar.h((dp) cdoA2.t());
        }
        int size = evVar2.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            bg bgVar = (bg) evVar2.get(i2);
            if ((bgVar.c() == cf.POSITION_START && !com.google.android.libraries.navigation.internal.gz.i.b(configuration)) || (bgVar.c() == cf.POSITION_END && com.google.android.libraries.navigation.internal.gz.i.b(configuration))) {
                com.google.android.libraries.navigation.internal.oo.f fVarB = bgVar.b();
                com.google.android.libraries.navigation.internal.yx.ar.q(fVarB);
                eqVar.i((dp) cVar.a(fVarB).t(), dpVar3);
                z4 = true;
            }
        }
        if (z4 && !z2 && z3) {
            eqVar.h(dpVar3);
        }
        eq eqVar2 = new eq();
        int i3 = 0;
        while (i3 < evVar.size()) {
            Cdo cdoA3 = cVar.a(fVar);
            boolean z5 = i3 != 0;
            if (!cdoA3.b.H()) {
                cdoA3.v();
            }
            dp dpVar5 = (dp) cdoA3.b;
            dpVar5.b |= 32;
            dpVar5.h = z5;
            String str = (String) evVar.get(i3);
            if (!cdoA3.b.H()) {
                cdoA3.v();
            }
            dp dpVar6 = (dp) cdoA3.b;
            str.getClass();
            dpVar6.b |= 1;
            dpVar6.c = str;
            eqVar2.h((dp) cdoA3.t());
            i3++;
        }
        eqVar.j(eqVar2.g());
        int size2 = evVar2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            bg bgVar2 = (bg) evVar2.get(i4);
            if ((bgVar2.c() == cf.POSITION_START && com.google.android.libraries.navigation.internal.gz.i.b(configuration)) || (bgVar2.c() == cf.POSITION_END && !com.google.android.libraries.navigation.internal.gz.i.b(configuration))) {
                com.google.android.libraries.navigation.internal.oo.f fVarB2 = bgVar2.b();
                com.google.android.libraries.navigation.internal.yx.ar.q(fVarB2);
                eqVar.i(dpVar3, (dp) cVar.a(fVarB2).t());
            }
        }
        return eqVar.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cl.bh
    public final ev b(Configuration configuration, com.google.android.libraries.navigation.internal.ol.aq aqVar, ev evVar, ev evVar2, boolean z, boolean z2, boolean z3) {
        Cdo cdo = (Cdo) dp.a.q();
        if (!cdo.b.H()) {
            cdo.v();
        }
        dp dpVar = (dp) cdo.b;
        dpVar.b |= 1;
        dpVar.c = StringUtils.SPACE;
        int iA = ((h) this.a).a().d.a().a();
        if (!cdo.b.H()) {
            cdo.v();
        }
        dp dpVar2 = (dp) cdo.b;
        dpVar2.b |= 2;
        dpVar2.d = iA;
        dp dpVar3 = (dp) cdo.t();
        int i = ev.d;
        eq eqVar = new eq();
        if (!z) {
            Cdo cdoB = aqVar.b();
            if (!cdoB.b.H()) {
                cdoB.v();
            }
            dp dpVar4 = (dp) cdoB.b;
            dpVar4.b |= 32;
            dpVar4.h = true;
            eqVar.h((dp) cdoB.t());
        }
        int size = evVar2.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            bg bgVar = (bg) evVar2.get(i2);
            if ((bgVar.c() == cf.POSITION_START && !com.google.android.libraries.navigation.internal.gz.i.b(configuration)) || (bgVar.c() == cf.POSITION_END && com.google.android.libraries.navigation.internal.gz.i.b(configuration))) {
                Cdo cdo2 = (Cdo) dp.a.q();
                com.google.android.libraries.navigation.internal.ol.aq aqVarA = bgVar.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(aqVarA);
                int iA2 = aqVarA.a();
                if (!cdo2.b.H()) {
                    cdo2.v();
                }
                dp dpVar5 = (dp) cdo2.b;
                dpVar5.b |= 2;
                dpVar5.d = iA2;
                eqVar.i((dp) cdo2.t(), dpVar3);
                z4 = true;
            }
        }
        if (z4 && !z2 && z3) {
            eqVar.h(dpVar3);
        }
        eq eqVar2 = new eq();
        int i3 = 0;
        while (i3 < evVar.size()) {
            Cdo cdoB2 = aqVar.b();
            boolean z5 = i3 != 0;
            if (!cdoB2.b.H()) {
                cdoB2.v();
            }
            dp dpVar6 = (dp) cdoB2.b;
            dpVar6.b |= 32;
            dpVar6.h = z5;
            String str = (String) evVar.get(i3);
            if (!cdoB2.b.H()) {
                cdoB2.v();
            }
            dp dpVar7 = (dp) cdoB2.b;
            str.getClass();
            dpVar7.b |= 1;
            dpVar7.c = str;
            eqVar2.h((dp) cdoB2.t());
            i3++;
        }
        eqVar.j(eqVar2.g());
        int size2 = evVar2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            bg bgVar2 = (bg) evVar2.get(i4);
            if ((bgVar2.c() == cf.POSITION_START && com.google.android.libraries.navigation.internal.gz.i.b(configuration)) || (bgVar2.c() == cf.POSITION_END && !com.google.android.libraries.navigation.internal.gz.i.b(configuration))) {
                Cdo cdo3 = (Cdo) dp.a.q();
                com.google.android.libraries.navigation.internal.ol.aq aqVarA2 = bgVar2.a();
                com.google.android.libraries.navigation.internal.yx.ar.q(aqVarA2);
                int iA3 = aqVarA2.a();
                if (!cdo3.b.H()) {
                    cdo3.v();
                }
                dp dpVar8 = (dp) cdo3.b;
                dpVar8.b |= 2;
                dpVar8.d = iA3;
                eqVar.i(dpVar3, (dp) cdo3.t());
            }
        }
        return eqVar.g();
    }
}
