package com.supersami.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.devsupport.StackTraceHelper;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes4.dex */
class NotificationHelper {
    private static final String NOTIFICATION_CHANNEL_ID = "com.supersami.foregroundservice.channel";
    private static boolean channelCreated = false;
    private static NotificationHelper instance;
    private NotificationConfig config;
    private Context context;
    private NotificationManager mNotificationManager;
    PendingIntent pendingBtn2Intent;
    PendingIntent pendingBtnIntent;

    public static synchronized NotificationHelper getInstance(Context context) {
        if (instance == null) {
            instance = new NotificationHelper(context);
        }
        return instance;
    }

    private NotificationHelper(Context context) {
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        this.context = context;
        this.config = new NotificationConfig(context);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x011a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0157  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    Notification buildNotification(Context context, Bundle bundle) {
        int i;
        int i2;
        byte b;
        if (bundle == null) {
            Log.e("NotificationHelper", "buildNotification: invalid config");
            return null;
        }
        Class mainActivityClass = getMainActivityClass(context);
        if (mainActivityClass == null) {
            return null;
        }
        Log.d("SuperLog", "" + bundle.getString("mainOnPress"));
        Intent intent = new Intent(context, (Class<?>) mainActivityClass);
        intent.putExtra("mainOnPress", bundle.getString("mainOnPress"));
        PendingIntent activity = PendingIntent.getActivity(context, (int) (System.currentTimeMillis() & ItemIdComposer.BIT_MASK_CHILD_ID), intent, 33554432);
        if (bundle.getBoolean("button", false)) {
            Log.d("SuperLog C ", "inButtonOnPress" + bundle.getString("buttonOnPress"));
            Intent intent2 = new Intent(context, (Class<?>) mainActivityClass);
            intent2.putExtra("buttonOnPress", bundle.getString("buttonOnPress"));
            this.pendingBtnIntent = PendingIntent.getActivity(context, (int) (System.currentTimeMillis() & ItemIdComposer.BIT_MASK_CHILD_ID), intent2, 33554432);
        }
        if (bundle.getBoolean("button2", false)) {
            Log.i("SuperLog C ", "inButton2OnPress" + bundle.getString("button2OnPress"));
            Intent intent3 = new Intent(context, (Class<?>) mainActivityClass);
            intent3.putExtra("button2OnPress", bundle.getString("button2OnPress"));
            this.pendingBtn2Intent = PendingIntent.getActivity(context, (int) (ItemIdComposer.BIT_MASK_CHILD_ID & System.currentTimeMillis()), intent3, 33554432);
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("importance");
        byte b2 = 2;
        int i3 = -1;
        if (string2 != null) {
            String lowerCase = string2.toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case 107348:
                    b = !lowerCase.equals("low") ? (byte) -1 : (byte) 0;
                    break;
                case 107876:
                    b = !lowerCase.equals("max") ? (byte) -1 : (byte) 1;
                    break;
                case 108114:
                    b = !lowerCase.equals("min") ? (byte) -1 : (byte) 2;
                    break;
                case 3202466:
                    b = !lowerCase.equals("high") ? (byte) -1 : (byte) 3;
                    break;
                case 1544803905:
                    b = !lowerCase.equals("default") ? (byte) -1 : (byte) 4;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    i = -1;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = -2;
                    break;
                case 3:
                default:
                    i = 1;
                    break;
                case 4:
                    i = 0;
                    break;
            }
        } else {
            i = 1;
        }
        String string3 = bundle.getString("visibility");
        if (string3 != null) {
            String lowerCase2 = string3.toLowerCase();
            lowerCase2.hashCode();
            switch (lowerCase2.hashCode()) {
                case -977423767:
                    b2 = !lowerCase2.equals("public") ? (byte) -1 : (byte) 0;
                    break;
                case -906277200:
                    b2 = !lowerCase2.equals("secret") ? (byte) -1 : (byte) 1;
                    break;
                case -314497661:
                    if (!lowerCase2.equals("private")) {
                        b2 = -1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    i3 = 1;
                    break;
                case 1:
                    break;
                case 2:
                default:
                    i3 = 0;
                    break;
            }
        } else {
            i3 = 0;
        }
        checkOrCreateChannel(this.mNotificationManager, bundle);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID).setContentTitle(string).setVisibility(i3).setPriority(i).setContentIntent(activity).setOngoing(bundle.getBoolean("ongoing", false)).setContentText(bundle.getString(StackTraceHelper.MESSAGE_KEY));
        if (bundle.getBoolean("button", false)) {
            contentText.addAction(com.facebook.react.R.drawable.redbox_top_border_background, bundle.getString("buttonText", "Button"), this.pendingBtnIntent);
        }
        if (bundle.getBoolean("button2", false)) {
            contentText.addAction(com.facebook.react.R.drawable.redbox_top_border_background, bundle.getString("button2Text", "Button"), this.pendingBtn2Intent);
        }
        contentText.setColor(this.config.getNotificationColor());
        String string4 = bundle.getString("color");
        if (string4 != null) {
            contentText.setColor(Color.parseColor(string4));
        }
        contentText.setStyle(new NotificationCompat.BigTextStyle().bigText(bundle.getString(StackTraceHelper.MESSAGE_KEY)));
        String string5 = bundle.getString("icon");
        if (string5 == null) {
            string5 = "ic_launcher";
        }
        contentText.setSmallIcon(getResourceIdForResourceName(context, string5));
        String string6 = bundle.getString("largeIcon");
        int resourceIdForResourceName = getResourceIdForResourceName(context, string6 != null ? string6 : "ic_launcher");
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), resourceIdForResourceName);
        if (resourceIdForResourceName != 0) {
            contentText.setLargeIcon(bitmapDecodeResource);
        }
        String string7 = bundle.getString("number");
        if (string7 != null && (i2 = Integer.parseInt(string7)) > 0) {
            contentText.setNumber(i2);
        }
        boolean z = bundle.getBoolean("progressBar");
        Boolean.valueOf(z).getClass();
        if (z) {
            contentText.setProgress((int) bundle.getDouble("progressBarMax"), (int) bundle.getDouble("progressBarCurr"), false);
        }
        contentText.setOnlyAlertOnce(true);
        return contentText.build();
    }

    private Class getMainActivityClass(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
            Log.e("NotificationHelper", "Failed to get launch intent or component");
            return null;
        }
        try {
            return Class.forName(launchIntentForPackage.getComponent().getClassName());
        } catch (ClassNotFoundException unused) {
            Log.e("NotificationHelper", "Failed to get main activity class");
            return null;
        }
    }

    private int getResourceIdForResourceName(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        return identifier == 0 ? context.getResources().getIdentifier(str, "mipmap", context.getPackageName()) : identifier;
    }

    /* JADX WARN: switch over string: strings are not added: [[high]] */
    private void checkOrCreateChannel(NotificationManager notificationManager, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26 || channelCreated || notificationManager == null) {
            return;
        }
        String string = bundle.getString("importance");
        int i = 4;
        if (string != null) {
            String lowerCase = string.toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase) {
                case "unspecified":
                    i = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    break;
                case "low":
                    i = 2;
                    break;
                case "max":
                    i = 5;
                    break;
                case "min":
                    i = 1;
                    break;
                case "none":
                    i = 0;
                    break;
                case "default":
                    i = 3;
                    break;
            }
        }
        Peripheral$$ExternalSyntheticApiModelOutline0.m2302m$1();
        NotificationChannel notificationChannelM = Peripheral$$ExternalSyntheticApiModelOutline0.m(NOTIFICATION_CHANNEL_ID, this.config.getChannelName(), i);
        notificationChannelM.setDescription(this.config.getChannelDescription());
        notificationChannelM.enableLights(true);
        notificationChannelM.enableVibration(bundle.getBoolean("vibration"));
        notificationChannelM.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannelM);
        channelCreated = true;
    }
}
