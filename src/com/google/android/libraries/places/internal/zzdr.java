package com.google.android.libraries.places.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdr {
    private final String zza;

    private zzdr(String str) {
        this.zza = str;
    }

    public static zzdr zza(zzdr zzdrVar, zzdr... zzdrVarArr) {
        return new zzdr(zzdrVar.zza.concat(zzki.zzc("").zzf(zzmh.zza(Arrays.asList(zzdrVarArr), new zzke() { // from class: com.google.android.libraries.places.internal.zzdq
        }))));
    }

    public static zzdr zzb(String str) {
        return new zzdr(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdr) {
            return this.zza.equals(((zzdr) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
