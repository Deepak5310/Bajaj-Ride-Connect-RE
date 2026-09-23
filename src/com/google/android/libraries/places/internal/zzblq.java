package com.google.android.libraries.places.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzblq extends zzaxv {
    private final zzbpl zza;

    zzblq(zzbpl zzbplVar) {
        this.zza = zzbplVar;
    }

    @Override // com.google.android.libraries.places.internal.zzaxv, com.google.android.libraries.places.internal.zzbhb, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        zzbpl zzbplVar = this.zza;
        zzbplVar.zzF(zzbplVar.getZzb());
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final int zze() {
        try {
            return this.zza.zzc() & 255;
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final int zzf() {
        return (int) this.zza.getZzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final zzbhb zzg(int i) {
        zzbpl zzbplVar = new zzbpl();
        zzbplVar.zzn(this.zza, i);
        return new zzblq(zzbplVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzi(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzj(OutputStream outputStream, int i) throws IOException {
        this.zza.zzr(outputStream, i);
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzk(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int iZzd = this.zza.zzd(bArr, i, i2);
            if (iZzd == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i2 + " bytes");
            }
            i2 -= iZzd;
            i += iZzd;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbhb
    public final void zzl(int i) {
        try {
            this.zza.zzF(i);
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }
}
