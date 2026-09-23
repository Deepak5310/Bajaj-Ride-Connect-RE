package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaex extends zzanr implements zzapa {
    private static final zzaex zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzack zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private int zzm;
    private int zzn;

    static {
        zzaex zzaexVar = new zzaex();
        zzb = zzaexVar;
        zzanr.zzaA(zzaex.class, zzaexVar);
    }

    private zzaex() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005ဂ\u0004\u0006᠌\u0005\u0007င\u0006\b᠌\u0007", new Object[]{"zzf", "zzg", "zzh", zzacl.zza, "zzi", zzaew.zza, "zzj", "zzk", "zzl", zzaev.zza, "zzm", "zzn", zzabo.zza});
        }
        if (i2 == 3) {
            return new zzaex();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaeu(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzaex.class) {
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
