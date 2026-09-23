package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ad implements TileProvider {
    final /* synthetic */ TileOverlayOptions a;
    private final com.google.android.libraries.navigation.internal.lz.ab b;

    public ad(TileOverlayOptions tileOverlayOptions) {
        this.a = tileOverlayOptions;
        this.b = tileOverlayOptions.a;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            return ((ae) this.b).a.getTile(i, i2, i3);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
