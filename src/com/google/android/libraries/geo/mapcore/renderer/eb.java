package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class eb {
    protected volatile eg s;
    protected volatile float[] t = new float[4];

    public eb(int i, int i2) {
        this.s = new g(0, 0);
        this.s = new g(i, i2);
        q(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public boolean l() {
        throw null;
    }

    public final int o() {
        return ((g) this.s).b;
    }

    public final int p() {
        return ((g) this.s).a;
    }

    public final void q(float f, float f2, float f3, float f4) {
        this.t = new float[]{f, f2, f3, f4};
    }
}
