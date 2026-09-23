package com.bajajconnect.gMaps;

import com.bajajconnect.ble.BleFeatures;
import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: loaded from: classes3.dex */
public class NavUtil {
    private Navigator defaultNavigator;
    private boolean isRegistered = false;

    public NavUtil(Navigator navigator) {
        this.defaultNavigator = navigator;
    }

    public void registerListners(Navigator navigator) {
        if (!this.isRegistered && navigator.registerServiceForNavUpdates(BleFeatures.getInstance().context.getPackageName(), NavInfoReceivingService.class.getName(), Integer.MAX_VALUE)) {
            this.isRegistered = true;
        }
    }

    public void unregisterReciever() {
        Navigator navigator = this.defaultNavigator;
        if (navigator != null) {
            navigator.unregisterServiceForNavUpdates();
        }
    }
}
