package com.bajajconnect.interfaces;

import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.mappls.sdk.navigation.model.AdviseInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface NavigationCallback {
    void onDestinationReached();

    void onGpsStateChange(boolean z);

    void onNavigationProgress(AdviseInfo adviseInfo);

    void onNavigationProgress(AdviseInfo adviseInfo, NavInfo navInfo);

    void onNavigationStart();

    void onNavigationStop();

    default void onRerouting() {
    }

    default void onRouteReady() {
    }
}
