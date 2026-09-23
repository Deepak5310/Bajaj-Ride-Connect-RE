package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaye implements zzbea {
    private final AtomicLong zza = new AtomicLong();

    zzaye() {
    }

    @Override // com.google.android.libraries.places.internal.zzbea
    public final void zza(long j) {
        this.zza.getAndAdd(1L);
    }
}
