package com.mappls.sdk.nearby.plugin.util;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION") || fragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
            fragment.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 0);
        } else {
            fragment.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 0);
        }
    }

    public static boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}
