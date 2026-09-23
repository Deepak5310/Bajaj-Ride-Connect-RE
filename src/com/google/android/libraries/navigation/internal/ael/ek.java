package com.google.android.libraries.navigation.internal.ael;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ek extends el {
    public ek(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final byte a(long j) {
        return Memory.peekByte(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final double b(Object obj, long j) {
        return Double.longBitsToDouble(k(obj, j));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final float c(Object obj, long j) {
        return Float.intBitsToFloat(j(obj, j));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final void d(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray(j, bArr, (int) j2, (int) j3);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final void e(Object obj, long j, boolean z) {
        if (em.d) {
            em.q(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            em.r(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final void f(Object obj, long j, byte b) {
        if (em.d) {
            em.q(obj, j, b);
        } else {
            em.r(obj, j, b);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final void g(Object obj, long j, double d) {
        n(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final void h(Object obj, long j, float f) {
        m(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.el
    public final boolean i(Object obj, long j) {
        return em.d ? em.z(obj, j) : em.A(obj, j);
    }
}
