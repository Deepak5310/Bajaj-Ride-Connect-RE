package com.google.android.libraries.navigation.internal.abt;

import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends StreetViewPanoramaLink {
    public final int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, float f, int i) {
        super(str, f);
        s.k(str, "panoId");
        this.a = i;
    }

    @Override // com.google.android.gms.maps.model.StreetViewPanoramaLink
    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("panoId", this.panoId);
        return ajVarF.b("bearing", this.bearing).c("linkARGB", this.a).toString();
    }
}
