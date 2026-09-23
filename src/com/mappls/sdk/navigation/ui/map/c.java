package com.mappls.sdk.navigation.ui.map;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.engine.LocationEngineProvider;
import com.mappls.sdk.navigation.camera.INavigation;
import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.camera.ProgressChangeListener;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.f;
import com.mappls.sdk.navigation.ui.map.route.NavigationMapRoute;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements INavigation {
    public static final int[] k = {0, 0, 0, 0};
    public final MapplsMap a;
    public final MapView b;
    public NavigationMapRoute c;
    public a d;
    public com.mappls.sdk.navigation.ui.map.plugins.c e;
    public NavigationCamera f;
    public final LocationComponent g;
    public boolean j = false;
    public final com.mappls.sdk.navigation.ui.utils.c h = new com.mappls.sdk.navigation.ui.utils.c();
    public final f i = new f();

    public c(MapView mapView, MapplsMap mapplsMap) {
        this.a = mapplsMap;
        this.b = mapView;
        mapplsMap.setMinZoomPreference(3.0d);
        mapplsMap.setMaxZoomPreference(18.5d);
        if (mapView.getResources().getConfiguration().orientation == 1) {
            mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 300);
        } else {
            mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 150);
        }
        mapplsMap.getUiSettings().setCompassEnabled(true);
        mapplsMap.setCameraPosition(new CameraPosition.Builder().target(new LatLng(28.0d, 77.0d)).zoom(16.0d).build());
        this.g = mapplsMap.getLocationComponent();
        if (this.f != null) {
            c(true);
        }
        mapView.getContext();
        if (com.mappls.sdk.navigation.ui.theme.a.a()) {
            mapplsMap.getUiSettings().setCompassImage(ContextCompat.getDrawable(mapView.getContext(), R.drawable.compass_north_up_dark));
        } else {
            mapplsMap.getUiSettings().setCompassImage(ContextCompat.getDrawable(mapView.getContext(), R.drawable.compass_north_up_light));
        }
        int iA = a(8.0f);
        int iA2 = a(8.0f);
        mapView.getCompassView().setPadding(iA, iA, iA, iA);
        ViewCompat.setElevation(mapView.getCompassView(), iA2);
        if (mapView.getResources().getConfiguration().orientation == 1) {
            mapplsMap.getUiSettings().setCompassMargins(a(20.0f), a(150.0f), a(20.0f), a(20.0f));
        } else {
            mapplsMap.getUiSettings().setCompassMargins(a(20.0f), a(40.0f), a(20.0f), a(20.0f));
        }
        mapplsMap.getStyle(new b(this));
    }

    public final void a(boolean z) {
        if (z) {
            LocationComponent locationComponent = this.g;
            if (locationComponent == null || !locationComponent.isLocationComponentActivated()) {
                return;
            }
            this.g.setLocationEngine(this.h);
            this.g.setCompassEngine(null);
            this.g.setRenderMode(8);
            return;
        }
        LocationComponent locationComponent2 = this.g;
        if (locationComponent2 == null || !locationComponent2.isLocationComponentActivated()) {
            return;
        }
        this.g.setLocationEngine(LocationEngineProvider.getBestLocationEngine(this.b.getContext()));
        this.g.resetCompassEngine(this.b.getContext());
        this.g.setRenderMode(8);
    }

    public final void b(boolean z) {
        if (this.a == null) {
            return;
        }
        if (!z) {
            this.d.a(k);
            return;
        }
        a aVar = this.d;
        aVar.getClass();
        aVar.a(aVar.b);
    }

    public final void c(boolean z) {
        if (z) {
            NavigationCamera navigationCamera = this.f;
            if (navigationCamera != null) {
                navigationCamera.resetCameraPositionWith(0);
                return;
            }
            return;
        }
        NavigationCamera navigationCamera2 = this.f;
        if (navigationCamera2 != null) {
            navigationCamera2.updateCameraTrackingMode(2);
        }
    }

    @Override // com.mappls.sdk.navigation.camera.INavigation
    public final void removeProgressChangeListener(ProgressChangeListener progressChangeListener) {
        f fVar = this.i;
        if (progressChangeListener == null) {
            fVar.a.clear();
        } else if (fVar.a.contains(progressChangeListener)) {
            fVar.a.remove(progressChangeListener);
        }
    }

    @Override // com.mappls.sdk.navigation.camera.INavigation
    public final void setProgressChangeListener(ProgressChangeListener progressChangeListener) {
        f fVar = this.i;
        if (fVar.a.contains(progressChangeListener)) {
            return;
        }
        fVar.a.add(progressChangeListener);
    }

    public final int a(float f) {
        return (int) (f * this.b.getResources().getDisplayMetrics().density);
    }
}
