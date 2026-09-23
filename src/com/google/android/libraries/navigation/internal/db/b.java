package com.google.android.libraries.navigation.internal.db;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final float a;
    public final p b;
    public final float c;
    public final com.google.android.libraries.navigation.internal.agh.as d;
    public final float f;
    public boolean g;
    public int h = com.google.android.libraries.navigation.internal.aax.h.a;
    public float e = 0.0f;

    public b(float f, p pVar, float f2, com.google.android.libraries.navigation.internal.agh.as asVar, float f3) {
        this.a = f;
        this.b = pVar;
        this.c = f2;
        this.f = f3;
        if (asVar.isEmpty()) {
            this.d = com.google.android.libraries.navigation.internal.agh.au.a;
        } else {
            this.d = asVar;
        }
        this.g = false;
    }
}
