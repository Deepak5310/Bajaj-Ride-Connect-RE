package com.google.android.libraries.navigation.internal.oe;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends k {
    @Override // com.google.android.libraries.navigation.internal.oe.k
    public final int a() {
        return 8;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void i(com.google.android.libraries.navigation.internal.ael.x xVar, int i, float[] fArr) {
        ByteBuffer byteBufferN = xVar.n();
        byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
        int i2 = i + i;
        int iMin = Math.min(xVar.d() / 8, (fArr.length >> 1) - i);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = i2 + 1;
            fArr[i2] = byteBufferN.getFloat();
            i2 += 2;
            fArr[i4] = byteBufferN.getFloat();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void k(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) {
        throw new UnsupportedOperationException("Float-precision would be lost.");
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final int[] n(com.google.android.libraries.navigation.internal.ael.x xVar, int i) {
        return new int[0];
    }
}
