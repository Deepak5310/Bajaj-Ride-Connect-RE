package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkp implements zzbna {
    private static final Logger zza = Logger.getLogger(zzblk.class.getName());
    private final zzbko zzb;
    private final zzbna zzc;
    private final zzbln zzd = new zzbln(Level.FINE, zzblk.class);

    zzbkp(zzbko zzbkoVar, zzbna zzbnaVar) {
        this.zzb = zzbkoVar;
        this.zzc = zzbnaVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.zzc.close();
        } catch (IOException e) {
            zza.logp(e.getClass().equals(IOException.class) ? Level.FINE : Level.INFO, "io.grpc.okhttp.ExceptionHandlingFrameWriter", "close", "Failed closing connection", (Throwable) e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zza(zzbnm zzbnmVar) {
        this.zzd.zzi(2);
        try {
            this.zzc.zza(zzbnmVar);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzb(boolean z, int i, int i2) {
        long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
        if (z) {
            this.zzd.zze(2, j);
        } else {
            this.zzd.zzd(2, j);
        }
        try {
            this.zzc.zzb(z, i, i2);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzc(int i, zzbmx zzbmxVar) {
        this.zzd.zzg(2, i, zzbmxVar);
        try {
            this.zzc.zzc(i, zzbmxVar);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final int zzd() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zze() {
        try {
            this.zzc.zze();
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzf(boolean z, int i, zzbpl zzbplVar, int i2) {
        this.zzd.zza(2, i, zzbplVar, i2, z);
        try {
            this.zzc.zzf(z, i, zzbplVar, i2);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzg() {
        try {
            this.zzc.zzg();
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzh(int i, zzbmx zzbmxVar, byte[] bArr) {
        zzbpo zzbpoVar = zzbpp.zza;
        this.zzd.zzb(2, 0, zzbmxVar, zzbpo.zzb(bArr));
        try {
            this.zzc.zzh(0, zzbmxVar, bArr);
            this.zzc.zzg();
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzi(zzbnm zzbnmVar) {
        this.zzd.zzh(2, zzbnmVar);
        try {
            this.zzc.zzi(zzbnmVar);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzj(boolean z, boolean z2, int i, int i2, List list) {
        try {
            this.zzc.zzj(false, false, i, 0, list);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final void zzk(int i, long j) {
        this.zzd.zzj(2, i, j);
        try {
            this.zzc.zzk(i, j);
        } catch (IOException e) {
            this.zzb.zzb(e);
        }
    }
}
