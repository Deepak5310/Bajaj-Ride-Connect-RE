package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import com.google.android.libraries.geo.mapcore.renderer.ef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ef {
    public boolean a;
    public float b;
    protected final float c;
    public float d;
    protected final com.google.android.libraries.navigation.internal.qq.d e;
    protected float f;
    public float g;
    protected boolean h;

    protected e(Class cls, float f, com.google.android.libraries.navigation.internal.qq.d dVar) {
        super(cls);
        this.a = false;
        this.b = 1.0f;
        this.d = 1.0f;
        this.f = 0.0f;
        this.g = 1.0f;
        this.h = false;
        this.c = (float) Math.pow(2.0d, 22.0f - f);
        this.e = dVar;
    }

    public final void a(float f, float f2, boolean z) {
        double dFloor = Math.floor(((double) f) / 0.25d) * 0.25d;
        if (!this.a) {
            this.b = this.d * this.c * ((float) Math.pow(2.0d, -(dFloor - ((double) f2))));
        }
        this.f = f;
        this.h = z;
    }
}
