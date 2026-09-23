package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.OnStyleLoadListener;
import com.mappls.sdk.navigation.ui.map.route.NavigationMapRoute;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements OnStyleLoadListener {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
    public final void onError(String str) {
    }

    @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
    public final void onStyleLoaded(Style style) {
        NavigationMapRoute navigationMapRoute;
        com.mappls.sdk.navigation.ui.map.c cVar = this.a.a.navigationMap;
        if (cVar == null || (navigationMapRoute = cVar.c) == null) {
            return;
        }
        navigationMapRoute.b();
    }
}
