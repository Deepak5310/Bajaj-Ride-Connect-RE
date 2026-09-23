package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzja extends zzjf {
    private final CancellationTokenSource zza;
    private final String zzb;

    zzja(CancellationTokenSource cancellationTokenSource, String str) {
        this.zza = cancellationTokenSource;
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzjf) {
            zzjf zzjfVar = (zzjf) obj;
            if (this.zza.equals(zzjfVar.zza()) && this.zzb.equals(zzjfVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "PlaceRequest{source=" + this.zza.toString() + ", placeId=" + this.zzb + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzjh
    public final CancellationTokenSource zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzjf
    public final String zzb() {
        return this.zzb;
    }
}
