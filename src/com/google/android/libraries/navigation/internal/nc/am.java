package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class am extends ah {
    final /* synthetic */ ah[] a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(Object[] objArr, ah[] ahVarArr) {
        super(objArr);
        this.a = ahVarArr;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Drawable[] drawableArr = new Drawable[2];
        for (int i = 0; i < 2; i++) {
            drawableArr[i] = this.a[i].a(context);
        }
        return new LayerDrawable(drawableArr);
    }
}
