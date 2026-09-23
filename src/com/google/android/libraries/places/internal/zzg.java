package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg extends zzanr implements zzapa {
    private static final zzg zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzcd zzg;
    private long zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private long zzm;
    private boolean zzn;
    private zzar zzo;

    static {
        zzg zzgVar = new zzg();
        zzb = zzgVar;
        zzanr.zzaA(zzg.class, zzgVar);
    }

    private zzg() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဇ\u0005\u0007ဂ\u0006\bဇ\u0007\tဉ\b", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", zzas.zza, "zzk", zzm.zza, "zzl", "zzm", "zzn", "zzo"});
        }
        if (i2 == 3) {
            return new zzg();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzf(zzaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzg.class) {
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
