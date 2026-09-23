package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fd {
    private final Navigator.ReroutingListener a;

    public fd(Navigator.ReroutingListener reroutingListener) {
        this.a = reroutingListener;
    }

    public final void a() {
        try {
            this.a.onReroutingRequestedByOffRoute();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
