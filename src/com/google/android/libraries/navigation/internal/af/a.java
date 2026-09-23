package com.google.android.libraries.navigation.internal.af;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.nc.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a extends x implements c<x> {
    private final x a;
    private final x b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(x dayValue, x nightValue) {
        super(new Object[]{dayValue, nightValue}, null);
        Intrinsics.checkNotNullParameter(dayValue, "dayValue");
        Intrinsics.checkNotNullParameter(nightValue, "nightValue");
        this.a = dayValue;
        this.b = nightValue;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x, com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawableA = ((x) e.f(this, context)).a(context);
        Intrinsics.checkNotNullExpressionValue(drawableA, "createDrawable(...)");
        return drawableA;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((x) e.f(this, context)).b(context);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final ColorStateList c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateListC = ((x) e.f(this, context)).c(context);
        Intrinsics.checkNotNullExpressionValue(colorStateListC, "getColorStateList(...)");
        return colorStateListC;
    }

    @Override // com.google.android.libraries.navigation.internal.af.c
    public final /* synthetic */ Object d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.af.c
    public final /* synthetic */ Object e() {
        return this.b;
    }
}
