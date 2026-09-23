package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkk extends zzbkq {
    final /* synthetic */ zzbkn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbkk(zzbkn zzbknVar, zzbna zzbnaVar) {
        super(zzbnaVar);
        this.zza = zzbknVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbkq, com.google.android.libraries.places.internal.zzbna
    public final void zza(zzbnm zzbnmVar) throws IOException {
        this.zza.zzk++;
        super.zza(zzbnmVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbkq, com.google.android.libraries.places.internal.zzbna
    public final void zzb(boolean z, int i, int i2) throws IOException {
        if (z) {
            this.zza.zzk++;
        }
        super.zzb(z, i, i2);
    }

    @Override // com.google.android.libraries.places.internal.zzbkq, com.google.android.libraries.places.internal.zzbna
    public final void zzc(int i, zzbmx zzbmxVar) throws IOException {
        this.zza.zzk++;
        super.zzc(i, zzbmxVar);
    }
}
