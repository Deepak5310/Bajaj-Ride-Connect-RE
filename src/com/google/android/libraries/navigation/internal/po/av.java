package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av implements gv {
    float a = Float.MAX_VALUE;
    float b = Float.MAX_VALUE;
    float c = -3.4028235E38f;
    float d = 0.0f;
    final /* synthetic */ ay e;

    protected av(ay ayVar) {
        this.e = ayVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final float a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final com.google.android.libraries.navigation.internal.oe.x b() {
        return new com.google.android.libraries.navigation.internal.oe.x(Math.round(this.a), Math.round(this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final com.google.android.libraries.geo.mapcore.renderer.ff c(List list, boolean z, float[] fArr, float[] fArr2, float[] fArr3, float f, GeometryUtil geometryUtil, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar) {
        float f2 = this.a;
        float f3 = this.b;
        ay ayVar = this.e;
        return com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v.c(list, f2, f3, ayVar.t, ayVar.m, z, fArr, fArr2, fArr3, f, vVar, geometryUtil, pVar);
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final void d(com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar) {
        float[] fArr;
        Iterator it2 = tVar.b.iterator();
        while (it2.hasNext()) {
            float[] fArr2 = ((com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u) it2.next()).c;
            int length = fArr2.length;
            if (length == 0 || (length & 1) != 0) {
                fArr = new float[]{0.0f, 0.0f, 0.0f};
            } else {
                float fMin = Float.MAX_VALUE;
                float fMax = -3.4028235E38f;
                float fMin2 = Float.MAX_VALUE;
                for (int i = 0; i < fArr2.length; i += 2) {
                    float f = fArr2[i];
                    fMin = Math.min(f, fMin);
                    fMax = Math.max(f, fMax);
                    fMin2 = Math.min(fArr2[i + 1], fMin2);
                }
                fArr = new float[]{fMin, fMax, fMin2};
            }
            float fMin3 = Math.min(fArr[0], this.a);
            this.a = fMin3;
            float fMax2 = Math.max(fArr[1], this.c);
            this.c = fMax2;
            this.b = Math.min(fArr[2], this.b);
            this.d = fMax2 - fMin3;
        }
    }
}
