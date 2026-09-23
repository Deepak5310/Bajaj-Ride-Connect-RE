package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ax extends ah {
    protected final aw[] a;

    public ax(aw[] awVarArr) {
        super(awVarArr);
        this.a = awVarArr;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        aw[] awVarArr = this.a;
        int length = awVarArr.length;
        for (int i = 0; i < 3; i++) {
            awVarArr[i].a(context, gradientDrawable);
        }
        return gradientDrawable;
    }
}
