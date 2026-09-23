package com.google.android.libraries.places.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgg extends FilterInputStream {
    private final int zza;
    private final zzbjt zzb;
    private long zzc;
    private long zzd;
    private long zze;

    zzbgg(InputStream inputStream, int i, zzbjt zzbjtVar) {
        super(inputStream);
        this.zze = -1L;
        this.zza = i;
        this.zzb = zzbjtVar;
    }

    private final void zza() {
        long j = this.zzd;
        long j2 = this.zzc;
        if (j > j2) {
            this.zzb.zzg(j - j2);
            this.zzc = this.zzd;
        }
    }

    private final void zzb() {
        long j = this.zzd;
        int i = this.zza;
        if (j <= i) {
            return;
        }
        throw new zzaxf(zzaxd.zzj.zzg("Decompressed gRPC message exceeds maximum size " + i), null);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.zze = this.zzd;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            this.zzd++;
        }
        zzb();
        zza();
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.zze == -1) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.zzd = this.zze;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = this.in.skip(j);
        this.zzd += jSkip;
        zzb();
        zza();
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            this.zzd += (long) i3;
        }
        zzb();
        zza();
        return i3;
    }
}
