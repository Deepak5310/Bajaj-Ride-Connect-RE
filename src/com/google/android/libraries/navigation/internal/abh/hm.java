package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.StrokeStyle;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hm {
    public final StrokeStyle.Builder a;
    public final gw b;

    public hm(StrokeStyle strokeStyle, z zVar) {
        this.a = new StrokeStyle.Builder(strokeStyle);
        this.b = strokeStyle.getStamp() != null ? new gw(strokeStyle.getStamp(), zVar) : null;
    }

    public final float a() {
        return this.a.build().a;
    }

    public final int b() {
        return ((Integer) this.a.a().first).intValue();
    }

    public final void c(boolean z) {
        this.a.d = z;
    }

    public final void d(float f) {
        this.a.a = f;
    }

    public final boolean e() {
        return this.a.d;
    }
}
