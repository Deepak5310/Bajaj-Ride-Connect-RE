package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static final ThreadLocal a = new q();

    public static void a(com.google.android.libraries.navigation.internal.pb.t tVar, x xVar, x xVar2, float f, boolean z, boolean z2, float[] fArr) {
        s sVar = (s) a.get();
        x xVar3 = sVar.a;
        x xVar4 = sVar.b;
        x xVar5 = sVar.c;
        x xVar6 = sVar.d;
        boolean zQ = com.google.android.libraries.navigation.internal.pb.j.q(tVar, tVar.s() / 2.0f, tVar.r() / 2.0f, xVar5, sVar.e);
        tVar.A(xVar3);
        if (!zQ) {
            xVar5.W(xVar3);
        }
        x.N(xVar, xVar5, xVar4);
        x.N(xVar5, xVar3, xVar6);
        if (z2) {
            x.F(xVar4, new x((xVar3.a <= 0 || xVar4.a >= 268435456) ? -1073741824 : 1073741824, 0), xVar4);
        }
        if (z) {
            xVar4.Q(xVar4);
        }
        xVar4.S(xVar6);
        if (xVar2 != null) {
            x.F(xVar4, xVar2, xVar4);
        }
        float fL = tVar.l();
        fArr[0] = xVar4.a * fL;
        fArr[1] = xVar4.b * fL;
        fArr[2] = xVar4.c * fL;
        fArr[3] = fL * f;
    }
}
