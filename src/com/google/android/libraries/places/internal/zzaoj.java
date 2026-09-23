package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaoj extends zzaon {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzaoj() {
        super(null);
    }

    /* synthetic */ zzaoj(zzaoi zzaoiVar) {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        List list;
        List listZzd;
        List list2 = (List) zzaqq.zzf(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzaoh) {
                listZzd = new zzaog(i);
            } else {
                listZzd = ((list2 instanceof zzaph) && (list2 instanceof zzanz)) ? ((zzanz) list2).zzd(i) : new ArrayList(i);
            }
            zzaqq.zzs(obj, j, listZzd);
            return listZzd;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzaqq.zzs(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzaql)) {
                if (!(list2 instanceof zzaph) || !(list2 instanceof zzanz)) {
                    return list2;
                }
                zzanz zzanzVar = (zzanz) list2;
                if (zzanzVar.zzc()) {
                    return list2;
                }
                zzanz zzanzVarZzd = zzanzVar.zzd(list2.size() + i);
                zzaqq.zzs(obj, j, zzanzVarZzd);
                return zzanzVarZzd;
            }
            zzaog zzaogVar = new zzaog(list2.size() + i);
            zzaogVar.addAll(zzaogVar.size(), (zzaql) list2);
            zzaqq.zzs(obj, j, zzaogVar);
            list = zzaogVar;
        }
        return list;
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzaqq.zzf(obj, j);
        if (list instanceof zzaoh) {
            objUnmodifiableList = ((zzaoh) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzaph) && (list instanceof zzanz)) {
                zzanz zzanzVar = (zzanz) list;
                if (zzanzVar.zzc()) {
                    zzanzVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzaqq.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.libraries.places.internal.zzaon
    final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzaqq.zzf(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzaqq.zzs(obj, j, list);
    }
}
