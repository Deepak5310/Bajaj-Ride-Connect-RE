package com.google.android.libraries.navigation;

import android.app.Notification;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class g implements com.google.android.libraries.navigation.internal.vz.h {
    final NotificationContentProvider a;

    public g(NotificationContentProvider notificationContentProvider) {
        this.a = notificationContentProvider;
    }

    @Override // com.google.android.libraries.navigation.internal.vz.h
    public final Notification a() {
        try {
            return this.a.getNotification();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
