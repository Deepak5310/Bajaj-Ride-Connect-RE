package com.mappls.sdk.navigation.ui.navigation;

import com.drew.metadata.avi.AviDirectory;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.ui.navigation.infobar.InfobarBottomSheetView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements com.mappls.sdk.navigation.ui.navigation.infobar.m {
    public final /* synthetic */ NavigationView a;

    public l(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a(String str) {
        NavigationViewCallback navigationViewCallback = this.a.navigationViewCallback;
        if (navigationViewCallback != null) {
            navigationViewCallback.onCustomInfoBarItemClick(str);
        }
    }

    public final void b() {
        if (MapplsNavigationHelper.getInstance().getCurrentRoute() == null) {
            return;
        }
        NavigationView navigationView = this.a;
        if (navigationView.navigationMap == null) {
            return;
        }
        navigationView.binding.followButton.show();
        this.a.navigationMap.b(false);
        this.a.navigationMap.c(false);
        com.mappls.sdk.navigation.ui.map.c cVar = this.a.navigationMap;
        cVar.d.a(com.mappls.sdk.navigation.ui.map.c.k);
        NavigationCamera navigationCamera = cVar.f;
        if (navigationCamera != null) {
            navigationCamera.showRouteGeometryOverview(new int[]{20, AviDirectory.TAG_DATETIME_ORIGINAL, 20, 280});
        }
    }

    public final void c() {
        this.a.binding.settingsView.show();
    }

    public final void d() {
        this.a.binding.directionList.show();
    }

    public final void e() {
        NavigationView navigationView = this.a;
        com.mappls.sdk.navigation.ui.map.c cVar = navigationView.navigationMap;
        if (cVar != null) {
            MapplsMap mapplsMap = cVar.a;
            if (mapplsMap == null ? cVar.j : mapplsMap.isEnableTraffic()) {
                com.mappls.sdk.navigation.ui.map.c cVar2 = this.a.navigationMap;
                cVar2.j = false;
                MapplsMap mapplsMap2 = cVar2.a;
                if (mapplsMap2 != null) {
                    mapplsMap2.enableTraffic(false);
                }
            } else {
                com.mappls.sdk.navigation.ui.map.c cVar3 = this.a.navigationMap;
                cVar3.j = true;
                MapplsMap mapplsMap3 = cVar3.a;
                if (mapplsMap3 != null) {
                    mapplsMap3.enableTraffic(true);
                }
            }
            NavigationView navigationView2 = this.a;
            InfobarBottomSheetView infobarBottomSheetView = navigationView2.binding.infobarView;
            com.mappls.sdk.navigation.ui.map.c cVar4 = navigationView2.navigationMap;
            MapplsMap mapplsMap4 = cVar4.a;
            infobarBottomSheetView.isTrafficEnable(mapplsMap4 == null ? cVar4.j : mapplsMap4.isEnableTraffic());
        } else {
            navigationView.binding.infobarView.isTrafficEnable(false);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Toggle-Traffic");
            com.mappls.sdk.navigation.ui.map.c cVar5 = this.a.navigationMap;
            MapplsMap mapplsMap5 = cVar5.a;
            jSONObject.put("is_traffic_enable", mapplsMap5 == null ? cVar5.j : mapplsMap5.isEnableTraffic());
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "navigation-ui", "1.2.3", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    public final void a() {
        String strMapplsMapLightStyle;
        this.a.getContext();
        if (com.mappls.sdk.navigation.ui.theme.a.a()) {
            com.mappls.sdk.navigation.ui.theme.a.a = 1;
        } else {
            com.mappls.sdk.navigation.ui.theme.a.a = 2;
        }
        this.a.toggleTheme();
        this.a.getContext();
        if (com.mappls.sdk.navigation.ui.theme.a.a()) {
            strMapplsMapLightStyle = this.a.options.mapplsMapDarkStyle();
        } else {
            strMapplsMapLightStyle = this.a.options.mapplsMapLightStyle();
        }
        this.a.mapplsMap.setMapplsStyle(strMapplsMapLightStyle, new k(this));
    }
}
