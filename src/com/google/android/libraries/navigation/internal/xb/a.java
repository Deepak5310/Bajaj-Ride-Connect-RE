package com.google.android.libraries.navigation.internal.xb;

import android.os.Debug;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.xa.b {
    public a() {
        super((ThreadFactory) null, 3000);
    }

    @Override // com.google.android.libraries.navigation.internal.xa.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final synchronized com.google.android.libraries.navigation.internal.wz.a a() {
        Debug.MemoryInfo memoryInfo;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long nativeHeapAllocatedSize;
        long totalPss;
        int i = com.google.android.libraries.navigation.internal.wz.a.f646n;
        memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        com.google.android.libraries.navigation.internal.wz.b bVarC = com.google.android.libraries.navigation.internal.wz.b.c();
        j = memoryInfo.otherPrivateDirty;
        j2 = memoryInfo.otherPss;
        j3 = memoryInfo.dalvikPrivateDirty;
        j4 = memoryInfo.dalvikPss;
        j5 = bVarC.o;
        j6 = bVarC.p;
        j7 = bVarC.q;
        nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize();
        totalPss = memoryInfo.getTotalPss();
        return new com.google.android.libraries.navigation.internal.wz.a(com.google.android.libraries.navigation.internal.wz.a.b(j), com.google.android.libraries.navigation.internal.wz.a.b(j2), com.google.android.libraries.navigation.internal.wz.a.b(j3), com.google.android.libraries.navigation.internal.wz.a.b(j4), j5, j6, j7, nativeHeapAllocatedSize, com.google.android.libraries.navigation.internal.wz.a.b(totalPss), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.java-heap"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.native-heap"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.private-other"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.code"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.graphics"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.stack"), com.google.android.libraries.navigation.internal.wz.a.a(memoryInfo, "summary.system"));
    }

    public a(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService, 3000);
    }
}
