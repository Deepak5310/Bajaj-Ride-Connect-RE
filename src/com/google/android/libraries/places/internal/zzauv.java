package com.google.android.libraries.places.internal;

import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzauv {
    private List zza;
    private zzarv zzb = zzarv.zza;

    @Nullable
    private Object zzc;

    zzauv() {
    }

    public final zzauv zza(List list) {
        this.zza = list;
        return this;
    }

    public final zzauv zzb(zzarv zzarvVar) {
        this.zzb = zzarvVar;
        return this;
    }

    public final zzauv zzc(@Nullable Object obj) {
        this.zzc = obj;
        return this;
    }

    public final zzaux zzd() {
        return new zzaux(this.zza, this.zzb, this.zzc, null);
    }
}
