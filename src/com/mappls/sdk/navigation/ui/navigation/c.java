package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.iface.NavigationEventLoadedListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements NavigationEventLoadedListener {
    public final /* synthetic */ NavigationView a;

    public c(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // com.mappls.sdk.navigation.iface.NavigationEventLoadedListener
    public final void onNavigationEventsLoaded(List list) {
        this.a.updateEvents(list);
    }
}
