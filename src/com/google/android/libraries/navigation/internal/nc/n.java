package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends p {
    private final ap a;
    private final ap b;
    private final ap d;

    public n(ap apVar, ap apVar2, ap apVar3) {
        super(new Object[]{apVar, apVar2, apVar3});
        this.a = apVar;
        this.b = apVar2;
        this.d = apVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return this.a.a(context) + this.b.a(context) + this.d.a(context);
    }
}
