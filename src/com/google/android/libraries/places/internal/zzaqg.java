package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzaqg {
    zzaqg() {
    }

    abstract int zza(Object obj);

    abstract int zzb(Object obj);

    abstract Object zzc(Object obj);

    abstract Object zzd(Object obj);

    abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i, int i2);

    abstract void zzi(Object obj, int i, long j);

    abstract void zzj(Object obj, int i, Object obj2);

    abstract void zzk(Object obj, int i, zzaml zzamlVar);

    abstract void zzl(Object obj, int i, long j);

    abstract void zzm(Object obj);

    abstract void zzn(Object obj, Object obj2);

    abstract void zzo(Object obj, Object obj2);

    abstract boolean zzq(zzapl zzaplVar);

    abstract void zzr(Object obj, zzamz zzamzVar) throws IOException;

    final boolean zzp(Object obj, zzapl zzaplVar) throws IOException {
        int iZzd = zzaplVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzaplVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzaplVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzaplVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzaoc.zza();
            }
            zzh(obj, i, zzaplVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i3 = i << 3;
        while (zzaplVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzaplVar)) {
        }
        if ((4 | i3) != zzaplVar.zzd()) {
            throw zzaoc.zzb();
        }
        zzg(objZzf);
        zzj(obj, i, objZzf);
        return true;
    }
}
