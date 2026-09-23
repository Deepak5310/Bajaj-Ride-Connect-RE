package com.google.android.libraries.navigation.internal.ck;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gg;
import com.google.android.libraries.navigation.internal.yz.gi;
import com.google.android.libraries.navigation.internal.yz.lg;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ce implements cl {
    public final ac a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final Resources c;
    private final int d;
    private final int e;
    private final com.google.android.libraries.navigation.internal.hn.r f;
    private final cw g;
    private final com.google.android.libraries.navigation.internal.oa.l h;
    private final u i;

    public ce(com.google.android.libraries.navigation.internal.afo.a aVar, u uVar, com.google.android.libraries.navigation.internal.oa.l lVar, ac acVar, Context context, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.b = aVar;
        this.i = uVar;
        this.h = lVar;
        this.a = acVar;
        this.c = context.getResources();
        this.f = rVar;
        this.g = new cw(context.getResources());
        this.d = lVar.b(0, false);
        this.e = lVar.b(1, false);
    }

    private final ck d(Bitmap icon, com.google.android.libraries.navigation.internal.oe.r latlng) {
        if (icon == null) {
            return new cj();
        }
        u uVar = this.i;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(latlng, "latlng");
        gi giVarQ = gi.q(0, icon);
        Intrinsics.checkNotNullExpressionValue(giVarQ, "of(...)");
        return uVar.a(giVarQ, latlng);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.az
    public final /* bridge */ /* synthetic */ Object a(ad adVar, int i) {
        int iB = this.h.b(adVar.b, true);
        ck ckVarD = ((fj) this.f.b()).g ? d(new com.google.android.libraries.geo.mapcore.renderer.k(this.c, iB).a(), adVar.a) : new i(this.a.a(adVar.a, iB, i, 2), this.b);
        ckVarD.f();
        return ckVarD;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.az
    public final /* bridge */ /* synthetic */ Object b(ay ayVar, int i) {
        int i2 = ayVar.b == 1 ? this.d : this.e;
        ck ckVarD = ((fj) this.f.b()).g ? d(new com.google.android.libraries.geo.mapcore.renderer.k(this.c, i2).a(), ayVar.a) : new i(this.a.a(ayVar.a, i2, i, 2), this.b);
        ckVarD.f();
        return ckVarD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.ck.az
    public final /* bridge */ /* synthetic */ Object c(cv cvVar, int i) {
        ck iVar;
        gi giVar;
        int i2 = i;
        int i3 = 0;
        if (((fj) this.f.b()).g) {
            u uVar = this.i;
            cw cwVar = this.g;
            int i4 = cvVar.b;
            cu cuVar = cvVar.c;
            com.google.android.libraries.navigation.internal.yx.ao aoVar = new com.google.android.libraries.navigation.internal.yx.ao(Integer.valueOf(i4), cuVar);
            if (cwVar.e.containsKey(aoVar)) {
                giVar = (gi) cwVar.e.get(aoVar);
            } else {
                cwVar.d.setStyle(Paint.Style.FILL);
                ev evVar = cuVar == cu.INTERMEDIATE ? cw.a : cw.b;
                Comparator comparator = gi.b;
                gg ggVar = new gg(lg.a);
                while (i3 < ((lv) evVar).c) {
                    com.google.android.libraries.navigation.internal.yx.ao aoVar2 = (com.google.android.libraries.navigation.internal.yx.ao) evVar.get(i3);
                    Integer num = (Integer) aoVar2.a;
                    float fFloatValue = ((Float) aoVar2.b).floatValue();
                    int iB = cwVar.b(fFloatValue) / 2;
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cwVar.b(fFloatValue), cwVar.b(fFloatValue), Bitmap.Config.ARGB_8888);
                    cwVar.c.setBitmap(bitmapCreateBitmap);
                    cwVar.d.setColor(i4);
                    float f = iB;
                    cwVar.c.drawCircle(f, f, f, cwVar.d);
                    cwVar.d.setColor(-1);
                    cwVar.c.drawCircle(f, f, iB - cwVar.b(1.5f), cwVar.d);
                    cwVar.c.setBitmap(null);
                    ggVar.f(num, bitmapCreateBitmap);
                    i3++;
                }
                gi giVarD = ggVar.d();
                cwVar.e.put(aoVar, giVarD);
                giVar = giVarD;
            }
            iVar = uVar.a(giVar, cvVar.a);
        } else {
            ac acVar = this.a;
            com.google.android.libraries.navigation.internal.oe.r rVar = cvVar.a;
            int i5 = cvVar.b;
            cu cuVar2 = cvVar.c;
            c cVar = new c(i5, i2, cuVar2);
            if (!acVar.c.containsKey(cVar)) {
                com.google.android.libraries.navigation.internal.ol.ax axVar = (com.google.android.libraries.navigation.internal.ol.ax) acVar.a.a();
                ev evVar2 = cuVar2 == cu.INTERMEDIATE ? cw.a : cw.b;
                fx fxVar = (fx) ga.a.q();
                while (i3 < ((lv) evVar2).c) {
                    com.google.android.libraries.navigation.internal.yx.ao aoVar3 = (com.google.android.libraries.navigation.internal.yx.ao) evVar2.get(i3);
                    da daVar = (da) db.a.q();
                    int iIntValue = ((Integer) aoVar3.a).intValue();
                    if (!daVar.b.H()) {
                        daVar.v();
                    }
                    db dbVar = (db) daVar.b;
                    dbVar.b |= 1;
                    dbVar.c = iIntValue;
                    float fFloatValue2 = ((Float) aoVar3.b).floatValue();
                    com.google.android.libraries.navigation.internal.adg.at atVar = (com.google.android.libraries.navigation.internal.adg.at) com.google.android.libraries.navigation.internal.adg.ba.a.q();
                    if (!atVar.b.H()) {
                        atVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adg.ba baVar = (com.google.android.libraries.navigation.internal.adg.ba) atVar.b;
                    baVar.b |= 4;
                    baVar.g = i2;
                    ic icVar = (ic) id.a.q();
                    if (!icVar.b.H()) {
                        icVar.v();
                    }
                    id idVar = (id) icVar.b;
                    ev evVar3 = evVar2;
                    idVar.b |= 1;
                    idVar.c = i5;
                    int iA = cw.a(fFloatValue2);
                    if (!icVar.b.H()) {
                        icVar.v();
                    }
                    id idVar2 = (id) icVar.b;
                    idVar2.b |= 8;
                    idVar2.e = iA;
                    atVar.c(icVar);
                    ic icVar2 = (ic) id.a.q();
                    if (!icVar2.b.H()) {
                        icVar2.v();
                    }
                    id idVar3 = (id) icVar2.b;
                    idVar3.b |= 1;
                    idVar3.c = -1;
                    int iA2 = cw.a(fFloatValue2 - 3.0f);
                    if (!icVar2.b.H()) {
                        icVar2.v();
                    }
                    id idVar4 = (id) icVar2.b;
                    idVar4.b |= 8;
                    idVar4.e = iA2;
                    atVar.c(icVar2);
                    com.google.android.libraries.navigation.internal.adg.ba baVar2 = (com.google.android.libraries.navigation.internal.adg.ba) atVar.t();
                    if (!daVar.b.H()) {
                        daVar.v();
                    }
                    db dbVar2 = (db) daVar.b;
                    baVar2.getClass();
                    dbVar2.d = baVar2;
                    dbVar2.b |= 2;
                    fxVar.c(daVar);
                    i3++;
                    evVar2 = evVar3;
                    i2 = i;
                }
                acVar.c.put(cVar, axVar.a((ga) fxVar.t()));
            }
            iVar = new i(((com.google.android.libraries.navigation.internal.on.h) acVar.b.a()).b(rVar.a, rVar.b, 16, 1.0f, false, (com.google.android.libraries.navigation.internal.ol.aq) acVar.c.get(cVar), true, 2), this.b);
        }
        iVar.f();
        return iVar;
    }
}
