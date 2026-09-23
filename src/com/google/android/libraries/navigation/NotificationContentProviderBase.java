package com.google.android.libraries.navigation;

import android.app.Application;
import android.app.Notification;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class NotificationContentProviderBase implements NotificationContentProvider {
    private final Application a;

    public NotificationContentProviderBase(Application application) {
        try {
            this.a = application;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.NotificationContentProvider
    public abstract Notification getNotification();

    public void updateNotification() {
        try {
            NavigationApi.getForegroundServiceManager(this.a).updateNotification();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
