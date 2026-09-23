package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzpw {
    private static final zznd zza;

    static {
        zznh zznhVarZza = zzni.zza();
        zznhVarZza.zzb(Typography.quote, "&quot;");
        zznhVarZza.zzb('\'', "&#39;");
        zznhVarZza.zzb(Typography.amp, "&amp;");
        zznhVarZza.zzb(Typography.less, "&lt;");
        zznhVarZza.zzb(Typography.greater, "&gt;");
        zza = zznhVarZza.zza();
    }

    static String zza(String str) {
        return zza.zza(str);
    }
}
