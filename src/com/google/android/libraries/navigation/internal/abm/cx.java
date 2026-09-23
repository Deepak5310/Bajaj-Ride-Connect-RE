package com.google.android.libraries.navigation.internal.abm;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cx implements com.google.android.libraries.navigation.internal.abn.bf {
    public LatLng a = null;
    final /* synthetic */ double b;
    final /* synthetic */ double c;
    final /* synthetic */ cz d;

    public cx(cz czVar, double d, double d2) {
        this.b = d;
        this.c = d2;
        this.d = czVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(com.google.android.libraries.navigation.internal.abn.aw awVar) {
        this.a = cz.e(awVar, this.b, this.c);
    }
}
