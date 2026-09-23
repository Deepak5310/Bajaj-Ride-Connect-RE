package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbma {
    private static final Logger zza = Logger.getLogger(zzbma.class.getName());

    private zzbma() {
    }

    public static zzavu zza(List list) {
        return zzauh.zzc(zzc(list));
    }

    public static zzavu zzb(List list) {
        return zzauh.zzc(zzc(list));
    }

    @CheckReturnValue
    private static byte[][] zzc(List list) {
        int size = list.size();
        byte[][] bArr = new byte[size + size][];
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            zzbnb zzbnbVar = (zzbnb) it2.next();
            bArr[i] = zzbnbVar.zzh.zzp();
            bArr[i + 1] = zzbnbVar.zzi.zzp();
            i += 2;
        }
        return zzbjz.zzb(bArr);
    }
}
