package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzid {
    public static zzic zzd(Context context) {
        String packageName = context.getPackageName();
        int i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zzhz zzhzVar = new zzhz();
        zzhzVar.zza(packageName);
        zzhzVar.zzb(i);
        zzhzVar.zzd(1);
        return zzhzVar;
    }

    public abstract int zza();

    public abstract String zzb();

    public abstract int zzc();
}
