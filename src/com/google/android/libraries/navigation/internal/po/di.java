package com.google.android.libraries.navigation.internal.po;

import android.graphics.Color;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class di {
    public final com.google.android.libraries.navigation.internal.qd.w a;
    public final com.google.android.libraries.navigation.internal.qv.k b;
    private final dj c;

    public di(com.google.android.libraries.navigation.internal.qd.w wVar, com.google.android.libraries.navigation.internal.qv.k kVar, dj djVar) {
        this.a = wVar;
        this.b = kVar;
        this.c = djVar;
    }

    public final void a(float f) {
        com.google.android.libraries.navigation.internal.yx.ar.b(f >= 0.0f && f <= 1.0f, "opacity not in range [0.0f, 1.0f]");
        dj djVar = this.c;
        com.google.android.libraries.navigation.internal.yx.ar.b(f >= 0.0f && f <= 1.0f, "opacity not in range [0.0f, 1.0f]");
        synchronized (djVar.b) {
            djVar.a = Math.round(f * 255.0f);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarD = djVar.b.d();
            int i = djVar.a;
            int iArgb = Color.argb(i, i, i, i);
            synchronized (aiVarD) {
                aiVarD.F = iArgb;
            }
            aiVarD.R = null;
        }
        this.a.G();
    }

    public final void b(boolean z) {
        this.a.x(z);
    }
}
