package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgj extends OutputStream {
    final /* synthetic */ zzbgn zza;
    private final List zzb = new ArrayList();
    private zzbkf zzc;

    /* synthetic */ zzbgj(zzbgn zzbgnVar, zzbgi zzbgiVar) {
        this.zza = zzbgnVar;
    }

    static /* bridge */ /* synthetic */ int zza(zzbgj zzbgjVar) {
        Iterator it2 = zzbgjVar.zzb.iterator();
        int iZza = 0;
        while (it2.hasNext()) {
            iZza += ((zzbkf) it2.next()).zza();
        }
        return iZza;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        zzbkf zzbkfVar = this.zzc;
        byte b = (byte) i;
        if (zzbkfVar == null || zzbkfVar.zzb() <= 0) {
            write(new byte[]{b}, 0, 1);
        } else {
            zzbkfVar.zzc(b);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        if (this.zzc == null) {
            zzbkf zzbkfVarZza = this.zza.zzg.zza(i2);
            this.zzc = zzbkfVarZza;
            this.zzb.add(zzbkfVarZza);
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, this.zzc.zzb());
            if (iMin == 0) {
                int iZza = this.zzc.zza();
                zzbkf zzbkfVarZza2 = this.zza.zzg.zza(Math.max(i2, iZza + iZza));
                this.zzc = zzbkfVarZza2;
                this.zzb.add(zzbkfVarZza2);
            } else {
                this.zzc.zzd(bArr, i, iMin);
                i += iMin;
                i2 -= iMin;
            }
        }
    }
}
