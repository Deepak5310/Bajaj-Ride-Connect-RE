package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqb {
    public static final zzqb zza = new zzqb("about:invalid#zGuavaz");
    private final String zzb;

    zzqb(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzqb) {
            return this.zzb.equals(((zzqb) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ 18288376;
    }

    public final String toString() {
        return "SafeUrl{" + this.zzb + "}";
    }

    public final String zza() {
        return this.zzb;
    }
}
