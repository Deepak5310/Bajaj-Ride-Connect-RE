package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends p {
    final /* synthetic */ ap a;
    final /* synthetic */ ap b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Object[] objArr, ap apVar, ap apVar2) {
        super(objArr);
        this.a = apVar;
        this.b = apVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return this.a.a(context) - this.b.a(context);
    }
}
