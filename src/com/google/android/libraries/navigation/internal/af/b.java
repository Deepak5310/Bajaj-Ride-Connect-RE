package com.google.android.libraries.navigation.internal.af;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.nc.ah;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b extends ah implements c<ah> {
    private final ah a;
    private final ah b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ah dayValue, ah nightValue) {
        super(new Object[]{dayValue, nightValue}, null);
        Intrinsics.checkNotNullParameter(dayValue, "dayValue");
        Intrinsics.checkNotNullParameter(nightValue, "nightValue");
        this.a = dayValue;
        this.b = nightValue;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawableA = ((ah) e.f(this, context)).a(context);
        Intrinsics.checkNotNullExpressionValue(drawableA, "createDrawable(...)");
        return drawableA;
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
