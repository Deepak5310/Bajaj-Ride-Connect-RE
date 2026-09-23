package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cl;
import com.google.android.libraries.navigation.internal.ly.cq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class at implements com.google.android.libraries.navigation.internal.lo.m {
    private final Fragment a;
    private final cl b;

    public at(Fragment fragment, cl clVar) {
        this.b = clVar;
        com.google.android.libraries.navigation.internal.lh.be.j(fragment);
        this.a = fragment;
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            cl clVar = this.b;
            com.google.android.libraries.navigation.internal.lo.n nVar = new com.google.android.libraries.navigation.internal.lo.n(layoutInflater);
            new com.google.android.libraries.navigation.internal.lo.n(viewGroup);
            com.google.android.libraries.navigation.internal.lo.l lVarJ = clVar.j(nVar, bundle2);
            cq.d(bundle2, bundle);
            return (View) com.google.android.libraries.navigation.internal.lo.n.b(lVarJ);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void b(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            cq.d(bundle, bundle2);
            Bundle arguments = this.a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                cq.f(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.b.b(bundle2);
            cq.d(bundle2, bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            Bundle bundle3 = new Bundle();
            cq.d(bundle2, bundle3);
            cl clVar = this.b;
            new com.google.android.libraries.navigation.internal.lo.n(activity);
            clVar.k();
            cq.d(bundle3, bundle2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
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
            this.b.c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lo.m
    public final void d() {
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
            this.b.a(new as(onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
