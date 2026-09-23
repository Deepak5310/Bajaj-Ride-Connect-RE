package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends Drawable.ConstantState {
    public final l a;
    public final Paint b;

    public k(l lVar, Paint paint) {
        this.a = lVar;
        this.b = paint;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new m(this);
    }
}
