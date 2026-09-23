package com.google.android.libraries.places.internal;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqn extends zzaqp {
    zzaqn(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaqq.zzb) {
            zzaqq.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzaqq.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final void zzd(Object obj, long j, byte b) {
        if (zzaqq.zzb) {
            zzaqq.zzD(obj, j, b);
        } else {
            zzaqq.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.libraries.places.internal.zzaqp
    public final boolean zzg(Object obj, long j) {
        return zzaqq.zzb ? zzaqq.zzt(obj, j) : zzaqq.zzu(obj, j);
    }
}
