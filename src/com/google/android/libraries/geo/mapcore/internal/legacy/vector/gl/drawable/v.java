package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v");
    public static final int[] b = new int[0];
    public static final float[] c = new float[0];

    public static s a(com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar, bt btVar, float f, int i, int i2) {
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF = btVar.f(f);
        s sVar = new s(i, i2);
        if (pVar.d(aiVarF) > 0) {
            bs bsVarF = pVar.f(aiVarF, 0);
            if (sVar.a == 4 && bsVarF.j.c()) {
                sVar.a = 0;
            }
            if (sVar.b == 4 && bsVarF.k.c()) {
                sVar.b = 0;
            }
        }
        return sVar;
    }

    public static ff b(List list, int i, int i2, float f, boolean z, boolean z2, float[] fArr, float[] fArr2, float[] fArr3, float f2, com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar, GeometryUtil geometryUtil, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            t tVar = (t) it2.next();
            s sVarA = a(pVar, ((u) tVar.b.get(0)).j[0], f, tVar.c, tVar.d);
            fg fgVar = tVar.a;
            bh bhVarS = bi.s(com.google.android.libraries.navigation.internal.adl.k.g);
            fgVar.h(bhVarS);
            Object objK = fgVar.w.k(bhVarS.d);
            float fFloatValue = ((Float) (objK == null ? bhVarS.b : bhVarS.c(objK))).floatValue();
            for (u uVar : tVar.b) {
                int[] iArr = uVar.b;
                int[] iArr2 = uVar.a;
                int[] iArr3 = uVar.i;
                bt[] btVarArr = uVar.j;
                int i3 = sVarA.a;
                int i4 = sVarA.b;
                int i5 = tVar.e;
                int[] iArr4 = uVar.d;
                int[] iArr5 = uVar.e;
                Iterator it3 = it2;
                if (iArr.length != 0 && btVarArr[0] != null) {
                    geometryUtil.addExtrudedMultiSegmentRoadsWithNormals(iArr, iArr2, new com.google.android.libraries.navigation.internal.oe.x(i, i2), g(iArr3, btVarArr, f, z), vVar, i3, i4, i5, 0.0f, iArr3, z2, fArr, fArr2, fArr3, true, f2, fFloatValue, iArr4, iArr5);
                }
                it2 = it3;
                tVar = tVar;
                sVarA = sVarA;
            }
            it2 = it2;
        }
        return f(vVar, z2);
    }

    public static ff c(List list, float f, float f2, float f3, boolean z, boolean z2, float[] fArr, float[] fArr2, float[] fArr3, float f4, com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar, GeometryUtil geometryUtil, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            t tVar = (t) it2.next();
            s sVarA = a(pVar, ((u) tVar.b.get(0)).j[0], f3, tVar.c, tVar.d);
            fg fgVar = tVar.a;
            bh bhVarS = bi.s(com.google.android.libraries.navigation.internal.adl.k.g);
            fgVar.h(bhVarS);
            Object objK = fgVar.w.k(bhVarS.d);
            float fFloatValue = ((Float) (objK == null ? bhVarS.b : bhVarS.c(objK))).floatValue();
            for (u uVar : tVar.b) {
                float[] fArr4 = uVar.c;
                int[] iArr = uVar.a;
                int[] iArr2 = uVar.i;
                bt[] btVarArr = uVar.j;
                int i = sVarA.a;
                int i2 = sVarA.b;
                int i3 = tVar.e;
                if (fArr4.length != 0 && btVarArr[0] != null) {
                    geometryUtil.addExtrudedMultiSegmentRoadsWithNormals(fArr4, iArr, f, f2, g(iArr2, btVarArr, f3, z), vVar, i, i2, i3, 0.0f, iArr2, z2, fArr, fArr2, fArr3, f4, 0, fFloatValue);
                }
            }
        }
        return f(vVar, z2);
    }

    public static void d(int i, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar, GeometryUtil geometryUtil, float[] fArr, com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar, int i2, int i3, bt btVar) {
        if (!geometryUtil.supportsVertexTextureFetching()) {
            e(btVar, pVar.f, i, fArr);
        }
        if (geometryUtil.supportsVertexTextureFetching()) {
            geometryUtil.copyExtrudedRoadsWithNormals(vVar, i2, i3, i);
        } else {
            geometryUtil.copyExtrudedRoadsWithNormalsAndWidths(vVar, i2, i3, i, fArr);
        }
    }

    public static void e(bt btVar, int i, int i2, float[] fArr) {
        int iMin = Math.min(4, btVar.c(i));
        for (int i3 = 0; i3 < iMin; i3++) {
            bs[] bsVarArr = btVar.g(i3 + i).o;
            if (bsVarArr.length > i2) {
                fArr[i3] = bsVarArr[i2].d;
            }
        }
    }

    private static ff f(com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar, boolean z) {
        if (vVar.f <= 0) {
            return null;
        }
        ff ffVarC = vVar.c(true != z ? 5 : 4);
        ffVarC.c(false);
        return ffVarC;
    }

    private static float[] g(int[] iArr, bt[] btVarArr, float f, boolean z) {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = btVarArr[i].g((int) f);
            bs[] bsVarArr = z ? aiVarG.f58n : aiVarG.o;
            if (bsVarArr.length > 0) {
                fArr[i] = bsVarArr[0].h;
            }
        }
        return fArr;
    }
}
