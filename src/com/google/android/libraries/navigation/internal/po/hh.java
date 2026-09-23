package com.google.android.libraries.navigation.internal.po;

import android.util.LongSparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hh implements com.google.android.libraries.navigation.internal.pp.h {
    private final hi a;
    private final LongSparseArray b = new LongSparseArray();
    private final hg c;

    public hh(hi hiVar) {
        this.a = hiVar;
        this.c = new hg(hiVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final int a() {
        return 2;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final com.google.android.libraries.navigation.internal.ol.s b(com.google.android.libraries.navigation.internal.adg.ga gaVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final com.google.android.libraries.navigation.internal.ol.aq c(long j) {
        ba baVar;
        synchronized (this) {
            baVar = (ba) this.b.get(j);
            if (baVar == null) {
                baVar = new ba((int) j, this.c);
                this.b.put(j, baVar);
            }
        }
        return baVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt d(int i, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        return hi.z(i, (com.google.android.libraries.geo.mapcore.internal.model.v) this.a.h.get(), ezVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt j(long j) {
        return this.a.r(j);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt k(int i) {
        return com.google.android.libraries.geo.mapcore.internal.model.bt.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt l(int i) {
        com.google.android.libraries.geo.mapcore.internal.model.bv bvVarS = this.a.s();
        return bvVarS != null ? bvVarS.b(i) : com.google.android.libraries.geo.mapcore.internal.model.bt.a;
    }
}
