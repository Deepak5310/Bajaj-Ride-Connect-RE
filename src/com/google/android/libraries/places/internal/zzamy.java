package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzamy extends zzamb {
    private static final Logger zza = Logger.getLogger(zzamy.class.getName());
    private static final boolean zzb = zzaqq.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzamz zze;

    private zzamy() {
    }

    /* synthetic */ zzamy(zzamx zzamxVar) {
    }

    public static int zzA(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzB(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            j >>>= 14;
            i += 2;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzamy zzC(byte[] bArr, int i, int i2) {
        return new zzamu(bArr, i, i2);
    }

    @Deprecated
    static int zzw(int i, zzaoz zzaozVar, zzapm zzapmVar) {
        int iZzag = ((zzalw) zzaozVar).zzag(zzapmVar);
        int iZzA = zzA(i << 3);
        return iZzA + iZzA + iZzag;
    }

    public static int zzx(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    static int zzy(zzaoz zzaozVar, zzapm zzapmVar) {
        int iZzag = ((zzalw) zzaozVar).zzag(zzapmVar);
        return zzA(iZzag) + iZzag;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzaqv.zzc(str);
        } catch (zzaqu unused) {
            length = str.getBytes(zzaoa.zzb).length;
        }
        return zzA(length) + length;
    }

    public final void zzD() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzE(String str, zzaqu zzaquVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaquVar);
        byte[] bytes = str.getBytes(zzaoa.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzamv(e);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b) throws IOException;

    public abstract void zzK(int i, boolean z) throws IOException;

    public abstract void zzL(int i, zzaml zzamlVar) throws IOException;

    @Override // com.google.android.libraries.places.internal.zzamb
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    abstract void zzn(int i, zzaoz zzaozVar, zzapm zzapmVar) throws IOException;

    public abstract void zzo(int i, String str) throws IOException;

    public abstract void zzq(int i, int i2) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i, long j) throws IOException;

    public abstract void zzu(long j) throws IOException;
}
