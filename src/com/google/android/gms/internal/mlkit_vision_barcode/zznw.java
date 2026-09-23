package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zznw extends LazyInstanceMap {
    private zznw() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzne zzneVar = (zzne) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zznm(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zznf(MlKitContext.getInstance().getApplicationContext(), zzneVar), zzneVar.zzb());
    }

    /* synthetic */ zznw(zznv zznvVar) {
    }
}
