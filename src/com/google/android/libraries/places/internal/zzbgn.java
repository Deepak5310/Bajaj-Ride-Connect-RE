package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgn implements zzbcj {
    private final zzbgm zza;
    private zzbkf zzc;
    private final zzbkg zzg;
    private final zzbjt zzh;
    private boolean zzi;
    private int zzj;
    private long zzl;
    private int zzb = -1;
    private zzass zzd = zzasq.zza;
    private final zzbgl zze = new zzbgl(this, null);
    private final ByteBuffer zzf = ByteBuffer.allocate(5);
    private int zzk = -1;

    public zzbgn(zzbgm zzbgmVar, zzbkg zzbkgVar, zzbjt zzbjtVar) {
        this.zza = zzbgmVar;
        this.zzg = zzbkgVar;
        this.zzh = zzbjtVar;
    }

    private final void zzi(boolean z, boolean z2) {
        zzbkf zzbkfVar = this.zzc;
        this.zzc = null;
        this.zza.zzi(zzbkfVar, z, z2, this.zzj);
        this.zzj = 0;
    }

    private final void zzj(zzbgj zzbgjVar, boolean z) {
        ByteBuffer byteBuffer = this.zzf;
        int iZza = zzbgj.zza(zzbgjVar);
        this.zzf.put(z ? (byte) 1 : (byte) 0).putInt(iZza);
        zzbkg zzbkgVar = this.zzg;
        ByteBuffer byteBuffer2 = this.zzf;
        zzbkf zzbkfVarZza = zzbkgVar.zza(5);
        zzbkfVarZza.zzd(byteBuffer2.array(), 0, byteBuffer2.position());
        if (iZza == 0) {
            this.zzc = zzbkfVarZza;
            return;
        }
        this.zza.zzi(zzbkfVarZza, false, false, this.zzj - 1);
        this.zzj = 1;
        List list = zzbgjVar.zzb;
        for (int i = 0; i < list.size() - 1; i++) {
            this.zza.zzi((zzbkf) list.get(i), false, false, 0);
        }
        this.zzc = (zzbkf) list.get(list.size() - 1);
        this.zzl = iZza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            zzbkf zzbkfVar = this.zzc;
            if (zzbkfVar != null && zzbkfVar.zzb() == 0) {
                zzi(false, false);
            }
            if (this.zzc == null) {
                this.zzc = this.zzg.zza(i2);
            }
            int iMin = Math.min(i2, this.zzc.zzb());
            this.zzc.zzd(bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcj
    public final /* synthetic */ zzbcj zza(zzass zzassVar) {
        this.zzd = zzassVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbcj
    public final void zzb() {
        if (this.zzi) {
            return;
        }
        this.zzi = true;
        zzbkf zzbkfVar = this.zzc;
        if (zzbkfVar != null && zzbkfVar.zza() == 0) {
            this.zzc = null;
        }
        zzi(true, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbcj
    public final void zzc() {
        zzbkf zzbkfVar = this.zzc;
        if (zzbkfVar == null || zzbkfVar.zza() <= 0) {
            return;
        }
        zzi(false, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbcj
    public final void zzd(int i) {
        zzkt.zzo(this.zzb == -1, "max size already set");
        this.zzb = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzbcj
    public final void zze(InputStream inputStream) {
        int iZza;
        if (this.zzi) {
            throw new IllegalStateException("Framer already closed");
        }
        this.zzj++;
        int i = this.zzk + 1;
        this.zzk = i;
        this.zzl = 0L;
        this.zzh.zzi(i);
        zzass zzassVar = this.zzd;
        zzasr zzasrVar = zzasq.zza;
        zzbgi zzbgiVar = null;
        try {
            int iAvailable = inputStream.available();
            if (iAvailable != 0 && zzassVar != zzasrVar) {
                zzbgj zzbgjVar = new zzbgj(this, zzbgiVar);
                try {
                    iZza = inputStream.zza(zzbgjVar);
                    zzbgjVar.close();
                    int i2 = this.zzb;
                    if (i2 >= 0 && iZza > i2) {
                        throw new zzaxf(zzaxd.zzj.zzg(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iZza), Integer.valueOf(this.zzb))), null);
                    }
                    zzj(zzbgjVar, true);
                } catch (Throwable th) {
                    zzbgjVar.close();
                    throw th;
                }
            } else if (iAvailable != -1) {
                this.zzl = iAvailable;
                int i3 = this.zzb;
                if (i3 >= 0 && iAvailable > i3) {
                    throw new zzaxf(zzaxd.zzj.zzg(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iAvailable), Integer.valueOf(this.zzb))), null);
                }
                this.zzf.put((byte) 0).putInt(iAvailable);
                if (this.zzc == null) {
                    this.zzc = this.zzg.zza(this.zzf.position() + iAvailable);
                }
                zzk(this.zzf.array(), 0, this.zzf.position());
                iZza = inputStream.zza(this.zze);
            } else {
                zzbgj zzbgjVar2 = new zzbgj(this, zzbgiVar);
                iZza = inputStream.zza(zzbgjVar2);
                int i4 = this.zzb;
                if (i4 >= 0 && iZza > i4) {
                    throw new zzaxf(zzaxd.zzj.zzg(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iZza), Integer.valueOf(this.zzb))), null);
                }
                zzj(zzbgjVar2, false);
            }
            if (iAvailable != -1 && iZza != iAvailable) {
                throw new zzaxf(zzaxd.zzo.zzg(String.format("Message length inaccurate %s != %s", Integer.valueOf(iZza), Integer.valueOf(iAvailable))), null);
            }
            long j = iZza;
            this.zzh.zzk(j);
            this.zzh.zzl(this.zzl);
            this.zzh.zzj(this.zzk, this.zzl, j);
        } catch (IOException e) {
            throw new zzaxf(zzaxd.zzo.zzg("Failed to frame message").zzf(e), null);
        } catch (RuntimeException e2) {
            throw new zzaxf(zzaxd.zzo.zzg("Failed to frame message").zzf(e2), null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcj
    public final boolean zzf() {
        return this.zzi;
    }
}
