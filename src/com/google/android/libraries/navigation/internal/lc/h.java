package com.google.android.libraries.navigation.internal.lc;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.rideapp.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends i {
    private static final Object e = new Object();
    public static final h a = new h();
    public static final int b = i.c;

    public final void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        be.k(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        cVar.a = dialog;
        cVar.b = onCancelListener;
        cVar.show(fragmentManager, GooglePlayServicesUtil.GMS_ERROR_DIALOG);
    }

    public final void b(Context context, int i) {
        d(context, i, c(context, i, "n"));
    }

    @Override // com.google.android.libraries.navigation.internal.lc.i
    public final PendingIntent c(Context context, int i, String str) {
        return super.c(context, i, str);
    }

    public final void d(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        new IllegalArgumentException();
        if (i == 18) {
            new g(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String strF = i == 6 ? com.google.android.libraries.navigation.internal.lh.q.f(context, "common_google_play_services_resolution_required_title") : com.google.android.libraries.navigation.internal.lh.q.d(context, i);
        if (strF == null) {
            strF = context.getResources().getString(R.id.Speedup);
        }
        String strE = (i == 6 || i == 19) ? com.google.android.libraries.navigation.internal.lh.q.e(context, "common_google_play_services_resolution_required_text", com.google.android.libraries.navigation.internal.lh.q.a(context)) : com.google.android.libraries.navigation.internal.lh.q.c(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        be.j(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strF).setStyle(new NotificationCompat.BigTextStyle().bigText(strE));
        boolean zA = com.google.android.libraries.navigation.internal.ll.e.a(context);
        int i3 = android.R.drawable.stat_sys_warning;
        if (zA) {
            be.f(com.google.android.libraries.navigation.internal.ll.i.b());
            int i4 = context.getApplicationInfo().icon;
            if (i4 != 0) {
                i3 = i4;
            }
            style.setSmallIcon(i3).setPriority(2);
            if (com.google.android.libraries.navigation.internal.ll.e.c(context)) {
                style.addAction(R.animator.design_appbar_state_list_animator, resources.getString(R.id.accessibility_actions), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(R.id.Speedup)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strE);
        }
        if (com.google.android.libraries.navigation.internal.ll.i.d()) {
            be.f(com.google.android.libraries.navigation.internal.ll.i.d());
            synchronized (e) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(R.id.SYM);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(ComponentDialog$$ExternalSyntheticApiModelOutline0.m("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification notificationBuild = style.build();
        if (i == 1 || i == 2 || i == 3) {
            ak.c.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }
}
