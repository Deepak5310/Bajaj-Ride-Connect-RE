package com.google.android.libraries.navigation.internal.us;

import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.ut.c {
    private final com.google.android.libraries.navigation.internal.dx.c a;
    private final com.google.android.libraries.navigation.internal.nc.t b;
    private final a c;
    private final com.google.android.libraries.navigation.internal.jy.aa d;

    /* JADX INFO: compiled from: PG */
    public interface a {
        void a();
    }

    public p(com.google.android.libraries.navigation.internal.dx.c cVar, boolean z, com.google.android.libraries.navigation.internal.nc.t tVar, a aVar, com.google.android.libraries.navigation.internal.jy.aa aaVar, final at atVar) {
        this.a = cVar;
        this.b = tVar;
        this.c = aVar;
        this.d = aaVar;
        cVar.b(new com.google.android.libraries.navigation.internal.bn.b() { // from class: com.google.android.libraries.navigation.internal.us.n
            @Override // com.google.android.libraries.navigation.internal.bn.b
            public final void a(com.google.android.libraries.navigation.internal.nc.ah ahVar) {
                atVar.a(this.a);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ut.c
    public com.google.android.libraries.navigation.internal.jy.aa a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.c
    public cs.a b() {
        this.c.a();
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.c
    public com.google.android.libraries.navigation.internal.nc.t c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.c
    public com.google.android.libraries.navigation.internal.nc.ah d() {
        return this.a.a;
    }
}
