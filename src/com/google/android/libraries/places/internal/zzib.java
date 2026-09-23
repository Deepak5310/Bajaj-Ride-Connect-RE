package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzib extends zzid {
    private final String zza;
    private final int zzb;
    private final int zzc;

    /* synthetic */ zzib(String str, int i, int i2, zzia zziaVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzid) {
            zzid zzidVar = (zzid) obj;
            if (this.zza.equals(zzidVar.zzb()) && this.zzb == zzidVar.zza() && this.zzc == zzidVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zzc != 1 ? "AUTOCOMPLETE_WIDGET" : "PROGRAMMATIC_API";
        int i = this.zzb;
        return "ClientProfile{packageName=" + this.zza + ", versionCode=" + i + ", requestSource=" + str + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzid
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzid
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzid
    public final int zzc() {
        return this.zzc;
    }
}
