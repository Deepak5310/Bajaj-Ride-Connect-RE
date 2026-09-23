package com.google.android.libraries.places.internal;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzks {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzks.class.getName());
    private static final zzkr zzc = new zzkr(null);

    private zzks() {
    }

    static boolean zza(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
