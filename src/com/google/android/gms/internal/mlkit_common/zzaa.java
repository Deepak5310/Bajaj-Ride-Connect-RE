package com.google.android.gms.internal.mlkit_common;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaa {
    private static final Logger zza = Logger.getLogger(zzaa.class.getName());
    private static final zzz zzb = new zzz(null);

    private zzaa() {
    }

    static String zza(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    static boolean zzb(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
