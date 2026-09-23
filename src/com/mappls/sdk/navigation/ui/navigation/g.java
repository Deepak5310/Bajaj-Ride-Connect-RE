package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.util.GPSInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Runnable {
    public final /* synthetic */ NavigationView a;

    public g(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NavigationView navigationView = this.a;
        GPSInfo gPSInfo = navigationView.gpsInfo;
        if (gPSInfo != null && !gPSInfo.fixed && !navigationView.isInPIPMode && navigationView.getResources().getConfiguration().orientation == 1) {
            NavigationView navigationView2 = this.a;
            navigationView2.showWarning("Searching for GPS", navigationView2.getResources().getColor(R.color.red));
            return;
        }
        NavigationView navigationView3 = this.a;
        GPSInfo gPSInfo2 = navigationView3.gpsInfo;
        if (gPSInfo2 == null || gPSInfo2.usedSatellites >= 3 || navigationView3.isInPIPMode || navigationView3.getResources().getConfiguration().orientation != 1) {
            this.a.hideWarning();
        } else {
            NavigationView navigationView4 = this.a;
            navigationView4.showWarning("Weak GPS connection", navigationView4.getResources().getColor(R.color.red));
        }
    }
}
