package com.google.android.libraries.places.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnu extends InputStream implements zzath, zzaul {

    @Nullable
    private zzaoz zza;
    private final zzapg zzb;

    @Nullable
    private ByteArrayInputStream zzc;

    zzbnu(zzaoz zzaozVar, zzapg zzapgVar) {
        this.zza = zzaozVar;
        this.zzb = zzapgVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        zzaoz zzaozVar = this.zza;
        if (zzaozVar != null) {
            return zzaozVar.zzal();
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzaoz zzaozVar = this.zza;
        if (zzaozVar != null) {
            this.zzc = new ByteArrayInputStream(zzaozVar.zzaj());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzath
    public final int zza(OutputStream outputStream) throws IOException {
        zzaoz zzaozVar = this.zza;
        if (zzaozVar != null) {
            int iZzal = zzaozVar.zzal();
            this.zza.zzai(outputStream);
            this.zza = null;
            return iZzal;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream == null) {
            return 0;
        }
        zzkt.zzc(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i = byteArrayInputStream.read(bArr);
            if (i == -1) {
                int i2 = (int) j;
                this.zzc = null;
                return i2;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    final zzaoz zzb() {
        zzaoz zzaozVar = this.zza;
        if (zzaozVar != null) {
            return zzaozVar;
        }
        throw new IllegalStateException("message not available");
    }

    final zzapg zzc() {
        return this.zzb;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        zzaoz zzaozVar = this.zza;
        if (zzaozVar != null) {
            int iZzal = zzaozVar.zzal();
            if (iZzal == 0) {
                this.zza = null;
                this.zzc = null;
                return -1;
            }
            if (i2 >= iZzal) {
                zzamy zzamyVarZzC = zzamy.zzC(bArr, i, iZzal);
                this.zza.zzaC(zzamyVarZzC);
                zzamyVarZzC.zzD();
                this.zza = null;
                this.zzc = null;
                return iZzal;
            }
            this.zzc = new ByteArrayInputStream(this.zza.zzaj());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzc;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }
}
