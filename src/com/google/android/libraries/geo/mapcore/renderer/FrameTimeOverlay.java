package com.google.android.libraries.geo.mapcore.renderer;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameTimeOverlay {
    private static final int a;

    /* JADX INFO: compiled from: PG */
    private static final class FrameTimeOverlayShaderProgram extends ee {
        private final bc a;
        private final String[] b;

        FrameTimeOverlayShaderProgram() {
            bc bcVar = new bc();
            this.a = bcVar;
            ba baVar = bcVar.d;
            this.b = new String[]{baVar.a, baVar.b};
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String a() {
            return this.a.b;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String b() {
            return this.a.a;
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        protected final void c(bv bvVar, int i) {
            bvVar.b(i, this.a.c.a);
            bvVar.b(i, this.a.c.b);
            bvVar.b(i, this.a.c.c);
            bvVar.b(i, this.a.c.d);
            bvVar.b(i, this.a.c.e);
            bvVar.b(i, this.a.c.f);
            bvVar.b(i, this.a.c.g);
        }

        @Override // com.google.android.libraries.geo.mapcore.renderer.ee
        public final String[] d() {
            return this.b;
        }
    }

    static {
        bd bdVar = bd.WAIT_FOR_NEXT_FRAME;
        a = (int) TimeUnit.MILLISECONDS.toNanos(110L);
    }
}
