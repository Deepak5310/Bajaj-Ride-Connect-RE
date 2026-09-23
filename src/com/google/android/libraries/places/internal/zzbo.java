package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbo extends zzanr implements zzapa {
    private static final zzanx zzb = new zzbm();
    private static final zzbo zze;
    private static volatile zzapg zzf;
    private int zzg;
    private zzanw zzh = zzap();
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private float zzm;
    private float zzn;
    private int zzo;
    private zzbj zzp;

    static {
        zzbo zzboVar = new zzbo();
        zze = zzboVar;
        zzanr.zzaA(zzbo.class, zzboVar);
    }

    private zzbo() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzanv zzanvVar = zzas.zza;
            zzanv zzanvVar2 = zzbh.zza;
            return zzax(zze, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ࠬ\u0002᠌\u0000\u0003᠌\u0001\u0004င\u0002\u0005ဂ\u0003\u0006ခ\u0004\u0007ခ\u0005\b᠌\u0006\tဉ\u0007", new Object[]{"zzg", "zzh", zzanvVar, "zzi", zzanvVar2, "zzj", zzanvVar2, "zzk", "zzl", "zzm", "zzn", "zzo", zzanvVar, "zzp"});
        }
        if (i2 == 3) {
            return new zzbo();
        }
        zzbg zzbgVar = null;
        if (i2 == 4) {
            return new zzbn(zzbgVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zzf;
        if (zzannVar == null) {
            synchronized (zzbo.class) {
                zzannVar = zzf;
                if (zzannVar == null) {
                    zzannVar = new zzann(zze);
                    zzf = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
