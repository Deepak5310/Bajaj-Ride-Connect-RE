package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbnk {
    private final zzbnk[] zza;
    private final int zzb;
    private final int zzc;

    zzbnk() {
        this.zza = new zzbnk[256];
        this.zzb = 0;
        this.zzc = 0;
    }

    zzbnk(int i, int i2) {
        this.zza = null;
        this.zzb = i;
        int i3 = i2 & 7;
        this.zzc = i3 == 0 ? 8 : i3;
    }
}
