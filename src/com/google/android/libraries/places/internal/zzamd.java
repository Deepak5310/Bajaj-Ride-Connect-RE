package com.google.android.libraries.places.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzamd implements Comparator {
    zzamd() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzaml zzamlVar = (zzaml) obj;
        zzaml zzamlVar2 = (zzaml) obj2;
        zzamc zzamcVar = new zzamc(zzamlVar);
        zzamc zzamcVar2 = new zzamc(zzamlVar2);
        while (zzamcVar.hasNext() && zzamcVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzamcVar.zza() & 255).compareTo(Integer.valueOf(zzamcVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzamlVar.zzd()).compareTo(Integer.valueOf(zzamlVar2.zzd()));
    }
}
