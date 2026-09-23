package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.iface.OnSpeedLimitListener;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements OnSpeedLimitListener {
    public final /* synthetic */ NavigationView a;

    public i(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // com.mappls.sdk.navigation.iface.OnSpeedLimitListener
    public final void onSpeedChanged(double d, boolean z) {
        if (this.a.binding.alertView.isShowingEvent()) {
            return;
        }
        NavigationView navigationView = this.a;
        if (navigationView.isInPIPMode || !navigationView.options.showSpeedWarning().booleanValue()) {
            this.a.binding.speedWarningButton.setVisibility(8);
            return;
        }
        this.a.binding.speedWarningButton.setText(((int) d) + "");
        this.a.binding.speedWarningButton.setVisibility(0);
    }
}
