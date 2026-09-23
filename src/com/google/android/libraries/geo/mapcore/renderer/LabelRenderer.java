package com.google.android.libraries.geo.mapcore.renderer;

import com.google.firebase.messaging.Constants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class LabelRenderer {
    public final LayeredLabelRenderer a;
    public final y b;
    public int c;
    public int d;

    /* JADX INFO: compiled from: PG */
    static class LabelShaderProgram extends ee {
        final int a;
        final int b;
        final int c;
        private final cx d;
        private final String[] e;

        public LabelShaderProgram(bv bvVar) {
            cx cxVar = new cx();
            this.d = cxVar;
            cv cvVar = cxVar.d;
            String[] strArr = {cvVar.a, cvVar.b};
            this.e = strArr;
            int iA = bvVar.a(cxVar.a, cxVar.b, strArr);
            this.w = iA;
            this.a = bvVar.b(iA, cxVar.c.c);
            this.b = bvVar.b(this.w, cxVar.c.b);
            this.c = bvVar.b(this.w, cxVar.c.a);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.d.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.d.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.e;
        }
    }

    public LabelRenderer(ax axVar, bv bvVar) {
        LabelShaderProgram labelShaderProgram = new LabelShaderProgram(bvVar);
        LayeredLabelRenderer layeredLabelRenderer = null;
        if (LayeredLabelRenderer.b()) {
            try {
                layeredLabelRenderer = new LayeredLabelRenderer(axVar, bvVar);
            } catch (fa unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1361)).p("Non fatal exception - could not instantiate LayeredLabelRenderer");
            }
        }
        this.a = layeredLabelRenderer;
        this.b = new y(4096, 5, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.mapcore.renderer.cu
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return new ct((af) obj);
            }
        }, bvVar, labelShaderProgram, axVar, Constants.ScionAnalytics.PARAM_LABEL);
    }

    public final w a(ep epVar, af afVar, int i) {
        return this.b.b(epVar, afVar, i);
    }

    public final void b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, w wVar) {
        float f12 = f5 * 0.5f;
        float f13 = f12 * f4;
        float f14 = f2 + f13;
        float f15 = 0.5f * f6;
        float f16 = f12 * f3;
        float f17 = f + f16;
        float f18 = f2 - f13;
        float f19 = f15 * f3;
        float f20 = f - f16;
        float f21 = f15 * (-f4);
        c(f20 + f21, f18 + f19, f20 - f21, f18 - f19, f17 - f21, f14 - f19, f17 + f21, f14 + f19, f7, f8, f9, f10, f11, wVar);
    }

    public final void c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, w wVar) {
        if (f >= 0.0f || f3 >= 0.0f || f5 >= 0.0f || f7 >= 0.0f) {
            if (f2 >= 0.0f || f4 >= 0.0f || f6 >= 0.0f || f8 >= 0.0f) {
                float f14 = this.c;
                if (f <= f14 || f3 <= f14 || f5 <= f14 || f7 <= f14) {
                    float f15 = this.d;
                    if (f2 <= f15 || f4 <= f15 || f6 <= f15 || f8 <= f15) {
                        float[] fArr = wVar.a;
                        int i = wVar.b;
                        int i2 = i + 1;
                        wVar.b = i2;
                        fArr[i] = f;
                        int i3 = i + 2;
                        wVar.b = i3;
                        fArr[i2] = f2;
                        int i4 = i + 3;
                        wVar.b = i4;
                        fArr[i3] = f13;
                        int i5 = i + 4;
                        wVar.b = i5;
                        fArr[i4] = f9;
                        int i6 = i + 5;
                        wVar.b = i6;
                        float f16 = f10 + f12;
                        fArr[i5] = f16;
                        int i7 = i + 6;
                        wVar.b = i7;
                        fArr[i6] = f3;
                        int i8 = i + 7;
                        wVar.b = i8;
                        fArr[i7] = f4;
                        int i9 = i + 8;
                        wVar.b = i9;
                        fArr[i8] = f13;
                        int i10 = i + 9;
                        wVar.b = i10;
                        fArr[i9] = f9;
                        int i11 = i + 10;
                        wVar.b = i11;
                        fArr[i10] = f10;
                        int i12 = i + 11;
                        wVar.b = i12;
                        fArr[i11] = f5;
                        int i13 = i + 12;
                        wVar.b = i13;
                        fArr[i12] = f6;
                        int i14 = i + 13;
                        wVar.b = i14;
                        fArr[i13] = f13;
                        int i15 = i + 14;
                        wVar.b = i15;
                        float f17 = f9 + f11;
                        fArr[i14] = f17;
                        int i16 = i + 15;
                        wVar.b = i16;
                        fArr[i15] = f10;
                        int i17 = i + 16;
                        wVar.b = i17;
                        fArr[i16] = f7;
                        int i18 = i + 17;
                        wVar.b = i18;
                        fArr[i17] = f8;
                        int i19 = i + 18;
                        wVar.b = i19;
                        fArr[i18] = f13;
                        int i20 = i + 19;
                        wVar.b = i20;
                        fArr[i19] = f17;
                        wVar.b = i + 20;
                        fArr[i20] = f16;
                    }
                }
            }
        }
    }

    public final void d(w wVar) {
        this.b.f(wVar);
    }

    public final void e(er erVar, af afVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        w wVarA = this.b.a(erVar.i, afVar);
        if (wVarA != null) {
            b(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, wVarA);
            this.b.f(wVarA);
        }
    }
}
