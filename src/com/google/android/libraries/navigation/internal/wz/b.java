package com.google.android.libraries.navigation.internal.wz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final Runtime a = Runtime.getRuntime();
    public final long o;
    public final long p;
    public final long q;

    public b(long j, long j2, long j3) {
        this.o = j;
        this.p = j2;
        this.q = j3;
    }

    public static b c() {
        Runtime runtime = a;
        long j = runtime.totalMemory();
        return new b(j - runtime.freeMemory(), j, runtime.maxMemory());
    }

    public String toString() {
        return "dalvikHeapAllocatedB: " + this.o + ", dalvikHeapSizeB: " + this.p + ", dalvikMaxHeapSizeB: " + this.q;
    }
}
