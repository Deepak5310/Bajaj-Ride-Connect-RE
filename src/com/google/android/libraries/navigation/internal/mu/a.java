package com.google.android.libraries.navigation.internal.mu;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends d {
    private final Drawable.ConstantState a;
    private final int b;
    private final int c;

    public a(Drawable.ConstantState constantState, int i, int i2) {
        if (constantState == null) {
            throw new NullPointerException("Null constantState");
        }
        this.a = constantState;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.d
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.d
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.d
    public final Drawable.ConstantState c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.d
    public final void d() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a.equals(dVar.c()) && this.b == dVar.b() && this.c == dVar.a()) {
                dVar.d();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ 1231;
    }

    public final String toString() {
        return "DropShadowBitmapState{constantState=" + this.a.toString() + ", shadowRadiusPx=" + this.b + ", shadowColor=" + this.c + ", isPurelyDecorative=true}";
    }
}
