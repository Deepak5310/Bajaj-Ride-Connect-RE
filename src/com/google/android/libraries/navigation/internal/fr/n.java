package com.google.android.libraries.navigation.internal.fr;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    private static final /* synthetic */ int[] e = {a, b, c, d};

    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "UNKNOWN";
        }
        if (i == 2) {
            return "LOW";
        }
        if (i != 3) {
            return i != 4 ? BuildConfig.TRAVIS : "HIGH";
        }
        return "MID";
    }

    public static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ar.q(activityManager);
        activityManager.getMemoryInfo(memoryInfo);
        Resources resources = context.getResources();
        ar.q(resources);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ar.q(displayMetrics);
        int iMax = (int) Math.max(displayMetrics.xdpi, displayMetrics.ydpi);
        int i = Build.VERSION.SDK_INT;
        long j = memoryInfo.totalMem;
        if ((j >= 8589934592L && i >= 31 && iMax >= 371) || (j >= 6442450944L && i >= 33 && iMax >= 371)) {
            return d;
        }
        if ((j < 6442450944L || (i >= 33 && iMax >= 371)) && (j <= 2147483648L || i < 31)) {
            return (j <= 2147483648L || i < 31) ? b : a;
        }
        return c;
    }

    public static int[] values$ar$edu$a4c0f0f2_0() {
        return new int[]{a, b, c, d};
    }
}
