package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxu extends zzaxy implements zzazi, zzbgm {
    private static final Logger zza = Logger.getLogger(zzaxu.class.getName());
    private final zzbke zzb;
    private final zzbcj zzc;
    private final boolean zzd;
    private zzavu zze;
    private volatile boolean zzf;

    protected zzaxu(zzbkg zzbkgVar, zzbjt zzbjtVar, zzbke zzbkeVar, zzavu zzavuVar, zzasa zzasaVar, boolean z) {
        zzkt.zzc(zzbkeVar, "transportTracer");
        this.zzb = zzbkeVar;
        this.zzd = !Boolean.TRUE.equals(zzasaVar.zzl(zzbcu.zzo));
        this.zzc = new zzbgn(this, zzbkgVar, zzbjtVar);
        this.zze = zzavuVar;
    }

    protected abstract zzaxr zza();

    protected abstract zzaxt zzb();

    @Override // com.google.android.libraries.places.internal.zzaxy
    protected /* bridge */ /* synthetic */ zzaxx zzc() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzaxy
    protected final zzbcj zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbke zze() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzg(zzbda zzbdaVar) {
        zzbdaVar.zzb("remote_addr", zzam().zzc(zzatm.zza));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzh(zzaxd zzaxdVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "Should not cancel with OK status");
        this.zzf = true;
        zza().zza(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgm
    public final void zzi(zzbkf zzbkfVar, boolean z, boolean z2, int i) {
        boolean z3 = true;
        if (zzbkfVar == null && !z) {
            z3 = false;
        }
        zzkt.zzf(z3, "null frame before EOS");
        zza().zzb(zzbkfVar, z, z2, i);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzj() {
        if (zzb().zzk()) {
            return;
        }
        zzb().zzg = true;
        zzd().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzk(zzatd zzatdVar) {
        this.zze.zzd(zzbcu.zzb);
        this.zze.zzf(zzbcu.zzb, Long.valueOf(Math.max(0L, zzatdVar.zzb(TimeUnit.NANOSECONDS))));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzl(zzatg zzatgVar) {
        zzaxt.zzc(zzb(), zzatgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzm(int i) {
        zzb().zzx(i);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzn(int i) {
        this.zzc.zzd(i);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzo(zzazk zzazkVar) {
        zzb().zzi(zzazkVar);
        zza().zzc(this.zze, null);
        this.zze = null;
    }

    @Override // com.google.android.libraries.places.internal.zzaxy, com.google.android.libraries.places.internal.zzbju
    public final boolean zzp() {
        return zzc().zzc() && !this.zzf;
    }

    public final boolean zzq() {
        return this.zzd;
    }
}
