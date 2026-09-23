package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class au extends aw {
    final /* synthetic */ x a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(Object[] objArr, x xVar) {
        super(objArr);
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.aw
    public final void a(Context context, GradientDrawable gradientDrawable) {
        gradientDrawable.setColor(this.a.c(context));
    }
}
