package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NightModeChangedEvent {
    private final boolean a;

    public NightModeChangedEvent(boolean z) {
        try {
            this.a = z;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean equals(Object obj) {
        try {
            return (obj instanceof NightModeChangedEvent) && this.a == ((NightModeChangedEvent) obj).inNightMode();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int hashCode() {
        try {
            return this.a ? 1231 : 1237;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean inNightMode() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
