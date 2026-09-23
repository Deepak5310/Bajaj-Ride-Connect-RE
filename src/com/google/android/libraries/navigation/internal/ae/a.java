package com.google.android.libraries.navigation.internal.ae;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.gw.o;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class a extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ x b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Object[] objArr, int i, x xVar) {
        super(objArr);
        this.a = i;
        this.b = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        return o.c().a(context.getResources(), this.a, this.b);
    }
}
