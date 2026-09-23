package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcd implements zzazl {
    final zzaxd zza;
    private final zzazj zzb;

    zzbcd(zzaxd zzaxdVar, zzazj zzazjVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "error must not be OK");
        this.zza = zzaxdVar;
        this.zzb = zzazjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazl
    public final zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) {
        return new zzbcc(this.zza, this.zzb, zzasoVarArr);
    }

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
