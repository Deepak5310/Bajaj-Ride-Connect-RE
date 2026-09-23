package com.mappls.sdk.navigation.ui.navigation;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements com.mappls.sdk.navigation.ui.navigation.instructioncontainer.g {
    public final /* synthetic */ NavigationView a;

    public o(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a() {
        this.a.binding.nextAdviseView.setVisibility(8);
        if (this.a.binding.followButton.getVisibility() != 0) {
            this.a.binding.followButton.setVisibility(0);
        }
        this.a.nextPreviousButtonPressed(false);
    }

    public final void b() {
        this.a.nextPreviousButtonPressed(true);
    }
}
