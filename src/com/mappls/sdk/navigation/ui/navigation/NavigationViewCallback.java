package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes4.dex */
public interface NavigationViewCallback {
    default void onCustomInfoBarItemClick(String str) {
    }

    void onNavigationEnd();

    void onNavigationMapReady(MapplsMap mapplsMap);

    void searchAlongRoute();
}
