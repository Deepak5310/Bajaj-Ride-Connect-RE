package com.google.android.libraries.navigation.internal.abg;

import androidx.collection.LruCache;
import com.google.android.libraries.navigation.internal.b.aa;
import com.google.android.libraries.navigation.internal.b.ad;
import com.google.android.libraries.navigation.internal.b.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends v {
    public final LruCache a;
    public final aa b;

    public k(LruCache lruCache, aa aaVar) {
        this.a = lruCache;
        this.b = aaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.v, com.google.android.libraries.navigation.internal.b.aa
    public final void a(com.google.android.libraries.navigation.internal.b.t tVar, ad adVar) {
        if (com.google.android.libraries.navigation.internal.abf.p.f(v.c, 3)) {
            v.e(tVar);
            v.d(adVar);
        }
        aa aaVar = this.b;
        tVar.f("post-error");
        ((com.google.android.libraries.navigation.internal.b.j) aaVar).a.execute(new com.google.android.libraries.navigation.internal.b.i(tVar, new z(adVar), null));
    }

    @Override // com.google.android.libraries.navigation.internal.abg.v, com.google.android.libraries.navigation.internal.b.aa
    public final void b(com.google.android.libraries.navigation.internal.b.t tVar, z zVar) {
        if (com.google.android.libraries.navigation.internal.abf.p.f(v.c, 3)) {
            v.e(tVar);
            v.f(zVar);
        }
        if (tVar.i && zVar.a()) {
            this.a.put(tVar.c, zVar);
        }
        this.b.b(tVar, zVar);
    }
}
