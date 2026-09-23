package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbls implements zzbkf {
    private final zzbpl zza;
    private int zzb;
    private int zzc;

    zzbls(zzbpl zzbplVar, int i) {
        this.zza = zzbplVar;
        this.zzb = i;
    }

    @Override // com.google.android.libraries.places.internal.zzbkf
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbkf
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbkf
    public final void zzc(byte b) {
        this.zza.zzm(b);
        this.zzb--;
        this.zzc++;
    }

    @Override // com.google.android.libraries.places.internal.zzbkf
    public final void zzd(byte[] bArr, int i, int i2) {
        this.zza.zzl(bArr, i, i2);
        this.zzb -= i2;
        this.zzc += i2;
    }

    final zzbpl zze() {
        return this.zza;
    }
}
