package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzl extends zzanr implements zzapa {
    private static final zzl zzb;
    private static volatile zzapg zze;
    private int zzf;
    private zzcd zzg;
    private long zzh;
    private int zzi;
    private boolean zzj;
    private zzar zzk;

    static {
        zzl zzlVar = new zzl();
        zzb = zzlVar;
        zzanr.zzaA(zzl.class, zzlVar);
    }

    private zzl() {
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005ဉ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", zzm.zza, "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzl();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzk(zzaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzl.class) {
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
