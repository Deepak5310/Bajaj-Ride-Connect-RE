package com.mappls.sdk.navigation.ui.navigation;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ NavigationView a;

    public n(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.options.showNextInstructionBanner().booleanValue()) {
            this.a.binding.nextAdviseView.setVisibility(0);
        }
        this.a.binding.infobarView.showRouteOverview(true);
        this.a.followMe(true);
        com.mappls.sdk.navigation.ui.map.c cVar = this.a.navigationMap;
        if (cVar != null) {
            cVar.b(true);
        }
    }
}
