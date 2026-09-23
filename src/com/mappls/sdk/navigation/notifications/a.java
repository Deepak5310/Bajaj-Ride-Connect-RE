package com.mappls.sdk.navigation.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import app.notifee.core.a$$ExternalSyntheticApiModelOutline0;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final int ERROR_NOTIFICATION_SERVICE_ID = 7;
    public static final int GPS_WAKE_UP_NOTIFICATION_SERVICE_ID = 8;
    public static final int GPX_NOTIFICATION_SERVICE_ID = 6;
    public static final int NAVIGATION_NOTIFICATION_SERVICE_ID = 5;
    public static String PRIMARY_CHANNEL = "navigation";
    public static final int TOP_NOTIFICATION_SERVICE_ID = 100;
    public static final int WEAR_ERROR_NOTIFICATION_SERVICE_ID = 1007;
    public static final int WEAR_GPS_WAKE_UP_NOTIFICATION_SERVICE_ID = 1008;
    public static final int WEAR_GPX_NOTIFICATION_SERVICE_ID = 1006;
    public static final int WEAR_NAVIGATION_NOTIFICATION_SERVICE_ID = 1005;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    protected Context f711app;
    protected int color;
    private String groupName;
    protected int icon;
    private NotificationManager notificationManager;
    protected boolean top;
    private final boolean ENABLE_WEARABLE_NOTIFICATIONS = false;
    protected boolean ongoing = true;

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.notifications.a$a, reason: collision with other inner class name */
    public enum EnumC0097a {
        NAVIGATION,
        GPX,
        /* JADX INFO: Fake field, exist only in values array */
        GPS,
        /* JADX INFO: Fake field, exist only in values array */
        ERROR
    }

    public a(Context context, String str) {
        this.f711app = context;
        this.groupName = str;
        init();
        initNotificationManagerOreo();
    }

    private NotificationManager getNotificationManager() {
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) this.f711app.getSystemService("notification");
        }
        return this.notificationManager;
    }

    private void initNotificationManagerOreo() {
        if (Build.VERSION.SDK_INT >= 26) {
            a$$ExternalSyntheticApiModelOutline0.m502m$1();
            NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(PRIMARY_CHANNEL, this.f711app.getString(R.string.mappls_noti_channel_navigation), 3);
            notificationChannelM.setLightColor(-16776961);
            notificationChannelM.setLockscreenVisibility(0);
            notificationChannelM.setSound(null, null);
            getNotificationManager().createNotificationChannel(notificationChannelM);
        }
    }

    private void notifyWearable(NotificationManager notificationManager) {
    }

    public abstract NotificationCompat.Builder buildNotification(boolean z);

    public void closeSystemDialogs(Context context) {
        Intent intent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intent.setPackage(this.f711app.getPackageName());
        context.sendBroadcast(intent);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0035 A[PHI: r0
      0x0035: PHI (r0v11 android.content.Intent) = (r0v4 android.content.Intent), (r0v14 android.content.Intent) binds: [B:8:0x0020, B:11:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    protected NotificationCompat.Builder createBuilder(boolean z) {
        Intent intent;
        if (MapplsNavigationHelper.getInstance().getNavigationActivityClass() != null) {
            try {
                intent = new Intent(this.f711app, (Class<?>) MapplsNavigationHelper.getInstance().getNavigationActivityClass());
            } catch (Exception e) {
                NavigationLogger.d(e);
                intent = null;
            }
            if (intent != null) {
                intent.setPackage(null);
            }
        } else {
            intent = this.f711app.getPackageManager().getLaunchIntentForPackage(this.f711app.getPackageName());
            if (intent != null) {
                intent.setPackage(null);
            }
        }
        int i = Build.VERSION.SDK_INT >= 31 ? 33554432 : 134217728;
        boolean z2 = false;
        PendingIntent activity = PendingIntent.getActivity(this.f711app, 0, intent, i);
        Intent intent2 = new Intent("com.mmi.maps.navigation.EXIT");
        intent2.setPackage(this.f711app.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f711app, 0, intent2, i);
        NotificationCompat.Builder priority = new NotificationCompat.Builder(this.f711app, PRIMARY_CHANNEL).setVisibility(1).setPriority(this.top ? 1 : getPriority());
        if (this.ongoing && !z) {
            z2 = true;
        }
        NotificationCompat.Builder deleteIntent = priority.setOngoing(z2).setContentIntent(activity).setWhen(System.currentTimeMillis()).setDeleteIntent(NotificationDismissReceiver.a(this.f711app, getType()));
        if (!MapplsNavigationHelper.getInstance().isHideExitFromNotification()) {
            deleteIntent.addAction(R.drawable.ic_close_white_24dp, "Exit Navigation", broadcast);
        }
        if (this.top) {
            deleteIntent.setGroup(this.groupName).setGroupSummary(!z);
        }
        int i2 = this.color;
        if (i2 != 0) {
            deleteIntent.setColor(i2);
        }
        int i3 = this.icon;
        if (i3 != 0) {
            deleteIntent.setSmallIcon(i3);
        }
        return deleteIntent;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public abstract int getNavigationNotificationId();

    public abstract int getNavigationWearableNotificationId();

    public abstract int getPriority();

    public abstract EnumC0097a getType();

    public void init() {
    }

    public abstract boolean isActive();

    public abstract boolean isEnabled();

    public boolean isTop() {
        return this.top;
    }

    public void onNotificationDismissed() {
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    public boolean refreshNotification() {
        Integer navigationNotificationId;
        if (isEnabled()) {
            NotificationCompat.Builder builderBuildNotification = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().buildNotification(false) : null;
            if (builderBuildNotification == null) {
                builderBuildNotification = buildNotification(false);
            }
            if (builderBuildNotification != null) {
                Notification notificationBuild = builderBuildNotification.build();
                setupNotification(notificationBuild);
                navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
                if (navigationNotificationId == null) {
                    navigationNotificationId = Integer.valueOf(this.top ? 100 : getNavigationNotificationId());
                }
                getNotificationManager().notify(navigationNotificationId.intValue(), notificationBuild);
                notifyWearable(getNotificationManager());
                return true;
            }
            navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
            if (navigationNotificationId == null) {
                navigationNotificationId = Integer.valueOf(getNavigationNotificationId());
            }
        } else {
            navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
            if (navigationNotificationId == null) {
                navigationNotificationId = Integer.valueOf(getNavigationNotificationId());
            }
        }
        getNotificationManager().cancel(navigationNotificationId.intValue());
        return false;
    }

    public void removeNotification() {
        Integer navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
        if (navigationNotificationId == null) {
            navigationNotificationId = Integer.valueOf(getNavigationNotificationId());
            getNotificationManager().cancel(100);
        }
        getNotificationManager().cancel(navigationNotificationId.intValue());
        getNotificationManager().cancel(getNavigationWearableNotificationId());
    }

    public void setNotificationChannelId(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                if (getNotificationManager().getNotificationChannel(PRIMARY_CHANNEL) != null) {
                    getNotificationManager().deleteNotificationChannel(PRIMARY_CHANNEL);
                }
            } catch (Exception unused) {
            }
            PRIMARY_CHANNEL = str;
            a$$ExternalSyntheticApiModelOutline0.m502m$1();
            NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(str, this.f711app.getString(R.string.mappls_noti_channel_navigation), 3);
            notificationChannelM.setLightColor(-16776961);
            notificationChannelM.setLockscreenVisibility(0);
            notificationChannelM.setSound(null, null);
            getNotificationManager().createNotificationChannel(notificationChannelM);
        }
    }

    public void setTop(boolean z) {
        this.top = z;
    }

    public void setupNotification(Notification notification) {
        notification.flags = 64;
    }

    public boolean showNotification() {
        if (isEnabled()) {
            NotificationCompat.Builder builderBuildNotification = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().buildNotification(false) : null;
            if (builderBuildNotification == null) {
                builderBuildNotification = buildNotification(false);
            }
            if (builderBuildNotification != null) {
                Notification notificationBuild = builderBuildNotification.build();
                setupNotification(notificationBuild);
                Integer navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
                if (navigationNotificationId == null) {
                    navigationNotificationId = Integer.valueOf(this.top ? 100 : getNavigationNotificationId());
                }
                getNotificationManager().notify(navigationNotificationId.intValue(), notificationBuild);
                notifyWearable(getNotificationManager());
                return true;
            }
        }
        return false;
    }
}
