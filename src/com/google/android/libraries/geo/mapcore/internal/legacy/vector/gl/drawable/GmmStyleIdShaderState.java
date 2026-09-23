package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GmmStyleIdShaderState extends ef {
    private static final int[] b = new int[0];
    protected float a;
    private int[] c;
    private int d;

    /* JADX INFO: compiled from: PG */
    public static class GmmStyleIdShaderProgram extends ee {
        protected int a;
        protected int b;
        private final ap c;
        private final String[] d;

        public GmmStyleIdShaderProgram() {
            ap apVar = new ap();
            this.c = apVar;
            an anVar = apVar.d;
            this.d = new String[]{anVar.a, "unused", "unused", "unused", anVar.b};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.c.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.c.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            ao aoVar = this.c.c;
            this.x = bvVar.b(i, aoVar.a);
            this.a = bvVar.b(i, aoVar.b);
            this.b = bvVar.b(i, aoVar.c);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.d;
        }
    }

    public GmmStyleIdShaderState() {
        super(GmmStyleIdShaderProgram.class);
        this.c = b;
    }

    public final void a(List list) {
        int i = this.d;
        int iMin = Math.min(list.size(), 64);
        this.d = iMin;
        if (iMin != i) {
            this.c = new int[iMin * 4];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.d; i3++) {
            com.google.android.libraries.navigation.internal.qh.b bVar = (com.google.android.libraries.navigation.internal.qh.b) list.get(i3);
            int i4 = bVar.a;
            int i5 = bVar.b;
            int[] iArr = this.c;
            iArr[i2] = i4 >>> 16;
            iArr[i2 + 1] = (char) i4;
            iArr[i2 + 2] = i5 >>> 16;
            iArr[i2 + 3] = (char) i5;
            i2 += 4;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        GmmStyleIdShaderProgram gmmStyleIdShaderProgram = (GmmStyleIdShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(gmmStyleIdShaderProgram);
        bv.S(gmmStyleIdShaderProgram.a, this.d, this.c);
        GLES20.glUniform1f(gmmStyleIdShaderProgram.b, this.a);
    }
}
