package com.google.android.libraries.places.internal;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzms extends zzmb {
    static final zzms zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzms(objArr, 0, objArr, 0, 0);
    }

    zzms(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzlq.zza(obj.hashCode());
                while (true) {
                    int i = iZza & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzmb, com.google.android.libraries.places.internal.zzlt
    /* JADX INFO: renamed from: zze */
    public final zzmx iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    final Object[] zzg() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzmb
    final zzlx zzi() {
        return zzlx.zzi(this.zzb, this.zzg);
    }

    @Override // com.google.android.libraries.places.internal.zzmb
    final boolean zzq() {
        return true;
    }
}
