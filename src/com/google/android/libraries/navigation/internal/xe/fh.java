package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fh {
    private final Navigator.TrafficUpdatedListener a;

    public fh(Navigator.TrafficUpdatedListener trafficUpdatedListener) {
        this.a = trafficUpdatedListener;
    }

    public final void a() {
        try {
            this.a.onTrafficUpdated();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
