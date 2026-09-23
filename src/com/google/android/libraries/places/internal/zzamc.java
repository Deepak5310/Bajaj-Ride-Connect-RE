package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzamc extends zzame {
    final /* synthetic */ zzaml zza;
    private int zzb = 0;
    private final int zzc;

    zzamc(zzaml zzamlVar) {
        this.zza = zzamlVar;
        this.zzc = zzamlVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzamg
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
