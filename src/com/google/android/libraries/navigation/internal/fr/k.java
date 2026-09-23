package com.google.android.libraries.navigation.internal.fr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final boolean a(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Object systemService = applicationContext.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        try {
            return activityManager.isLowRamDevice();
        } catch (VerifyError unused) {
            k kVar = l.a;
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(512)).q("Expected isLowRamDevice API from version %d", Build.VERSION.SDK_INT);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem <= 1073741824;
        }
    }
}
