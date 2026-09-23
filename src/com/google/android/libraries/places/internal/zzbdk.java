package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdk extends zzbce {
    final /* synthetic */ zzazi zza;
    final /* synthetic */ zzbdm zzb;

    zzbdk(zzbdm zzbdmVar, zzazi zzaziVar) {
        this.zzb = zzbdmVar;
        this.zza = zzaziVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbce
    protected final zzazi zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbce, com.google.android.libraries.places.internal.zzazi
    public final void zzo(zzazk zzazkVar) {
        this.zzb.zzb.zzb();
        this.zza.zzo(new zzbdj(this, zzazkVar));
    }
}
