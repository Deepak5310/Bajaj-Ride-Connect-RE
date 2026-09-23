package com.mappls.sdk.navigation.ui.navigation;

import android.location.Location;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationLocationProvider;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.ui.map.route.NavigationMapRoute;
import com.mappls.sdk.navigation.ui.navigation.infobar.InfobarBottomSheetView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Style.OnStyleLoaded {
    public final /* synthetic */ MapplsMap a;
    public final /* synthetic */ NavigationView b;

    public e(NavigationView navigationView, MapplsMap mapplsMap) {
        this.b = navigationView;
        this.a = mapplsMap;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        this.a.moveCamera(CameraUpdateFactory.zoomTo(16.0d));
        NavigationView navigationView = this.b;
        navigationView.navigationMap = new com.mappls.sdk.navigation.ui.map.c(navigationView.mapView, this.a);
        this.b.locationModeNavigation(true);
        this.a.removeAnnotations();
        com.mappls.sdk.navigation.ui.map.c cVar = this.b.navigationMap;
        List events = MapplsNavigationHelper.getInstance().getEvents();
        NavigationMapRoute navigationMapRoute = cVar.c;
        if (navigationMapRoute != null) {
            navigationMapRoute.a(events);
        }
        AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
        if (adviseInfo != null) {
            if (this.b.getContext() != null) {
                adviseInfo.setLocation(NavigationLocationProvider.convertLocation(this.b.getLocationForNavigation(), this.b.getContext()));
            }
            this.b.onRouteProgress(adviseInfo);
        }
        NavigationView navigationView2 = this.b;
        com.mappls.sdk.navigation.ui.map.c cVar2 = navigationView2.navigationMap;
        if (cVar2 != null) {
            Location locationForNavigation = navigationView2.getLocationForNavigation();
            LocationComponent locationComponent = cVar2.g;
            if (locationComponent != null && locationComponent.isLocationComponentActivated()) {
                cVar2.g.forceLocationUpdate(locationForNavigation);
            }
        }
        NavigationView navigationView3 = this.b;
        InfobarBottomSheetView infobarBottomSheetView = navigationView3.binding.infobarView;
        com.mappls.sdk.navigation.ui.map.c cVar3 = navigationView3.navigationMap;
        MapplsMap mapplsMap = cVar3.a;
        infobarBottomSheetView.isTrafficEnable(mapplsMap == null ? cVar3.j : mapplsMap.isEnableTraffic());
        this.b.drawPolyLine();
        this.b.isMapInitialised = true;
    }
}
