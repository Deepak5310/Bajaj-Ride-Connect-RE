package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpp {
    private static final Comparator zza = new zzph();
    private static final Comparator zzb = new zzpi();
    private static final zzpp zzc = new zzpp(new zzpn(Collections.emptyList()));
    private final zzpn zzd;

    private zzpp(zzpn zzpnVar) {
        this.zzd = zzpnVar;
    }

    public static zzpp zza() {
        return zzc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzpp) && ((zzpp) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }
}
