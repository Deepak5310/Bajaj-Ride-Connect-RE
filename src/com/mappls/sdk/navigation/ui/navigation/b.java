package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.routing.NavigationStep;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.mappls.sdk.navigation.ui.navigation.directions.h {
    public final /* synthetic */ NavigationView a;

    public b(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a(NavigationStep navigationStep) {
        this.a.binding.directionList.hide();
        this.a.binding.nextAdviseView.setVisibility(8);
        if (navigationStep.getPosition() > this.a.binding.instructionContainer.getCurrentItem()) {
            this.a.binding.instructionContainer.setCurrentItem(navigationStep.getPosition() == 0 ? 1 : navigationStep.getPosition());
            com.mappls.sdk.navigation.ui.map.c cVar = this.a.navigationMap;
            if (cVar != null) {
                com.mappls.sdk.navigation.ui.map.plugins.c cVar2 = cVar.e;
                if (cVar2 != null) {
                    cVar2.a(true);
                }
                this.a.navigationMap.b(false);
            }
            if (this.a.binding.followButton.getVisibility() != 0) {
                this.a.binding.followButton.setVisibility(0);
            }
            this.a.fixPreviewNavigationMarker();
        }
    }
}
