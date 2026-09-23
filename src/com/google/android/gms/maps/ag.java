package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ag implements com.google.android.libraries.navigation.internal.lo.m {
    private final ViewGroup a;
    private final com.google.android.libraries.navigation.internal.ly.s b;
    private View c;

    public ag(ViewGroup viewGroup, com.google.android.libraries.navigation.internal.ly.s sVar) {
        this.b = sVar;
        com.google.android.libraries.navigation.internal.lh.be.j(viewGroup);
        this.a = viewGroup;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
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
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void i(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            this.b.h(bundle2);
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
    public final void f() {
        try {
            this.b.e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void g() {
        try {
            this.b.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void h() {
        try {
            this.b.g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void j() {
        try {
            this.b.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void k() {
        try {
            this.b.j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void l(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.b.b(new af(onMapReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
