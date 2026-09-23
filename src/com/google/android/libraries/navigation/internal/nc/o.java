package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends p {
    private final ap a;
    private final ap b;

    public o(ap apVar, ap apVar2) {
        super(new Object[]{apVar, apVar2});
        this.a = apVar;
        this.b = apVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return this.a.a(context) + this.b.a(context);
    }
}
