package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbni implements zzbna {
    private final zzbpm zza;
    private final zzbpl zzb;
    private final zzbnd zzc;
    private int zzd;
    private boolean zze;

    zzbni(zzbpm zzbpmVar, boolean z) {
        this.zza = zzbpmVar;
        zzbpl zzbplVar = new zzbpl();
        this.zzb = zzbplVar;
        this.zzc = new zzbnd(4096, false, zzbplVar);
        this.zzd = 16384;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.zze = true;
        this.zza.close();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zza(zzbnm zzbnmVar) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        this.zzd = zzbnmVar.zzc(this.zzd);
        zzl(0, 0, (byte) 4, (byte) 1);
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzb(boolean z, int i, int i2) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        zzl(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.zza.zzw(i);
        this.zza.zzw(i2);
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzc(int i, zzbmx zzbmxVar) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        if (zzbmxVar.zzs == -1) {
            throw new IllegalArgumentException();
        }
        zzl(i, 4, (byte) 3, (byte) 0);
        this.zza.zzw(zzbmxVar.zzs);
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zze() throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        if (zzbnj.zza.isLoggable(Level.FINE)) {
            zzbnj.zza.logp(Level.FINE, "io.grpc.okhttp.internal.framed.Http2$Writer", "connectionPreface", String.format(">> CONNECTION %s", zzbnj.zzb.zze()));
        }
        zzbpm zzbpmVar = this.zza;
        byte[] source = zzbnj.zzb.zzp();
        Intrinsics.checkNotNullParameter(source, "source");
        if (((zzbpu) zzbpmVar).zzc) {
            throw new IllegalStateException("closed");
        }
        zzbpl zzbplVar = ((zzbpu) zzbpmVar).zzb;
        Intrinsics.checkNotNullParameter(source, "source");
        zzbplVar.zzl(source, 0, source.length);
        ((zzbpu) zzbpmVar).zza();
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzf(boolean z, int i, zzbpl zzbplVar, int i2) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        zzl(i, i2, (byte) 0, z ? (byte) 1 : (byte) 0);
        if (i2 > 0) {
            this.zza.zzn(zzbplVar, i2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzg() throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzh(int i, zzbmx zzbmxVar, byte[] bArr) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        if (zzbmxVar.zzs == -1) {
            throw zzbnj.zzf("errorCode.httpCode == -1", new Object[0]);
        }
        zzl(0, 8, (byte) 7, (byte) 0);
        this.zza.zzw(0);
        this.zza.zzw(zzbmxVar.zzs);
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzi(zzbnm zzbnmVar) throws IOException {
        int i;
        if (this.zze) {
            throw new IOException("closed");
        }
        int i2 = 0;
        zzl(0, zzbnmVar.zzd() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (zzbnmVar.zzf(i2)) {
                if (i2 == 4) {
                    int i3 = i2;
                    i2 = 3;
                    i = i3;
                } else {
                    i = 7;
                    if (i2 == 7) {
                        i2 = 4;
                    } else {
                        i = i2;
                    }
                }
                zzbpm zzbpmVar = this.zza;
                if (((zzbpu) zzbpmVar).zzc) {
                    throw new IllegalStateException("closed");
                }
                ((zzbpu) zzbpmVar).zzb.zzq(i2);
                ((zzbpu) zzbpmVar).zza();
                this.zza.zzw(zzbnmVar.zza(i));
                i2 = i;
            }
            i2++;
        }
        this.zza.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzj(boolean z, boolean z2, int i, int i2, List list) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        this.zzc.zzb(list);
        long zzb = this.zzb.getZzb();
        int iMin = (int) Math.min(this.zzd, zzb);
        long j = iMin;
        zzl(i, iMin, (byte) 1, zzb == j ? (byte) 4 : (byte) 0);
        this.zza.zzn(this.zzb, j);
        if (zzb > j) {
            long j2 = zzb - j;
            while (j2 > 0) {
                int iMin2 = (int) Math.min(this.zzd, j2);
                long j3 = iMin2;
                j2 -= j3;
                zzl(i, iMin2, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
                this.zza.zzn(this.zzb, j3);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbna
    public final synchronized void zzk(int i, long j) throws IOException {
        if (this.zze) {
            throw new IOException("closed");
        }
        if (j == 0) {
            throw zzbnj.zzf("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{0L});
        }
        zzl(i, 4, (byte) 8, (byte) 0);
        this.zza.zzw((int) j);
        this.zza.flush();
    }

    final void zzl(int i, int i2, byte b, byte b2) throws IOException {
        if (zzbnj.zza.isLoggable(Level.FINE)) {
            zzbnj.zza.logp(Level.FINE, "io.grpc.okhttp.internal.framed.Http2$Writer", "frameHeader", zzbng.zza(false, i, i2, b, b2));
        }
        int i3 = this.zzd;
        if (i2 > i3) {
            throw zzbnj.zzf("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw zzbnj.zzf("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        }
        zzbpm zzbpmVar = this.zza;
        zzbpmVar.zzv((i2 >>> 16) & 255);
        zzbpmVar.zzv((i2 >>> 8) & 255);
        zzbpmVar.zzv(i2 & 255);
        this.zza.zzv(b);
        this.zza.zzv(b2);
        this.zza.zzw(i & Integer.MAX_VALUE);
    }
}
