package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.ui.navigation.settings.s;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements s {
    public final /* synthetic */ NavigationView a;

    public p(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a(com.mappls.sdk.navigation.ui.utils.b bVar) {
        com.mappls.sdk.navigation.ui.map.c cVar;
        NavigationCamera navigationCamera;
        NavigationCamera navigationCamera2;
        NavigationCamera navigationCamera3;
        this.a.binding.settingsView.hide();
        if (bVar == com.mappls.sdk.navigation.ui.utils.b.a) {
            com.mappls.sdk.navigation.ui.map.c cVar2 = this.a.navigationMap;
            if (cVar2 == null || (navigationCamera3 = cVar2.f) == null) {
                return;
            }
            navigationCamera3.resetNavigationMode();
            return;
        }
        if (bVar == com.mappls.sdk.navigation.ui.utils.b.b) {
            com.mappls.sdk.navigation.ui.map.c cVar3 = this.a.navigationMap;
            if (cVar3 == null || (navigationCamera2 = cVar3.f) == null) {
                return;
            }
            navigationCamera2.toggleTilt(false);
            return;
        }
        if (bVar != com.mappls.sdk.navigation.ui.utils.b.c || (cVar = this.a.navigationMap) == null || (navigationCamera = cVar.f) == null) {
            return;
        }
        navigationCamera.toggleTilt(true);
    }
}
