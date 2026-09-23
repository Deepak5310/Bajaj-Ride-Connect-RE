package com.google.android.libraries.navigation.internal.sk;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba implements com.google.android.libraries.navigation.internal.aac.t {
    final /* synthetic */ bf a;

    public ba(bf bfVar) {
        this.a = bfVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.t
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.aac.bj a(Object obj) throws Exception {
        com.google.android.libraries.navigation.internal.yp.a aVar = (com.google.android.libraries.navigation.internal.yp.a) obj;
        if (aVar == null || aVar == com.google.android.libraries.navigation.internal.yp.a.IDLE) {
            return com.google.android.libraries.navigation.internal.aac.az.h(false);
        }
        final bf bfVar = this.a;
        com.google.android.libraries.navigation.internal.aac.bj bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.au
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Long.valueOf(bfVar.m);
            }
        }, bfVar.j), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sk.ay
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj2) {
                return Boolean.valueOf(this.a.a.g.a() - ((Long) Objects.requireNonNull((Long) obj2)).longValue() < bf.a);
            }
        }, this.a.k);
        com.google.android.libraries.navigation.internal.aac.az.o(bjVarH, new az(this), this.a.k);
        return bjVarH;
    }
}
