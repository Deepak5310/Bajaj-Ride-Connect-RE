package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzboa extends zzahe {
    private final zzasf zzb;

    zzboa(zzasf zzasfVar) {
        this.zzb = zzasfVar;
    }

    @Override // com.google.android.libraries.places.internal.zzahe
    protected final String zze() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("clientCall", this.zzb);
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzahe
    protected final void zzk() {
        this.zzb.zza("GrpcFuture was cancelled", null);
    }

    @Override // com.google.android.libraries.places.internal.zzahe
    protected final boolean zzl(@Nullable Object obj) {
        return super.zzl(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzahe
    protected final boolean zzm(Throwable th) {
        return super.zzm(th);
    }
}
