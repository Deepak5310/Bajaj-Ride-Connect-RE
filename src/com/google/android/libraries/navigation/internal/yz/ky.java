package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ky extends kv implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object a;
    private final int b;

    public ky(Object obj, int i) {
        this.a = obj;
        this.b = i;
        bs.d(i, "count");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kt
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kt
    public final Object b() {
        return this.a;
    }
}
