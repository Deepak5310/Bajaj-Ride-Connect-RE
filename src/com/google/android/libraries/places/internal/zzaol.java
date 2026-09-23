package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaol extends zzaon {
    private zzaol() {
        super(null);
    }

    /* synthetic */ zzaol(zzaok zzaokVar) {
        super(null);
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final List zza(Object obj, long j) {
        zzanz zzanzVar = (zzanz) zzaqq.zzf(obj, j);
        if (zzanzVar.zzc()) {
            return zzanzVar;
        }
        int size = zzanzVar.size();
        zzanz zzanzVarZzd = zzanzVar.zzd(size == 0 ? 10 : size + size);
        zzaqq.zzs(obj, j, zzanzVarZzd);
        return zzanzVarZzd;
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final void zzb(Object obj, long j) {
        ((zzanz) zzaqq.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final void zzc(Object obj, Object obj2, long j) {
        zzanz zzanzVarZzd = (zzanz) zzaqq.zzf(obj, j);
        zzanz zzanzVar = (zzanz) zzaqq.zzf(obj2, j);
        int size = zzanzVarZzd.size();
        int size2 = zzanzVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzanzVarZzd.zzc()) {
                zzanzVarZzd = zzanzVarZzd.zzd(size2 + size);
            }
            zzanzVarZzd.addAll(zzanzVar);
        }
        if (size > 0) {
            zzanzVar = zzanzVarZzd;
        }
        zzaqq.zzs(obj, j, zzanzVar);
    }
}
