package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class TextureShaderState$TextureShaderProgram extends ee {
    public int a;
    public int b;
    public int c;
    private final ew d;
    private final String[] e;

    public TextureShaderState$TextureShaderProgram() {
        ew ewVar = new ew();
        this.d = ewVar;
        eu euVar = ewVar.d;
        this.e = new String[]{euVar.a, "unused", euVar.b, euVar.c};
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
        ev evVar = this.d.c;
        this.x = bvVar.b(i, evVar.a);
        this.a = bvVar.b(i, evVar.b);
        this.b = bvVar.b(i, evVar.c);
        this.c = bvVar.b(i, evVar.d);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ee
    public final String[] d() {
        return this.e;
    }
}
