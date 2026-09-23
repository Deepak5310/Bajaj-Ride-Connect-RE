package com.google.android.libraries.places.internal;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzec {
    public static final /* synthetic */ int zza = 0;
    private static final long zzb = TimeUnit.MINUTES.toMicros(1);
    private final zzdh zzc;
    private final Context zzd;

    zzec(Context context, zzdh zzdhVar) {
        this.zzd = context;
        this.zzc = zzdhVar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    public final zzlx zza(String str) {
        boolean z;
        WifiManager wifiManager = (WifiManager) this.zzd.getSystemService("wifi");
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            return zzlx.zzl();
        }
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults == null || scanResults.isEmpty()) {
            return zzlx.zzl();
        }
        zzlx zzlxVarZzo = zzlx.zzo(zzmj.zza(new Comparator() { // from class: com.google.android.libraries.places.internal.zzeb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zzec.zza;
                return ((ScanResult) obj2).level - ((ScanResult) obj).level;
            }
        }), scanResults);
        ArrayList arrayList = new ArrayList();
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        int size = zzlxVarZzo.size();
        for (int i = 0; i < size; i++) {
            ScanResult scanResult = (ScanResult) zzlxVarZzo.get(i);
            if (scanResult != null && !TextUtils.isEmpty(scanResult.SSID)) {
                long jZza = (this.zzc.zza() * 1000) - scanResult.timestamp;
                long j = zzb;
                String str2 = scanResult.SSID;
                if (str2 == null) {
                    throw new IllegalArgumentException("Null SSID.");
                }
                if (str2.indexOf(95) < 0) {
                    z = false;
                } else {
                    String lowerCase = str2.toLowerCase(Locale.ENGLISH);
                    z = true;
                    if (!lowerCase.contains("_nomap") && !lowerCase.contains("_optout")) {
                        z = false;
                    }
                }
                if (jZza <= j && !z) {
                    arrayList.add(new zzea(connectionInfo, scanResult));
                }
            }
        }
        return zzlx.zzj(arrayList);
    }
}
