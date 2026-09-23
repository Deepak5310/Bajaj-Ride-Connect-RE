package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import io.grpc.internal.GrpcUtil;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxt extends zzaxx {
    private final zzbjt zza;
    private boolean zzb;
    private zzazk zzc;
    private zzatg zzd;
    private boolean zze;
    private Runnable zzf;
    private volatile boolean zzg;
    private boolean zzh;
    private boolean zzi;

    protected zzaxt(int i, zzbjt zzbjtVar, zzbke zzbkeVar) {
        super(i, zzbjtVar, zzbkeVar);
        this.zzd = zzatg.zzb();
        this.zze = false;
        this.zza = zzbjtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzA(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        if (this.zzb) {
            return;
        }
        this.zzb = true;
        this.zza.zzm(zzaxdVar);
        this.zzc.zzd(zzaxdVar, zzazjVar, zzavuVar);
        zzm().zze(zzaxdVar.zzl());
    }

    static /* bridge */ /* synthetic */ void zzc(zzaxt zzaxtVar, zzatg zzatgVar) {
        zzkt.zzo(zzaxtVar.zzc == null, "Already called start");
        zzkt.zzc(zzatgVar, "decompressorRegistry");
        zzaxtVar.zzd = zzatgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzaxx
    protected final /* synthetic */ zzbjw zza() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbgd
    public void zze(boolean z) {
        zzkt.zzo(this.zzh, "status should have been reported on deframer closed");
        this.zze = true;
        if (this.zzi && z) {
            zzj(zzaxd.zzo.zzg("Encountered end-of-stream mid-frame"), zzazj.PROCESSED, true, new zzavu());
        }
        Runnable runnable = this.zzf;
        if (runnable != null) {
            runnable.run();
            this.zzf = null;
        }
    }

    protected final void zzf(zzbhb zzbhbVar) throws Throwable {
        boolean z = true;
        try {
            if (this.zzh) {
                zzaxu.zza.logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundDataReceived", "Received data on closed stream");
                zzbhbVar.close();
                return;
            } else {
                try {
                    zzq(zzbhbVar);
                    return;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (z) {
            zzbhbVar.close();
        }
        throw th;
    }

    protected final void zzg(zzavu zzavuVar) {
        zzkt.zzo(!this.zzh, "Received headers on closed stream");
        this.zza.zzb();
        String str = (String) zzavuVar.zzb(zzbcu.zzc);
        if (str != null) {
            zzate zzateVarZza = this.zzd.zza(str);
            if (zzateVarZza == null) {
                zzF(new zzaxf(zzaxd.zzo.zzg(String.format("Can't find decompressor for %s", str)), null));
                return;
            } else if (zzateVarZza != zzasq.zza) {
                zzw(zzateVarZza);
            }
        }
        this.zzc.zze(zzavuVar);
    }

    protected final void zzh(zzavu zzavuVar, zzaxd zzaxdVar) {
        if (this.zzh) {
            zzaxu.zza.logp(Level.INFO, "io.grpc.internal.AbstractClientStream$TransportState", "inboundTrailersReceived", "Received trailers on closed stream:\n {1}\n {2}", new Object[]{zzaxdVar, zzavuVar});
        } else {
            this.zza.zzc(zzavuVar);
            zzj(zzaxdVar, zzazj.PROCESSED, false, zzavuVar);
        }
    }

    public final void zzi(zzazk zzazkVar) {
        zzkt.zzo(this.zzc == null, "Already called setListener");
        this.zzc = zzazkVar;
    }

    public final void zzj(zzaxd zzaxdVar, zzazj zzazjVar, boolean z, zzavu zzavuVar) {
        zzkt.zzc(zzaxdVar, NotificationCompat.CATEGORY_STATUS);
        zzkt.zzc(zzavuVar, GrpcUtil.TE_TRAILERS);
        if (this.zzh) {
            if (!z) {
                return;
            } else {
                z = true;
            }
        }
        this.zzh = true;
        this.zzi = zzaxdVar.zzl();
        zzu();
        if (this.zze) {
            this.zzf = null;
            zzA(zzaxdVar, zzazjVar, zzavuVar);
        } else {
            this.zzf = new zzaxs(this, zzaxdVar, zzazjVar, zzavuVar);
            zzp(z);
        }
    }

    protected final boolean zzk() {
        return this.zzg;
    }
}
