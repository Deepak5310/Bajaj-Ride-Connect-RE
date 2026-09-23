package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fc {
    private final Navigator.RemainingTimeOrDistanceChangedListener a;

    public fc(Navigator.RemainingTimeOrDistanceChangedListener remainingTimeOrDistanceChangedListener) {
        this.a = remainingTimeOrDistanceChangedListener;
    }

    public final void a() {
        try {
            this.a.onRemainingTimeOrDistanceChanged();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
