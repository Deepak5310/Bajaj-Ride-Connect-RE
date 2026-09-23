package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class an extends ah {
    final /* synthetic */ ah a;
    final /* synthetic */ ap b;
    final /* synthetic */ ap c;
    final /* synthetic */ ap d;
    final /* synthetic */ ap e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(Object[] objArr, ah ahVar, ap apVar, ap apVar2, ap apVar3, ap apVar4) {
        super(objArr);
        this.a = ahVar;
        this.b = apVar;
        this.c = apVar2;
        this.d = apVar3;
        this.e = apVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        ap apVar = this.e;
        ap apVar2 = this.d;
        ap apVar3 = this.c;
        return new InsetDrawable(this.a.a(context), this.b.d(context), apVar3.d(context), apVar2.d(context), apVar.d(context));
    }
}
