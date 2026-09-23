package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fg {
    private final Navigator.NavigationSessionListener a;

    public fg(Navigator.NavigationSessionListener navigationSessionListener) {
        this.a = navigationSessionListener;
    }

    public final void a() {
        try {
            this.a.onNewNavigationSession();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
