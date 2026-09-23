package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dj implements com.google.android.libraries.geo.mapcore.internal.model.be {
    public int a = 255;
    public final com.google.android.libraries.geo.mapcore.internal.model.bt b;

    public dj() {
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVar = new com.google.android.libraries.geo.mapcore.internal.model.ah();
        ahVar.e = false;
        ahVar.f = false;
        ahVar.t = -1;
        this.b = com.google.android.libraries.geo.mapcore.internal.model.bt.i(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt d(int i, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        throw null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt j(long j) {
        throw null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt k(int i) {
        com.google.android.libraries.geo.mapcore.internal.model.bt btVar;
        synchronized (this.b) {
            btVar = this.b;
        }
        return btVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt l(int i) {
        throw null;
    }
}
