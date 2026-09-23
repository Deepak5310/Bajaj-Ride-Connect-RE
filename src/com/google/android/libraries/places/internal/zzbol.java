package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbol extends zzavb {
    final /* synthetic */ zzboo zzc;

    zzbol(zzboo zzbooVar) {
        this.zzc = zzbooVar;
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zza(zzaxd zzaxdVar) {
        this.zzc.zze.zzd(zzasu.TRANSIENT_FAILURE, new zzaur(zzaut.zzb(zzaxdVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzb(zzaux zzauxVar) {
        throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzd() {
    }
}
