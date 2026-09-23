package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class be extends com.google.android.libraries.navigation.internal.lo.i {
    public final List d = new ArrayList();
    protected com.google.android.libraries.navigation.internal.lo.a e;
    private final Fragment f;
    private Activity g;

    public be(Fragment fragment) {
        this.f = fragment;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.i
    protected final void m(com.google.android.libraries.navigation.internal.lo.a aVar) {
        this.e = aVar;
        n();
    }

    public final void n() {
        Activity activity = this.g;
        if (activity == null || this.e == null || this.a != null) {
            return;
        }
        try {
            MapsInitializer.initialize(activity);
            try {
                this.e.a(new bd(this.f, cr.a(this.g).d(new com.google.android.libraries.navigation.internal.lo.n(this.g))));
                Iterator it2 = this.d.iterator();
                while (it2.hasNext()) {
                    ((bd) this.a).l((OnStreetViewPanoramaReadyCallback) it2.next());
                }
                this.d.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (com.google.android.libraries.navigation.internal.lc.ah unused) {
        }
    }

    public final void o(Activity activity) {
        this.g = activity;
        n();
    }
}
