package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class DisplayOptions {
    private boolean a;
    private boolean b;
    private boolean c;

    public boolean getHideDestinationMarkers() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getShowStopSigns() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean getShowTrafficLights() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public DisplayOptions hideDestinationMarkers(boolean z) {
        try {
            this.a = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public DisplayOptions showStopSigns(boolean z) {
        try {
            this.c = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public DisplayOptions showTrafficLights(boolean z) {
        try {
            this.b = z;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
