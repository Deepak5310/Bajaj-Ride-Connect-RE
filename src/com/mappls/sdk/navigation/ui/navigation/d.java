package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.iface.NavigationEventListener;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements NavigationEventListener {
    public final /* synthetic */ NavigationView a;

    public d(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // com.mappls.sdk.navigation.iface.NavigationEventListener
    public final void onNavigationEvent(NavEvent navEvent) {
        if (navEvent != null || this.a.isInPIPMode) {
            this.a.binding.speedWarningButton.setVisibility(8);
        }
        NavigationView navigationView = this.a;
        if (navigationView.isInPIPMode) {
            navigationView.binding.alertView.updateRouteEvent(null);
        } else {
            navigationView.binding.alertView.updateRouteEvent(navEvent);
        }
    }
}
