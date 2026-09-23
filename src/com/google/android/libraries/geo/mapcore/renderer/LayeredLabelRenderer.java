package com.google.android.libraries.geo.mapcore.renderer;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class LayeredLabelRenderer {
    public static final float[] a = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] b = {Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f};
    static final int c = (int) Math.ceil(30.25d);
    public final y d;
    public final List e = new ArrayList(6);
    public final com.google.android.libraries.navigation.internal.rm.a f = new com.google.android.libraries.navigation.internal.rm.a();

    /* JADX INFO: compiled from: PG */
    static class LayeredLabelShaderProgram extends ee {
        final int a;
        final int b;
        final int c;
        private final de d;
        private final String[] e;

        public LayeredLabelShaderProgram(bv bvVar) {
            de deVar = new de();
            this.d = deVar;
            dc dcVar = deVar.d;
            String[] strArr = {dcVar.a, dcVar.b, dcVar.c, dcVar.i, dcVar.d, dcVar.j, dcVar.e, dcVar.k, dcVar.f, dcVar.l, dcVar.g, dcVar.m, dcVar.h, dcVar.f79n};
            this.e = strArr;
            int iA = bvVar.a(deVar.a, deVar.b, strArr);
            this.w = iA;
            this.a = bvVar.b(iA, deVar.c.c);
            this.b = bvVar.b(this.w, deVar.c.b);
            this.c = bvVar.b(this.w, deVar.c.a);
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

    public LayeredLabelRenderer(ax axVar, bv bvVar) {
        this.d = new y(256, 33, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.mapcore.renderer.db
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return new da((af) obj);
            }
        }, bvVar, new LayeredLabelShaderProgram(bvVar), axVar, "layered_label");
    }

    public static void a(float f, float f2, List list, int i, float f3, w wVar) {
        int i2 = wVar.b;
        int i3 = i2 + 1;
        wVar.b = i3;
        float[] fArr = wVar.a;
        fArr[i2] = f;
        int i4 = i2 + 2;
        wVar.b = i4;
        fArr[i3] = f2;
        wVar.b = i2 + 3;
        fArr[i4] = f3;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int i6 = i + i;
            int i7 = i6 + 1;
            cz czVar = (cz) list.get(i5);
            float[] fArr2 = wVar.a;
            int i8 = wVar.b;
            int i9 = i8 + 1;
            wVar.b = i9;
            float[] fArr3 = czVar.d;
            fArr2[i8] = fArr3[i6];
            int i10 = i8 + 2;
            wVar.b = i10;
            fArr2[i9] = fArr3[i7];
            int i11 = i8 + 3;
            wVar.b = i11;
            float[] fArr4 = czVar.e;
            fArr2[i10] = fArr4[i6];
            int i12 = i8 + 4;
            wVar.b = i12;
            fArr2[i11] = fArr4[i7];
            wVar.b = i8 + 5;
            fArr2[i12] = czVar.a;
        }
        int size = 6 - list.size();
        for (int i13 = 0; i13 < size; i13++) {
            float[] fArr5 = wVar.a;
            int i14 = wVar.b;
            int i15 = i14 + 1;
            wVar.b = i15;
            fArr5[i14] = -1.0f;
            int i16 = i14 + 2;
            wVar.b = i16;
            fArr5[i15] = -1.0f;
            int i17 = i14 + 3;
            wVar.b = i17;
            fArr5[i16] = 0.0f;
            int i18 = i14 + 4;
            wVar.b = i18;
            fArr5[i17] = 0.0f;
            wVar.b = i14 + 5;
            fArr5[i18] = 0.0f;
        }
    }

    public static boolean b() {
        return bt.a().f >= 14 && bt.a().e >= c;
    }
}
