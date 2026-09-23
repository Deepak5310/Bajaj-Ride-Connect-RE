package com.google.android.libraries.navigation.internal.je;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.pm.PackageInfoCompat;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static long a(Context context) {
        try {
            return PackageInfoCompat.getLongVersionCode(context.getPackageManager().getPackageInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException unused) {
            ((h) j.b.F(742)).s("Error trying to get versionCode from PackageManager for package: '%s'", context.getPackageName());
            return 0L;
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            ((h) j.b.F((char) 743)).p("Error trying to get versionName from PackageManager.");
            return "";
        }
    }
}
