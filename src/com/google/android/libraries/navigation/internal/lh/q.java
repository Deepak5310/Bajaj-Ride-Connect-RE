package com.google.android.libraries.navigation.internal.lh;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.ConfigurationCompat;
import com.bajajconnect.rideapp.R;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    private static final SimpleArrayMap a = new SimpleArrayMap();
    private static Locale b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            com.google.android.libraries.navigation.internal.ln.c cVarB = com.google.android.libraries.navigation.internal.ln.d.b(context);
            return cVarB.a.getPackageManager().getApplicationLabel(cVarB.a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.id.SHOW_ALL);
        }
        if (i != 2) {
            return i != 3 ? resources.getString(android.R.string.ok) : resources.getString(R.id.MinSpeedup);
        }
        return resources.getString(R.id.a11y_action_drag_waypoint_down);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i == 1) {
            return resources.getString(R.id.SHOW_PATH, strA);
        }
        if (i == 2) {
            return com.google.android.libraries.navigation.internal.ll.e.c(context) ? resources.getString(R.id.accessibility_action_clickable_span) : resources.getString(R.id.a11y_action_drag_waypoint_up, strA);
        }
        if (i == 3) {
            return resources.getString(R.id.NO_DEBUG, strA);
        }
        if (i == 5) {
            return e(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i == 7) {
            return e(context, "common_google_play_services_network_error_text", strA);
        }
        if (i == 9) {
            return resources.getString(R.id.TOP_START, strA);
        }
        if (i == 20) {
            return e(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i) {
            case 16:
                return e(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return e(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(R.id.accelerate, strA);
            default:
                return resources.getString(R.id.MinSpeedup, strA);
        }
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.id.SHOW_PROGRESS);
        }
        if (i == 2) {
            return resources.getString(R.id.above_compass_container);
        }
        if (i == 3) {
            return resources.getString(R.id.SHIFT);
        }
        if (i == 5) {
            return f(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return f(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return f(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return f(context, "common_google_play_services_restricted_profile_title");
    }

    public static String e(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strF = f(context, str);
        if (strF == null) {
            strF = resources.getString(R.id.MinSpeedup);
        }
        return String.format(resources.getConfiguration().locale, strF, str2);
    }

    public static String f(Context context, String str) {
        Resources resourcesForApplication;
        SimpleArrayMap simpleArrayMap = a;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(b)) {
                simpleArrayMap.clear();
                b = locale;
            }
            String str2 = (String) simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            int i = com.google.android.libraries.navigation.internal.lc.aj.a;
            try {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            } catch (PackageManager.NameNotFoundException unused) {
                resourcesForApplication = null;
            }
            if (resourcesForApplication == null) {
                return null;
            }
            int identifier = resourcesForApplication.getIdentifier(str, TypedValues.Custom.S_STRING, "com.google.android.gms");
            if (identifier == 0) {
                return null;
            }
            String string = resourcesForApplication.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            a.put(str, string);
            return string;
        }
    }
}
