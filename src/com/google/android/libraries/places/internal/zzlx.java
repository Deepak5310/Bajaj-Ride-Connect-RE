package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzlx extends zzlt implements List, RandomAccess {
    private static final zzmy zza = new zzlv(zzmm.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzlx() {
    }

    static zzlx zzi(Object[] objArr, int i) {
        return i == 0 ? zzmm.zza : new zzmm(objArr, i);
    }

    public static zzlx zzj(Collection collection) {
        if (!(collection instanceof zzlt)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzmi.zzb(array, length);
            return zzi(array, length);
        }
        zzlx zzlxVarZzd = ((zzlt) collection).zzd();
        if (!zzlxVarZzd.zzf()) {
            return zzlxVarZzd;
        }
        Object[] array2 = zzlxVarZzd.toArray();
        return zzi(array2, array2.length);
    }

    public static zzlx zzk(Object[] objArr) {
        if (objArr.length == 0) {
            return zzmm.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzmi.zzb(objArr2, length);
        return zzi(objArr2, length);
    }

    public static zzlx zzl() {
        return zzmm.zza;
    }

    public static zzlx zzm(Object obj) {
        Object[] objArr = {obj};
        zzmi.zzb(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzlx zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzmi.zzb(objArr, 2);
        return zzi(objArr, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzlx zzo(Comparator comparator, Iterable iterable) {
        Object[] array = iterable.toArray();
        int length = array.length;
        zzmi.zzb(array, length);
        Arrays.sort(array, comparator);
        return zzi(array, length);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzkp.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it2 = iterator();
                Iterator it3 = list.iterator();
                while (it2.hasNext()) {
                    if (it3.hasNext() && zzkp.zza(it2.next(), it3.next())) {
                    }
                }
                if (!it3.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    @Deprecated
    public final zzlx zzd() {
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    /* JADX INFO: renamed from: zze */
    public final zzmx iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzlx subList(int i, int i2) {
        zzkt.zzm(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? zzmm.zza : new zzlw(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public final zzmy listIterator(int i) {
        zzkt.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzlv(this, i);
    }
}
