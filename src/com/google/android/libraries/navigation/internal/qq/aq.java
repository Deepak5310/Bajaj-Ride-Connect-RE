package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.internal.model.cd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq {
    private final com.google.android.libraries.navigation.internal.oe.ai e;
    private final com.google.android.libraries.navigation.internal.oe.x f;
    private final com.google.android.libraries.navigation.internal.oe.x g;
    public final float[] a = {1.0f, 1.0f, 1.0f};
    private final float[] h = new float[4];
    private com.google.android.libraries.geo.mapcore.renderer.v i = null;
    public com.google.android.libraries.geo.mapcore.renderer.v b = null;
    public final com.google.android.libraries.navigation.internal.rm.c c = new com.google.android.libraries.navigation.internal.rm.c();
    public final com.google.android.libraries.navigation.internal.rm.c d = new com.google.android.libraries.navigation.internal.rm.c();

    public aq(cd cdVar) {
        this.e = cdVar.e();
        this.f = cdVar.b();
        this.g = cdVar.c();
    }

    public static void b(cd cdVar, float f) {
        aq aqVar = new aq(cdVar);
        int iA = cdVar.a();
        int i = cdVar.g;
        if (i > 0) {
            iA >>= i;
        }
        float[] fArr = aqVar.a;
        float f2 = iA / f;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
    }

    public final com.google.android.libraries.navigation.internal.rm.c a(com.google.android.libraries.geo.mapcore.renderer.u uVar) {
        if (uVar.x() != this.i) {
            com.google.android.libraries.navigation.internal.rm.c cVar = this.c;
            com.google.android.libraries.geo.mapcore.internal.vector.gl.t.a((com.google.android.libraries.navigation.internal.pb.t) uVar, this.f, this.g, this.e.e(), true, false, this.h);
            cVar.e();
            float[] fArr = this.h;
            cVar.f(fArr[0], fArr[1], fArr[2]);
            float[] fArr2 = this.h;
            float[] fArr3 = this.a;
            float f = fArr2[3];
            cVar.c(f / fArr3[0], f / fArr3[1], f / fArr3[2]);
            this.i = uVar.x();
        }
        return this.c;
    }
}
