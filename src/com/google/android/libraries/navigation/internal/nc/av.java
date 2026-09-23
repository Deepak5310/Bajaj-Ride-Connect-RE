package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class av extends aw {
    final /* synthetic */ ap a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(Object[] objArr, ap apVar) {
        super(objArr);
        this.a = apVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.aw
    public final void a(Context context, GradientDrawable gradientDrawable) {
        gradientDrawable.setCornerRadius(this.a.a(context));
    }
}
