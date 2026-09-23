package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayd {
    private static final Logger zza = Logger.getLogger(zzayd.class.getName());
    private final String zzb;
    private final AtomicLong zzc;

    public zzayd(String str, long j) {
        AtomicLong atomicLong = new AtomicLong();
        this.zzc = atomicLong;
        this.zzb = "keepalive time nanos";
        atomicLong.set(Long.MAX_VALUE);
    }

    public final zzayc zza() {
        return new zzayc(this, this.zzc.get(), null);
    }
}
