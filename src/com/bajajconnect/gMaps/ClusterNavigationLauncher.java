package com.bajajconnect.gMaps;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bajajconnect.R;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.variables.GlobalVar;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class ClusterNavigationLauncher {
    private static final String CHANNEL_ID = "cluster_nav_launch";
    private static final int NOTIFICATION_ID = 793173;
    private static final int PI_SEND_REQUEST_CODE = 793174;
    private static final String TAG = "ClusterNavLaunch";
    private static final String WAKE_TAG = "BajajRideConnect:ClusterNavWake";

    private ClusterNavigationLauncher() {
    }

    public static void launchFromCluster(Context context) {
        launchFromCluster(context, null);
    }

    public static void launchFromCluster(Context context, String str) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        boolean zIsKeyguardLocked = isKeyguardLocked(applicationContext);
        boolean zIsAppProcessForeground = isAppProcessForeground(applicationContext);
        boolean z = !zIsAppProcessForeground;
        boolean zIsScreenOff = isScreenOff(applicationContext);
        wakeScreen(applicationContext, zIsKeyguardLocked || zIsScreenOff);
        Intent intentCreateNavIntent = createNavIntent(applicationContext);
        if (str != null && !str.isEmpty()) {
            intentCreateNavIntent.setAction(str);
        }
        Log.i(TAG, "launch locked=" + zIsKeyguardLocked + " screenOff=" + zIsScreenOff + " background=" + z + " googleNav=" + GlobalVar.isGoogleNavigation + " canFsi=" + canUseFullScreenIntent(applicationContext) + " notifPerm=" + hasPostNotificationsPermission(applicationContext) + " action=" + str);
        try {
            applicationContext.startActivity(intentCreateNavIntent);
            Log.i(TAG, "startActivity issued");
        } catch (Exception e) {
            Log.e(TAG, "startActivity failed", e);
        }
        if (zIsKeyguardLocked || zIsScreenOff || !zIsAppProcessForeground) {
            sendLaunchPendingIntent(applicationContext, intentCreateNavIntent);
        }
        if (zIsKeyguardLocked || zIsScreenOff || !zIsAppProcessForeground) {
            postFullScreenLaunchNotification(applicationContext, intentCreateNavIntent, zIsKeyguardLocked || zIsScreenOff);
        }
    }

    private static Intent createNavIntent(Context context) {
        if (GlobalVar.isGoogleNavigation) {
            GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
            return NavigationActivity.createLaunchIntent(context);
        }
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.addFlags(872546304);
        return intent;
    }

    private static boolean isKeyguardLocked(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.isKeyguardLocked();
    }

    private static boolean isScreenOff(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return (powerManager == null || powerManager.isInteractive()) ? false : true;
    }

    private static boolean isAppProcessForeground(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance <= 100;
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "isAppProcessForeground failed", e);
        }
        return false;
    }

    private static boolean canUseFullScreenIntent(Context context) {
        if (Build.VERSION.SDK_INT < 34) {
            return true;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            return notificationManager != null && notificationManager.canUseFullScreenIntent();
        } catch (Exception e) {
            Log.w(TAG, "canUseFullScreenIntent failed", e);
            return false;
        }
    }

    private static boolean hasPostNotificationsPermission(Context context) {
        return Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0;
    }

    private static Bundle creatorBalOptionsBundle() {
        if (Build.VERSION.SDK_INT < 34) {
            return null;
        }
        try {
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            activityOptionsMakeBasic.setPendingIntentCreatorBackgroundActivityStartMode(1);
            return activityOptionsMakeBasic.toBundle();
        } catch (Exception e) {
            Log.w(TAG, "creatorBalOptionsBundle failed", e);
            return null;
        }
    }

    private static Bundle senderBalOptionsBundle() {
        if (Build.VERSION.SDK_INT < 34) {
            return null;
        }
        try {
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            activityOptionsMakeBasic.setPendingIntentBackgroundActivityStartMode(1);
            return activityOptionsMakeBasic.toBundle();
        } catch (Exception e) {
            Log.w(TAG, "senderBalOptionsBundle failed", e);
            return null;
        }
    }

    private static PendingIntent createLaunchPendingIntent(Context context, Intent intent, int i) {
        Intent intent2 = new Intent(intent);
        Bundle bundleCreatorBalOptionsBundle = creatorBalOptionsBundle();
        if (bundleCreatorBalOptionsBundle != null) {
            return PendingIntent.getActivity(context, i, intent2, 201326592, bundleCreatorBalOptionsBundle);
        }
        return PendingIntent.getActivity(context, i, intent2, 201326592);
    }

    private static void sendLaunchPendingIntent(Context context, Intent intent) {
        try {
            PendingIntent pendingIntentCreateLaunchPendingIntent = createLaunchPendingIntent(context, intent, PI_SEND_REQUEST_CODE);
            Bundle bundleSenderBalOptionsBundle = senderBalOptionsBundle();
            if (bundleSenderBalOptionsBundle != null) {
                pendingIntentCreateLaunchPendingIntent.send(context, 0, null, null, null, null, bundleSenderBalOptionsBundle);
            } else {
                pendingIntentCreateLaunchPendingIntent.send();
            }
            Log.i(TAG, "PendingIntent.send issued (BAL opt-in)");
        } catch (Exception e) {
            Log.e(TAG, "PendingIntent.send failed", e);
        }
    }

    private static void wakeScreen(Context context, boolean z) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager == null) {
                return;
            }
            if (z || !powerManager.isInteractive()) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435466, WAKE_TAG);
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(8000L);
                Log.i(TAG, "acquired SCREEN wake lock (8s) force=" + z);
            }
        } catch (Exception e) {
            Log.w(TAG, "wakeScreen failed", e);
        }
    }

    private static void ensureChannel(Context context) {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class)) != null) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(CHANNEL_ID);
            if (notificationChannel != null) {
                if (notificationChannel.getImportance() >= 4) {
                    return;
                } else {
                    notificationManager.deleteNotificationChannel(CHANNEL_ID);
                }
            }
            NotificationChannel notificationChannelM = Peripheral$$ExternalSyntheticApiModelOutline0.m(CHANNEL_ID, "Cluster navigation", 4);
            notificationChannelM.setDescription("Starts navigation when the cluster requests a trip");
            notificationChannelM.setLockscreenVisibility(1);
            notificationChannelM.enableVibration(false);
            notificationChannelM.setSound(null, null);
            notificationChannelM.setBypassDnd(true);
            notificationManager.createNotificationChannel(notificationChannelM);
        }
    }

    private static void postFullScreenLaunchNotification(Context context, Intent intent, boolean z) {
        try {
            if (!hasPostNotificationsPermission(context)) {
                Log.w(TAG, "POST_NOTIFICATIONS not granted — cannot post FSI backup");
                return;
            }
            ensureChannel(context);
            PendingIntent pendingIntentCreateLaunchPendingIntent = createLaunchPendingIntent(context, intent, NOTIFICATION_ID);
            boolean zCanUseFullScreenIntent = canUseFullScreenIntent(context);
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Starting navigation").setContentText("Cluster requested turn-by-turn guidance").setPriority(2).setCategory("navigation").setVisibility(1).setAutoCancel(true).setTimeoutAfter(z ? 60000L : 20000L).setContentIntent(pendingIntentCreateLaunchPendingIntent);
            if (zCanUseFullScreenIntent) {
                contentIntent.setFullScreenIntent(pendingIntentCreateLaunchPendingIntent, true);
            } else {
                Log.w(TAG, "USE_FULL_SCREEN_INTENT not granted — heads-up only; enable in Settings → Special app access → Full screen intents");
            }
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, contentIntent.build());
            Log.i(TAG, "posted navigation launch notification fsi=" + zCanUseFullScreenIntent + " lockOrOff=" + z);
        } catch (Exception e) {
            Log.e(TAG, "postFullScreenLaunchNotification failed", e);
        }
    }

    public static void clearLaunchNotification(Context context) {
        if (context == null) {
            return;
        }
        try {
            NotificationManagerCompat.from(context.getApplicationContext()).cancel(NOTIFICATION_ID);
        } catch (Exception unused) {
        }
    }
}
