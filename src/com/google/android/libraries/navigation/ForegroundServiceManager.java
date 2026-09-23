package com.google.android.libraries.navigation;

import android.app.Service;
import android.content.Intent;
import com.google.maps.api.android.lib6.common.apiexception.ApiExpectedException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ForegroundServiceManager {
    public final com.google.android.libraries.navigation.internal.vz.c a;

    /* JADX INFO: compiled from: PG */
    public static class ForegroundExpectedException extends Exception implements ApiExpectedException {
        public ForegroundExpectedException(Exception exc) {
            super("ERROR: Unable to start foreground service. ".concat(String.valueOf(exc.getMessage())), exc);
        }
    }

    public ForegroundServiceManager(com.google.android.libraries.navigation.environment.am amVar, Integer num, String str, Intent intent, NotificationContentProvider notificationContentProvider) {
        com.google.android.libraries.navigation.internal.vz.c cVarAS = amVar.aS();
        this.a = cVarAS;
        if (num != null) {
            cVarAS.a = num.intValue();
        }
        cVarAS.a(str);
        if (notificationContentProvider != null) {
            g gVar = new g(notificationContentProvider);
            cVarAS.d = false;
            cVarAS.c = gVar;
        }
        cVarAS.b(intent);
    }

    public void startForeground(Service service) throws Throwable {
        try {
            try {
                this.a.c(service);
            } catch (RuntimeException e) {
                try {
                    throw new ForegroundExpectedException(e);
                } catch (RuntimeException e2) {
                    e = e2;
                    com.google.android.libraries.navigation.environment.b.c(e);
                    throw e;
                }
            }
        } catch (Error e3) {
            e = e3;
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void stopForeground(Service service) {
        try {
            com.google.android.libraries.navigation.internal.vz.c.e(service);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void updateNotification() {
        try {
            this.a.d();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
