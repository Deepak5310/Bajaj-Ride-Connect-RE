package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.ch;
import com.google.android.libraries.geo.mapcore.renderer.cp;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.geo.mapcore.renderer.fg;
import com.google.android.libraries.navigation.internal.adg.bc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements g {
    public static float a = 1.0f;
    public final k b;
    public final ArrayList c = new ArrayList(2);
    private final List d;

    private o(List list, k kVar) {
        this.d = list;
        this.b = kVar;
    }

    public static o c(GeometryUtil geometryUtil, ce ceVar, ba baVar, bq bqVar, List list, k kVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.ps.q qVar, ef efVar, fg fgVar, List list2, List list3) {
        List list4 = list;
        o oVar = new o(list4, kVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            bc bcVar = ((j) it2.next()).e;
            if (bcVar != null) {
                list3.add(bcVar);
            }
        }
        int iMax = Math.max(ceVar.a(), 4);
        float fCeil = (float) Math.ceil(j.a(list) * a);
        Iterator it3 = list.iterator();
        float f = fCeil * (1 << iMax);
        int maxVerticesForExtrudedPolyline = 0;
        while (it3.hasNext()) {
            for (com.google.android.libraries.navigation.internal.oe.ad adVar : ((j) it3.next()).a) {
                maxVerticesForExtrudedPolyline += GeometryUtil.getMaxVerticesForExtrudedPolyline(adVar);
            }
        }
        char c = 2;
        ArrayList arrayList = new ArrayList(2);
        int i = (ceVar.a() > 6 ? 1 : 2) | 80;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.v builder = geometryUtil.getBuilder("line_group", i, true, 0, maxVerticesForExtrudedPolyline, bqVar);
        arrayList.add(builder);
        int i2 = 0;
        int i3 = 0;
        while (i3 < list.size()) {
            j jVar = (j) list4.get(i3);
            com.google.android.libraries.navigation.internal.oe.ad[] adVarArr = jVar.a;
            int i4 = 0;
            while (i4 < adVarArr.length) {
                int iE = (adVarArr[i4].e() - 1) * 5;
                if (iE + i2 >= 65536) {
                    builder = geometryUtil.getBuilder("line_group", i, true, 0, maxVerticesForExtrudedPolyline, bqVar);
                    arrayList.add(builder);
                    i2 = 0;
                }
                i2 += iE;
                com.google.android.libraries.navigation.internal.oe.ad adVar2 = adVarArr[i4];
                n nVar = jVar.b;
                if (adVar2.e() >= 2) {
                    com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
                    k kVar2 = oVar.b;
                    geometryUtil.addExtrudedPolyline(adVar2, f * 0.5f, xVar, kVar2.c(), kVar2.d(nVar), nVar.d(), builder);
                }
                i4++;
                i3 = i3;
                jVar = jVar;
                c = 2;
            }
            i3++;
            list4 = list;
        }
        int size = arrayList.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar = (com.google.android.libraries.geo.mapcore.internal.vector.gl.v) arrayList.get(i6);
            int i7 = vVar.f;
            if (i7 > 0) {
                i5 += i7;
                ff ffVarC = vVar.c(4);
                ffVarC.c(true);
                oVar.c.add(ffVarC);
            }
        }
        if (i5 != 0) {
            boolean z = (afVar == cp.TRANSIT || afVar == ch.INDOOR_LINES) ? false : true;
            ArrayList arrayList2 = oVar.c;
            int size2 = arrayList2.size();
            int i8 = 0;
            while (i8 < size2) {
                cd cdVar = ceVar.a;
                ff ffVar = (ff) arrayList2.get(i8);
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = arrayList;
                com.google.android.libraries.navigation.internal.qq.an anVar = new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar, baVar.b, fgVar, z);
                int i9 = ffVar.j;
                String.valueOf(cdVar);
                anVar.w(ffVar);
                anVar.B(0, oVar.b.a);
                anVar.C(false);
                if (qVar == null) {
                    anVar.t(1, 771);
                } else {
                    anVar.t(770, 771);
                    qVar.a(anVar);
                    anVar.f(qVar.a);
                    qVar.c.add(efVar);
                    qVar.e.d(qVar);
                    qVar.e.b();
                }
                anVar.v(efVar);
                list2.add(anVar);
                i8++;
                arrayList = arrayList4;
                arrayList2 = arrayList3;
            }
        }
        ArrayList arrayList5 = arrayList;
        int size3 = arrayList5.size();
        for (int i10 = 0; i10 < size3; i10++) {
            ((com.google.android.libraries.geo.mapcore.internal.vector.gl.v) arrayList5.get(i10)).l();
        }
        return oVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int a() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((ff) arrayList.get(i2)).p;
        }
        return i;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int b() {
        int length = TypedValues.MotionType.TYPE_DRAW_PATH;
        for (j jVar : this.d) {
            int length2 = 208;
            for (com.google.android.libraries.navigation.internal.oe.ad adVar : jVar.a) {
                length2 += (adVar.b.length * 4) + 160;
            }
            length += length2 + (jVar.b.e().length * 24);
        }
        return length;
    }
}
