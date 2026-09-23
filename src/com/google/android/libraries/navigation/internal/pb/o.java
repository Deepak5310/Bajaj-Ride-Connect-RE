package com.google.android.libraries.navigation.internal.pb;

import com.google.android.libraries.navigation.internal.oe.ay;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final float[] a;
    public n b;
    public n c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    private final com.google.android.libraries.navigation.internal.mj.a j;

    public o() {
        com.google.android.libraries.navigation.internal.mk.b bVar = new com.google.android.libraries.navigation.internal.mk.b();
        this.a = new float[8];
        this.b = new n();
        this.c = new n();
        this.j = bVar;
    }

    static float a(float f, float f2) {
        return f2 == 0.0f ? f : (f * 0.3f) + (f2 * 0.7f);
    }

    public final com.google.android.libraries.geo.mapcore.renderer.v b() {
        return this.c.d;
    }

    public final boolean c(com.google.android.libraries.geo.mapcore.renderer.v vVar, ay ayVar) {
        if (vVar == null) {
            return false;
        }
        if (this.i && vVar == this.b.d) {
            ayVar.q(this.d, this.e);
            return true;
        }
        if (vVar != this.c.d) {
            return false;
        }
        ayVar.q(0.0f, 0.0f);
        return true;
    }
}
