package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class i extends ah {
    final /* synthetic */ j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Object[] objArr, j jVar) {
        super(objArr);
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        return AppCompatResources.getDrawable(context, this.a.g);
    }
}
