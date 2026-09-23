package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ia extends dg implements Serializable {
    private static final long serialVersionUID = 3;
    final in a;
    final in b;
    final com.google.android.libraries.navigation.internal.yx.y c;
    final int d;
    transient ConcurrentMap e;

    public ia(in inVar, in inVar2, com.google.android.libraries.navigation.internal.yx.y yVar, int i, ConcurrentMap concurrentMap) {
        this.a = inVar;
        this.b = inVar2;
        this.c = yVar;
        this.d = i;
        this.e = concurrentMap;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dg
    protected final ConcurrentMap a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dg, com.google.android.libraries.navigation.internal.yz.dl
    protected final /* synthetic */ Map f() {
        return this.e;
    }
}
