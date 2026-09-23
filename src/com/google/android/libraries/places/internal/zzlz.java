package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlz {
    Object[] zza;
    int zzb;
    zzly zzc;

    public zzlz() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzls.zza(length, i2));
        }
    }

    public final zzlz zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzlj.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzlz zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzma zzc() {
        zzly zzlyVar = this.zzc;
        if (zzlyVar != null) {
            throw zzlyVar.zza();
        }
        zzmr zzmrVarZzh = zzmr.zzh(this.zzb, this.zza, this);
        zzly zzlyVar2 = this.zzc;
        if (zzlyVar2 == null) {
            return zzmrVarZzh;
        }
        throw zzlyVar2.zza();
    }

    zzlz(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
