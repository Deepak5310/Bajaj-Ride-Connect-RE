package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0015"}, d2 = {"Lokio/SegmentPool;", "", "()V", "HASH_BUCKET_COUNT", "", "LOCK", "Lokio/Segment;", "MAX_SIZE", "getMAX_SIZE", "()I", "byteCount", "getByteCount", "hashBuckets", "", "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "firstRef", "recycle", "", "segment", "take", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbpy {
    public static final zzbpy zza = new zzbpy();
    private static final zzbpx zzb = new zzbpx(new byte[0], 0, 0, false, false);
    private static final int zzc;
    private static final AtomicReference[] zzd;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iHighestOneBit = Integer.highestOneBit((iAvailableProcessors + iAvailableProcessors) - 1);
        zzc = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        zzd = atomicReferenceArr;
    }

    private zzbpy() {
    }

    @JvmStatic
    public static final zzbpx zza() {
        AtomicReference atomicReferenceZzc = zzc();
        zzbpx zzbpxVar = zzb;
        zzbpx zzbpxVar2 = (zzbpx) atomicReferenceZzc.getAndSet(zzbpxVar);
        if (zzbpxVar2 == zzbpxVar) {
            return new zzbpx();
        }
        if (zzbpxVar2 == null) {
            atomicReferenceZzc.set(null);
            return new zzbpx();
        }
        atomicReferenceZzc.set(zzbpxVar2.zzg);
        zzbpxVar2.zzg = null;
        zzbpxVar2.zzd = 0;
        return zzbpxVar2;
    }

    @JvmStatic
    public static final void zzb(zzbpx segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.zzg != null || segment.zzh != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.zze) {
            return;
        }
        AtomicReference atomicReferenceZzc = zzc();
        zzbpx zzbpxVar = zzb;
        zzbpx zzbpxVar2 = (zzbpx) atomicReferenceZzc.getAndSet(zzbpxVar);
        if (zzbpxVar2 != zzbpxVar) {
            int i = zzbpxVar2 != null ? zzbpxVar2.zzd : 0;
            if (i >= 65536) {
                atomicReferenceZzc.set(zzbpxVar2);
                return;
            }
            segment.zzg = zzbpxVar2;
            segment.zzc = 0;
            segment.zzd = i + 8192;
            atomicReferenceZzc.set(segment);
        }
    }

    private static final AtomicReference zzc() {
        return zzd[(int) (Thread.currentThread().getId() & (((long) zzc) - 1))];
    }
}
