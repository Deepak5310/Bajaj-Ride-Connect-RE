package com.google.android.libraries.navigation.internal.zl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends g {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;

    public ab(long j, long j2) {
        super(8, 8);
        this.e = 0L;
        this.f = 0L;
        this.a = 8317987319222330741L ^ j;
        this.b = 7237128888997146477L ^ j2;
        this.c = j ^ 7816392313619706465L;
        this.d = 8387220255154660723L ^ j2;
    }

    private final void l(long j) {
        this.d ^= j;
        m(2);
        this.a = j ^ this.a;
    }

    private final void m(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            long j = this.a;
            long j2 = this.b;
            long j3 = j + j2;
            this.a = j3;
            long j4 = this.c;
            long j5 = this.d;
            long j6 = j4 + j5;
            this.c = j6;
            long jRotateLeft = Long.rotateLeft(j2, 13);
            this.b = jRotateLeft;
            long jRotateLeft2 = Long.rotateLeft(j5, 16);
            long j7 = jRotateLeft ^ j3;
            this.b = j7;
            long j8 = jRotateLeft2 ^ j6;
            this.d = j8;
            long j9 = j6 + j7;
            long jRotateLeft3 = Long.rotateLeft(j3, 32);
            this.c = j9;
            long j10 = jRotateLeft3 + j8;
            this.a = j10;
            long jRotateLeft4 = Long.rotateLeft(j7, 17);
            this.b = jRotateLeft4;
            long jRotateLeft5 = Long.rotateLeft(j8, 21);
            this.b = jRotateLeft4 ^ j9;
            this.d = j10 ^ jRotateLeft5;
            this.c = Long.rotateLeft(j9, 32);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final l e() {
        long j = this.f ^ (this.e << 56);
        this.f = j;
        l(j);
        this.c ^= 255;
        m(4);
        return new k(((this.a ^ this.b) ^ this.c) ^ this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final void h(ByteBuffer byteBuffer) {
        this.e += 8;
        l(byteBuffer.getLong());
    }

    @Override // com.google.android.libraries.navigation.internal.zl.g
    protected final void k(ByteBuffer byteBuffer) {
        this.e += (long) byteBuffer.remaining();
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            this.f ^= (((long) byteBuffer.get()) & 255) << i;
            i += 8;
        }
    }
}
