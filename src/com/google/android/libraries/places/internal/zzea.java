package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzea {
    private final String zza;
    private final int zzb;
    private final zzdz zzc;
    private final boolean zzd;
    private final int zze;

    public zzea(WifiInfo wifiInfo, ScanResult scanResult) {
        zzdz zzdzVar;
        String str = scanResult.BSSID;
        String str2 = scanResult.capabilities;
        int i = scanResult.level;
        int i2 = scanResult.frequency;
        if (TextUtils.isEmpty(str2)) {
            zzdzVar = zzdz.OTHER;
        } else {
            String upperCase = str2.toUpperCase(Locale.getDefault());
            zzdzVar = (upperCase.equals("[ESS]") || upperCase.equals("[IBSS]")) ? zzdz.NONE : upperCase.matches(".*WPA[0-9]*-PSK.*") ? zzdz.PSK : upperCase.matches(".*WPA[0-9]*-EAP.*") ? zzdz.EAP : zzdz.OTHER;
        }
        boolean z = false;
        if (wifiInfo != null && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(wifiInfo.getBSSID())) {
            z = true;
        }
        this.zza = str;
        this.zzb = i;
        this.zzc = zzdzVar;
        this.zzd = z;
        this.zze = i2;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzdz zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
