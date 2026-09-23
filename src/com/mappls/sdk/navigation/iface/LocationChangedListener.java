package com.mappls.sdk.navigation.iface;

import android.location.Location;
import com.mappls.sdk.navigation.util.GPSInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface LocationChangedListener {
    void onGPSConnectionChanged(boolean z);

    void onLocationChanged(Location location);

    void onSatelliteInfoChanged(GPSInfo gPSInfo);
}
