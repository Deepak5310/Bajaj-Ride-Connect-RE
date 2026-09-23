package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzax {
    static int zza(Set set) {
        Iterator it2 = set.iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
