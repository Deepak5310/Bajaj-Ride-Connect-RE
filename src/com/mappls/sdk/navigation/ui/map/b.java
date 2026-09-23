package com.mappls.sdk.navigation.ui.map;

import android.content.Context;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.LocationComponentOptions;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.map.route.NavigationMapRoute;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Style.OnStyleLoaded {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        c cVar = this.a;
        Context context = cVar.b.getContext();
        int i = R.attr.navigationViewRouteStyle;
        int i2 = R.style.NavigationMapRoute;
        int i3 = com.mappls.sdk.navigation.ui.theme.a.a(context, i).resourceId;
        if (i3 != -1 && ((-16777216) & i3) != 0 && (16711680 & i3) != 0) {
            i2 = i3;
        }
        cVar.c = new NavigationMapRoute(cVar.b, cVar.a, cVar, i2);
        cVar.a.enableTraffic(cVar.j);
        com.mappls.sdk.navigation.ui.map.plugins.c cVar2 = new com.mappls.sdk.navigation.ui.map.plugins.c(cVar.b, cVar.a);
        cVar.e = cVar2;
        cVar2.a(false);
        com.mappls.sdk.navigation.ui.map.plugins.c cVar3 = cVar.e;
        cVar3.c = 0.0f;
        cVar3.d = null;
        cVar3.a.removeCallbacksAndMessages(null);
        cVar3.a.postDelayed(cVar3.h, 100L);
        c cVar4 = this.a;
        cVar4.d = new a(cVar4.b, cVar4.a);
        this.a.b(true);
        c cVar5 = this.a;
        LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(cVar5.b.getContext()).trackingGesturesManagement(true).gpsDrawable(com.mappls.sdk.navigation.ui.theme.a.a(cVar5.b.getContext(), R.attr.navigationBearingIcon).resourceId).gpsStaleDrawable(com.mappls.sdk.navigation.ui.theme.a.a(cVar5.b.getContext(), R.attr.navigationBearingIcon).resourceId).build();
        LocationComponent locationComponent = cVar5.a.getLocationComponent();
        locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(cVar5.b.getContext(), style).locationComponentOptions(locationComponentOptionsBuild).build());
        locationComponent.setLocationComponentEnabled(true);
        locationComponent.setCameraMode(34);
        locationComponent.setRenderMode(4);
        c cVar6 = this.a;
        cVar6.getClass();
        NavigationCamera navigationCamera = new NavigationCamera(cVar6.a);
        cVar6.f = navigationCamera;
        navigationCamera.addProgressChangeListener(cVar6);
        cVar6.f.start(MapplsNavigationHelper.getInstance().getCurrentRoute());
    }
}
