package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class SimulationOptions {
    private float a = 1.0f;

    public final com.google.android.libraries.navigation.internal.vp.h a() {
        com.google.android.libraries.navigation.internal.vp.h hVar = new com.google.android.libraries.navigation.internal.vp.h();
        float f = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.b(f > 0.0f, "Speed multiplier must be positive.");
        hVar.a = f;
        return hVar;
    }

    public float getSpeedMultiplier() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public SimulationOptions speedMultiplier(float f) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.a(f > 0.0f, "Speed multiplier must be positive.");
            this.a = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
