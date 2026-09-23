package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzij {
    private final Context zza;

    public zzij(Context context) {
        zzkt.zzc(context, "Context must not be null.");
        this.zza = context;
    }

    public final zzma zza() {
        Context context = this.zza;
        String packageName = context.getPackageName();
        String strZza = zzhy.zza(context.getPackageManager(), packageName);
        zzlz zzlzVar = new zzlz();
        if (packageName != null) {
            zzlzVar.zza("X-Android-Package", packageName);
        }
        if (strZza != null) {
            zzlzVar.zza("X-Android-Cert", strZza);
        }
        return zzlzVar.zzc();
    }
}
