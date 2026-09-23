package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends j implements ap, ar {
    public af(int i) {
        super(i);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return context.getResources().getDimension(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int d(Context context) {
        return context.getResources().getDimensionPixelOffset(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int e(Context context) {
        return context.getResources().getDimensionPixelSize(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ar
    public final float l(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(this.g, typedValue, true);
        return typedValue.getFloat();
    }
}
