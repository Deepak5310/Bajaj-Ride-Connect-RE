package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.util.TypedValue;
import java.math.RoundingMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements ap {
    private final int a;

    public a(int i) {
        this.a = i;
    }

    public static int b(int i, double d) {
        return com.google.android.libraries.navigation.internal.zw.b.d(d) ? c(i, 0, (int) d) : c(i, 1, com.google.android.libraries.navigation.internal.zw.b.b(d * 128.0d, RoundingMode.HALF_EVEN));
    }

    public static int c(int i, int i2, int i3) {
        return i | (i2 << 4) | ((i3 & 16777215) << 8);
    }

    public static a f(double d) {
        return new a(b(1, d));
    }

    public static a g(int i) {
        return new a(c(1, 0, i));
    }

    public static a h(double d) {
        return new a(b(2, d));
    }

    public static a i(int i) {
        return new a(c(2, 0, i));
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return TypedValue.complexToDimension(this.a, context.getResources().getDisplayMetrics());
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int d(Context context) {
        return TypedValue.complexToDimensionPixelOffset(this.a, context.getResources().getDisplayMetrics());
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final int e(Context context) {
        return TypedValue.complexToDimensionPixelSize(this.a, context.getResources().getDisplayMetrics());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).a == this.a;
    }

    public final int hashCode() {
        return this.a;
    }
}
