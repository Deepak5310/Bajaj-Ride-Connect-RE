package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmh {
    public static List zza(List list, zzke zzkeVar) {
        return list instanceof RandomAccess ? new zzme(list, zzkeVar) : new zzmg(list, zzkeVar);
    }
}
