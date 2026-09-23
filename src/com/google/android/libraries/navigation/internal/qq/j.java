package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.renderer.ea;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j extends h {
    private static final com.google.android.libraries.navigation.internal.rm.d a = new com.google.android.libraries.navigation.internal.rm.d((byte[]) null);
    private float A;
    private final float[] b;
    private float c;
    public final com.google.android.libraries.navigation.internal.oe.x e;
    public final float[] f;
    public com.google.android.libraries.geo.mapcore.internal.vector.gl.r g;
    protected final boolean h;
    private final float[] y;
    private boolean z;

    public j(com.google.android.libraries.geo.mapcore.renderer.af afVar) {
        this(afVar, new com.google.android.libraries.geo.mapcore.renderer.ae(afVar.a(), 0L, 0L, 0L));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public void G(com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar2, com.google.android.libraries.geo.mapcore.renderer.u uVar) {
        if (this.p || uVar.x() != this.r) {
            if (this.z) {
                this.c = com.google.android.libraries.navigation.internal.pb.j.u((com.google.android.libraries.navigation.internal.pb.t) uVar, uVar.m(this.e, this.h));
            } else {
                float[] fArr = this.y;
                fArr[2] = 1.0f;
                fArr[1] = 1.0f;
                fArr[0] = 1.0f;
            }
            this.g.a((com.google.android.libraries.navigation.internal.pb.t) uVar, this.e, this.c, this.b);
            this.o.e();
            com.google.android.libraries.navigation.internal.rm.c cVar = this.o;
            float[] fArr2 = this.b;
            cVar.f(fArr2[0], fArr2[1], fArr2[2]);
            float f = this.A;
            if (f != 0.0f) {
                this.o.b(a, f);
            }
            float[] fArr3 = this.b;
            com.google.android.libraries.navigation.internal.rm.c cVar2 = this.o;
            float[] fArr4 = this.y;
            float f2 = fArr3[3];
            cVar2.c(fArr4[0] * f2, fArr4[1] * f2, fArr4[2] * f2);
            com.google.android.libraries.navigation.internal.rm.c cVar3 = this.o;
            float[] fArr5 = this.f;
            cVar3.g(fArr5[0], fArr5[1], fArr5[2]);
        }
        super.G(ajVar, ajVar2, uVar);
    }

    public final void j(float f) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        this.A = f;
        this.p = true;
    }

    public final void k(com.google.android.libraries.navigation.internal.oe.x xVar) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        this.e.W(xVar);
        this.p = true;
    }

    public final void l(float f) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        this.c = f;
        this.z = false;
        this.p = true;
    }

    public final void m(float f, float f2) {
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        float[] fArr = this.y;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = 1.0f;
        this.z = true;
        this.p = true;
    }

    public j(com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.geo.mapcore.renderer.ae aeVar) {
        super(afVar, aeVar, 0);
        this.b = new float[4];
        this.e = new com.google.android.libraries.navigation.internal.oe.x();
        this.y = new float[]{1.0f, 1.0f, 1.0f};
        this.f = new float[3];
        this.z = true;
        this.h = true;
        this.g = new com.google.android.libraries.geo.mapcore.internal.vector.gl.r() { // from class: com.google.android.libraries.navigation.internal.qq.i
            @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.r
            public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, float[] fArr) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.t.a(tVar, xVar, null, f, true, false, fArr);
            }
        };
    }
}
