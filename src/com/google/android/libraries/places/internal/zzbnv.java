package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnv implements zzavx {
    private static final ThreadLocal zza = new ThreadLocal();
    private final zzapg zzb;
    private final zzaoz zzc;

    zzbnv(zzaoz zzaozVar, int i) {
        zzkt.zzc(zzaozVar, "defaultInstance cannot be null");
        this.zzc = zzaozVar;
        this.zzb = zzaozVar.zzav();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzavx
    public final /* bridge */ /* synthetic */ InputStream zza(Object obj) {
        return new zzbnu(obj, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.google.android.libraries.places.internal.zzaoz, java.lang.Object] */
    @Override // com.google.android.libraries.places.internal.zzavx
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        zzamr zzamrVarZzI;
        byte[] bArr;
        if (inputStream instanceof zzbnu) {
            zzbnu zzbnuVar = (zzbnu) inputStream;
            if (zzbnuVar.zzc() == this.zzb) {
                try {
                    return zzbnuVar.zzb();
                } catch (IllegalStateException unused) {
                }
            }
        }
        try {
            if (inputStream instanceof zzaul) {
                int iAvailable = inputStream.available();
                if (iAvailable <= 0 || iAvailable > 4194304) {
                    if (iAvailable == 0) {
                        return this.zzc;
                    }
                    zzamrVarZzI = null;
                } else {
                    ThreadLocal threadLocal = zza;
                    Reference reference = (Reference) threadLocal.get();
                    if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                        bArr = new byte[iAvailable];
                        threadLocal.set(new WeakReference(bArr));
                    }
                    int i = iAvailable;
                    while (i > 0) {
                        int i2 = inputStream.read(bArr, iAvailable - i, i);
                        if (i2 == -1) {
                            break;
                        }
                        i -= i2;
                    }
                    if (i != 0) {
                        throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i));
                    }
                    zzamrVarZzI = zzamr.zzJ(bArr, 0, iAvailable);
                }
            } else {
                zzamrVarZzI = null;
            }
            if (zzamrVarZzI == null) {
                zzamrVarZzI = zzamr.zzI(inputStream, 4096);
            }
            zzamrVarZzI.zzG(Integer.MAX_VALUE);
            try {
                ?? Zza = this.zzb.zza(zzamrVarZzI, zzbnw.zza);
                try {
                    zzamrVarZzI.zzz(0);
                    return Zza;
                } catch (zzaoc e) {
                    e.zzh(Zza);
                    throw e;
                }
            } catch (zzaoc e2) {
                throw new zzaxf(zzaxd.zzo.zzg("Invalid protobuf byte sequence").zzf(e2), null);
            }
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
