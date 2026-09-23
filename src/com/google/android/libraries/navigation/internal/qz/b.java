package com.google.android.libraries.navigation.internal.qz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b extends ah {
    final /* synthetic */ Bitmap a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object[] objArr, Bitmap bitmap) {
        super(objArr);
        this.a = bitmap;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        return new BitmapDrawable(context.getResources(), this.a);
    }
}
