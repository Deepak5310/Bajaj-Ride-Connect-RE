package com.google.android.libraries.navigation.internal.abh;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dp extends com.google.android.libraries.navigation.internal.lu.x {
    final /* synthetic */ dq a;

    public dp(dq dqVar) {
        this.a = dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lu.x
    public final void a(com.google.android.libraries.navigation.internal.lu.ab abVar) {
        int size = abVar.b.size();
        Location location = size == 0 ? null : (Location) abVar.b.get(size - 1);
        com.google.android.libraries.navigation.internal.ly.ar arVar = this.a.b;
        if (arVar != null) {
            try {
                arVar.a(new com.google.android.libraries.navigation.internal.lo.n(location));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }
}
