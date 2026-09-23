package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.cd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ba {
    final com.google.android.libraries.navigation.internal.qq.aq a;
    final com.google.android.libraries.navigation.internal.qq.aq b;

    public ba(cd cdVar, int i) {
        this.a = new com.google.android.libraries.navigation.internal.qq.aq(cdVar);
        com.google.android.libraries.navigation.internal.qq.aq aqVar = new com.google.android.libraries.navigation.internal.qq.aq(cdVar);
        int iA = cdVar.a();
        int i2 = cdVar.g;
        int i3 = i2 <= 0 ? iA : iA >> i2;
        float[] fArr = aqVar.a;
        float f = i3;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = iA;
        com.google.android.libraries.navigation.internal.qq.aq aqVar2 = new com.google.android.libraries.navigation.internal.qq.aq(cdVar);
        int iA2 = cdVar.a();
        int iMax = cdVar.g - (Math.max(i, 4) - 4);
        int i4 = iMax < 0 ? iA2 << (-iMax) : iA2 >> iMax;
        float[] fArr2 = aqVar2.a;
        float f2 = i4;
        fArr2[0] = f2;
        fArr2[1] = f2;
        fArr2[2] = iA2;
        this.b = aqVar2;
        com.google.android.libraries.navigation.internal.qq.aq.b(cdVar, 1.0f);
        com.google.android.libraries.navigation.internal.qq.aq.b(cdVar, (float) Math.pow(2.0d, 18 - cdVar.a));
    }
}
