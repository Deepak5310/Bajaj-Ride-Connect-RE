package com.google.android.libraries.places.internal;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzov extends zzop {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicLong zzb = new AtomicLong();
    private static final ConcurrentLinkedQueue zzc = new ConcurrentLinkedQueue();
    private volatile zznw zzd;

    private zzov(String str) {
        super(str);
        boolean z = true;
        boolean z2 = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        boolean z3 = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        if (!"eng".equals(Build.TYPE) && !"userdebug".equals(Build.TYPE)) {
            z = false;
        }
        if (z2 || z3) {
            this.zzd = new zzoq().zza(zza());
        } else if (z) {
            this.zzd = zzpb.zzc().zzb(false).zza(zza());
        } else {
            this.zzd = null;
        }
    }

    public static zznw zzb(String str) {
        AtomicReference atomicReference = zza;
        if (atomicReference.get() != null) {
            return ((zzor) atomicReference.get()).zza(str);
        }
        zzov zzovVar = new zzov(str.replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR));
        zzot.zza.offer(zzovVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzov zzovVar2 = (zzov) zzot.zza.poll();
                if (zzovVar2 == null) {
                    break;
                }
                zzovVar2.zzd = ((zzor) zza.get()).zza(zzovVar2.zza());
            }
            if (((zzou) zzc.poll()) != null) {
                zzb.getAndDecrement();
                throw null;
            }
        }
        return zzovVar;
    }
}
