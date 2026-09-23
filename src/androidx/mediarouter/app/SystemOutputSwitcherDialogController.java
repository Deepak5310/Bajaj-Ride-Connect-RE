package androidx.mediarouter.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class SystemOutputSwitcherDialogController {
    private static final String OUTPUT_SWITCHER_INTENT_ACTION_ANDROID_R = "com.android.settings.panel.action.MEDIA_OUTPUT";
    private static final String OUTPUT_SWITCHER_INTENT_ACTION_ANDROID_S = "com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG";
    private static final String OUTPUT_SWITCHER_INTENT_KEY_PACKAGE_NAME_ANDROID_R = "com.android.settings.panel.extra.PACKAGE_NAME";
    private static final String OUTPUT_SWITCHER_INTENT_KEY_PACKAGE_NAME_ANDROID_S = "package_name";
    private static final String PACKAGE_NAME_SYSTEM_UI = "com.android.systemui";

    private SystemOutputSwitcherDialogController() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    public static boolean showDialog(Context context) {
        boolean zShowDialogForAndroidR;
        if (Build.VERSION.SDK_INT >= 31) {
            if (showDialogForAndroidSAndAbove(context) || showDialogForAndroidR(context)) {
                zShowDialogForAndroidR = true;
            } else {
                zShowDialogForAndroidR = false;
            }
        } else if (Build.VERSION.SDK_INT == 30) {
            zShowDialogForAndroidR = showDialogForAndroidR(context);
        } else {
            zShowDialogForAndroidR = false;
        }
        if (zShowDialogForAndroidR) {
            return true;
        }
        return isRunningOnWear(context) && showBluetoothSettingsFragment(context);
    }

    private static boolean showDialogForAndroidSAndAbove(Context context) {
        Intent intentPutExtra = new Intent().setAction(OUTPUT_SWITCHER_INTENT_ACTION_ANDROID_S).setPackage(PACKAGE_NAME_SYSTEM_UI).putExtra(OUTPUT_SWITCHER_INTENT_KEY_PACKAGE_NAME_ANDROID_S, context.getPackageName());
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryBroadcastReceivers(intentPutExtra, 0).iterator();
        while (it2.hasNext()) {
            ActivityInfo activityInfo = it2.next().activityInfo;
            if (activityInfo != null && activityInfo.applicationInfo != null && (activityInfo.applicationInfo.flags & 129) != 0) {
                context.sendBroadcast(intentPutExtra);
                return true;
            }
        }
        return false;
    }

    private static boolean showDialogForAndroidR(Context context) {
        Intent intentPutExtra = new Intent().addFlags(268435456).setAction(OUTPUT_SWITCHER_INTENT_ACTION_ANDROID_R).putExtra(OUTPUT_SWITCHER_INTENT_KEY_PACKAGE_NAME_ANDROID_R, context.getPackageName());
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentActivities(intentPutExtra, 0).iterator();
        while (it2.hasNext()) {
            ActivityInfo activityInfo = it2.next().activityInfo;
            if (activityInfo != null && activityInfo.applicationInfo != null && (activityInfo.applicationInfo.flags & 129) != 0) {
                context.startActivity(intentPutExtra);
                return true;
            }
        }
        return false;
    }

    private static boolean showBluetoothSettingsFragment(Context context) {
        Intent intentPutExtra = new Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(268468224).putExtra("EXTRA_CONNECTION_ONLY", true).putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1);
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentActivities(intentPutExtra, 0).iterator();
        while (it2.hasNext()) {
            ActivityInfo activityInfo = it2.next().activityInfo;
            if (activityInfo != null && activityInfo.applicationInfo != null && (activityInfo.applicationInfo.flags & 129) != 0) {
                context.startActivity(intentPutExtra);
                return true;
            }
        }
        return false;
    }

    private static boolean isRunningOnWear(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
