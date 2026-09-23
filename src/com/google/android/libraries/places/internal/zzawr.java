package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzawr extends zzasf {
    zzawr() {
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zzf());
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public void zza(@Nullable String str, @Nullable Throwable th) {
        zzf().zza(str, th);
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzb() {
        zzf().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public void zzc(int i) {
        throw null;
    }

    protected abstract zzasf zzf();
}
