package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dh implements com.google.android.libraries.navigation.internal.aac.t {
    final /* synthetic */ com.google.android.libraries.navigation.internal.sl.h a;
    final /* synthetic */ dp b;

    public dh(dp dpVar, com.google.android.libraries.navigation.internal.sl.h hVar) {
        this.a = hVar;
        this.b = dpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.t
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.aac.bj a(Object obj) throws Exception {
        c cVar = (c) obj;
        if (cVar == null || cVar.e() == b.d) {
            return com.google.android.libraries.navigation.internal.aac.az.h(new Cdo(false, null));
        }
        final com.google.android.libraries.navigation.internal.sl.h hVar = this.a;
        return com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.az.l(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.sk.df
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final com.google.android.libraries.navigation.internal.aac.bj a() {
                return this.a.b.e.a(hVar);
            }
        }, this.b.a), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sk.dg
            public final /* synthetic */ boolean a = true;

            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj2) {
                return new Cdo(true, (ad) obj2);
            }
        }, this.b.b);
    }
}
