package com.google.android.libraries.places.internal;

import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbid {
    final Object zza;
    Future zzb;
    boolean zzc;

    zzbid(Object obj) {
        this.zza = obj;
    }

    @CheckForNull
    final Future zza() {
        this.zzc = true;
        return this.zzb;
    }

    final void zzb(Future future) {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzb = future;
            }
        }
    }
}
