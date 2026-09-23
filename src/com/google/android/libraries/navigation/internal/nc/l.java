package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends p {
    final /* synthetic */ ap a;
    final /* synthetic */ Float b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Object[] objArr, ap apVar, Float f) {
        super(objArr);
        this.a = apVar;
        this.b = f;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        ap apVar = this.a;
        if (apVar != null) {
            return apVar.a(context) * this.b.floatValue();
        }
        return 0.0f;
    }
}
