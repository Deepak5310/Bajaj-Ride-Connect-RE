package com.google.android.libraries.navigation.internal.qc;

import com.google.android.libraries.geo.mapcore.renderer.et;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i {
    public final float h;
    public final float i;

    protected i(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    public float c() {
        return 0.0f;
    }

    public final float d() {
        return (this.i - c()) - k();
    }

    public abstract et j();

    public float k() {
        return 0.0f;
    }
}
