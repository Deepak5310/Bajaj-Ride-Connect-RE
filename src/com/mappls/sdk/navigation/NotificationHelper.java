package com.mappls.sdk.navigation;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.notifications.NavigationNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationHelper {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private Context f708app;
    private NavigationNotification navigationNotification;
    boolean showGPXNotification = false;
    private List<com.mappls.sdk.navigation.notifications.a> all = new ArrayList();

    public NotificationHelper(Context context) {
        this.f708app = context;
        init();
    }

    private com.mappls.sdk.navigation.notifications.a acquireTopNotification() {
        if (this.navigationNotification.isEnabled()) {
            return this.navigationNotification;
        }
        return null;
    }

    private void init() {
        NavigationNotification navigationNotification = new NavigationNotification(this.f708app);
        this.navigationNotification = navigationNotification;
        this.all.add(navigationNotification);
    }

    private void setTopNotification(com.mappls.sdk.navigation.notifications.a aVar) {
        Iterator<com.mappls.sdk.navigation.notifications.a> it2 = this.all.iterator();
        while (it2.hasNext()) {
            com.mappls.sdk.navigation.notifications.a next = it2.next();
            next.setTop(next == aVar);
        }
    }

    public Notification buildTopNotification() {
        com.mappls.sdk.navigation.notifications.a aVarAcquireTopNotification = acquireTopNotification();
        if (aVarAcquireTopNotification == null) {
            return null;
        }
        removeNotification(aVarAcquireTopNotification.getType());
        setTopNotification(aVarAcquireTopNotification);
        NotificationCompat.Builder builderBuildNotification = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().buildNotification(false) : null;
        if (builderBuildNotification == null) {
            builderBuildNotification = aVarAcquireTopNotification.buildNotification(false);
        }
        return builderBuildNotification.build();
    }

    public void onNotificationDismissed(com.mappls.sdk.navigation.notifications.a.EnumC0097a enumC0097a) {
        for (com.mappls.sdk.navigation.notifications.a aVar : this.all) {
            if (aVar.getType() == enumC0097a) {
                aVar.onNotificationDismissed();
                return;
            }
        }
    }

    public void refreshNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a enumC0097a) {
        for (com.mappls.sdk.navigation.notifications.a aVar : this.all) {
            if (aVar.getType() == enumC0097a) {
                aVar.refreshNotification();
                return;
            }
        }
    }

    public void refreshNotifications() {
        this.navigationNotification.refreshNotification();
    }

    public void removeNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a enumC0097a) {
        NavigationLogger.d("removeNotification(NotificationType notificationType)", new Object[0]);
        for (com.mappls.sdk.navigation.notifications.a aVar : this.all) {
            if (aVar.getType() == enumC0097a) {
                aVar.removeNotification();
                return;
            }
        }
    }

    public void removeNotifications() {
        NavigationLogger.d("removeNotifications", new Object[0]);
        Iterator<com.mappls.sdk.navigation.notifications.a> it2 = this.all.iterator();
        while (it2.hasNext()) {
            it2.next().removeNotification();
        }
    }

    public void setNotificationChannelId(String str) {
        this.navigationNotification.setNotificationChannelId(str);
    }

    public void showNotifications() {
        this.navigationNotification.showNotification();
    }

    public void updateTopNotification() {
        setTopNotification(acquireTopNotification());
    }
}
