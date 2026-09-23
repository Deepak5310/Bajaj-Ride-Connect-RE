package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcu implements Comparator {
    zzcu() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdb zzdbVar = (zzdb) obj;
        zzdb zzdbVar2 = (zzdb) obj2;
        zzcx it2 = zzdbVar.iterator();
        zzcx it3 = zzdbVar2.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            int iZza = zzct.zza(it2.zza() & 255, it3.zza() & 255);
            if (iZza != 0) {
                return iZza;
            }
        }
        return zzct.zza(zzdbVar.zzd(), zzdbVar2.zzd());
    }
}
