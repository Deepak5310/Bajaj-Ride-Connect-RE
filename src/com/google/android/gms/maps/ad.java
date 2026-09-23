package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ad implements com.google.android.libraries.navigation.internal.lo.m {
    public final com.google.android.libraries.navigation.internal.ly.q a;
    private final Fragment b;

    public ad(Fragment fragment, com.google.android.libraries.navigation.internal.ly.q qVar) {
        this.a = qVar;
        com.google.android.libraries.navigation.internal.lh.be.j(fragment);
        this.b = fragment;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            com.google.android.libraries.navigation.internal.ly.q qVar = this.a;
            com.google.android.libraries.navigation.internal.lo.n nVar = new com.google.android.libraries.navigation.internal.lo.n(layoutInflater);
            new com.google.android.libraries.navigation.internal.lo.n(viewGroup);
            com.google.android.libraries.navigation.internal.lo.l lVarL = qVar.l(nVar, bundle2);
            cq.d(bundle2, bundle);
            return (View) com.google.android.libraries.navigation.internal.lo.n.b(lVarL);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void b(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            Bundle arguments = this.b.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                cq.f(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.a.c(bundle2);
            cq.d(bundle2, bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
        try {
            Bundle bundle3 = new Bundle();
            cq.d(bundle2, bundle3);
            com.google.android.libraries.navigation.internal.ly.q qVar = this.a;
            new com.google.android.libraries.navigation.internal.lo.n(activity);
            qVar.m(googleMapOptions);
            cq.d(bundle3, bundle2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void i(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            this.a.i(bundle2);
            cq.d(bundle2, bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void c() {
        try {
            this.a.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void d() {
        try {
            this.a.e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void f() {
        try {
            this.a.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void g() {
        try {
            this.a.g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void h() {
        try {
            this.a.h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void j() {
        try {
            this.a.j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void k() {
        try {
            this.a.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void l(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.a.a(new ac(onMapReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
