package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawh {
    private List zza = Collections.emptyList();
    private zzarv zzb = zzarv.zza;

    @Nullable
    private zzawe zzc;

    zzawh() {
    }

    public final zzawh zza(List list) {
        this.zza = list;
        return this;
    }

    public final zzawh zzb(zzarv zzarvVar) {
        this.zzb = zzarvVar;
        return this;
    }

    public final zzawh zzc(@Nullable zzawe zzaweVar) {
        this.zzc = zzaweVar;
        return this;
    }

    public final zzawi zzd() {
        return new zzawi(this.zza, this.zzb, this.zzc);
    }
}
