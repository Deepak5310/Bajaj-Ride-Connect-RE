package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblj implements Runnable, zzbmy {
    final zzbmz zza;
    final /* synthetic */ zzblk zzc;
    private final zzbln zzd = new zzbln(Level.FINE, zzblk.class);
    boolean zzb = true;

    zzblj(zzblk zzblkVar, zzbmz zzbmzVar) {
        this.zzc = zzblkVar;
        this.zza = zzbmzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaxd zzaxdVarZzg;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.zza.zza(this)) {
            try {
                zzblk zzblkVar = this.zzc;
                if (zzblkVar.zzK != null) {
                    zzblkVar.zzK.zza();
                }
            } catch (Throwable th) {
                try {
                    this.zzc.zzaa(0, zzbmx.PROTOCOL_ERROR, zzaxd.zzo.zzg("error in frame handler").zzf(th));
                } finally {
                    try {
                        this.zza.close();
                    } catch (IOException e) {
                        zzblk.zzd.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e);
                    }
                    this.zzc.zzl.zzd();
                    Thread.currentThread().setName(name);
                }
            }
        }
        synchronized (this.zzc.zzo) {
            zzaxdVarZzg = this.zzc.zzz;
        }
        if (zzaxdVarZzg == null) {
            zzaxdVarZzg = zzaxd.zzp.zzg("End of stream or IOException");
        }
        this.zzc.zzaa(0, zzbmx.INTERNAL_ERROR, zzaxdVarZzg);
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zza(boolean z, int i, zzbpn zzbpnVar, int i2, int i3) throws IOException {
        zzbpv zzbpvVar = (zzbpv) zzbpnVar;
        this.zzd.zza(1, i, zzbpvVar.zzb, i2, z);
        zzbld zzbldVarZzr = this.zzc.zzr(i);
        if (zzbldVarZzr != null) {
            long j = i2;
            zzbpnVar.zzD(j);
            zzbpl zzbplVar = new zzbpl();
            zzbplVar.zzn(zzbpvVar.zzb, j);
            zzbldVarZzr.zzD().zzI();
            int i4 = zzbpb.zza;
            synchronized (this.zzc.zzo) {
                zzbldVarZzr.zzD().zzO(zzbplVar, z, i3 - i2);
            }
        } else {
            if (!this.zzc.zzU(i)) {
                zzblk zzblkVar = this.zzc;
                zzbmx zzbmxVar = zzbmx.PROTOCOL_ERROR;
                zzblkVar.zzaa(0, zzbmxVar, zzblk.zzm(zzbmxVar).zzc("Received data for unknown stream: " + i));
                return;
            }
            synchronized (this.zzc.zzo) {
                this.zzc.zzm.zzc(i, zzbmx.STREAM_CLOSED);
            }
            zzbpnVar.zzF(i2);
        }
        this.zzc.zzw += i3;
        zzblk zzblkVar2 = this.zzc;
        if (zzblkVar2.zzw >= zzblkVar2.zzj * 0.5f) {
            synchronized (zzblkVar2.zzo) {
                zzblk zzblkVar3 = this.zzc;
                zzblkVar3.zzm.zzk(0, zzblkVar3.zzw);
            }
            this.zzc.zzw = 0;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzb(int i, zzbmx zzbmxVar, zzbpp zzbppVar) {
        this.zzd.zzb(1, i, zzbmxVar, zzbppVar);
        if (zzbmxVar == zzbmx.ENHANCE_YOUR_CALM) {
            String strZzf = zzbppVar.zzf();
            zzblk.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "goAway", String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strZzf));
            if ("too_many_pings".equals(strZzf)) {
                ((zzbkx) this.zzc.zzL).zza.zza();
            }
        }
        zzaxd zzaxdVarZzc = zzbcs.zza(zzbmxVar.zzs).zzc("Received Goaway");
        if (zzbppVar.zzc() > 0) {
            zzaxdVarZzc = zzaxdVarZzc.zzc(zzbppVar.zzf());
        }
        this.zzc.zzaa(i, null, zzaxdVarZzc);
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzc(boolean z, int i, int i2) {
        zzbcy zzbcyVar;
        long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
        this.zzd.zzd(1, j);
        if (!z) {
            synchronized (this.zzc.zzo) {
                this.zzc.zzm.zzb(true, i, i2);
            }
            return;
        }
        synchronized (this.zzc.zzo) {
            zzblk zzblkVar = this.zzc;
            zzbcyVar = null;
            if (zzblkVar.zzB == null) {
                zzblk.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", "Received unexpected ping ack. No ping outstanding");
            } else if (zzblkVar.zzB.zza() == j) {
                zzblk zzblkVar2 = this.zzc;
                zzbcy zzbcyVar2 = zzblkVar2.zzB;
                zzblkVar2.zzB = null;
                zzbcyVar = zzbcyVar2;
            } else {
                zzblk.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(this.zzc.zzB.zza()), Long.valueOf(j)));
            }
        }
        if (zzbcyVar != null) {
            zzbcyVar.zzc();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzd(int i, int i2, List list) throws IOException {
        this.zzd.zzf(1, i, i2, list);
        synchronized (this.zzc.zzo) {
            this.zzc.zzm.zzc(i, zzbmx.PROTOCOL_ERROR);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zze(int i, zzbmx zzbmxVar) {
        boolean z = true;
        this.zzd.zzg(1, i, zzbmxVar);
        zzaxd zzaxdVarZzc = zzblk.zzm(zzbmxVar).zzc("Rst Stream");
        if (zzaxdVarZzc.zza() != zzawy.CANCELLED && zzaxdVarZzc.zza() != zzawy.DEADLINE_EXCEEDED) {
            z = false;
        }
        boolean z2 = z;
        synchronized (this.zzc.zzo) {
            zzbld zzbldVar = (zzbld) this.zzc.zzr.get(Integer.valueOf(i));
            if (zzbldVar != null) {
                zzbldVar.zzD().zzI();
                int i2 = zzbpb.zza;
                this.zzc.zzP(i, zzaxdVarZzc, zzbmxVar == zzbmx.REFUSED_STREAM ? zzazj.REFUSED : zzazj.PROCESSED, z2, null, null);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzf(boolean z, zzbnm zzbnmVar) {
        boolean zZzh;
        this.zzd.zzh(1, zzbnmVar);
        synchronized (this.zzc.zzo) {
            if (zzbnmVar.zzf(4)) {
                this.zzc.zzH = zzbnmVar.zza(4);
            }
            if (zzbnmVar.zzf(7)) {
                zZzh = this.zzc.zzn.zzh(zzbnmVar.zza(7));
            } else {
                zZzh = false;
            }
            if (this.zzb) {
                this.zzc.zzl.zzb();
                this.zzb = false;
            }
            this.zzc.zzm.zza(zzbnmVar);
            if (zZzh) {
                this.zzc.zzn.zzg();
            }
            this.zzc.zzad();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x004f, please report this as an issue */
    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzg(int i, long j) {
        boolean z = true;
        this.zzd.zzj(1, i, j);
        synchronized (this.zzc.zzo) {
            try {
                if (i == 0) {
                    this.zzc.zzn.zza(null, (int) j);
                    return;
                }
                zzbld zzbldVar = (zzbld) this.zzc.zzr.get(Integer.valueOf(i));
                if (zzbldVar == null) {
                    if (!this.zzc.zzU(i)) {
                    }
                    if (z) {
                        zzblk zzblkVar = this.zzc;
                        zzbmx zzbmxVar = zzbmx.PROTOCOL_ERROR;
                        zzblkVar.zzaa(0, zzbmxVar, zzblk.zzm(zzbmxVar).zzc("Received window_update for unknown stream: " + i));
                    }
                }
                this.zzc.zzn.zza(zzbldVar.zzD().zzH(), (int) j);
                z = false;
                if (z) {
                    zzblk zzblkVar2 = this.zzc;
                    zzbmx zzbmxVar2 = zzbmx.PROTOCOL_ERROR;
                    zzblkVar2.zzaa(0, zzbmxVar2, zzblk.zzm(zzbmxVar2).zzc("Received window_update for unknown stream: " + i));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmy
    public final void zzh(boolean z, boolean z2, int i, int i2, List list, int i3) {
        boolean z3 = true;
        this.zzd.zzc(1, i, list, z2);
        zzaxd zzaxdVarZzg = null;
        if (this.zzc.zzM != Integer.MAX_VALUE) {
            long jZzc = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                zzbnb zzbnbVar = (zzbnb) list.get(i4);
                jZzc += (long) (zzbnbVar.zzh.zzc() + 32 + zzbnbVar.zzi.zzc());
            }
            int iMin = (int) Math.min(jZzc, 2147483647L);
            if (iMin > this.zzc.zzM) {
                zzaxdVarZzg = zzaxd.zzj.zzg(String.format(Locale.US, "Response %s metadata larger than %d: %d", true != z2 ? "header" : "trailer", Integer.valueOf(this.zzc.zzM), Integer.valueOf(iMin)));
            }
        }
        synchronized (this.zzc.zzo) {
            zzbld zzbldVar = (zzbld) this.zzc.zzr.get(Integer.valueOf(i));
            if (zzbldVar == null) {
                if (this.zzc.zzU(i)) {
                    this.zzc.zzm.zzc(i, zzbmx.STREAM_CLOSED);
                }
            } else if (zzaxdVarZzg == null) {
                zzbldVar.zzD().zzI();
                int i5 = zzbpb.zza;
                zzbldVar.zzD().zzP(list, z2);
            } else {
                if (!z2) {
                    this.zzc.zzm.zzc(i, zzbmx.CANCEL);
                }
                zzbldVar.zzD().zzj(zzaxdVarZzg, zzazj.PROCESSED, false, new zzavu());
            }
            z3 = false;
        }
        if (z3) {
            zzblk zzblkVar = this.zzc;
            zzbmx zzbmxVar = zzbmx.PROTOCOL_ERROR;
            zzblkVar.zzaa(0, zzbmxVar, zzblk.zzm(zzbmxVar).zzc("Received header for unknown stream: " + i));
        }
    }
}
