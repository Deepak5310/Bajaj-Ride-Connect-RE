package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaac extends zzanr implements zzapa {
    private static final zzaac zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private zzaba zzk;
    private zzaak zzl;
    private zzaay zzm;
    private int zzn;
    private int zzo;

    static {
        zzaac zzaacVar = new zzaac();
        zzb = zzaacVar;
        zzanr.zzaA(zzaac.class, zzaacVar);
    }

    private zzaac() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004᠌\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\b᠌\u0007\t᠌\b", new Object[]{"zzf", "zzg", zzzz.zza, "zzh", zzaab.zza, "zzi", "zzj", zzzy.zza, "zzk", "zzl", "zzm", "zzn", zzzw.zza, "zzo", zzaaa.zza});
        }
        if (i2 == 3) {
            return new zzaac();
        }
        zzyy zzyyVar = null;
        if (i2 == 4) {
            return new zzzx(zzyyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaac.class) {
                zzannVar = zze;
                if (zzannVar == null) {
                    zzannVar = new zzann(zzb);
                    zze = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
