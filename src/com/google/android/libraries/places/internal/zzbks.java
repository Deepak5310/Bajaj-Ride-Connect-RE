package com.google.android.libraries.places.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbks implements zzbjq {
    zzbks() {
    }

    @Override // com.google.android.libraries.places.internal.zzbjq
    public final /* bridge */ /* synthetic */ Object zza() {
        return Executors.newCachedThreadPool(zzbcu.zzg("grpc-okhttp-%d", true));
    }

    @Override // com.google.android.libraries.places.internal.zzbjq
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
