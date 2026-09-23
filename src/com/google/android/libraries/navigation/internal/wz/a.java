package com.google.android.libraries.navigation.internal.wz;

import android.os.Debug;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f646n = 0;
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;

    public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        super(j5, j6, j7);
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j9;
        this.a = j8;
        this.g = j10;
        this.h = j11;
        this.l = j12;
        this.i = j13;
        this.j = j14;
        this.k = j15;
        this.m = j16;
    }

    public static long a(Debug.MemoryInfo memoryInfo, String str) {
        String memoryStat = memoryInfo.getMemoryStat(str);
        if (memoryStat != null) {
            return Long.parseLong(memoryStat);
        }
        return 0L;
    }

    public static long b(long j) {
        return j * 1024;
    }

    @Override // com.google.android.libraries.navigation.internal.wz.b
    public final String toString() {
        return super.toString() + ", nativeHeapAllocatedB: " + this.a + ", otherPrivateDirtyB: " + this.b + ", otherPssB: " + this.c + ", dalvikPrivateDirtyB: " + this.d + ", dalvikPssB: " + this.e + ", totalPssB: " + this.f + ", javaPrivateDirtyB: " + this.g + ", nativePrivateDirtyB: " + this.h + ", otherPrivateCodeB: " + this.i + ", otherPrivateGraphicsB: " + this.j + ", otherPrivateStackB: " + this.k + ", otherPrivateB: " + this.l + ", systemB: " + this.m;
    }
}
