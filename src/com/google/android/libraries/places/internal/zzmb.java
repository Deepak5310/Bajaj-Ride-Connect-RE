package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzmb extends zzlt implements Set {

    @CheckForNull
    private transient zzlx zza;

    zzmb() {
    }

    static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzkt.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzmb zzj(Collection collection) {
        if ((collection instanceof zzmb) && !(collection instanceof SortedSet)) {
            zzmb zzmbVar = (zzmb) collection;
            if (!zzmbVar.zzf()) {
                return zzmbVar;
            }
        }
        Object[] array = collection.toArray();
        return zzr(array.length, array);
    }

    public static zzmb zzk() {
        return zzms.zza;
    }

    public static zzmb zzl(Object obj) {
        return new zzmu(obj);
    }

    public static zzmb zzm(Object obj, Object obj2) {
        return zzr(2, obj, obj2);
    }

    public static zzmb zzn(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzr(4, UriUtil.HTTP_SCHEME, UriUtil.HTTPS_SCHEME, "mailto", "ftp");
    }

    public static zzmb zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzr(5, "audio", "img", "input", "source", "video");
    }

    @SafeVarargs
    public static zzmb zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzr(i, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzmb) && zzq() && ((zzmb) obj).zzq() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzmt.zza(this);
    }

    @Override // com.google.android.libraries.places.internal.zzlt
    public zzlx zzd() {
        zzlx zzlxVar = this.zza;
        if (zzlxVar != null) {
            return zzlxVar;
        }
        zzlx zzlxVarZzi = zzi();
        this.zza = zzlxVarZzi;
        return zzlxVarZzi;
    }

    @Override // com.google.android.libraries.places.internal.zzlt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzmx iterator();

    zzlx zzi() {
        Object[] array = toArray();
        int i = zzlx.zzd;
        return zzlx.zzi(array, array.length);
    }

    boolean zzq() {
        return false;
    }

    private static zzmb zzr(int i, Object... objArr) {
        if (i == 0) {
            return zzms.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzmu(obj);
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzmi.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzlq.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzmu(obj4);
        }
        if (zzh(i4) < iZzh / 2) {
            return zzr(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzms(objArr, i3, objArr2, i2, i4);
    }
}
