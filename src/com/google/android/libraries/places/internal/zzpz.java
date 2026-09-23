package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpz {
    public static final zzpz zza = new zzpz("");
    public static final zzpz zzb = new zzpz("<br>");
    public static final zzpz zzc = new zzpz("<!DOCTYPE html>");
    private final String zzd;

    zzpz(String str) {
        this.zzd = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzpz) {
            return this.zzd.equals(((zzpz) obj).zzd);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzd.hashCode() ^ 867184553;
    }

    public final String toString() {
        return "SafeHtml{" + this.zzd + "}";
    }

    public final String zza() {
        return this.zzd;
    }
}
