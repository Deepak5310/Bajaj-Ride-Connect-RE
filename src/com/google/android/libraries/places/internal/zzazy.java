package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazy {
    private ArrayList zza = new ArrayList();
    private volatile zzasu zzb = zzasu.IDLE;

    zzazy() {
    }

    final void zza(@Nonnull zzasu zzasuVar) {
        zzkt.zzc(zzasuVar, "newState");
        if (this.zzb == zzasuVar || this.zzb == zzasu.SHUTDOWN) {
            return;
        }
        this.zzb = zzasuVar;
        if (this.zza.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.zza;
        this.zza = new ArrayList();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }
}
