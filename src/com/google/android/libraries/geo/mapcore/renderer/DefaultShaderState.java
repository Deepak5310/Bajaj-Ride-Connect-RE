package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Color;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultShaderState extends ef {
    private final float[] a;

    /* JADX INFO: compiled from: PG */
    public static class DefaultShaderProgram extends ee {
        private static final String[] a = {"aPosition", "unused", "aColor"};

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return "precision mediump float;\nvarying vec4 color;\nvoid main() {\n  gl_FragColor = color;\n}\n";
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return "precision highp float;\nuniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aColor;\nvarying vec4 color;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  color = aColor;\n}\n";
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            this.x = bvVar.b(i, "uMVPMatrix");
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return a;
        }
    }

    public DefaultShaderState() {
        super(DefaultShaderProgram.class);
        this.a = new float[]{Color.red(-1) / 255.0f, Color.green(-1) / 255.0f, Color.blue(-1) / 255.0f, Color.alpha(-1) / 255.0f};
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ef
    protected final void b(bv bvVar, aj ajVar, u uVar, float[] fArr, float[] fArr2, float[] fArr3) {
        super.b(bvVar, ajVar, uVar, fArr, fArr2, fArr3);
        bv.V(this.a);
    }
}
