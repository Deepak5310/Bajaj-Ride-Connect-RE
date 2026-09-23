package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ee;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ClientLineLiteShaderState$ClientInjectedStrokeLiteShader extends ee {
    protected int a;
    protected int b;
    protected int c;
    private final d d;
    private final String[] e;

    public ClientLineLiteShaderState$ClientInjectedStrokeLiteShader() {
        d dVar = new d();
        this.d = dVar;
        b bVar = dVar.d;
        this.e = new String[]{bVar.a, "unused", "unused", "unused", bVar.b, bVar.c};
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
        c cVar = this.d.c;
        this.a = bvVar.b(i, cVar.m);
        this.b = bvVar.b(i, cVar.f52n);
        this.c = bvVar.b(i, cVar.j);
        GLES20.glUniform1i(this.a, 1);
        GLES20.glUniform1i(this.b, 2);
        int i2 = this.c;
        int i3 = i.e;
        bvVar.R(i2, 7, i.a);
        bvVar.b(i, cVar.a);
        bvVar.b(i, cVar.b);
        this.x = bvVar.b(i, cVar.c);
        bvVar.b(i, cVar.d);
        bvVar.b(i, cVar.e);
        bvVar.b(i, cVar.f);
        bvVar.b(i, cVar.g);
        bvVar.b(i, cVar.i);
        bvVar.b(i, cVar.h);
        bvVar.b(i, cVar.o);
        bvVar.b(i, cVar.k);
        bvVar.b(i, cVar.l);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ee
    public final String[] d() {
        return this.e;
    }
}
