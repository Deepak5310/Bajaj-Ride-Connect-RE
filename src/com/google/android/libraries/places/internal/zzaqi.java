package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqi extends zzaqg {
    zzaqi() {
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ int zza(Object obj) {
        return ((zzaqh) obj).zza();
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ int zzb(Object obj) {
        return ((zzaqh) obj).zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzanr zzanrVar = (zzanr) obj;
        zzaqh zzaqhVar = zzanrVar.zzc;
        if (zzaqhVar != zzaqh.zzc()) {
            return zzaqhVar;
        }
        zzaqh zzaqhVarZzf = zzaqh.zzf();
        zzanrVar.zzc = zzaqhVarZzf;
        return zzaqhVarZzf;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzanr) obj).zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzaqh.zzc().equals(obj2)) {
            return obj;
        }
        if (zzaqh.zzc().equals(obj)) {
            return zzaqh.zze((zzaqh) obj, (zzaqh) obj2);
        }
        ((zzaqh) obj).zzd((zzaqh) obj2);
        return obj;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ Object zzf() {
        return zzaqh.zzf();
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ Object zzg(Object obj) {
        ((zzaqh) obj).zzh();
        return obj;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, int i2) {
        ((zzaqh) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i, long j) {
        ((zzaqh) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i, Object obj2) {
        ((zzaqh) obj).zzj((i << 3) | 3, obj2);
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ void zzk(Object obj, int i, zzaml zzamlVar) {
        ((zzaqh) obj).zzj((i << 3) | 2, zzamlVar);
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* bridge */ /* synthetic */ void zzl(Object obj, int i, long j) {
        ((zzaqh) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final void zzm(Object obj) {
        ((zzanr) obj).zzc.zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzanr) obj).zzc = (zzaqh) obj2;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzanr) obj).zzc = (zzaqh) obj2;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final boolean zzq(zzapl zzaplVar) {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzaqg
    final /* synthetic */ void zzr(Object obj, zzamz zzamzVar) throws IOException {
        ((zzaqh) obj).zzk(zzamzVar);
    }
}
