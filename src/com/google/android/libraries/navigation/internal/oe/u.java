package com.google.android.libraries.navigation.internal.oe;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends k {
    @Override // com.google.android.libraries.navigation.internal.oe.k
    public final int a() {
        return 16;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void i(com.google.android.libraries.navigation.internal.ael.x xVar, int i, float[] fArr) {
        throw new UnsupportedOperationException("Floats do not have enough precision to represent LatLng data.");
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void k(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) {
        ByteBuffer byteBufferN = xVar.n();
        byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
        x xVar2 = new x();
        int i2 = i + i;
        int iMin = Math.min(xVar.d() / 16, (iArr.length >> 1) - i);
        for (int i3 = 0; i3 < iMin; i3++) {
            xVar2.L(byteBufferN.getDouble(), byteBufferN.getDouble());
            int i4 = i2 + 1;
            iArr[i2] = xVar2.a;
            i2 += 2;
            iArr[i4] = x.n(xVar2.b);
        }
    }
}
