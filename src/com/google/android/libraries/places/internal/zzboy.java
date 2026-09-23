package com.google.android.libraries.places.internal;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzboy extends zzavd {
    @Override // com.google.android.libraries.places.internal.zzauq
    public final zzavb zza(zzaus zzausVar) {
        return new zzbox(zzausVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final int zzb() {
        return 5;
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final zzawe zzc(Map map) {
        return zzawe.zza("no service config");
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final String zzd() {
        return "round_robin";
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final boolean zze() {
        return true;
    }
}
