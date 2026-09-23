package com.google.android.gms.maps.model;

import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class MapCapabilities {
    private final com.google.android.libraries.navigation.internal.lz.n a;

    public MapCapabilities(com.google.android.libraries.navigation.internal.lz.n nVar) {
        be.j(nVar);
        this.a = nVar;
    }

    public boolean isAdvancedMarkersAvailable() {
        return false;
    }

    public boolean isDataDrivenStylingAvailable() {
        return false;
    }
}
