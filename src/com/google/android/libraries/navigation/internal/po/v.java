package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.google.android.libraries.navigation.internal.qq.j {
    protected boolean a;
    private final x b;

    public v(x xVar, com.google.android.libraries.geo.mapcore.renderer.af afVar) {
        super(afVar);
        this.a = false;
        this.b = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.j, com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar2, com.google.android.libraries.geo.mapcore.renderer.u uVar) {
        if (!this.a) {
            super.G(ajVar, ajVar2, uVar);
            return;
        }
        ((com.google.android.libraries.navigation.internal.qq.j) this).g = new com.google.android.libraries.geo.mapcore.internal.vector.gl.r() { // from class: com.google.android.libraries.navigation.internal.po.t
            @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.r
            public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, float[] fArr) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.t.a(tVar, xVar, null, f, false, false, fArr);
            }
        };
        super.G(ajVar, ajVar2, uVar);
        this.p = true;
        ((com.google.android.libraries.navigation.internal.qq.j) this).g = new com.google.android.libraries.geo.mapcore.internal.vector.gl.r() { // from class: com.google.android.libraries.navigation.internal.po.u
            @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.r
            public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, float[] fArr) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.t.a(tVar, xVar, null, f, false, true, fArr);
            }
        };
        super.G(ajVar, ajVar2, uVar);
        ((com.google.android.libraries.navigation.internal.qq.j) this).g = new com.google.android.libraries.geo.mapcore.internal.vector.gl.r() { // from class: com.google.android.libraries.navigation.internal.po.t
            @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.r
            public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, float[] fArr) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.t.a(tVar, xVar, null, f, false, false, fArr);
            }
        };
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void b(long j) {
        this.b.B();
    }
}
