package com.mappls.sdk.navigation.util;

import com.mappls.sdk.navigation.h;

/* JADX INFO: loaded from: classes4.dex */
public class GPSInfo {
    public int foundSatellites = 0;
    public int usedSatellites = 0;
    public boolean fixed = false;

    public String toString() {
        StringBuilder sbA = h.a("GPSInfo{foundSatellites=");
        sbA.append(this.foundSatellites);
        sbA.append(", usedSatellites=");
        sbA.append(this.usedSatellites);
        sbA.append(", fixed=");
        sbA.append(this.fixed);
        sbA.append('}');
        return sbA.toString();
    }
}
