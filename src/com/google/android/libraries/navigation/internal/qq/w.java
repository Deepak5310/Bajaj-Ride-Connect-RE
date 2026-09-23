package com.google.android.libraries.navigation.internal.qq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w {
    private final com.google.android.libraries.navigation.internal.rm.c a = new com.google.android.libraries.navigation.internal.rm.c();
    private final com.google.android.libraries.navigation.internal.rm.d b = new com.google.android.libraries.navigation.internal.rm.d();
    private final com.google.android.libraries.navigation.internal.rm.d c = new com.google.android.libraries.navigation.internal.rm.d();
    private final com.google.android.libraries.navigation.internal.oe.x d = new com.google.android.libraries.navigation.internal.oe.x();

    final com.google.android.libraries.navigation.internal.oe.x a(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.rm.c cVar) {
        com.google.android.libraries.navigation.internal.rm.c cVar2 = this.a;
        if (cVar2 != cVar) {
            cVar2.d(cVar);
            com.google.android.libraries.navigation.internal.rm.c cVar3 = this.a;
            if (cVar3.b) {
                this.d.W(xVar);
            } else {
                com.google.android.libraries.navigation.internal.rm.d dVar = this.b;
                float f = xVar.a;
                float f2 = xVar.b;
                float[] fArr = dVar.a;
                fArr[0] = f;
                fArr[1] = f2;
                fArr[2] = 1.0f;
                com.google.android.libraries.navigation.internal.rm.d dVar2 = this.c;
                fArr[3] = 1.0f;
                com.google.android.libraries.navigation.internal.rq.f.e(dVar2.a, 0, cVar3.a, fArr);
                com.google.android.libraries.navigation.internal.oe.x xVar2 = this.d;
                float[] fArr2 = this.c.a;
                xVar2.J((int) fArr2[0], (int) fArr2[1]);
            }
        }
        return this.d;
    }
}
