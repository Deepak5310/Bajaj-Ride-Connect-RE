package com.google.android.libraries.navigation.internal.qz;

import android.content.Context;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.gw.o;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class i extends ah {
    final /* synthetic */ Picture a;
    final /* synthetic */ x b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Object[] objArr, Picture picture, x xVar) {
        super(objArr);
        this.a = picture;
        this.b = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        return o.c().b(context.getResources(), this.a, this.b);
    }
}
