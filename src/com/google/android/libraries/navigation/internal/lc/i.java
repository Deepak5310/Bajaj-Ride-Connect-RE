package com.google.android.libraries.navigation.internal.lc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.PendingIntentCompat;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i {
    public static final int c;
    public static final i d;

    static {
        int i = ak.d;
        c = 245125000;
        d = new i();
    }

    public PendingIntent c(Context context, int i, String str) {
        Intent intentG = g(context, i, str);
        if (intentG == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, 0, intentG, 134217728, false);
    }

    public final int e(Context context) {
        return f(context, c);
    }

    public final int f(Context context, int i) {
        int iB = ak.b(context, i);
        if (iB == 1) {
            if (com.google.android.libraries.navigation.internal.ll.i.c()) {
                try {
                    Iterator<PackageInstaller.SessionInfo> it2 = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                    while (it2.hasNext()) {
                        if ("com.google.android.gms".equals(it2.next().getAppPackageName())) {
                            return 18;
                        }
                    }
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                }
            }
            if (context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled) {
                return 18;
            }
        }
        return iB;
    }

    public final Intent g(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            int i2 = com.google.android.libraries.navigation.internal.lh.ah.a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && com.google.android.libraries.navigation.internal.ll.e.c(context)) {
            int i3 = com.google.android.libraries.navigation.internal.lh.ah.a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(c);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(com.google.android.libraries.navigation.internal.ln.d.b(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        int i4 = com.google.android.libraries.navigation.internal.lh.ah.a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }
}
