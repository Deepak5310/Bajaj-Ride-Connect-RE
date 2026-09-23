package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;
import com.google.android.libraries.geo.mapcore.renderer.ef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class PointGeometryShaderState extends ef {
    public float a;
    public float b;
    public float c;
    public float d;

    /* JADX INFO: compiled from: PG */
    public static final class PointGeometryShaderProgram extends ee {
        public int a;
        private final az b;
        private final String[] c;

        public PointGeometryShaderProgram() {
            az azVar = new az();
            this.b = azVar;
            ax axVar = azVar.d;
            this.c = new String[]{axVar.a, "unused", axVar.c, "unused", axVar.d, axVar.b};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.b.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.b.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            ay ayVar = this.b.c;
            this.x = bvVar.b(i, ayVar.a);
            this.a = bvVar.b(i, ayVar.b);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.c;
        }
    }

    public PointGeometryShaderState() {
        super(PointGeometryShaderProgram.class);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        PointGeometryShaderProgram pointGeometryShaderProgram = (PointGeometryShaderProgram) this.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(pointGeometryShaderProgram);
        GLES20.glUniform4f(pointGeometryShaderProgram.a, this.a, this.d, this.b, this.c);
    }
}
