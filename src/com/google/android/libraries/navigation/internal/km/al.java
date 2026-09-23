package com.google.android.libraries.navigation.internal.km;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al {
    public static final s a;

    static {
        w wVar = w.NOTIFICATIONS;
        a = new s("LocaleUpdatedCount", wVar, 4, 2025);
        new y("TransitStationNotificationElsaConfidence", wVar, 4, 2025);
        new com.google.android.libraries.navigation.internal.ky.af((int) TimeUnit.SECONDS.toMillis(30L), 0, (int) TimeUnit.HOURS.toMillis(4L));
        new ac("GenericWebviewNotificationLatency", w.NOTIFICATIONS, 4, 2025);
        new y("Maps15NotificationSendLatency", w.NOTIFICATIONS, 4, 2025);
    }
}
