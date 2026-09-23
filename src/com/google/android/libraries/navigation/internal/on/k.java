package com.google.android.libraries.navigation.internal.on;

import com.google.android.libraries.navigation.internal.oe.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static com.google.android.libraries.navigation.internal.adg.h a(x xVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer intBufferAsIntBuffer = byteBufferAllocate.asIntBuffer();
        intBufferAsIntBuffer.put(xVar.p());
        intBufferAsIntBuffer.put(xVar.r());
        com.google.android.libraries.navigation.internal.adg.g gVar = (com.google.android.libraries.navigation.internal.adg.g) com.google.android.libraries.navigation.internal.adg.h.a.q();
        com.google.android.libraries.navigation.internal.ael.x xVarT = com.google.android.libraries.navigation.internal.ael.x.t(byteBufferAllocate.array());
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.h hVar = (com.google.android.libraries.navigation.internal.adg.h) gVar.b;
        hVar.b |= 1;
        hVar.c = xVarT;
        return (com.google.android.libraries.navigation.internal.adg.h) gVar.t();
    }

    public static com.google.android.libraries.navigation.internal.ael.x b(double[] dArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(dArr.length * 8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.asDoubleBuffer().put(dArr);
        return com.google.android.libraries.navigation.internal.ael.x.s(byteBufferAllocate);
    }
}
