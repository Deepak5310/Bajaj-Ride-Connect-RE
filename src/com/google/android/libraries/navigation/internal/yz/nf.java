package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class nf extends ne implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object a;
    private final Object b;
    private final Object c;

    public nf(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nc
    public final Object a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nc
    public final Object b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nc
    public final Object c() {
        return this.c;
    }
}
