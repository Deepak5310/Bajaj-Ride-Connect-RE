package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzok {
    private static final zzog zza = new zzoi();
    private static final zzof zzb = new zzoj();

    public static zzoc zza(Set set) {
        zzoc zzocVar = new zzoc(zza, null);
        zzocVar.zza(zzb);
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            zzocVar.zzg((zznr) it2.next());
        }
        return zzocVar;
    }
}
