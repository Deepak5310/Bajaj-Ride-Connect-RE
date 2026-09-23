package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbee extends zzauz {
    final /* synthetic */ Throwable zza;
    private final zzaut zzb;

    zzbee(zzbfr zzbfrVar, Throwable th) {
        this.zza = th;
        this.zzb = zzaut.zza(zzaxd.zzo.zzg("Panic! This is a bug!").zzf(th));
    }

    public final String toString() {
        zzkn zzknVarZza = zzko.zza(zzbee.class);
        zzknVarZza.zzd("panicPickResult", this.zzb);
        return zzknVarZza.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzauz
    public final zzaut zza(zzauu zzauuVar) {
        return this.zzb;
    }
}
