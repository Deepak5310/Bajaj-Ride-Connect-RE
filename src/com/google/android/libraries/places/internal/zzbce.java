package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzbce implements zzazi {
    zzbce() {
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zza());
        return zzknVarZzb.toString();
    }

    protected abstract zzazi zza();

    @Override // com.google.android.libraries.places.internal.zzazi
    public final zzarv zzam() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzg(zzbda zzbdaVar) {
        zza().zzg(zzbdaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzh(zzaxd zzaxdVar) {
        zza().zzh(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzj() {
        zza().zzj();
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzk(zzatd zzatdVar) {
        zza().zzk(zzatdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzl(zzatg zzatgVar) {
        zza().zzl(zzatgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzm(int i) {
        zza().zzm(i);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzn(int i) {
        zza().zzn(i);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public void zzo(zzazk zzazkVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final boolean zzp() {
        return zza().zzp();
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzr() {
        zza().zzr();
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzt() {
        zza().zzt();
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzu(int i) {
        zza().zzu(2);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzv(zzass zzassVar) {
        zza().zzv(zzassVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzw(InputStream inputStream) {
        zza().zzw(inputStream);
    }
}
