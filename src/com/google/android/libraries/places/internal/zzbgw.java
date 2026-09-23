package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgw extends zzavd {
    @Override // com.google.android.libraries.places.internal.zzauq
    public final zzavb zza(zzaus zzausVar) {
        return new zzbgv(zzausVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final int zzb() {
        return 5;
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final zzawe zzc(Map map) {
        try {
            return zzawe.zza(new zzbgr(zzbdx.zza(map, "shuffleAddressList"), null));
        } catch (RuntimeException e) {
            return zzawe.zzb(zzaxd.zzp.zzf(e).zzg("Failed parsing configuration for pick_first"));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final String zzd() {
        return GrpcUtil.DEFAULT_LB_POLICY;
    }

    @Override // com.google.android.libraries.places.internal.zzavd
    public final boolean zze() {
        return true;
    }
}
