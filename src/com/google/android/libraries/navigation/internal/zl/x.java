package com.google.android.libraries.navigation.internal.zl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x extends g {
    private long a;
    private long b;
    private int c;

    public x(int i) {
        super(16, 16);
        this.a = 0L;
        this.b = 0L;
        this.c = 0;
    }

    private static long l(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private static long m(long j) {
        return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
    }

    private static long n(long j) {
        return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final l e() {
        long j = this.a;
        long j2 = this.c;
        long j3 = j ^ j2;
        long j4 = j2 ^ this.b;
        long j5 = j3 + j4;
        this.a = j5;
        long j6 = j4 + j5;
        this.b = j6;
        long jL = l(j5);
        this.a = jL;
        long jL2 = l(j6);
        long j7 = jL + jL2;
        this.a = j7;
        this.b = jL2 + j7;
        return new i(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.a).putLong(this.b).array());
    }

    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final void h(ByteBuffer byteBuffer) {
        long j = byteBuffer.getLong();
        long j2 = byteBuffer.getLong();
        long jM = m(j) ^ this.a;
        this.a = jM;
        long jRotateLeft = Long.rotateLeft(jM, 27);
        long j3 = this.b;
        long j4 = ((jRotateLeft + j3) * 5) + 1390208809;
        this.a = j4;
        long jN = n(j2) ^ j3;
        this.b = jN;
        this.b = ((Long.rotateLeft(jN, 31) + j4) * 5) + 944331445;
        this.c += 16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final void k(ByteBuffer byteBuffer) {
        long jA;
        long jA2;
        long jA3;
        long jA4;
        long jA5;
        long jA6;
        long jA7;
        this.c += byteBuffer.remaining();
        long jA8 = 0;
        switch (byteBuffer.remaining()) {
            case 1:
                jA = 0;
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 2:
                jA2 = 0;
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 3:
                jA3 = 0;
                jA2 = jA3 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(2))) << 16);
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 4:
                jA4 = 0;
                jA3 = jA4 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(3))) << 24);
                jA2 = jA3 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(2))) << 16);
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 5:
                jA5 = 0;
                jA4 = jA5 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(4))) << 32);
                jA3 = jA4 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(3))) << 24);
                jA2 = jA3 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(2))) << 16);
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 6:
                jA6 = 0;
                jA5 = (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(5))) << 40) ^ jA6;
                jA4 = jA5 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(4))) << 32);
                jA3 = jA4 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(3))) << 24);
                jA2 = jA3 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(2))) << 16);
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 7:
                jA6 = ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(6))) << 48;
                jA5 = (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(5))) << 40) ^ jA6;
                jA4 = jA5 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(4))) << 32);
                jA3 = jA4 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(3))) << 24);
                jA2 = jA3 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(2))) << 16);
                jA = jA2 ^ (((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(1))) << 8);
                jA7 = jA ^ ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(0)));
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 8:
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 9:
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 10:
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 11:
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(10))) << 16;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 12:
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(11))) << 24;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(10))) << 16;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 13:
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(12))) << 32;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(11))) << 24;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(10))) << 16;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 14:
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(13))) << 40;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(12))) << 32;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(11))) << 24;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(10))) << 16;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            case 15:
                jA8 = ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(14))) << 48;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(13))) << 40;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(12))) << 32;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(11))) << 24;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(10))) << 16;
                jA8 ^= ((long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(9))) << 8;
                jA8 ^= (long) com.google.android.libraries.navigation.internal.zy.m.a(byteBuffer.get(8));
                jA7 = byteBuffer.getLong();
                this.a = m(jA7) ^ this.a;
                this.b ^= n(jA8);
                return;
            default:
                throw new AssertionError("Should never get here.");
        }
    }
}
