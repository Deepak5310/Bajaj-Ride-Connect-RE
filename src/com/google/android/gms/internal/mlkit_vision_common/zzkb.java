package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkb extends LazyInstanceMap {
    private zzkb() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzjn zzjnVar = (zzjn) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzjt(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzjo(MlKitContext.getInstance().getApplicationContext(), zzjnVar), zzjnVar.zzb());
    }

    /* synthetic */ zzkb(zzka zzkaVar) {
    }
}
