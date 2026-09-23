package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fe {
    private final Navigator.RouteChangedListener a;

    public fe(Navigator.RouteChangedListener routeChangedListener) {
        this.a = routeChangedListener;
    }

    public final void a() {
        try {
            this.a.onRouteChanged();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
