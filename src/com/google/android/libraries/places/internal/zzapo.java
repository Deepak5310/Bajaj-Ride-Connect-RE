package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzaqg zzc;
    private static final zzaqg zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzaqg zzaqgVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzaqgVar = (zzaqg) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzaqgVar;
        zzd = new zzaqi();
    }

    public static void zzA(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzx(i, list, z);
    }

    public static void zzC(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzz(i, list, z);
    }

    public static void zzD(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzB(i, list, z);
    }

    public static void zzE(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzD(i, list, z);
    }

    public static void zzF(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzI(i, list, z);
    }

    public static void zzG(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzK(i, list, z);
    }

    static int zza(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzans) {
            zzans zzansVar = (zzans) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzamy.zzx(zzansVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzamy.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzamy.zzA(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzamy.zzA(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzans) {
            zzans zzansVar = (zzans) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzamy.zzx(zzansVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzamy.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzg(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaoo) {
            zzaoo zzaooVar = (zzaoo) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzamy.zzB(zzaooVar.zze(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzamy.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzh(int i, Object obj, zzapm zzapmVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzaof)) {
            return zzamy.zzA(i2) + zzamy.zzy((zzaoz) obj, zzapmVar);
        }
        int i3 = zzamy.zzf;
        int iZza = ((zzaof) obj).zza();
        return zzamy.zzA(i2) + zzamy.zzA(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzans) {
            zzans zzansVar = (zzans) list;
            iZzA = 0;
            while (i < size) {
                int iZze = zzansVar.zze(i);
                iZzA += zzamy.zzA((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzA += zzamy.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzA;
    }

    static int zzj(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaoo) {
            zzaoo zzaooVar = (zzaoo) list;
            iZzB = 0;
            while (i < size) {
                long jZze = zzaooVar.zze(i);
                iZzB += zzamy.zzB((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzB += zzamy.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzB;
    }

    static int zzk(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzans) {
            zzans zzansVar = (zzans) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzamy.zzA(zzansVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzamy.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzl(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaoo) {
            zzaoo zzaooVar = (zzaoo) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzamy.zzB(zzaooVar.zze(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzamy.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    public static zzaqg zzm() {
        return zzc;
    }

    public static zzaqg zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, List list, zzanv zzanvVar, Object obj2, zzaqg zzaqgVar) {
        if (zzanvVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzanvVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = zzp(obj, i, iIntValue, obj2, zzaqgVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int iIntValue2 = ((Integer) it2.next()).intValue();
                if (!zzanvVar.zza(iIntValue2)) {
                    obj2 = zzp(obj, i, iIntValue2, obj2, zzaqgVar);
                    it2.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzp(Object obj, int i, int i2, Object obj2, zzaqg zzaqgVar) {
        if (obj2 == null) {
            obj2 = zzaqgVar.zzc(obj);
        }
        zzaqgVar.zzl(obj2, i, i2);
        return obj2;
    }

    static void zzq(zzaqg zzaqgVar, Object obj, Object obj2) {
        zzaqgVar.zzo(obj, zzaqgVar.zze(zzaqgVar.zzd(obj), zzaqgVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzanr.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzs(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzt(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzc(i, list, z);
    }

    public static void zzu(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzg(i, list, z);
    }

    public static void zzv(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzj(i, list, z);
    }

    public static void zzw(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzl(i, list, z);
    }

    public static void zzx(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzn(i, list, z);
    }

    public static void zzy(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzp(i, list, z);
    }

    public static void zzz(int i, List list, zzamz zzamzVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzamzVar.zzs(i, list, z);
    }
}
