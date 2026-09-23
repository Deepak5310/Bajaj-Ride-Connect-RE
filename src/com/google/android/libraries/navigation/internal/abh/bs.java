package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs {
    public final bq a;
    public com.google.android.libraries.navigation.internal.ly.v b;
    private boolean c;
    private final fe d;

    public bs(bq bqVar, fe feVar, af afVar) {
        this.a = bqVar;
        this.d = feVar;
        afVar.c.a();
        afVar.k.add(this);
    }

    public final void a(int i) {
        if (!this.c) {
            if (i == 4) {
                this.c = true;
                com.google.android.libraries.navigation.internal.ly.v vVar = this.b;
                if (vVar != null) {
                    try {
                        vVar.a();
                        return;
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
                return;
            }
            return;
        }
        if (i != 4) {
            this.c = false;
            this.a.i();
            this.d.d(i == 1);
            com.google.android.libraries.navigation.internal.ly.v vVar2 = this.b;
            if (vVar2 != null) {
                try {
                    vVar2.b();
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            }
        }
    }
}
