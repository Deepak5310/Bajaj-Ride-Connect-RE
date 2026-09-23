package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxx implements zzaya, zzbgd {
    private zzbaa zzr;
    private final Object zzs = new Object();
    private final zzbjt zzt;
    private final zzbke zzu;
    private final zzbgh zzv;
    private int zzw;
    private boolean zzx;
    private boolean zzy;

    protected zzaxx(int i, zzbjt zzbjtVar, zzbke zzbkeVar) {
        this.zzt = zzbjtVar;
        this.zzu = zzbkeVar;
        zzbgh zzbghVar = new zzbgh(this, zzasq.zza, i, zzbjtVar, zzbkeVar);
        this.zzv = zzbghVar;
        this.zzr = zzbghVar;
    }

    private final void zzb() {
        boolean zZzc;
        synchronized (this.zzs) {
            zZzc = zzc();
        }
        if (zZzc) {
            zza().zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc() {
        boolean z;
        synchronized (this.zzs) {
            z = false;
            if (this.zzx && this.zzw < 32768 && !this.zzy) {
                z = true;
            }
        }
        return z;
    }

    static /* bridge */ /* synthetic */ void zzn(zzaxx zzaxxVar, int i) {
        synchronized (zzaxxVar.zzs) {
            zzaxxVar.zzw += i;
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzaxx zzaxxVar, int i) {
        zzbaa zzbaaVar = zzaxxVar.zzr;
        zzaxxVar.zzz(new zzaxw(zzaxxVar, zzbpb.zza(), 2));
    }

    protected abstract zzbjw zza();

    protected final zzbke zzm() {
        return this.zzu;
    }

    protected final void zzp(boolean z) {
        if (z) {
            this.zzr.close();
        } else {
            this.zzr.zza();
        }
    }

    protected final void zzq(zzbhb zzbhbVar) {
        try {
            this.zzr.zzb(zzbhbVar);
        } catch (Throwable th) {
            zzF(th);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgd
    public final void zzr(zzbjv zzbjvVar) {
        zza().zzf(zzbjvVar);
    }

    public final void zzs(int i) {
        boolean z;
        synchronized (this.zzs) {
            zzkt.zzo(this.zzx, "onStreamAllocated was not called, but it seems the stream is active");
            int i2 = this.zzw;
            int i3 = i2 - i;
            this.zzw = i3;
            z = false;
            if (i2 >= 32768 && i3 < 32768) {
                z = true;
            }
        }
        if (z) {
            zzb();
        }
    }

    protected final void zzt() {
        zzkt.zzn(zza() != null);
        synchronized (this.zzs) {
            zzkt.zzo(!this.zzx, "Already allocated");
            this.zzx = true;
        }
        zzb();
    }

    protected final void zzu() {
        synchronized (this.zzs) {
            this.zzy = true;
        }
    }

    final void zzv() {
        this.zzv.zzf(this);
        this.zzr = this.zzv;
    }

    protected final void zzw(zzate zzateVar) {
        this.zzr.zzd(zzateVar);
    }

    final void zzx(int i) {
        this.zzr.zze(i);
    }
}
