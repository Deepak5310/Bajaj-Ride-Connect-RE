package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlv extends LazyInstanceMap {
    private zzlv() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzle zzleVar = (zzle) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzll(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzlf(MlKitContext.getInstance().getApplicationContext(), zzleVar), zzleVar.zzb());
    }

    /* synthetic */ zzlv(zzlu zzluVar) {
    }
}
