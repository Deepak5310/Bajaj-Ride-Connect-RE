package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zziz extends zzje {
    private final CancellationTokenSource zza;
    private final String zzb;

    zziz(CancellationTokenSource cancellationTokenSource, String str) {
        this.zza = cancellationTokenSource;
        if (str == null) {
            throw new NullPointerException("Null query");
        }
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzje) {
            zzje zzjeVar = (zzje) obj;
            if (this.zza.equals(zzjeVar.zza()) && this.zzb.equals(zzjeVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "AutocompleteRequest{source=" + this.zza.toString() + ", query=" + this.zzb + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzjh
    public final CancellationTokenSource zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzje
    public final String zzb() {
        return this.zzb;
    }
}
