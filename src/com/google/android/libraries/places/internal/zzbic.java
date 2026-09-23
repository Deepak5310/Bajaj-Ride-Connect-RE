package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbic {
    private final AtomicLong zza = new AtomicLong();

    zzbic() {
    }

    final long zza(long j) {
        return this.zza.addAndGet(j);
    }
}
