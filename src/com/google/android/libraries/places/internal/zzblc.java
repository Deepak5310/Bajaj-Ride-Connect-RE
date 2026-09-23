package com.google.android.libraries.places.internal;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblc extends zzbcx implements zzblu {
    final /* synthetic */ zzbld zza;
    private final int zzb;
    private final Object zzc;
    private List zzd;
    private final zzbpl zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private final zzbkp zzk;
    private final zzblz zzl;
    private final zzblk zzm;
    private boolean zzn;
    private final zzbpc zzo;
    private zzblv zzp;
    private int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzblc(zzbld zzbldVar, int i, zzbjt zzbjtVar, Object obj, zzbkp zzbkpVar, zzblz zzblzVar, zzblk zzblkVar, int i2, String str) {
        super(i, zzbjtVar, zzbldVar.zze());
        this.zza = zzbldVar;
        this.zze = new zzbpl();
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzn = true;
        this.zzq = -1;
        this.zzc = obj;
        this.zzk = zzbkpVar;
        this.zzl = zzblzVar;
        this.zzm = zzblkVar;
        this.zzi = i2;
        this.zzj = i2;
        this.zzb = i2;
        this.zzo = zzbpb.zzb(str);
    }

    static /* bridge */ /* synthetic */ void zzL(zzblc zzblcVar, zzbpl zzbplVar, boolean z, boolean z2) {
        if (zzblcVar.zzh) {
            return;
        }
        if (!zzblcVar.zzn) {
            zzkt.zzo(zzblcVar.zzq != -1, "streamId should be set");
            zzblcVar.zzl.zze(z, zzblcVar.zzp, zzbplVar, z2);
        } else {
            zzblcVar.zze.zzn(zzbplVar, (int) zzbplVar.getZzb());
            zzblcVar.zzf |= z;
            zzblcVar.zzg |= z2;
        }
    }

    static /* bridge */ /* synthetic */ void zzM(zzblc zzblcVar, zzavu zzavuVar, String str) {
        zzbld zzbldVar = zzblcVar.zza;
        String str2 = zzbldVar.zze;
        String str3 = zzbldVar.zzc;
        boolean zZzT = zzblcVar.zzm.zzT();
        zzkt.zzc(zzavuVar, "headers");
        zzkt.zzc(str2, "authority");
        zzavuVar.zzd(zzbcu.zzh);
        zzavuVar.zzd(zzbcu.zzi);
        zzavuVar.zzd(zzbcu.zzj);
        ArrayList arrayList = new ArrayList(zzauh.zza(zzavuVar) + 7);
        if (zZzT) {
            arrayList.add(zzbkr.zzb);
        } else {
            arrayList.add(zzbkr.zza);
        }
        arrayList.add(zzbkr.zzc);
        zzbpp zzbppVar = zzbnb.zze;
        zzbpo zzbpoVar = zzbpp.zza;
        arrayList.add(new zzbnb(zzbppVar, zzbpo.zza(str2)));
        arrayList.add(new zzbnb(zzbnb.zzc, zzbpo.zza(str)));
        arrayList.add(new zzbnb(zzbcu.zzj.zzd(), str3));
        arrayList.add(zzbkr.zze);
        arrayList.add(zzbkr.zzf);
        byte[][] bArrZza = zzbjz.zza(zzavuVar);
        for (int i = 0; i < bArrZza.length; i += 2) {
            zzbpp zzbppVarZzb = zzbpo.zzb(bArrZza[i]);
            if (zzbppVarZzb.getZzc().length != 0 && zzbppVarZzb.getZzc()[0] != 58) {
                arrayList.add(new zzbnb(zzbppVarZzb, zzbpo.zzb(bArrZza[i + 1])));
            }
        }
        zzblcVar.zzd = arrayList;
        zzblcVar.zzm.zzR(zzblcVar.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ(zzaxd zzaxdVar, boolean z, zzavu zzavuVar) throws EOFException {
        if (this.zzh) {
            return;
        }
        this.zzh = true;
        if (!this.zzn) {
            this.zzm.zzP(this.zzq, zzaxdVar, zzazj.PROCESSED, z, zzbmx.CANCEL, zzavuVar);
            return;
        }
        this.zzm.zzQ(this.zza);
        this.zzd = null;
        zzbpl zzbplVar = this.zze;
        zzbplVar.zzF(zzbplVar.getZzb());
        this.zzn = false;
        if (zzavuVar == null) {
            zzavuVar = new zzavu();
        }
        zzj(zzaxdVar, zzazj.PROCESSED, true, zzavuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbcx
    protected final void zzA(zzaxd zzaxdVar, boolean z, zzavu zzavuVar) throws EOFException {
        zzQ(zzaxdVar, false, zzavuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgd
    public final void zzE(int i) {
        int i2 = this.zzj - i;
        this.zzj = i2;
        int i3 = this.zzb;
        if (i2 <= i3 * 0.5f) {
            int i4 = i3 - i2;
            this.zzi += i4;
            this.zzj = i2 + i4;
            this.zzk.zzk(this.zzq, i4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgd
    public final void zzF(Throwable th) throws EOFException {
        zzQ(zzaxd.zze(th), true, new zzavu());
    }

    final int zzG() {
        return this.zzq;
    }

    final zzblv zzH() {
        zzblv zzblvVar;
        synchronized (this.zzc) {
            zzblvVar = this.zzp;
        }
        return zzblvVar;
    }

    final zzbpc zzI() {
        return this.zzo;
    }

    public final void zzN(int i) {
        zzkt.zzp(this.zzq == -1, "the stream has been started with id %s", i);
        this.zzq = i;
        this.zzp = this.zzl.zzc(this, i);
        zzblc zzblcVar = this.zza.zzf;
        super.zzt();
        zzblcVar.zzm().zzb();
        if (this.zzn) {
            this.zzk.zzj(false, false, this.zzq, 0, this.zzd);
            this.zza.zzd.zzd();
            this.zzd = null;
            if (this.zze.getZzb() > 0) {
                this.zzl.zze(this.zzf, this.zzp, this.zze, this.zzg);
            }
            this.zzn = false;
        }
    }

    public final void zzO(zzbpl zzbplVar, boolean z, int i) {
        int zzb = this.zzi - (((int) zzbplVar.getZzb()) + i);
        this.zzi = zzb;
        this.zzj -= i;
        if (zzb >= 0) {
            super.zzB(new zzblq(zzbplVar), z);
        } else {
            this.zzk.zzc(this.zzq, zzbmx.FLOW_CONTROL_ERROR);
            this.zzm.zzP(this.zzq, zzaxd.zzo.zzg("Received data size exceeded our receiving window size"), zzazj.PROCESSED, false, null, null);
        }
    }

    public final void zzP(List list, boolean z) {
        if (z) {
            zzD(zzbma.zzb(list));
        } else {
            zzC(zzbma.zza(list));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaxt, com.google.android.libraries.places.internal.zzbgd
    public final void zze(boolean z) {
        if (zzk()) {
            this.zzm.zzP(this.zzq, null, zzazj.PROCESSED, false, null, null);
        } else {
            this.zzm.zzP(this.zzq, null, zzazj.PROCESSED, false, zzbmx.CANCEL, null);
        }
        super.zze(z);
    }

    @Override // com.google.android.libraries.places.internal.zzaya
    public final void zzz(Runnable runnable) {
        synchronized (this.zzc) {
            runnable.run();
        }
    }
}
