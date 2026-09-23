package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class AdvancedMarker extends Marker {
    public AdvancedMarker(com.google.android.libraries.navigation.internal.lz.p pVar) {
        super(pVar);
    }

    public View getIconView() {
        try {
            return (View) com.google.android.libraries.navigation.internal.lo.n.b(this.a.e());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIconView(View view) {
        if (view != null && view.getParent() != null) {
            throw new IllegalArgumentException("View already has a parent, can not be used as Marker");
        }
        try {
            this.a.r(new com.google.android.libraries.navigation.internal.lo.n(view));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
