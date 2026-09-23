package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cn;
import com.google.android.libraries.navigation.internal.ly.cq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ax implements com.google.android.libraries.navigation.internal.lo.m {
    private final ViewGroup a;
    private final cn b;
    private View c;

    public ax(ViewGroup viewGroup, cn cnVar) {
        this.b = cnVar;
        com.google.android.libraries.navigation.internal.lh.be.j(viewGroup);
        this.a = viewGroup;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void b(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            this.b.c(bundle2);
            cq.d(bundle2, bundle);
            this.c = (View) com.google.android.libraries.navigation.internal.lo.n.b(this.b.a());
            this.a.removeAllViews();
            this.a.addView(this.c);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void d() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void f() {
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void i(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            this.b.g(bundle2);
            cq.d(bundle2, bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void c() {
        try {
            this.b.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void g() {
        try {
            this.b.e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void h() {
        try {
            this.b.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void j() {
        try {
            this.b.h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void k() {
        try {
            this.b.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void l(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.b.b(new aw(onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
