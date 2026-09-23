package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class MapFragment extends Fragment {
    private final ae a = new ae(this);

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        com.google.android.libraries.navigation.internal.lh.be.e("getMapAsync must be called on the main thread.");
        ae aeVar = this.a;
        com.google.android.libraries.navigation.internal.lo.m mVar = aeVar.a;
        if (mVar != null) {
            ((ad) mVar).l(onMapReadyCallback);
        } else {
            aeVar.d.add(onMapReadyCallback);
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a.o(activity);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.google.android.libraries.navigation.internal.lo.m mVar = this.a.a;
        if (mVar != null) {
            try {
                ((ad) mVar).a.b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.b(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewA = this.a.a(layoutInflater, viewGroup, bundle);
        viewA.setClickable(true);
        return viewA;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.a.c();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.a.d();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
    }

    public final void onExitAmbient() {
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.a.o(activity);
            GoogleMapOptions googleMapOptionsCreateFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsCreateFromAttributes);
            this.a.e(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.a.f();
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.a.g();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.a.h();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.a.i(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.j();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.a.k();
        super.onStop();
    }

    @Override // android.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }
}
