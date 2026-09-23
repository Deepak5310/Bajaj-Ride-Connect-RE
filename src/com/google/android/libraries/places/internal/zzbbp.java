package com.google.android.libraries.places.internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzbbp implements zzazi {
    private volatile boolean zza;
    private zzazk zzb;
    private zzazi zzc;
    private zzaxd zzd;
    private zzbbo zzf;
    private long zzg;
    private long zzh;
    private List zze = new ArrayList();
    private List zzi = new ArrayList();

    zzbbp() {
    }

    private final void zza(Runnable runnable) {
        zzkt.zzo(this.zzb != null, "May only be called after start");
        synchronized (this) {
            if (this.zza) {
                runnable.run();
            } else {
                this.zze.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzb() {
        zzbbo zzbboVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zze.isEmpty()) {
                    break;
                }
                list = this.zze;
                this.zze = arrayList;
            }
            if (zzbboVar != null) {
                zzbboVar.zzb();
            }
            list.clear();
            arrayList = list;
        }
        this.zze = null;
        this.zza = true;
        zzbboVar = this.zzf;
        if (zzbboVar != null) {
            zzbboVar.zzb();
        }
    }

    private final void zzi(zzazk zzazkVar) {
        Iterator it2 = this.zzi.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        this.zzi = null;
        this.zzc.zzo(zzazkVar);
    }

    private final void zzq(zzazi zzaziVar) {
        zzazi zzaziVar2 = this.zzc;
        zzkt.zzq(zzaziVar2 == null, "realStream already set to %s", zzaziVar2);
        this.zzc = zzaziVar;
        this.zzh = System.nanoTime();
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final zzarv zzam() {
        throw null;
    }

    protected void zzc(zzaxd zzaxdVar) {
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public void zzg(zzbda zzbdaVar) {
        synchronized (this) {
            if (this.zzb == null) {
                return;
            }
            if (this.zzc != null) {
                zzbdaVar.zzb("buffered_nanos", Long.valueOf(this.zzh - this.zzg));
                this.zzc.zzg(zzbdaVar);
            } else {
                zzbdaVar.zzb("buffered_nanos", Long.valueOf(System.nanoTime() - this.zzg));
                zzbdaVar.zza("waiting_for_connection");
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public void zzh(zzaxd zzaxdVar) {
        boolean z = true;
        zzkt.zzo(this.zzb != null, "May only be called after start");
        zzkt.zzc(zzaxdVar, "reason");
        synchronized (this) {
            if (this.zzc == null) {
                zzq(zzbgp.zza);
                this.zzd = zzaxdVar;
                z = false;
            }
        }
        if (z) {
            zza(new zzbbi(this, zzaxdVar));
            return;
        }
        zzb();
        zzc(zzaxdVar);
        this.zzb.zzd(zzaxdVar, zzazj.PROCESSED, new zzavu());
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzj() {
        zzkt.zzo(this.zzb != null, "May only be called after start");
        zza(new zzbbj(this));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzk(zzatd zzatdVar) {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzbbe(this, zzatdVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzl(zzatg zzatgVar) {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        zzkt.zzc(zzatgVar, "decompressorRegistry");
        this.zzi.add(new zzbbb(this, zzatgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzm(int i) {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzbbc(this, i));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzn(int i) {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzbbd(this, i));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzo(zzazk zzazkVar) {
        zzaxd zzaxdVar;
        boolean z;
        zzkt.zzo(this.zzb == null, "already started");
        synchronized (this) {
            zzaxdVar = this.zzd;
            z = this.zza;
            if (!z) {
                zzbbo zzbboVar = new zzbbo(zzazkVar);
                this.zzf = zzbboVar;
                zzazkVar = zzbboVar;
            }
            this.zzb = zzazkVar;
            this.zzg = System.nanoTime();
        }
        if (zzaxdVar != null) {
            zzazkVar.zzd(zzaxdVar, zzazj.PROCESSED, new zzavu());
        } else if (z) {
            zzi(zzazkVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final boolean zzp() {
        if (this.zza) {
            return this.zzc.zzp();
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzr() {
        zzkt.zzo(this.zzb != null, "May only be called after start");
        if (this.zza) {
            this.zzc.zzr();
        } else {
            zza(new zzbbh(this));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzt() {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzbaz(this));
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzu(int i) {
        zzkt.zzo(this.zzb != null, "May only be called after start");
        if (this.zza) {
            this.zzc.zzu(2);
        } else {
            zza(new zzbay(this, 2));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzv(zzass zzassVar) {
        zzkt.zzo(this.zzb == null, "May only be called before start");
        this.zzi.add(new zzbba(this, zzassVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzw(InputStream inputStream) {
        zzkt.zzo(this.zzb != null, "May only be called after start");
        if (this.zza) {
            this.zzc.zzw(inputStream);
        } else {
            zza(new zzbbg(this, inputStream));
        }
    }

    @CheckReturnValue
    final Runnable zze(zzazi zzaziVar) {
        synchronized (this) {
            if (this.zzc == null) {
                zzq(zzaziVar);
                zzazk zzazkVar = this.zzb;
                if (zzazkVar == null) {
                    this.zze = null;
                    this.zza = true;
                }
                if (zzazkVar != null) {
                    zzi(zzazkVar);
                    return new zzbbf(this);
                }
            }
        }
        return null;
    }
}
