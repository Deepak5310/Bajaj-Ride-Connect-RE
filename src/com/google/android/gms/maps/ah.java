package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ah extends com.google.android.libraries.navigation.internal.lo.i {
    public final List d = new ArrayList();
    protected com.google.android.libraries.navigation.internal.lo.a e;
    private final ViewGroup f;
    private final Context g;
    private final GoogleMapOptions h;

    public ah(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.f = viewGroup;
        this.g = context;
        this.h = googleMapOptions;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.i
    protected final void m(com.google.android.libraries.navigation.internal.lo.a aVar) {
        this.e = aVar;
        if (aVar == null || this.a != null) {
            return;
        }
        try {
            MapsInitializer.initialize(this.g);
            this.e.a(new ag(this.f, cr.a(this.g).c(new com.google.android.libraries.navigation.internal.lo.n(this.g), this.h)));
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                ((ag) this.a).l((OnMapReadyCallback) it2.next());
            }
            this.d.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (com.google.android.libraries.navigation.internal.lc.ah unused) {
        }
    }
}
