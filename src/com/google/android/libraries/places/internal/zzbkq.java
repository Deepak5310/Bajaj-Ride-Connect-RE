package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzbkq implements zzbna {
    private final zzbna zza;

    public zzbkq(zzbna zzbnaVar) {
        this.zza = zzbnaVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public void zza(zzbnm zzbnmVar) throws IOException {
        this.zza.zza(zzbnmVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public void zzb(boolean z, int i, int i2) throws IOException {
        this.zza.zzb(z, i, i2);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public void zzc(int i, zzbmx zzbmxVar) throws IOException {
        this.zza.zzc(i, zzbmxVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final int zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zze() throws IOException {
        this.zza.zze();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzf(boolean z, int i, zzbpl zzbplVar, int i2) throws IOException {
        this.zza.zzf(z, i, zzbplVar, i2);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzg() throws IOException {
        this.zza.zzg();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzh(int i, zzbmx zzbmxVar, byte[] bArr) throws IOException {
        this.zza.zzh(0, zzbmxVar, bArr);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzi(zzbnm zzbnmVar) throws IOException {
        this.zza.zzi(zzbnmVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzj(boolean z, boolean z2, int i, int i2, List list) throws IOException {
        this.zza.zzj(false, false, i, 0, list);
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzk(int i, long j) throws IOException {
        this.zza.zzk(i, j);
    }
}
